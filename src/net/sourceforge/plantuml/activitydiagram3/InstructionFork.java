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
package net.sourceforge.plantuml.activitydiagram3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.sourceforge.plantuml.activitydiagram3.ftile.Ftile;
import net.sourceforge.plantuml.activitydiagram3.ftile.FtileFactory;
import net.sourceforge.plantuml.activitydiagram3.ftile.Swimlane;
import net.sourceforge.plantuml.cucadiagram.Display;
import net.sourceforge.plantuml.sequencediagram.NotePosition;

public class InstructionFork implements Instruction {

	private final List<InstructionList> forks = new ArrayList<InstructionList>();
	private final Instruction parent;

	public InstructionFork(Instruction parent) {
		this.parent = parent;
		this.forks.add(new InstructionList());
	}

	private InstructionList getLast() {
		return forks.get(forks.size() - 1);
	}
	

	public void add(Instruction ins) {
		getLast().add(ins);
	}

	public Ftile createFtile(FtileFactory factory) {
		final List<Ftile> all = new ArrayList<Ftile>();
		for (InstructionList list : forks) {
			all.add(list.createFtile(factory));
		}
		return factory.createFork(getSwimlaneIn(), all);
	}

	public Instruction getParent() {
		return parent;
	}

	public void forkAgain() {
		this.forks.add(new InstructionList());
	}

	final public boolean kill() {
		return getLast().kill();
	}

	public LinkRendering getInLinkRendering() {
		return null;
	}

	public void addNote(Display note, NotePosition position) {
		getLast().addNote(note, position);
	}
	
	public Set<Swimlane> getSwimlanes() {
		return InstructionList.getSwimlanes2(forks);
	}

	public Swimlane getSwimlaneIn() {
		return parent.getSwimlaneOut();
	}

	public Swimlane getSwimlaneOut() {
		return getLast().getSwimlaneOut();
	}


}
