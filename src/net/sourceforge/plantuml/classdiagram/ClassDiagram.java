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
package net.sourceforge.plantuml.classdiagram;

import net.sourceforge.plantuml.UmlDiagramType;
import net.sourceforge.plantuml.cucadiagram.Code;
import net.sourceforge.plantuml.cucadiagram.Display;
import net.sourceforge.plantuml.cucadiagram.EntityUtils;
import net.sourceforge.plantuml.cucadiagram.GroupType;
import net.sourceforge.plantuml.cucadiagram.IGroup;
import net.sourceforge.plantuml.cucadiagram.ILeaf;
import net.sourceforge.plantuml.cucadiagram.LeafType;
import net.sourceforge.plantuml.graphic.USymbol;
import net.sourceforge.plantuml.objectdiagram.AbstractClassOrObjectDiagram;

public class ClassDiagram extends AbstractClassOrObjectDiagram {

	private String namespaceSeparator = ".";

	@Override
	public ILeaf getOrCreateLeaf(Code code, LeafType type, USymbol symbol) {
		if (namespaceSeparator != null) {
			code = code.withSeparator(namespaceSeparator);
		}
		if (type == null) {
			code = code.eventuallyRemoveStartingAndEndingDoubleQuote();
			if (namespaceSeparator == null) {
				return getOrCreateLeafDefault(code, LeafType.CLASS, symbol);
			}
			code = code.getFullyQualifiedCode(getCurrentGroup());
			if (super.leafExist(code)) {
				return getOrCreateLeafDefault(code, LeafType.CLASS, symbol);
			}
			return createEntityWithNamespace(code, Display.getWithNewlines(code.getShortName(getLeafs())),
					LeafType.CLASS, symbol);
		}
		if (namespaceSeparator == null) {
			return getOrCreateLeafDefault(code, LeafType.CLASS, symbol);
		}
		code = code.getFullyQualifiedCode(getCurrentGroup());
		if (super.leafExist(code)) {
			return getOrCreateLeafDefault(code, type, symbol);
		}
		return createEntityWithNamespace(code, Display.getWithNewlines(code.getShortName(getLeafs())), type, symbol);
	}

	@Override
	public ILeaf createLeaf(Code code, Display display, LeafType type, USymbol symbol) {
		if (namespaceSeparator != null) {
			code = code.withSeparator(namespaceSeparator);
		}
		if (type != LeafType.ABSTRACT_CLASS && type != LeafType.ANNOTATION && type != LeafType.CLASS
				&& type != LeafType.INTERFACE && type != LeafType.ENUM && type != LeafType.LOLLIPOP
				&& type != LeafType.NOTE) {
			return super.createLeaf(code, display, type, symbol);
		}
		if (namespaceSeparator == null) {
			return super.createLeaf(code, display, type, symbol);
		}
		code = code.getFullyQualifiedCode(getCurrentGroup());
		if (super.leafExist(code)) {
			throw new IllegalArgumentException("Already known: " + code);
		}
		return createEntityWithNamespace(code, display, type, symbol);
	}

	private ILeaf createEntityWithNamespace(Code fullyCode, Display display, LeafType type, USymbol symbol) {
		IGroup group = getCurrentGroup();
		final String namespace = getNamespace(fullyCode);
		if (namespace != null
				&& (EntityUtils.groupRoot(group) || group.getCode().getFullName().equals(namespace) == false)) {
			final Code namespace2 = Code.of(namespace);
			group = getOrCreateGroupInternal(namespace2, Display.getWithNewlines(namespace), namespace2,
					GroupType.PACKAGE, getRootGroup());
		}
		return createLeafInternal(fullyCode,
				display == null ? Display.getWithNewlines(fullyCode.getShortName(getLeafs())) : display, type, group,
				symbol);
	}

	private final String getNamespace(Code fullyCode) {
		String name = fullyCode.getFullName();
		do {
			final int x = name.lastIndexOf(namespaceSeparator);
			if (x == -1) {
				return null;
			}
			name = name.substring(0, x);
		} while (getLeafs().containsKey(Code.of(name, namespaceSeparator)));
		return name;
	}

	@Override
	public final boolean leafExist(Code code) {
		if (namespaceSeparator == null) {
			return super.leafExist(code);
		}
		code = code.withSeparator(namespaceSeparator);
		return super.leafExist(code.getFullyQualifiedCode(getCurrentGroup()));
	}

	@Override
	public UmlDiagramType getUmlDiagramType() {
		return UmlDiagramType.CLASS;
	}

	public void setNamespaceSeparator(String namespaceSeparator) {
		this.namespaceSeparator = namespaceSeparator;
	}

	public String getNamespaceSeparator() {
		return namespaceSeparator;
	}

}
