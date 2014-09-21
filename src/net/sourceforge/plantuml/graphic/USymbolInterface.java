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

import net.sourceforge.plantuml.ColorParam;
import net.sourceforge.plantuml.FontParam;
import net.sourceforge.plantuml.svek.CircleInterface2;

public class USymbolInterface extends USymbolSimpleAbstract {

	public USymbolInterface() {
		super(ColorParam.interfaceBackground, ColorParam.interfaceBorder, FontParam.INTERFACE,
				FontParam.INTERFACE_STEREOTYPE);
	}

	@Override
	protected TextBlock getDrawing(SymbolContext symbolContext) {
		return new CircleInterface2(symbolContext.getBackColor(), symbolContext.getForeColor(),
				symbolContext.isShadowing() ? 4.0 : 0.0);
	}

}