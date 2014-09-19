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
package net.sourceforge.plantuml.sequencediagram;

import java.util.ArrayList;
import java.util.List;

public class ParticipantEngloberContexted {

	final private ParticipantEnglober participantEnglober;
	final private List<Participant> participants = new ArrayList<Participant>();

	public ParticipantEngloberContexted(ParticipantEnglober participantEnglober, Participant first) {
		this.participantEnglober = participantEnglober;
		this.participants.add(first);
	}

	public final ParticipantEnglober getParticipantEnglober() {
		return participantEnglober;
	}
	
	public boolean contains(Participant p) {
		return participants.contains(p);
	}

	public void add(Participant p) {
		if (participants.contains(p)) {
			throw new IllegalArgumentException();
		}
		participants.add(p);
	}

	public final Participant getFirst2() {
		return participants.get(0);
	}

	public final Participant getLast2() {
		return participants.get(participants.size() - 1);
	}
	
	@Override
	public String toString() {
		return super.toString()+" "+participants;
	}

}
