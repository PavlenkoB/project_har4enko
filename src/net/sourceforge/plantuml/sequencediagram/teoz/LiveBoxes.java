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

import java.util.Iterator;

import net.sourceforge.plantuml.ISkinParam;
import net.sourceforge.plantuml.graphic.UDrawable;
import net.sourceforge.plantuml.sequencediagram.graphic.Stairs;
import net.sourceforge.plantuml.skin.Area;
import net.sourceforge.plantuml.skin.Component;
import net.sourceforge.plantuml.skin.ComponentType;
import net.sourceforge.plantuml.skin.SimpleContext2D;
import net.sourceforge.plantuml.skin.Skin;
import net.sourceforge.plantuml.ugraphic.UGraphic;
import net.sourceforge.plantuml.ugraphic.UTranslate;

public class LiveBoxes implements UDrawable {

	private final Stairs stairs;
	private final Skin skin;
	private final ISkinParam skinParam;
	private final double totalHeight;

	public LiveBoxes(Stairs stairs, Skin skin, ISkinParam skinParam, double totalHeight) {
		this.stairs = stairs;
		this.skin = skin;
		this.skinParam = skinParam;
		this.totalHeight = totalHeight;
	}

	public void drawU(UGraphic ug) {
		stairs.addStep(totalHeight, stairs.getLastValue());
		System.err.println("stairs=" + stairs);
		for (Double y : stairs.getYs()) {
			System.err.println("LiveBoxes y=" + y + " " + stairs.getValue(y));
		}
		final int max = stairs.getMaxValue();
		for (int i = 1; i <= max; i++) {
			drawOneLevel(ug, i);
		}
	}

	private void drawOneLevel(UGraphic ug, int levelToDraw) {
		final Component comp = skin.createComponent(ComponentType.ALIVE_BOX_CLOSE_CLOSE, null, skinParam, null);
		final double width = comp.getPreferredWidth(ug.getStringBounder());
		ug = ug.apply(new UTranslate((levelToDraw - 1) * width / 2.0, 0));

		double y1 = Double.MAX_VALUE;
		for (Iterator<Double> it = stairs.getYs().iterator(); it.hasNext();) {
			// for (Double y : stairs.getYs()) {
			final double y = it.next();
			final int level = stairs.getValue(y);
			if (y1 == Double.MAX_VALUE && level == levelToDraw) {
				y1 = y;
			} else if (y1 != Double.MAX_VALUE && (it.hasNext() == false || level < levelToDraw)) {
				final double y2 = y;
				final Area area = new Area(width, y2 - y1);
				comp.drawU(ug.apply(new UTranslate(-width / 2, y1)), area, new SimpleContext2D(false));
				y1 = Double.MAX_VALUE;
			}
		}
	}

}
