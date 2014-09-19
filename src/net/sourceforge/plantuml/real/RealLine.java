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

class RealLine {

	// private final List<RealImpl> allReals = new ArrayList<RealImpl>();

	private final List<PositiveForce> forces = new ArrayList<PositiveForce>();

	// private boolean isFreezed;
	//
	// public void freeze() {
	// this.isFreezed = true;
	// }
	//
	// public final boolean isFreezed() {
	// return isFreezed;
	// }

	public void addForce(PositiveForce force) {
		this.forces.add(force);
	}

	static private int CPT;

	public void compile() {
		int cpt = 0;
		do {
			boolean done = true;
			for (PositiveForce f : forces) {
				// System.err.println("force=" + f);
				final boolean change = f.apply();
				if (change) {
					// System.err.println("changed! " + f);
					done = false;
				}
			}
			if (done) {
				System.err.println("cpt=" + cpt + " size=" + forces.size());
				CPT += cpt;
				System.err.println("CPT=" + CPT);
				return;
			}
			cpt++;
			if (cpt > 99999) {
				throw new IllegalStateException("Inifinite Loop?");
			}
		} while (true);

	}

}
