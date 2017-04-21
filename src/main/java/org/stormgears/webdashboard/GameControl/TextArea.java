package org.stormgears.webdashboard.GameControl;

/**
 * Creates a multi-line text area on the dashboard.
 */
public class TextArea implements GameControl {
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
	 * Whether the text box should be limited to numerical input.
	 */
	public boolean fill = false;

	public final ControlType type = ControlType.TEXTAREA;

	public TextArea(String label, String path) {
		this.label = label;
		this.path = path;
	}

	public TextArea(String label, String path, int width, boolean large, boolean enabled, boolean fill) {
		this.label = label;
		this.path = path;
		this.width = width;
		this.large = large;
		this.enabled = enabled;
		this.fill = fill;
	}

	/**
	 * Builder class to assist in the construction of a TextArea.
	 */
	public static class Builder {
		private String label;
		private String path;
		private int width = 12;
		private boolean large = false;
		private boolean enabled = true;
		private boolean fill = false;

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

		public TextArea createTextArea() {
			return new TextArea(label, path, width, large, enabled, fill);
		}
	}
}
