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
package net.sourceforge.plantuml.cucadiagram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import net.sourceforge.plantuml.FontParam;
import net.sourceforge.plantuml.ISkinParam;
import net.sourceforge.plantuml.graphic.TextBlock;
import net.sourceforge.plantuml.skin.VisibilityModifier;
import net.sourceforge.plantuml.utils.StringUtils;

public class Bodier {

	private final List<String> rawBody = new ArrayList<String>();
	private final Set<VisibilityModifier> hides;
	private final LeafType type;
	private List<Member> methodsToDisplay;
	private List<Member> fieldsToDisplay;
	private final boolean manageModifier;

	public Bodier(LeafType type, Set<VisibilityModifier> hides) {
		this.hides = hides;
		this.type = type;
		this.manageModifier = type == null ? false : type.manageModifier();
	}

	public void addFieldOrMethod(String s) {
		// Empty cache
		methodsToDisplay = null;
		fieldsToDisplay = null;
		rawBody.add(s);
	}

	public boolean isBodyEnhanced() {
		for (String s : rawBody) {
			if (BodyEnhanced.isBlockSeparator(s)) {
				return true;
			}
		}
		return false;
	}

	public BlockMember getBodyEnhanced() {
		return new BlockMember() {
			public TextBlock asTextBlock(FontParam fontParam, ISkinParam skinParam) {
				final BodyEnhanced result = new BodyEnhanced(rawBody, fontParam, skinParam, manageModifier);
				return result;
			}
		};
	}

	private LeafType getEntityType() {
		return type;
	}

	private boolean isMethod(String s) {
		if (getEntityType() == LeafType.ANNOTATION || getEntityType() == LeafType.ABSTRACT_CLASS
				|| getEntityType() == LeafType.CLASS || getEntityType() == LeafType.INTERFACE
				|| getEntityType() == LeafType.ENUM) {
			return StringUtils.isMethod(s);
		}
		return false;
	}

	public List<Member> getMethodsToDisplay() {
		if (methodsToDisplay == null) {
			methodsToDisplay = new ArrayList<Member>();
			for (int i = 0; i < rawBody.size(); i++) {
				final String s = rawBody.get(i);
				if (isMethod(i, rawBody) == false) {
					continue;
				}
				if (s.length() == 0 && methodsToDisplay.size() == 0) {
					continue;
				}
				final Member m = new Member(s, true, manageModifier);
				if (hides == null || hides.contains(m.getVisibilityModifier()) == false) {
					methodsToDisplay.add(m);
				}
			}
			removeFinalEmptyMembers(methodsToDisplay);
		}
		return Collections.unmodifiableList(methodsToDisplay);
	}

	private boolean isMethod(int i, List<String> rawBody) {
		if (i > 0 && i < rawBody.size() - 1 && rawBody.get(i).length() == 0 && isMethod(rawBody.get(i - 1))
				&& isMethod(rawBody.get(i + 1))) {
			return true;
		}
		return isMethod(rawBody.get(i));
	}

	public List<Member> getFieldsToDisplay() {
		if (fieldsToDisplay == null) {
			fieldsToDisplay = new ArrayList<Member>();
			for (String s : rawBody) {
				if (isMethod(s) == true) {
					continue;
				}
				if (s.length() == 0 && fieldsToDisplay.size() == 0) {
					continue;
				}
				final Member m = new Member(s, false, manageModifier);
				if (hides == null || hides.contains(m.getVisibilityModifier()) == false) {
					fieldsToDisplay.add(m);
				}
			}
			removeFinalEmptyMembers(fieldsToDisplay);
		}
		return Collections.unmodifiableList(fieldsToDisplay);
	}

	private void removeFinalEmptyMembers(List<Member> result) {
		while (result.size() > 0 && result.get(result.size() - 1).getDisplay(false).trim().length() == 0) {
			result.remove(result.size() - 1);
		}
	}

	public boolean hasUrl() {
		for (Member m : getFieldsToDisplay()) {
			if (m.hasUrl()) {
				return true;
			}
		}
		for (Member m : getMethodsToDisplay()) {
			if (m.hasUrl()) {
				return true;
			}
		}
		return true;
	}
}
