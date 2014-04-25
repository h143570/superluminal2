package com.kartoflane.superluminal2.components;

import com.kartoflane.superluminal2.core.Manager;

public class Hotkey {
	public enum Hotkeys {
		// Tools
		POINTER_TOOL,
		CREATE_TOOL,
		GIB_TOOL,
		PROPERTIES_TOOL,
		OVERVIEW_TOOL,
		ROOM_TOOL,
		DOOR_TOOL,
		MOUNT_TOOL,
		STATION_TOOL,

		// Commands
		DELETE,
		PIN,
		NEW_SHIP,
		LOAD_SHIP,
		SAVE_SHIP,
		CLOSE_SHIP,
		UNDO,
		REDO,

		// View
		TOGGLE_GRID,
		SHOW_ANCHOR,
		SHOW_MOUNTS,
		SHOW_ROOMS,
		SHOW_DOORS,
		SHOW_STATIONS,
		SHOW_HULL,
		SHOW_FLOOR,
		SHOW_SHIELD;
	}

	private final Hotkeys id;

	private boolean shift = false;
	private boolean ctrl = false;
	private boolean alt = false;
	private int key = '\0';

	public Hotkey(Hotkeys id) {
		this.id = id;
	}

	public Hotkeys getId() {
		return id;
	}

	public void setKey(int ch) {
		key = ch;
	}

	public int getKey() {
		return key;
	}

	public void setShift(boolean shift) {
		this.shift = shift;
	}

	public boolean getShift() {
		return shift;
	}

	public void setCtrl(boolean control) {
		ctrl = control;
	}

	public boolean getCtrl() {
		return ctrl;
	}

	public void setAlt(boolean alt) {
		this.alt = alt;
	}

	public boolean getAlt() {
		return alt;
	}

	/**
	 * Checks whether the hotkey is to be activated by comparing the hotkey's modifier settings with currently
	 * active modifiers, and the hotkey's trigger key with currently pressed key.
	 * 
	 * @param keyCode
	 *            int representing the currently pressed key
	 * @return true if the hotkey is tiggered, false otherwise
	 */
	public boolean passes(int keyCode) {
		return Manager.modShift == shift && Manager.modCtrl == ctrl && Manager.modAlt == alt && key == keyCode;
	}

	@Override
	public String toString() {
		if (key == '\0')
			return "";

		StringBuilder buf = new StringBuilder();

		if (shift)
			buf.append("Shift+");
		if (ctrl)
			buf.append("Ctrl+");
		if (alt)
			buf.append("Alt+");

		if (key == ' ')
			buf.append("Spacebar");
		else if (key == '\t')
			buf.append("Tab");
		else {
			buf.append(Character.toUpperCase((char) key));
		}

		return buf.toString();
	}
}
