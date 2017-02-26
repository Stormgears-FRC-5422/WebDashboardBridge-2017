package org.stormgears.WebDashboard.GameControl;

/**
 * Creates radio buttons on the dashboard.
 */
public class Radios extends GameControl {
	/**
	 * Represents a single radio button.
	 */
	public static class Radio {
		/**
		 * The underlying value used by the software.
		 */
		public final String value;

		/**
		 * The label displayed next to the radio button.
		 */
		public final String label;

		/**
		 * Whether this single radio button is enabled.
		 */
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

	/**
	 * A list of radio buttons to display as options.
	 */
	public final Radios[] entries;

	/**
	 * Specifies the style of toggles.
	 */
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

	/**
	 * Builder class to assist in the construction of a Radios object
	 */
	public static class Builder {
		private String label;
		private String path;
		private byte width = 12;
		private boolean large = false;
		private boolean enabled = true;
		private Radios[] entries;
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

		public Builder setEntries(Radios[] entries) {
			this.entries = entries;
			return this;
		}

		public Builder setToggleType(ToggleType toggleType) {
			this.toggleType = toggleType;
			return this;
		}

		public Radios createRadios() {
			return new Radios(label, path, width, large, enabled, entries, toggleType);
		}
	}
}
