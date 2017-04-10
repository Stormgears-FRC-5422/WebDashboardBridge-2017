package org.stormgears.WebDashboard.GameControl;

/**
 * Creates a single-line text box on the dashboard.
 */
public class TextField implements GameControl {
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
	 * Specifies whether the text field fills the entire width allowed.
	 */
	public boolean fill = false;

	/**
	 * Whether the text box should be limited to numerical input.
	 */
	public boolean numbersOnly = false;

	public final ControlType type = ControlType.TEXTFIELD;

	public TextField(String label, String path, int width, boolean large, boolean enabled, boolean fill, boolean numbersOnly) {
		this.label = label;
		this.path = path;
		this.width = width;
		this.large = large;
		this.enabled = enabled;
		this.fill = fill;
		this.numbersOnly = numbersOnly;
	}

	/**
	 * Builder class to assist in the construction of a TextField object
	 */
	public static class Builder {
		private String label;
		private String path;
		private int width = 12;
		private boolean large = false;
		private boolean enabled = true;
		private boolean fill = false;
		private boolean numbersOnly = false;

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

		public Builder setFill(boolean fill) {
			this.fill = fill;
			return this;
		}

		public Builder setNumbersOnly(boolean numbersOnly) {
			this.numbersOnly = numbersOnly;
			return this;
		}

		public TextField createTextField() {
			return new TextField(label, path, width, large, enabled, fill, numbersOnly);
		}
	}
}
