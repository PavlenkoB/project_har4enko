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
package net.sourceforge.plantuml.version;

import java.util.Date;

public class Version {

	public static int version() {
		return 8007;
	}

	public static String versionString() {
		if (beta() != 0) {
			return "" + (version() + 1) + "beta" + beta();
		}
		return "" + version();
	}

	private static int beta() {
		final int beta = 0;
		return beta;
	}

	private static long compileTime() {
		return 1410804872234L;
	}

	public static String compileTimeString() {
		if (beta() != 0) {
			return versionString();
		}
		return new Date(Version.compileTime()).toString();
	}

}
