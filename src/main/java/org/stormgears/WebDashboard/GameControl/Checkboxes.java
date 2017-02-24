package org.stormgears.WebDashboard.GameControl;

/**
 * Created by andrew on 2/24/17.
 */
public class Checkboxes extends GameControl {
	public static class Checkbox {
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

	public static class Builder {
		private String label;
		private String path;
		private byte width = 12;
		private boolean large = false;
		private boolean enabled = true;
		private Checkbox[] entries;
		private ToggleType toggleType = ToggleType.DEFAULT;

		public Builder setLabel(String label) {
			this.label = label;
			return this;
		}

		public Builder setPath(String path) {
			this.path = path;
			return this;
		}

		public Builder setWidth(byte width) {
			this.width = width;
			return this;
		}

		public Builder setLarge(boolean large) {
			this.large = large;
			return this;
		}

		public Builder setEnabled(boolean enabled) {
			this.enabled = enabled;
			return this;
		}

		public Builder setEntries(Checkbox[] entries) {
			this.entries = entries;
			return this;
		}

		public Builder setToggleType(ToggleType toggleType) {
			this.toggleType = toggleType;
			return this;
		}

		public Checkboxes createCheckboxes() {
			return new Checkboxes(label, path, width, large, enabled, entries);
		}
	}
}
