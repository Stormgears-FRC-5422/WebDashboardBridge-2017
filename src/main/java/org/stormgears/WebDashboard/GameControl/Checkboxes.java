package org.stormgears.WebDashboard.GameControl;

/**
 * Created by andrew on 2/24/17.
 */
public class Checkboxes extends GameControl {
	public class Checkbox {
		public final String value;
		public final String label;
		public boolean enabled = true;

		public Checkbox(String value, String label) {
			this.value = value;
			this.label = label;
		}

		public Checkbox(String value, String label, boolean enabled) {
			this.value = value;
			this.label = label;
			this.enabled = enabled;
		}
	}

	public final Checkbox[] entries;
	public ToggleType toggleType = ToggleType.DEFAULT;

	public final ControlType type = ControlType.CHECKBOXES;

	public Checkboxes(String label, String path, byte width, boolean large, boolean enabled, Checkbox[] entries) {
		super(label, path, width, large, enabled);
		this.entries = entries;
	}

	public Checkboxes(String label, String path, Checkbox[] entries) {
		super(label, path);
		this.entries = entries;
	}

	public Checkboxes(String label, String path, byte width, boolean large, boolean enabled, Checkbox[] entries, ToggleType toggleType) {
		super(label, path, width, large, enabled);
		this.entries = entries;
		this.toggleType = toggleType;
	}

	public Checkboxes(String label, String path, Checkbox[] entries, ToggleType toggleType) {
		super(label, path);
		this.entries = entries;
		this.toggleType = toggleType;
	}
}
