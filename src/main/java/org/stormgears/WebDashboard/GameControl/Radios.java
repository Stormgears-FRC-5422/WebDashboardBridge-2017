package org.stormgears.WebDashboard.GameControl;

/**
 * Created by andrew on 2/24/17.
 */
public class Radios extends GameControl {
	public static class Radio {
		public final String value;
		public final String label;
		public boolean enabled = true;

		public Radio(String value, String label) {
			this.value = value;
			this.label = label;
		}

		public Radio(String value, String label, boolean enabled) {
			this.value = value;
			this.label = label;
			this.enabled = enabled;
		}
	}

	public final Radios[] entries;
	public ToggleType toggleType = ToggleType.DEFAULT;

	public final ControlType type = ControlType.RADIOS;

	public Radios(String label, String path, byte width, boolean large, boolean enabled, Radios[] entries) {
		super(label, path, width, large, enabled);
		this.entries = entries;
	}

	public Radios(String label, String path, Radios[] entries) {
		super(label, path);
		this.entries = entries;
	}

	public Radios(String label, String path, byte width, boolean large, boolean enabled, Radios[] entries, ToggleType toggleType) {
		super(label, path, width, large, enabled);
		this.entries = entries;
		this.toggleType = toggleType;
	}

	public Radios(String label, String path, Radios[] entries, ToggleType toggleType) {
		super(label, path);
		this.entries = entries;
		this.toggleType = toggleType;
	}
}
