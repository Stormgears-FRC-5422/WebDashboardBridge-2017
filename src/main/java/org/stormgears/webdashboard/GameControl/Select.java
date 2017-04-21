package org.stormgears.webdashboard.GameControl;

/**
 * Creates a dropdown menu on the dashboard.
 */
public class Select implements GameControl {
	/**
	 * Represents a single choice in the dropdown menu.
	 */
	public static class Option {
		public final String label;
		public final String value;

		public Option(String label, String value) {
			this.label = label;
			this.value = value;
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
	 * A list of options to display
	 */
	public final Option[] options;

	public final ControlType type = ControlType.SELECT;

	public Select(String label, String path, Option[] options) {
		this.label = label;
		this.path = path;
		this.options = options;
	}

	public Select(String label, String path, int width, boolean large, boolean enabled, Option[] options) {
		this.label = label;
		this.path = path;
		this.width = width;
		this.large = large;
		this.enabled = enabled;
		this.options = options;
	}

	/**
	 * Builder class to assist in the construction of a Select
	 */
	public static class Builder {
		private String label;
		private String path;
		private int width = 12;
		private boolean large = false;
		private boolean enabled = true;
		private Select.Option[] options;

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

		public Builder setOptions(Select.Option[] options) {
			this.options = options;
			return this;
		}

		public Select createSelect() {
			return new Select(label, path, width, large, enabled, options);
		}
	}
}
