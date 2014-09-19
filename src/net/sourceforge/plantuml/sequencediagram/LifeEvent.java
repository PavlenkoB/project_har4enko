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
package net.sourceforge.plantuml.sequencediagram;

import net.sourceforge.plantuml.Url;
import net.sourceforge.plantuml.graphic.HtmlColor;

public class LifeEvent implements Event {

	private final Participant p;
	private final LifeEventType type;
	private final HtmlColor backcolor;

	public LifeEvent(Participant p, LifeEventType type, HtmlColor backcolor) {
		this.p = p;
		this.type = type;
		this.backcolor = backcolor;
	}

	@Override
	public String toString() {
		return "LifeEvent:" + p + " " + type;
	}

	public Participant getParticipant() {
		return p;
	}

	public LifeEventType getType() {
		return type;
	}

	public HtmlColor getSpecificBackColor() {
		return backcolor;
	}

	public boolean dealWith(Participant someone) {
		return this.p == someone;
	}

	public Url getUrl() {
		return null;
	}

	public boolean hasUrl() {
		return false;
	}

}
