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

import net.sourceforge.plantuml.ISkinParam;
import net.sourceforge.plantuml.graphic.StringBounder;
import net.sourceforge.plantuml.real.Real;
import net.sourceforge.plantuml.sequencediagram.Event;
import net.sourceforge.plantuml.sequencediagram.MessageExo;
import net.sourceforge.plantuml.skin.Area;
import net.sourceforge.plantuml.skin.ArrowConfiguration;
import net.sourceforge.plantuml.skin.Component;
import net.sourceforge.plantuml.skin.ComponentType;
import net.sourceforge.plantuml.skin.SimpleContext2D;
import net.sourceforge.plantuml.skin.Skin;
import net.sourceforge.plantuml.ugraphic.UGraphic;
import net.sourceforge.plantuml.ugraphic.UTranslate;

public class CommunicationExoTile implements Tile {

	private final LivingSpace livingSpace;
	private final MessageExo message;
	private final Skin skin;
	private final ISkinParam skinParam;
	private final Real alpha;
	private final Real omega;
	
	public Event getEvent() {
		return message;
	}


	public CommunicationExoTile(LivingSpace livingSpace, MessageExo message, Skin skin, ISkinParam skinParam,
			Real alpha, Real omega) {
		this.livingSpace = livingSpace;
		this.message = message;
		this.skin = skin;
		this.skinParam = skinParam;
		this.alpha = alpha;
		this.omega = omega;
	}

	private Component getComponent(StringBounder stringBounder) {
		ArrowConfiguration arrowConfiguration = message.getArrowConfiguration();
		if (message.getType().getDirection() == -1) {
			arrowConfiguration = arrowConfiguration.reverse();
		}
		final Component comp = skin.createComponent(ComponentType.ARROW, arrowConfiguration, skinParam,
				message.getLabel());
		return comp;
	}

	public void drawU(UGraphic ug) {
		final StringBounder stringBounder = ug.getStringBounder();
		final Component comp = getComponent(stringBounder);
		final Dimension2D dim = comp.getPreferredDimension(stringBounder);
		final double x1 = getPoint1(stringBounder).getCurrentValue();
		final double x2 = getPoint2(stringBounder).getCurrentValue();
		final Area area = new Area(x2 - x1, dim.getHeight());
		ug = ug.apply(new UTranslate(x1, 0));
		comp.drawU(ug, area, new SimpleContext2D(false));
	}

	public double getPreferredHeight(StringBounder stringBounder) {
		final Component comp = getComponent(stringBounder);
		final Dimension2D dim = comp.getPreferredDimension(stringBounder);
		return dim.getHeight();
	}

	public void addConstraints(StringBounder stringBounder) {
		final Component comp = getComponent(stringBounder);
		final Dimension2D dim = comp.getPreferredDimension(stringBounder);
		final double width = dim.getWidth();

		final Real point1 = getPoint1(stringBounder);
		final Real point2 = getPoint2(stringBounder);
		if (point1.getCurrentValue() < point2.getCurrentValue()) {
			point2.ensureBiggerThan(point1.addFixed(width));
		} else {
			point1.ensureBiggerThan(point2.addFixed(width));
		}
	}

	private Real getPoint1(final StringBounder stringBounder) {
		if (message.getType().isRightBorder()) {
			return livingSpace.getPosC(stringBounder);
		}
		return alpha;
	}

	private Real getPoint2(final StringBounder stringBounder) {
		if (message.getType().isRightBorder()) {
			return omega;
		}
		return livingSpace.getPosC(stringBounder);
	}

	public Real getMinX(StringBounder stringBounder) {
		return getPoint1(stringBounder);
	}

	public Real getMaxX(StringBounder stringBounder) {
		return getPoint2(stringBounder);
	}

}
