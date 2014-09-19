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
import java.util.List;

import net.sourceforge.plantuml.ISkinParam;
import net.sourceforge.plantuml.sequencediagram.Delay;
import net.sourceforge.plantuml.sequencediagram.Event;
import net.sourceforge.plantuml.skin.Area;
import net.sourceforge.plantuml.skin.Component;
import net.sourceforge.plantuml.skin.ComponentType;
import net.sourceforge.plantuml.skin.SimpleContext2D;
import net.sourceforge.plantuml.skin.Skin;
import net.sourceforge.plantuml.ugraphic.UGraphic;

public class MutingLine {

	private final Skin skin;
	private final ISkinParam skinParam;
	private final boolean useContinueLineBecauseOfDelay;

	public MutingLine(Skin skin, ISkinParam skinParam, List<Event> events) {
		this.skin = skin;
		this.skinParam = skinParam;
		this.useContinueLineBecauseOfDelay = useContinueLineBecauseOfDelay(events);
	}

	private boolean useContinueLineBecauseOfDelay(List<Event> events) {
		final String strategy = skinParam.getValue("lifelineStrategy");
		if ("nosolid".equalsIgnoreCase(strategy)) {
			return false;
		}
		for (Event ev : events) {
			if (ev instanceof Delay) {
				return true;
			}
		}
		return false;
	}

	public void drawLine(UGraphic ug, double height) {
		final ComponentType defaultLineType = useContinueLineBecauseOfDelay ? ComponentType.CONTINUE_LINE
				: ComponentType.PARTICIPANT_LINE;
		final Component comp = skin.createComponent(defaultLineType, null, skinParam, null);
		final Dimension2D dim = comp.getPreferredDimension(ug.getStringBounder());
		final Area area = new Area(dim.getWidth(), height);
		comp.drawU(ug, area, new SimpleContext2D(false));
	}

}
