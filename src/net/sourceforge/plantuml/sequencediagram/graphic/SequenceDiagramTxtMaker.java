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
package net.sourceforge.plantuml.sequencediagram.graphic;

import java.awt.geom.Dimension2D;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.api.ImageDataSimple;
import net.sourceforge.plantuml.asciiart.TextSkin;
import net.sourceforge.plantuml.asciiart.TextStringBounder;
import net.sourceforge.plantuml.core.ImageData;
import net.sourceforge.plantuml.graphic.StringBounder;
import net.sourceforge.plantuml.sequencediagram.Event;
import net.sourceforge.plantuml.sequencediagram.LifeEvent;
import net.sourceforge.plantuml.sequencediagram.LifeEventType;
import net.sourceforge.plantuml.sequencediagram.Message;
import net.sourceforge.plantuml.sequencediagram.Participant;
import net.sourceforge.plantuml.sequencediagram.SequenceDiagram;
import net.sourceforge.plantuml.skin.Skin;
import net.sourceforge.plantuml.ugraphic.txt.UGraphicTxt;

public class SequenceDiagramTxtMaker implements FileMaker {

	private final SequenceDiagram diagram;
	private final DrawableSet drawableSet;
	private final Dimension2D fullDimension;
	private final StringBounder dummyStringBounder = new TextStringBounder();
	private final UGraphicTxt ug = new UGraphicTxt();
	private final FileFormat fileFormat;
	private final Skin skin;

	public SequenceDiagramTxtMaker(SequenceDiagram sequenceDiagram, FileFormat fileFormat) {
		this.fileFormat = fileFormat;
		this.diagram = sequenceDiagram;
		this.skin = new TextSkin(fileFormat);

		final DrawableSetInitializer initializer = new DrawableSetInitializer(skin, sequenceDiagram.getSkinParam(),
				sequenceDiagram.isShowFootbox(), sequenceDiagram.getAutonewpage());

		for (Participant p : sequenceDiagram.participants().values()) {
			initializer.addParticipant(p, null);
		}
		for (Event ev : sequenceDiagram.events()) {
			initializer.addEvent(ev);
			if (ev instanceof Message) {
				// TODO mieux faire
				final Message m = (Message) ev;
				for (LifeEvent lifeEvent : m.getLiveEvents()) {
					if (lifeEvent.getType() == LifeEventType.DESTROY
					/*
					 * || lifeEvent.getType() == LifeEventType.CREATE
					 */) {
						initializer.addEvent(lifeEvent);
					}
				}
			}
		}
		drawableSet = initializer.createDrawableSet(dummyStringBounder);
		// final List<Newpage> newpages = new ArrayList<Newpage>();
		// for (Event ev : drawableSet.getAllEvents()) {
		// if (ev instanceof Newpage) {
		// newpages.add((Newpage) ev);
		// }
		// }
		fullDimension = drawableSet.getDimension();
		final double headerHeight = drawableSet.getHeadHeight(dummyStringBounder);
		final double tailHeight = drawableSet.getTailHeight(dummyStringBounder, diagram.isShowFootbox());
		final double newpage2 = fullDimension.getHeight() - (diagram.isShowFootbox() ? tailHeight : 0) - headerHeight;
		final Page page = new Page(headerHeight, 0, newpage2, tailHeight, 0, null);
		drawableSet.drawU(ug, 0, fullDimension.getWidth(), page, diagram.isShowFootbox());
	}


	public ImageData createOne(OutputStream os, int index, boolean isWithMetadata) throws IOException {
		if (fileFormat == FileFormat.UTXT) {
			final PrintStream ps = new PrintStream(os, true, "UTF-8");
			ug.getCharArea().print(ps);
		} else {
			final PrintStream ps = new PrintStream(os);
			ug.getCharArea().print(ps);
		}
		return new ImageDataSimple(1, 1);
	}

	public int getNbPages() {
		return 1;
	}
}
