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
package net.sourceforge.plantuml.tikz;

import java.awt.Color;
import java.awt.geom.PathIterator;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sourceforge.plantuml.Log;
import net.sourceforge.plantuml.eps.EpsGraphics;
import net.sourceforge.plantuml.ugraphic.UPath;
import net.sourceforge.plantuml.ugraphic.USegment;
import net.sourceforge.plantuml.ugraphic.USegmentType;
import net.sourceforge.plantuml.version.Version;

public class TikzGraphics {

	// https://www.sharelatex.com/blog/2013/08/27/tikz-series-pt1.html
	// http://cremeronline.com/LaTeX/minimaltikz.pdf

	private final List<String> cmd = new ArrayList<String>();

	private Color color = Color.BLACK;
	private Color fillcolor = Color.BLACK;
	private double thickness = 1.0;
	private String dash = null;

	private final Map<Color, String> colornames = new LinkedHashMap<Color, String>();

	private String getColorName(Color c) {
		if (c.equals(Color.WHITE)) {
			return "white";
		}
		if (c.equals(Color.BLACK)) {
			return "black";
		}
		final String result = colornames.get(c);
		if (result == null) {
			throw new IllegalArgumentException();
		}
		return result;
	}

	public void createData(OutputStream os) throws IOException {
		out(os, "\\documentclass{article}");
		out(os, "\\usepackage{tikz}");
		// out(os, "\\usetikzlibrary{trees}");
		out(os, "\\begin{document}");
		out(os, "% generated by Plantuml " + Version.versionString());
		for (Map.Entry<Color, String> ent : colornames.entrySet()) {
			out(os, definecolor(ent.getValue(), ent.getKey()));

		}
		out(os, "\\begin{tikzpicture}[yscale=-1]");
		for (String s : cmd) {
			out(os, s);
		}
		out(os, "\\end{tikzpicture}");
		out(os, "\\end{document}");
	}

	private String definecolor(String name, Color color) {
		return "\\definecolor{" + name + "}{RGB}{" + color.getRed() + "," + color.getGreen() + "," + color.getBlue()
				+ "}";
	}

	public void rectangle(double x, double y, double width, double height) {
		final StringBuilder sb = new StringBuilder();
		sb.append("\\draw[");
		if (color != null) {
			sb.append("color=" + getColorName(color) + ",");
		}
		if (fillcolor != null) {
			sb.append("fill=" + getColorName(fillcolor) + ",");
			if (color == null) {
				sb.append("color=" + getColorName(fillcolor) + ",");
			}
		}
		sb.append("line width=" + thickness + "pt] ");
		sb.append(couple(x, y) + " rectangle " + couple(x + width, y + height));
		sb.append(";");
		cmd.add(sb.toString());
	}

	private String couple(double x, double y) {
		return "(" + format(x) + "pt," + format(y) + "pt)";
	}

	private String format(double x) {
		return EpsGraphics.format(x);
	}

	private void out(OutputStream os, String s) throws IOException {
		os.write(s.getBytes());
		os.write("\n".getBytes());
	}

	public void text(double x, double y, String text) {
		final String s = "\\node at " + couple(x, y) + "[below right]{" + text + "};";
		cmd.add(s);
	}

	public void line(double x1, double y1, double x2, double y2) {
		final StringBuilder sb = new StringBuilder();
		sb.append("\\draw[");
		if (color != null) {
			sb.append("color=" + getColorName(color) + ",");
		}
		sb.append("line width=" + thickness + "pt");
		if (dash != null) {
			sb.append(",dash pattern=" + dash);
		}
		sb.append("] ");
		sb.append(couple(x1, y1));
		sb.append(" -- ");
		sb.append(couple(x2, y2));
		sb.append(";");
		cmd.add(sb.toString());
	}

	public void polygon(double[] points) {
		final StringBuilder sb = new StringBuilder("\\draw[");
		if (color != null) {
			sb.append("color=" + getColorName(color) + ",");
		}
		if (fillcolor != null) {
			sb.append("fill=" + getColorName(fillcolor) + ",");
		}
		sb.append("line width=" + thickness + "pt]");
		sb.append(" ");
		for (int i = 0; i < points.length; i += 2) {
			sb.append(couple(points[i], points[i + 1]));
			sb.append(" -- ");
		}
		sb.append("cycle;");
		cmd.add(sb.toString());
	}

