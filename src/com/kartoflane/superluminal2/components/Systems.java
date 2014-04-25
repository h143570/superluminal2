package com.kartoflane.superluminal2.components;

public enum Systems {
	EMPTY,
	ARTILLERY, BATTERY, CLOAKING, CLONEBAY, DOORS, DRONES, ENGINES, HACKING,
	MEDBAY, MIND, OXYGEN, PILOT, SENSORS, SHIELDS, TELEPORTER, WEAPONS;

	@Override
	public String toString() {
		String result = super.toString().toLowerCase();
		result = result.substring(0, 1).toUpperCase() + result.substring(1);
		return result;
	}

	/** @return array of all systems, excluding {@link #EMPTY} */
	public static Systems[] getSystems() {
		return new Systems[] {
				ARTILLERY, BATTERY, CLOAKING, CLONEBAY, DOORS, DRONES, ENGINES, HACKING,
				MEDBAY, MIND, OXYGEN, PILOT, SENSORS, SHIELDS, TELEPORTER, WEAPONS,
		};
	}

	/** Returns true if the system can have a station, false otherwise. */
	public boolean canContainStation() {
		return this == Systems.SHIELDS || this == Systems.ENGINES ||
				this == Systems.WEAPONS || this == Systems.MEDBAY ||
				this == Systems.PILOT || this == Systems.DOORS ||
				this == Systems.SENSORS || this == Systems.CLONEBAY;
	}

	/** Returns true if the system can have a interior image, false otherwise */
	public boolean canContainInterior() {
		return this != Systems.EMPTY && this != Systems.CLONEBAY && this != Systems.TELEPORTER;
	}

	/** Returns true if the system can have a glow image, false otherwise. */
	public boolean canContainGlow() {
		return this == Systems.SHIELDS || this == Systems.ENGINES ||
				this == Systems.WEAPONS || this == Systems.PILOT ||
				this == Systems.CLOAKING;
	}

	public int getDefaultSlotId() {
		switch (this) {
			case PILOT:
			case DOORS:
			case SHIELDS:
				return 0;
			case WEAPONS:
			case MEDBAY:
			case CLONEBAY:
			case SENSORS:
				return 1;
			case ENGINES:
				return 2;
			default:
				return -2;
		}
	}

	public Directions getDefaultSlotDirection() {
		switch (this) {
			case ENGINES:
				return Directions.DOWN;
			case PILOT:
				return Directions.RIGHT;
			case SHIELDS:
				return Directions.LEFT;
			case WEAPONS:
			case DOORS:
			case SENSORS:
				return Directions.UP;
			case MEDBAY:
			case CLONEBAY:
				return Directions.NONE;
			default:
				return Directions.UP;
		}
	}

	public String getDefaultInterior() {
		switch (this) {
			case ARTILLERY:
				return "rdat:img/ship/interior/room_artillery.png";
			case BATTERY:
				return "rdat:img/ship/interior/room_battery.png";
			case CLOAKING:
				return "rdat:img/ship/interior/room_cloaking.png";
			case DOORS:
				return "rdat:img/ship/interior/room_doors.png";
			case DRONES:
				return "rdat:img/ship/interior/room_drones.png";
			case ENGINES:
				return "rdat:img/ship/interior/room_engines.png";
			case HACKING:
				return "rdat:img/ship/interior/room_hacking.png";
			case MEDBAY:
				return "rdat:img/ship/interior/room_medbay.png";
			case MIND:
				return "rdat:img/ship/interior/room_mind.png";
			case OXYGEN:
				return "rdat:img/ship/interior/room_oxygen.png";
			case PILOT:
				return "rdat:img/ship/interior/room_pilot.png";
			case SENSORS:
				return "rdat:img/ship/interior/room_sensors.png";
			case SHIELDS:
				return "rdat:img/ship/interior/room_shields.png";
			case WEAPONS:
				return "rdat:img/ship/interior/room_weapons.png";
			case CLONEBAY: // always uses the clonebay "station", can't have interior
			case TELEPORTER: // always uses teleporter pads, can't have interior
			case EMPTY: // can't have interior
			default:
				return null;
		}
	}
}
