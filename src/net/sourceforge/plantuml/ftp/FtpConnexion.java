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
package net.sourceforge.plantuml.ftp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;
import net.sourceforge.plantuml.core.DiagramDescription;

public class FtpConnexion {

	private final String user;
	private final Map<String, String> incoming = new HashMap<String, String>();
	private final Map<String, byte[]> outgoing = new HashMap<String, byte[]>();

	public FtpConnexion(String user) {
		this.user = user;
	}

	public synchronized void addIncoming(String fileName, String data) {
		if (fileName.startsWith("/")) {
			throw new IllegalArgumentException();
		}
		incoming.put(fileName, data);
	}

	public synchronized void removeOutgoing(String fileName) {
		outgoing.remove(fileName);
	}

	public synchronized Collection<String> getFiles() {
		final List<String> result = new ArrayList<String>(incoming.keySet());
		result.addAll(outgoing.keySet());
		return Collections.unmodifiableCollection(result);
	}

	public synchronized byte[] getData(String fileName) {
		if (fileName.startsWith("/")) {
			throw new IllegalArgumentException();
		}
		final String data = incoming.get(fileName);
		if (data != null) {
			return data.getBytes();
		}
		final byte data2[] = outgoing.get(fileName);
		if (data2 != null) {
			return data2;
		}
		return new byte[0];
	}

	public synchronized int getSize(String fileName) {
		if (fileName.startsWith("/")) {
			throw new IllegalArgumentException();
		}
		final String data = incoming.get(fileName);
		if (data != null) {
			return data.length();
		}
		final byte data2[] = outgoing.get(fileName);
		if (data2 != null) {
			return data2.length;
		}
		return 0;
	}

	public void processImage(String fileName) throws IOException {
		if (fileName.startsWith("/")) {
			throw new IllegalArgumentException();
		}
		final SourceStringReader sourceStringReader = new SourceStringReader(incoming.get(fileName));
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		final FileFormat format = FileFormat.PNG;
		final DiagramDescription desc = sourceStringReader.generateDiagramDescription(baos,
				new FileFormatOption(format));
		final String pngFileName = format.changeName(fileName, 0);
		final String errorFileName = pngFileName.substring(0, pngFileName.length() - 4) + ".err";
		synchronized (this) {
			outgoing.remove(pngFileName);
			outgoing.remove(errorFileName);
			if (desc != null && desc.getDescription() != null) {
				outgoing.put(pngFileName, baos.toByteArray());
				if (desc.getDescription().startsWith("(Error)")) {
					final ByteArrayOutputStream errBaos = new ByteArrayOutputStream();
					sourceStringReader.generateImage(errBaos, new FileFormatOption(FileFormat.ATXT));
					errBaos.close();
					outgoing.put(errorFileName, errBaos.toByteArray());
				}
			}
		}
	}

	public synchronized void delete(String fileName) {
		incoming.remove(fileName);
		outgoing.remove(fileName);
	}

}
