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
package net.sourceforge.plantuml.cucadiagram.dot;

import java.io.File;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import net.sourceforge.plantuml.Log;
import net.sourceforge.plantuml.OptionFlags;
import net.sourceforge.plantuml.api.Performance;
import net.sourceforge.plantuml.utils.StringUtils;

abstract class AbstractGraphviz implements Graphviz {

	private final File dotExe;
	private final String dotString;
	private final String[] type;

	static boolean isWindows() {
		return File.separatorChar == '\\';
	}

	AbstractGraphviz(String dotString, String... type) {
		if (type == null) {
			throw new IllegalArgumentException();
		}
		this.dotExe = searchDotExe();
		this.dotString = dotString;
		this.type = type;
	}

	private File searchDotExe() {
		if (OptionFlags.getInstance().getDotExecutable() == null) {
			final String getenv = GraphvizUtils.getenvGraphvizDot();
			if (getenv == null) {
				return specificDotExe();
			}
			return new File(getenv);
		}

		return new File(OptionFlags.getInstance().getDotExecutable());

	}

	abstract protected File specificDotExe();

	final public ProcessState createFile3(OutputStream os) {
		if (dotString == null) {
			throw new IllegalArgumentException();
		}

		if (illegalDotExe()) {
			// createPngNoGraphviz(os, new FileFormatOption(FileFormat.valueOf(type[0].toUpperCase())));
			throw new IllegalStateException();
		}
		final String cmd[] = getCommandLine();
		ProcessRunner p = null;
		ProcessState state = null;
		long startTime2 = -1;
		try {
			Log.info("Starting Graphviz process " + Arrays.asList(cmd));
			Log.info("DotString size: " + dotString.length());
			p = new ProcessRunner(cmd);
			startTime2 = System.currentTimeMillis();
			state = p.run(dotString.getBytes(), os);
			// if (state == ProcessState.TERMINATED_OK) {
			// result = true;
			// }
			Log.info("Ending process ok");
		} catch (Throwable e) {
			e.printStackTrace();
			Log.error("Error: " + e);
			Log.error("The command was " + cmd);
			Log.error("");
			Log.error("Try java -jar plantuml.jar -testdot to figure out the issue");
			Log.error("");
		} finally {
			if (startTime2 != -1) {
				final long duration = System.currentTimeMillis() - startTime2;
				Performance.updateDotTime2(duration);
			}
			Log.info("Ending Graphviz process");
		}
		if (OptionFlags.getInstance().isCheckDotError() && p != null && p.getError().length() > 0) {
			Log.error("GraphViz error stream : " + p.getError());
			if (OptionFlags.getInstance().isCheckDotError()) {
				throw new IllegalStateException("Dot error " + p.getError());
			}
		}
		if (OptionFlags.getInstance().isCheckDotError() && p != null && p.getOut().length() > 0) {
			Log.error("GraphViz out stream : " + p.getOut());
			if (OptionFlags.getInstance().isCheckDotError()) {
				throw new IllegalStateException("Dot out " + p.getOut());
			}
		}
		return state;
	}

	private boolean illegalDotExe() {
		return dotExe == null || dotExe.isFile() == false || dotExe.canRead() == false;
	}

	final public String dotVersion() {
		final String cmd[] = getCommandLineVersion();
		return executeCmd(cmd);
	}

	private String executeCmd(final String cmd[]) {
		final ProcessRunner p = new ProcessRunner(cmd);
		final ProcessState state = p.run(null, null);
		if (state != ProcessState.TERMINATED_OK) {
			return "?";
		}
		final StringBuilder sb = new StringBuilder();
		if (StringUtils.isNotEmpty(p.getOut())) {
			sb.append(p.getOut());
		}
		if (StringUtils.isNotEmpty(p.getError())) {
			if (sb.length() > 0) {
				sb.append(' ');
			}
			sb.append(p.getError());
		}
		return sb.toString().replace('\n', ' ').trim();
	}

	final String[] getCommandLine() {
		if (OptionFlags.ADD_NICE_FOR_DOT) {
			final String[] result = new String[type.length + 1 + 3];
			result[0] = "/bin/nice";
			result[1] = "-n";
			result[2] = "10";
			result[3] = getDotExe().getAbsolutePath();
			for (int i = 0; i < type.length; i++) {
				result[i + 4] = "-T" + type[i];
			}
			return result;
		}
		final String[] result = new String[type.length + 1];
		result[0] = getDotExe().getAbsolutePath();
		for (int i = 0; i < type.length; i++) {
			result[i + 1] = "-T" + type[i];
		}
		return result;
	}

	final String[] getCommandLineVersion() {
		return new String[] { getDotExe().getAbsolutePath(), "-V" };
	}

	public final File getDotExe() {
		return dotExe;
	}

	public final String getDotString() {
		return dotString;
	}

	public final List<String> getType() {
		return Arrays.asList(type);
	}

}
