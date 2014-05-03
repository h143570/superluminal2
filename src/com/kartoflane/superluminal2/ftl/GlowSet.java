package com.kartoflane.superluminal2.ftl;

import com.kartoflane.superluminal2.components.interfaces.Identifiable;

public class GlowSet implements Comparable<GlowSet>, Identifiable {

	public enum Glows {
		CLOAK, BLUE, GREEN, YELLOW;
	}

	private final String namespace;
	private String glowC = null;
	private String glowB = null;
	private String glowG = null;
	private String glowY = null;

	public GlowSet() {
		this.namespace = "glow";
		setImage(Glows.BLUE, "dat:img/ship/interior/glow1.png");
		setImage(Glows.GREEN, "dat:img/ship/interior/glow2.png");
		setImage(Glows.YELLOW, "dat:img/ship/interior/glow3.png");
	}

	public GlowSet(String namespace) {
		this.namespace = namespace;
	}

	@Override
	public String getIdentifier() {
		return namespace;
	}

	public void setImage(Glows id, String path) {
		if (id == null)
			throw new IllegalArgumentException("Glow id must not be null.");
		switch (id) {
			case CLOAK:
				glowC = path;
				break;
			case BLUE:
				glowB = path;
				break;
			case GREEN:
				glowG = path;
				break;
			case YELLOW:
				glowY = path;
				break;
		}
	}

	public String getImage(Glows id) {
		if (id == null)
			throw new IllegalArgumentException("Glow id must not be null.");
		switch (id) {
			case CLOAK:
				return glowC;
			case BLUE:
				return glowB;
			case GREEN:
				return glowG;
			case YELLOW:
				return glowY;
			default:
				throw new IllegalArgumentException("Unknown glow id: " + id);
		}
	}

	@Override
	public int compareTo(GlowSet o) {
		return namespace.compareTo(o.namespace);
	}

}
