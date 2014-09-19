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
package net.sourceforge.plantuml.svek;

import java.awt.geom.Dimension2D;

import net.sourceforge.plantuml.graphic.HtmlColor;
import net.sourceforge.plantuml.graphic.HtmlColorUtils;
import net.sourceforge.plantuml.graphic.StringBounder;
import net.sourceforge.plantuml.ugraphic.UChangeColor;
import net.sourceforge.plantuml.ugraphic.UGraphic;
import net.sourceforge.plantuml.ugraphic.URectangle;
import net.sourceforge.plantuml.ugraphic.UShape;
import net.sourceforge.plantuml.ugraphic.UStroke;

public final class InnerStateConcurrent implements IEntityImage {

	private final IEntityImage im;

	public InnerStateConcurrent(final IEntityImage im) {
		this.im = im;
	}

	public final static double THICKNESS_BORDER = 1.5;
	private static final int DASH = 8;

	public void drawU(UGraphic ug) {
		final Dimension2D dim = calculateDimension(ug.getStringBounder());
		final UShape rect = new URectangle(dim.getWidth(), dim.getHeight());
		ug = ug.apply(new UChangeColor(HtmlColorUtils.BLACK));
		ug.apply(new UStroke(DASH, 10, THICKNESS_BORDER)).draw(rect);

		im.drawU(ug);
	}

	public HtmlColor getBackcolor() {
		return null;
	}

	public Dimension2D calculateDimension(StringBounder stringBounder) {
		final Dimension2D img = im.calculateDimension(stringBounder);

		return img;
	}

	public ShapeType getShapeType() {
		return ShapeType.RECTANGLE;
	}

	public int getShield() {
		return 0;
	}

	public boolean isHidden() {
		return im.isHidden();
	}

}
