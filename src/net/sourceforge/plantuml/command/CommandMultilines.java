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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sourceforge.plantuml.command.regex.MyPattern;
import net.sourceforge.plantuml.core.Diagram;

public abstract class CommandMultilines<S extends Diagram> implements Command<S> {

	private final Pattern starting;

	public CommandMultilines(String patternStart) {
		if (patternStart.startsWith("(?i)^") == false || patternStart.endsWith("$") == false) {
			throw new IllegalArgumentException("Bad pattern " + patternStart);
		}
		this.starting = MyPattern.cmpile(patternStart);
	}

	public abstract String getPatternEnd();

	public String[] getDescription() {
		return new String[] { "START: " + starting.pattern(), "END: " + getPatternEnd() };
	}

	final public CommandControl isValid(List<String> lines) {
		if (isCommandForbidden()) {
			return CommandControl.NOT_OK;
		}
		Matcher m1 = starting.matcher(lines.get(0).trim());
		if (m1.matches() == false) {
			return CommandControl.NOT_OK;
		}
		if (lines.size() == 1) {
			return CommandControl.OK_PARTIAL;
		}

		m1 = MyPattern.cmpile(getPatternEnd()).matcher(lines.get(lines.size() - 1).trim());
		if (m1.matches() == false) {
			return CommandControl.OK_PARTIAL;
		}

		actionIfCommandValid();
		return CommandControl.OK;
	}

	protected boolean isCommandForbidden() {
		return false;
	}

	protected void actionIfCommandValid() {
	}

	protected final Pattern getStartingPattern() {
		return starting;
	}

}
