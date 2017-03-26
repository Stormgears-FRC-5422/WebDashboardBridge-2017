package org.stormgears.WebDashboard.GameControl;

/**
 * Creates a single-line text box on the dashboard.
 */
public class TextField extends GameControl {
	/**
	 * Whether the text box should be limited to numerical input.
	 */
	public boolean numbersOnly = false;

	public TextField(String label, String path, int width, boolean large, boolean enabled) {
		super(label, path, width, large, enabled);
	}

	public TextField(String label, String path) {
		super(label, path);
	}

	public TextField(String label, String path, int width, boolean large, boolean enabled, boolean numbersOnly) {
		super(label, path, width, large, enabled);
		this.numbersOnly = numbersOnly;
	}

	public TextField(String label, String path, boolean numbersOnly) {
		super(label, path);
		this.numbersOnly = numbersOnly;
	}

	@Override
	public ControlType getControlType() {
		return ControlType.TEXTFIELD;
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

		public Builder setNumbersOnly(boolean numbersOnly) {
			this.numbersOnly = numbersOnly;
			return this;
		}

		public TextField createTextField() {
			return new TextField(label, path, width, large, enabled, numbersOnly);
		}
	}
}
