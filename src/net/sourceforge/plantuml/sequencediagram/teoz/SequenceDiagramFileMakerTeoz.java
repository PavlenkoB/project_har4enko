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
import java.io.IOException;
import java.io.OutputStream;

import net.sourceforge.plantuml.Dimension2DDouble;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.ISkinParam;
import net.sourceforge.plantuml.api.ImageDataSimple;
import net.sourceforge.plantuml.core.ImageData;
import net.sourceforge.plantuml.graphic.StringBounder;
import net.sourceforge.plantuml.graphic.TextBlockUtils;
import net.sourceforge.plantuml.real.Real;
import net.sourceforge.plantuml.real.RealUtils;
import net.sourceforge.plantuml.sequencediagram.Participant;
import net.sourceforge.plantuml.sequencediagram.SequenceDiagram;
import net.sourceforge.plantuml.sequencediagram.graphic.FileMaker;
import net.sourceforge.plantuml.skin.Skin;
import net.sourceforge.plantuml.ugraphic.UGraphic;
import net.sourceforge.plantuml.ugraphic.UGraphic2;
import net.sourceforge.plantuml.ugraphic.UTranslate;

public class SequenceDiagramFileMakerTeoz implements FileMaker {

	private final SequenceDiagram diagram;
	private final FileFormatOption fileFormatOption;
	private final Skin skin;

	public SequenceDiagramFileMakerTeoz(SequenceDiagram sequenceDiagram, Skin skin, FileFormatOption fileFormatOption) {
		this.diagram = sequenceDiagram;
		this.fileFormatOption = fileFormatOption;
		this.skin = skin;

	}

	public ImageData createOne(OutputStream os, int index, boolean isWithMetadata) throws IOException {
		StringBounder stringBounder = TextBlockUtils.getDummyStringBounder();

		final ISkinParam skinParam = diagram.getSkinParam();

		final Real origin = RealUtils.createOrigin();
		Real currentPos = origin.addAtLeast(0);
		double headHeight = 0;
		LivingSpace last = null;
		LivingSpaces livingSpaces = new LivingSpaces();
		for (Participant p : diagram.participants().values()) {
			final LivingSpace livingSpace = new LivingSpace(p, diagram.getEnglober(p), skin, skinParam, currentPos,
					diagram.events());
			last = livingSpace;
			((LivingSpaces) livingSpaces).put(p, livingSpace);
			final Dimension2D headDim = livingSpace.getHeadPreferredDimension(stringBounder);
			currentPos = livingSpace.getPosD(stringBounder).addAtLeast(0);
			headHeight = Math.max(headHeight, headDim.getHeight());
		}
		// livingSpaces = new LivingSpacesDeltaSimple(livingSpaces);

		final MainTile mainTile = new MainTile(diagram, skin, last.getPosD(stringBounder).addAtLeast(0), livingSpaces,
				origin);
		mainTile.addConstraints(stringBounder);
		origin.compile();

		final double height = mainTile.getPreferredHeight(stringBounder) + 2 * headHeight;

		final Real min1 = mainTile.getMinX(stringBounder);
		final Real max1 = mainTile.getMaxX(stringBounder);
		System.err.println("min1=" + min1.getCurrentValue());
		System.err.println("max1=" + max1.getCurrentValue());

		final Dimension2D dim = new Dimension2DDouble(max1.getCurrentValue() - min1.getCurrentValue(), height);
		final UGraphic2 ug = (UGraphic2) fileFormatOption.createUGraphic(dim).apply(
				new UTranslate(-min1.getCurrentValue(), 0));
		stringBounder = ug.getStringBounder();

		drawHeads(ug, livingSpaces);
		// mainTile.beforeDrawing(ug.getStringBounder(), livingSpaces.values());
		mainTile.drawU(ug.apply(new UTranslate(0, headHeight)));
		drawLifeLines(ug.apply(new UTranslate(0, headHeight)), mainTile.getPreferredHeight(stringBounder), livingSpaces);
		drawHeads(ug.apply(new UTranslate(0, mainTile.getPreferredHeight(stringBounder) + headHeight)), livingSpaces);

		ug.writeImageTOBEMOVED(os, isWithMetadata ? diagram.getMetadata() : null, diagram.getDpi(fileFormatOption));
		final Dimension2D info = new Dimension2DDouble(dim.getWidth(), dim.getHeight());

		// if (fileFormatOption.getFileFormat() == FileFormat.PNG && ug instanceof UGraphicG2d) {
		// final Set<Url> urls = ((UGraphicG2d) ug).getAllUrlsEncountered();
		// if (urls.size() > 0) {
		// if (scale == 0) {
		// throw new IllegalStateException();
		// }
		// final CMapData cmap = CMapData.cmapString(urls, scale);
		// return new ImageDataComplex(info, cmap, null);
		// }
		// }
		return new ImageDataSimple(info);
	}

	private void drawLifeLines(final UGraphic ug, double height, LivingSpaces livingSpaces) {
		for (LivingSpace livingSpace : livingSpaces.values()) {
			System.err.println("drawing lines " + livingSpace);
			final double x = livingSpace.getPosC(ug.getStringBounder()).getCurrentValue();
			livingSpace.drawLine(ug.apply(new UTranslate(x, 0)), height);
		}
	}

	private void drawHeads(final UGraphic ug, LivingSpaces livingSpaces) {
		for (LivingSpace livingSpace : livingSpaces.values()) {
			System.err.println("drawing heads " + livingSpace);
			final double x = livingSpace.getPosB().getCurrentValue();
			livingSpace.drawHead(ug.apply(new UTranslate(x, 0)));
		}
	}

	public int getNbPages() {
		return 1;
	}

}
