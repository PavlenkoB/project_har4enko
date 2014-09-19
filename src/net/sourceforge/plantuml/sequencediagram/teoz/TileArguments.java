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

import java.util.Collections;
import java.util.Map;

import net.sourceforge.plantuml.ISkinParam;
import net.sourceforge.plantuml.graphic.StringBounder;
import net.sourceforge.plantuml.real.Real;
import net.sourceforge.plantuml.sequencediagram.Participant;
import net.sourceforge.plantuml.skin.Skin;

public class TileArguments {
	private final StringBounder stringBounder;
	private final Real omega;
	private final Real origin;
	private final LivingSpaces livingSpaces;
	private final Skin skin;
	private final ISkinParam skinParam;

	public TileArguments(StringBounder stringBounder, Real omega, LivingSpaces livingSpaces, Skin skin,
			ISkinParam skinParam, Real origin) {
		this.stringBounder = stringBounder;
		this.origin = origin;
		this.omega = omega;
		this.livingSpaces = livingSpaces;
		this.skin = skin;
		this.skinParam = skinParam;
	}

	public final StringBounder getStringBounder() {
		return stringBounder;
	}

	public final Real getOmega() {
		return omega;
	}

	public final Real getOrigin() {
		return origin;
	}

	public final LivingSpaces getLivingSpaces() {
		return livingSpaces;
	}

	public final Skin getSkin() {
		return skin;
	}

	public final ISkinParam getSkinParam() {
		return skinParam;
	}

	public LivingSpace getLivingSpace(Participant p) {
		return livingSpaces.get(p);
	}

	public LivingSpace getFirstLivingSpace() {
		return livingSpaces.values().iterator().next();
	}

	public LivingSpace getLastLivingSpace() {
		LivingSpace result = null;
		for (LivingSpace v : livingSpaces.values()) {
			result = v;
		}
		return result;
	}

	// public void ensure(Tile tile) {
	// getAlpha().ensureLowerThan(tile.getMinX(getStringBounder()));
	// getOmega().ensureBiggerThan(tile.getMaxX(getStringBounder()));
	// }

}
