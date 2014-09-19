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
package net.sourceforge.plantuml.graphic;

import net.sourceforge.plantuml.ugraphic.UChangeBackColor;
import net.sourceforge.plantuml.ugraphic.UChangeColor;
import net.sourceforge.plantuml.ugraphic.UGraphic;
import net.sourceforge.plantuml.ugraphic.UStroke;

public class SymbolContext {

	private final HtmlColor backColor;
	private final HtmlColor foreColor;
	private final UStroke stroke;
	private final boolean shadowing;

	private SymbolContext(HtmlColor backColor, HtmlColor foreColor, UStroke stroke, boolean shadowing) {
		this.backColor = backColor;
		this.foreColor = foreColor;
		this.stroke = stroke;
		this.shadowing = shadowing;
//		if (backColor instanceof HtmlColorTransparent) {
//			throw new UnsupportedOperationException();
//		}
	}

	final public UGraphic apply(UGraphic ug) {
		return ug.apply(new UChangeColor(foreColor)).apply(new UChangeBackColor(backColor)).apply(stroke);
	}

	public SymbolContext(HtmlColor backColor, HtmlColor foreColor) {
		this(backColor, foreColor, new UStroke(), false);
	}

	public SymbolContext withShadow(boolean newShadow) {
		return new SymbolContext(backColor, foreColor, stroke, newShadow);
	}

	public SymbolContext withStroke(UStroke newStroke) {
		return new SymbolContext(backColor, foreColor, newStroke, shadowing);
	}

	public HtmlColor getBackColor() {
		return backColor;
	}

	public HtmlColor getForeColor() {
		return foreColor;
	}

	public UStroke getStroke() {
		return stroke;
	}

	public boolean isShadowing() {
		return shadowing;
	}

}
