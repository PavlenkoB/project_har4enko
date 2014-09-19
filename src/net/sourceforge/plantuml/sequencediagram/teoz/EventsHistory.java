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

import java.util.List;

import net.sourceforge.plantuml.sequencediagram.Event;
import net.sourceforge.plantuml.sequencediagram.LifeEvent;
import net.sourceforge.plantuml.sequencediagram.LifeEventType;
import net.sourceforge.plantuml.sequencediagram.Message;
import net.sourceforge.plantuml.sequencediagram.Participant;

public class EventsHistory {

	private final Participant p;
	private final List<Event> events;

	// private final Stairs stairs = new Stairs();
	//
	// public void addLifeEvent(Tile tile, LifeEvent lifeEvent) {
	// if (lifeEvent.getParticipant() != p) {
	// return;
	// }
	// System.err.println("Adding " + lifeEvent);
	// }
	//
	// int getLevel(double y) {
	// return stairs.getValue(y);
	// }
	//
	// public double getRightShift(double y) {
	// return getRightShiftAtLevel(getLevel(y));
	// }
	//
	// public double getLeftShift(double y) {
	// return getLeftShiftAtLevel(getLevel(y));
	// }
	//
	// private final double nominalPreferredWidth = 10;
	//
	// private double getRightShiftAtLevel(int level) {
	// if (level == 0) {
	// return 0;
	// }
	// return level * (nominalPreferredWidth / 2.0);
	// }
	//
	// private double getLeftShiftAtLevel(int level) {
	// if (level == 0) {
	// return 0;
	// }
	// return nominalPreferredWidth / 2.0;
	// }

	public EventsHistory(Participant p, List<Event> events) {
		this.p = p;
		this.events = events;
	}

	public Participant getParticipant() {
		return p;
	}

	public int getLevelAt(Event event) {
		int level = p.getInitialLife();
		for (Event current : events) {
			if (current instanceof Message) {
				final Message msg = (Message) current;
				for (LifeEvent le : msg.getLiveEvents()) {
					if (le.getParticipant() == p && le.getType() == LifeEventType.ACTIVATE) {
						level++;
					}
					if (le.getParticipant() == p && le.getType() == LifeEventType.DEACTIVATE) {
						level--;
					}
				}
			}
			if (event == current) {
				return level;
			}
		}
		return level;
	}

	private int getLevelAtOld(Event event) {
		int level = p.getInitialLife();
		for (Event current : events) {
			if (current instanceof Message) {
				final Message msg = (Message) current;
				for (LifeEvent le : msg.getLiveEvents()) {
					if (le.getParticipant() == p && le.getType() == LifeEventType.ACTIVATE) {
						level++;
					}
				}
			}
			if (event == current) {
				return level;
			}
			if (current instanceof Message) {
				final Message msg = (Message) current;
				for (LifeEvent le : msg.getLiveEvents()) {
					if (le.getParticipant() == p && le.getType() == LifeEventType.DEACTIVATE) {
						level--;
					}
				}
			}
		}
		return level;
	}

	// public final LivingSpace getNextTOBEREMOVED() {
	// return next;
	// }
	//
	// final void setNext(LivingSpace next) {
	// this.next = next;
	// }

}
