package org.stormgears.webdashboard.GameControl;

/**
 * Creates radio buttons on the dashboard.
 */
public class Radios implements GameControl {
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
	 * Text to be displayed near the control.
	 */
	public final String label;

	/**
	 * Specifies what JSON path the control is bound to. The control will display the value of the JSON path in
	 * WebDashboard's distributed hashtable, and changes made to the control's value will be propagated to the
	 * hashtable.
	 */
	public final String path;

	/**
	 * The width of the control, ranging from 1 to 12.
	 */
	public int width = 12;

	/**
	 * Specifies whether the control is displayed with large text.
	 */
	public boolean large = false;

	/**
	 * Specifies whether the user is allowed to make modifications to the control's value.
	 */
	public boolean enabled = true;

	/**
	 * A list of radio buttons to display as options.
	 */
	public final Radio[] entries;

	/**
	 * Specifies the style of toggles.
	 */
	public ToggleType toggleType = ToggleType.DEFAULT;

	public final ControlType type = ControlType.RADIOS;

	public Radios(String label, String path, int width, boolean large, boolean enabled, Radio[] entries, ToggleType toggleType) {
		this.label = label;
		this.path = path;
		this.width = width;
		this.large = large;
		this.enabled = enabled;
		this.entries = entries;
		this.toggleType = toggleType;
	}

	/**
	 * Builder class to assist in the construction of a Radios object
	 */
	public static class Builder {
		private String label;
		private String path;
		private int width = 12;
		private boolean large = false;
		private boolean enabled = true;
		private Radios.Radio[] entries;
		private ToggleType toggleType = ToggleType.DEFAULT;

		public Builder setLabel(String label) {
			this.label = label;
			return this;
		}

		public Builder setPath(String path) {
			this.path = path;
			return this;
		}

		public Builder setWidth(int width) {
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

		public Builder setEntries(Radios.Radio[] entries) {
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