	public void upath(double x, double y, UPath path) {
		final StringBuilder sb = new StringBuilder("\\draw[color=" + getColorName(color) + ",line width=" + thickness
				+ "pt] ");
		for (USegment seg : path) {
			final USegmentType type = seg.getSegmentType();
			final double coord[] = seg.getCoord();
			if (type == USegmentType.SEG_MOVETO) {
				sb.append(couple(coord[0] + x, coord[1] + y));
			} else if (type == USegmentType.SEG_LINETO) {
				sb.append(" -- ");
				sb.append(couple(coord[0] + x, coord[1] + y));
			} else if (type == USegmentType.SEG_QUADTO) {
				throw new UnsupportedOperationException();
			} else if (type == USegmentType.SEG_CUBICTO) {
				// curvetoNoMacro(coord[0] + x, coord[1] + y, coord[2] + x, coord[3] + y, coord[4] + x, coord[5] + y);
				sb.append(" ..controls ");
				sb.append(couple(coord[0] + x, coord[1] + y));
				sb.append(" and ");
				sb.append(couple(coord[2] + x, coord[3] + y));
				sb.append(" .. ");
				sb.append(couple(coord[4] + x, coord[5] + y));
			} else if (type == USegmentType.SEG_CLOSE) {
				// Nothing
			} else {
				Log.println("unknown " + seg);
			}
		}
		sb.append(";");
		cmd.add(sb.toString());
	}

	public void ellipse(double x, double y, double width, double height) {
		final StringBuilder sb = new StringBuilder();
		sb.append("\\draw[");
		if (color != null) {
			sb.append("color=" + getColorName(color) + ",");
		}
		if (fillcolor != null) {
			sb.append("fill=" + getColorName(fillcolor) + ",");
		}
		sb.append("line width=" + thickness + "pt] " + couple(x, y) + " ellipse (" + format(width) + "pt and "
				+ format(height) + "pt);");
		cmd.add(sb.toString());
	}

	public void drawPathIterator(double x, double y, PathIterator path) {
		final StringBuilder sb = new StringBuilder("\\draw[color=" + getColorName(color) + ",fill="
				+ getColorName(color) + "] ");
		final double coord[] = new double[6];
		while (path.isDone() == false) {
			final int code = path.currentSegment(coord);
			if (code == PathIterator.SEG_MOVETO) {
				sb.append(couple(coord[0] + x, coord[1] + y));
			} else if (code == PathIterator.SEG_LINETO) {
				sb.append(" -- ");
				sb.append(couple(coord[0] + x, coord[1] + y));
			} else if (code == PathIterator.SEG_CLOSE) {
				sb.append(";");
				cmd.add(sb.toString());
				sb.setLength(0);
				sb.append("\\draw ");
			} else if (code == PathIterator.SEG_CUBICTO) {
				sb.append(" ..controls ");
				sb.append(couple(coord[0] + x, coord[1] + y));
				sb.append(" and ");
				sb.append(couple(coord[2] + x, coord[3] + y));
				sb.append(" .. ");
				sb.append(couple(coord[4] + x, coord[5] + y));
			} else if (code == PathIterator.SEG_QUADTO) {
				sb.append(" ..controls ");
				sb.append(couple(coord[0] + x, coord[1] + y));
				sb.append(" .. ");
				sb.append(couple(coord[2] + x, coord[3] + y));
			} else {
				throw new UnsupportedOperationException("code=" + code);
			}

			path.next();
		}

		// eps.fill(path.getWindingRule());

	}

	public void setFillColor(Color c) {
		// if (c == null) {
		// c = Color.WHITE;
		// }
		this.fillcolor = c;
		addColor(c);
	}

	public void setStrokeColor(Color c) {
		// if (c == null) {
		// throw new IllegalArgumentException();
		// }
		this.color = c;
		addColor(c);
	}

	private void addColor(Color c) {
		if (c == null) {
			return;
		}
		if (colornames.containsKey(c)) {
			return;
		}
		final String name = "plantucolor" + String.format("%04d", colornames.size());
		colornames.put(c, name);
	}

	public void setStrokeWidth(double thickness, String dash) {
		this.thickness = thickness;
		this.dash = dash;
	}

}