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
package net.sourceforge.plantuml.sequencediagram.command;

import java.util.List;

import net.sourceforge.plantuml.command.CommandExecutionResult;
import net.sourceforge.plantuml.command.SingleLineCommand;
import net.sourceforge.plantuml.graphic.HtmlColor;
import net.sourceforge.plantuml.sequencediagram.GroupingType;
import net.sourceforge.plantuml.sequencediagram.SequenceDiagram;
import net.sourceforge.plantuml.utils.StringUtils;

public class CommandGrouping extends SingleLineCommand<SequenceDiagram> {

	public CommandGrouping() {
		super(
				"(?i)^(opt|alt|loop|par|par2|break|critical|else|end|also|group)((?<!else)(?<!also)(?<!end)#\\w+)?(?:[%s]+(#\\w+))?(?:[%s]+(.*?))?$");
	}

	@Override
	protected CommandExecutionResult executeArg(SequenceDiagram diagram, List<String> arg) {
		final String type = arg.get(0).toLowerCase();
		final HtmlColor backColorElement = diagram.getSkinParam().getIHtmlColorSet().getColorIfValid(arg.get(1));
		final HtmlColor backColorGeneral = diagram.getSkinParam().getIHtmlColorSet().getColorIfValid(arg.get(2));
		String comment = arg.get(3);
		if ("group".equals(type) && StringUtils.isEmpty(comment)) {
			comment = "group";
		}
		final boolean result = diagram.grouping(type, comment, GroupingType.getType(type), backColorGeneral,
				backColorElement);
		if (result == false) {
			return CommandExecutionResult.error("Cannot create group");
		}
		return CommandExecutionResult.ok();
	}
}
