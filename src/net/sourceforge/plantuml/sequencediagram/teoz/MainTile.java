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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.sourceforge.plantuml.ISkinParam;
import net.sourceforge.plantuml.graphic.StringBounder;
import net.sourceforge.plantuml.graphic.TextBlockUtils;
import net.sourceforge.plantuml.graphic.UGraphicInterceptorUDrawable;
import net.sourceforge.plantuml.real.Real;
import net.sourceforge.plantuml.real.RealMax;
import net.sourceforge.plantuml.real.RealMin;
import net.sourceforge.plantuml.sequencediagram.Event;
import net.sourceforge.plantuml.sequencediagram.SequenceDiagram;
import net.sourceforge.plantuml.skin.Skin;
import net.sourceforge.plantuml.ugraphic.UGraphic;
import net.sourceforge.plantuml.ugraphic.UTranslate;

public class MainTile implements Tile {

	private final RealMin min = new RealMin();
	private final RealMax max = new RealMax();
	private double height;

	private final List<Tile> tiles = new ArrayList<Tile>();

	public MainTile(SequenceDiagram diagram, Skin skin, Real omega, LivingSpaces livingSpaces, Real origin) {

		min.put(origin);
		max.put(omega);

		final ISkinParam skinParam = diagram.getSkinParam();
		final StringBounder stringBounder = TextBlockUtils.getDummyStringBounder();

		final TileArguments tileArguments = new TileArguments(stringBounder, omega, livingSpaces, skin, skinParam,
				origin);

		tiles.addAll(TileBuilder.buildSeveral(diagram.events().iterator(), tileArguments, null));

		for (Tile tile : tiles) {
			height += tile.getPreferredHeight(stringBounder);
			min.put(tile.getMinX(stringBounder));
			max.put(tile.getMaxX(stringBounder));
			// if (tile instanceof DelayTile) {
			// for (LivingSpace livingSpace : livingSpaces.values()) {
			// livingSpace.addDelayTile((DelayTile) tile);
			// }
			// }
		}
	}

	private void beforeDrawing(StringBounder stringBounder, Collection<LivingSpace> livingSpaces) {
		double h = 0;
		for (Tile tile : tiles) {
			System.err.println("tile=" + tile);
			// if (tile instanceof DelayTile) {
			// ((DelayTile) tile).setStartingY(h);
			// }
			h += tile.getPreferredHeight(stringBounder);
		}
	}

	public void drawU(UGraphic ug) {
		final StringBounder stringBounder = ug.getStringBounder();
		final LiveBoxFinder liveBoxFinder = new LiveBoxFinder(stringBounder);

		drawUInternal(liveBoxFinder);
		drawUInternal(new UGraphicInterceptorUDrawable(ug));
	}

	private void drawUInternal(UGraphic ug) {
		final StringBounder stringBounder = ug.getStringBounder();
		double h = 0;
		for (Tile tile : tiles) {
			// tile.drawU(ug.apply(new UTranslate(0, h)));
			ug.apply(new UTranslate(0, h)).draw(tile);
			h += tile.getPreferredHeight(stringBounder);
		}
	}

	public double getPreferredHeight(StringBounder stringBounder) {
		return height;
	}

	public void addConstraints(StringBounder stringBounder) {
		for (Tile tile : tiles) {
			tile.addConstraints(stringBounder);
		}
	}

	public Real getMinX(StringBounder stringBounder) {
		return min;
	}

	public Real getMaxX(StringBounder stringBounder) {
		return max;
	}

	public Event getEvent() {
		return null;
	}

}
