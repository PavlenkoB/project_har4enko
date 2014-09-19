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
package net.sourceforge.plantuml.jungle;

import java.io.IOException;
import java.io.OutputStream;

import net.sourceforge.plantuml.AbstractPSystem;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.core.DiagramDescription;
import net.sourceforge.plantuml.core.DiagramDescriptionImpl;
import net.sourceforge.plantuml.core.ImageData;
import net.sourceforge.plantuml.cucadiagram.Display;
import net.sourceforge.plantuml.graphic.HtmlColorUtils;
import net.sourceforge.plantuml.ugraphic.ColorMapperIdentity;
import net.sourceforge.plantuml.ugraphic.ImageBuilder;

public class PSystemTree extends AbstractPSystem {

	private GNode root;

	public DiagramDescription getDescription() {
		return new DiagramDescriptionImpl("(Tree)", getClass());
	}

	public ImageData exportDiagram(OutputStream os, int num, FileFormatOption fileFormat) throws IOException {
		final ImageBuilder builder = new ImageBuilder(new ColorMapperIdentity(), 1.0, HtmlColorUtils.WHITE, null,
				null, 5, 5, null);
		builder.addUDrawable(getGTile());
		return builder.writeImageTOBEMOVED(fileFormat.getFileFormat(), os);
	}

	public GNode createRoot(String id) {
		root = new GNode(id, Display.create(id));
		return root;
	}

	private GTile getGTile() {
		return new GTileOneLevelFactory().createGTile(root);
		// return new GTileNode(root);
	}

	public GNode getNode(String id) {
		return GNodeUtils.getIndirectChild(root, id);
	}

}
