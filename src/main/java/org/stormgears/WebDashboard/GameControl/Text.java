package org.stormgears.WebDashboard.GameControl;

/**
 * Displays a piece of text on the dashboard. This text may or may not be editable.
 */
public class Text extends GameControl {
	/**
	 * Whether the text field should be restricted to number input.
	 */
	public boolean numbersOnly = false;

	public final ControlType type = ControlType.TEXT;

	public Text(String label, String path, byte width, boolean large, boolean enabled, boolean numbersOnly) {
		super(label, path, width, large, enabled);
		this.numbersOnly = numbersOnly;
	}

	public Text(String label, String path, boolean numbersOnly) {
		super(label, path);
		this.numbersOnly = numbersOnly;
	}

	public Text(String label, String path, byte width, boolean large, boolean enabled) {
		super(label, path, width, large, enabled);
	}

	public Text(String label, String path) {
		super(label, path);
	}

	/**
	 * Builder class to assist in the construction of a Text object.
	 */
	public static class Builder {
		private String label;
		private String path;
		private byte width = 12;
		private boolean large = false;
		private boolean enabled = true;
		private boolean numbersOnly = false;

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

		public Builder setNumbersOnly(boolean numbersOnly) {
			this.numbersOnly = numbersOnly;
			return this;
		}

		public Text createText() {
			return new Text(label, path, width, large, enabled, numbersOnly);
		}
	}
}
