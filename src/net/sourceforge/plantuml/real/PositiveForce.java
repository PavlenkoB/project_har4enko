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

class PositiveForce {

	private final Real fixedPoint;
	private final RealMoveable movingPoint;
	private final double minimunDistance;

	public PositiveForce(Real fixedPoint, RealMoveable movingPoint, double minimunDistance) {
		if (fixedPoint == movingPoint) {
			throw new IllegalArgumentException();
		}
		this.fixedPoint = fixedPoint;
		this.movingPoint = movingPoint;
		this.minimunDistance = minimunDistance;
	}

	@Override
	public String toString() {
		return "PositiveForce fixed=" + fixedPoint + " moving=" + movingPoint + " min=" + minimunDistance;
	}

	public boolean apply() {
		final double distance = movingPoint.getCurrentValue() - fixedPoint.getCurrentValue();
		final double diff = distance - minimunDistance;
		if (diff >= 0) {
			return false;
		}
		// System.err.println("moving " + (-diff) + " " + movingPoint);
		movingPoint.move(-diff);
		return true;
	}

}
