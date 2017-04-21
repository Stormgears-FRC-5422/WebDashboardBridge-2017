package org.stormgears.webdashboard.GameControl;

/**
 * Displays a piece of text on the dashboard. This text may or may not be editable.
 */
public class Text implements GameControl {
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
	public boolean editable = false;

	/**
	 * Whether the text field should be restricted to number input.
	 */
	public boolean numbersOnly = false;

	public final ControlType type = ControlType.TEXT;

	public Text(String label, String path) {
		this.label = label;
		this.path = path;
	}

	public Text(String label, String path, int width, boolean large, boolean editable, boolean numbersOnly) {
		this.label = label;
		this.path = path;
		this.width = width;
		this.large = large;
		this.editable = editable;
		this.numbersOnly = numbersOnly;
	}

	/**
	 * Builder class to assist in the construction of a Text object.
	 */
	public static class Builder {
		private String label;
		private String path;
		private int width = 12;
		private boolean large = false;
		private boolean editable = false;
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

		public Builder setEditable(boolean editable) {
			this.editable = editable;
			return this;
		}

		public Builder setNumbersOnly(boolean numbersOnly) {
			this.numbersOnly = numbersOnly;
			return this;
		}

		public Text createText() {
			return new Text(label, path, width, large, editable, numbersOnly);
		}
	}
}
