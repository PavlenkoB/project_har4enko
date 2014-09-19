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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sourceforge.plantuml.cucadiagram.Display;

public class GNode {

	private final String id;
	private final Display display;
	private final List<GNode> children = new ArrayList<GNode>();

	public GNode(String id, Display display) {
		this.id = id;
		this.display = display;
	}

	public String getId() {
		return id;
	}

	public Display getDisplay() {
		return display;
	}

	public List<GNode> getChildren() {
		return Collections.unmodifiableList(children);
	}

	public GNode addChild(String id, Display display) {
		final GNode child = new GNode(id, display);
		children.add(child);
		return child;
	}

	public GNode getDirectChild(String id) {
		for (final GNode node : children) {
			if (node.id.equals(id)) {
				return node;
			}
		}
		return null;
	}
}
