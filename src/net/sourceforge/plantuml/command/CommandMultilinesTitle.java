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
package net.sourceforge.plantuml.command;

import java.util.List;

import net.sourceforge.plantuml.UmlDiagram;
import net.sourceforge.plantuml.cucadiagram.Display;
import net.sourceforge.plantuml.utils.StringUtils;

public class CommandMultilinesTitle extends CommandMultilines<UmlDiagram> {

	public CommandMultilinesTitle() {
		super("(?i)^title$");
	}

	@Override
	public String getPatternEnd() {
		return "(?i)^end[%s]?title$";
	}

	public CommandExecutionResult execute(final UmlDiagram diagram, List<String> lines) {
		final Display strings = Display.create(lines.subList(1, lines.size() - 1)).removeEmptyColumns();
		if (strings.size() > 0) {
			diagram.setTitle(strings);
			return CommandExecutionResult.ok();
		}
		return CommandExecutionResult.error("No title defined");
	}

}