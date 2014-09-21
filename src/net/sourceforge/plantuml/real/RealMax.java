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
package net.sourceforge.plantuml.real;

import java.util.ArrayList;
import java.util.List;

public class RealMax implements Real {

	private final List<Real> all = new ArrayList<Real>();

	public void put(Real real) {
		if (real == null) {
			throw new IllegalArgumentException();
		}
		if (real == this) {
			return;
		}
		all.add(real);
	}

	public String getName() {
		return "max " + all;
	}

	public double getCurrentValue() {
		double result = all.get(0).getCurrentValue();
		for (int i = 1; i < all.size(); i++) {
			final double v = all.get(i).getCurrentValue();
			if (v > result) {
				result = v;
			}
		}
		return result;
	}

	public Real addFixed(double delta) {
		return new RealDelta(this, delta);
	}

	public Real addAtLeast(double delta) {
		throw new UnsupportedOperationException();
	}

	public void ensureBiggerThan(Real other) {
		all.add(other);
	}

	public void compile() {
		all.get(0).compile();
	}

}