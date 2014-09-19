/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009-2014, Arnaud Roques
 *
 * Project Info:  http://plantuml.sourceforge.net
 * 
 * This file is part of PlantUML.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 * Original Author:  Arnaud Roques
 */
package net.sourceforge.plantuml.sequencediagram.teoz;

import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.util.Iterator;

import net.sourceforge.plantuml.ISkinParam;
import net.sourceforge.plantuml.graphic.StringBounder;
import net.sourceforge.plantuml.real.Real;
import net.sourceforge.plantuml.sequencediagram.Event;
import net.sourceforge.plantuml.sequencediagram.Message;
import net.sourceforge.plantuml.skin.Area;
import net.sourceforge.plantuml.skin.ArrowComponent;
import net.sourceforge.plantuml.skin.ArrowConfiguration;
import net.sourceforge.plantuml.skin.Component;
import net.sourceforge.plantuml.skin.ComponentType;
import net.sourceforge.plantuml.skin.SimpleContext2D;
import net.sourceforge.plantuml.skin.Skin;
import net.sourceforge.plantuml.ugraphic.UGraphic;
import net.sourceforge.plantuml.ugraphic.UTranslate;

public class CommunicationTileSelf implements Tile {

	private final LivingSpace livingSpace1;
	private final Message message;
	private final Skin skin;
	private final ISkinParam skinParam;
	private final LivingSpaces livingSpaces;

	public Event getEvent() {
		return message;
	}

	public CommunicationTileSelf(LivingSpace livingSpace1, Message message, Skin skin, ISkinParam skinParam,
			LivingSpaces livingSpaces) {
		this.livingSpace1 = livingSpace1;
		this.livingSpaces = livingSpaces;
		this.message = message;
		this.skin = skin;
		this.skinParam = skinParam;
	}

	// private boolean isReverse(StringBounder stringBounder) {
	// final Real point1 = livingSpace1.getPosC(stringBounder);
	// final Real point2 = livingSpace2.getPosC(stringBounder);
	// if (point1.getCurrentValue() > point2.getCurrentValue()) {
	// return true;
	// }
	// return false;
	//
	// }

	private Component getComponent(StringBounder stringBounder) {
		ArrowConfiguration arrowConfiguration = message.getArrowConfiguration();
		arrowConfiguration = arrowConfiguration.self();
		final Component comp = skin.createComponent(ComponentType.ARROW, arrowConfiguration, skinParam,
				message.getLabel());
		return comp;
	}

	public void updateStairs(StringBounder stringBounder, double y) {
		System.err.println("self=" + message.getLiveEvents() + " " + message.isActivate() + " "
				+ message.isDeactivate());
		final ArrowComponent comp = (ArrowComponent) getComponent(stringBounder);
		final Dimension2D dim = comp.getPreferredDimension(stringBounder);
		final Point2D p1 = comp.getStartPoint(stringBounder, dim);
		final Point2D p2 = comp.getEndPoint(stringBounder, dim);
		final int level1 = livingSpace1.getLevelAt(this);
		System.err.println("CommunicationTileSelf level1=" + level1 + " y=" + y + " p1=" + p1 + " p2=" + p2 + " dim="
				+ dim);

		if (message.isActivate()) {
			livingSpace1.addStep(y + p2.getY(), level1);
		}
		if (message.isDeactivate()) {
			livingSpace1.addStep(y + p1.getY(), level1);
		}

		// livingSpace1.addStep(y + arrowY, level1);
		// livingSpace1.addStep(y + dim.getHeight(), level1);
		// final int level2 = livingSpace2.getLevelAt(this);
		// livingSpace2.addStep(y + arrowY, level2);
		// livingSpace2.addStep(y + dim.getHeight(), level2);
	}

	public void drawU(UGraphic ug) {
		final StringBounder stringBounder = ug.getStringBounder();
		final Component comp = getComponent(stringBounder);
		final Dimension2D dim = comp.getPreferredDimension(stringBounder);
		double x1 = getPoint1(stringBounder).getCurrentValue();
		final int level1 = livingSpace1.getLevelAt(this);
		x1 += CommunicationTile.LIVE_DELTA_SIZE * level1;

		final Area area = new Area(dim.getWidth(), dim.getHeight());
		if (message.isActivate()) {
			area.setDeltaX1(-CommunicationTile.LIVE_DELTA_SIZE);
		} else if (message.isDeactivate()) {
			area.setDeltaX1(CommunicationTile.LIVE_DELTA_SIZE);
			x1 += CommunicationTile.LIVE_DELTA_SIZE * level1;
		}
		ug = ug.apply(new UTranslate(x1, 0));
		comp.drawU(ug, area, new SimpleContext2D(false));
	}

	public double getPreferredHeight(StringBounder stringBounder) {
		final Component comp = getComponent(stringBounder);
		final Dimension2D dim = comp.getPreferredDimension(stringBounder);
		return dim.getHeight();
	}

	public void addConstraints(StringBounder stringBounder) {
		// final Component comp = getComponent(stringBounder);
		// final Dimension2D dim = comp.getPreferredDimension(stringBounder);
		// final double width = dim.getWidth();

		final LivingSpace next = getNext();
		if (next != null) {
			next.getPosB().ensureBiggerThan(getMaxX(stringBounder));
		}
	}

	// private boolean isSelf() {
	// return livingSpace1 == livingSpace2;
	// }

	private LivingSpace getNext() {
		for (Iterator<LivingSpace> it = livingSpaces.values().iterator(); it.hasNext();) {
			final LivingSpace current = it.next();
			if (current == livingSpace1 && it.hasNext()) {
				return it.next();
			}
		}
		return null;
	}

	private Real getPoint1(final StringBounder stringBounder) {
		return livingSpace1.getPosC(stringBounder);
	}

	public Real getMinX(StringBounder stringBounder) {
		return getPoint1(stringBounder);
	}

	public Real getMaxX(StringBounder stringBounder) {
		final Component comp = getComponent(stringBounder);
		final Dimension2D dim = comp.getPreferredDimension(stringBounder);
		final double width = dim.getWidth();
		return livingSpace1.getPosC(stringBounder).addFixed(width);
	}

}
