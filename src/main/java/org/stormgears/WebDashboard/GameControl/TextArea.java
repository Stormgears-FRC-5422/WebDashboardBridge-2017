package org.stormgears.WebDashboard.GameControl;

/**
 * Creates a multi-line text area on the dashboard.
 */
public class TextArea extends GameControl {
	public TextArea(String label, String path, int width, boolean large, boolean enabled) {
		super(label, path, width, large, enabled);
	}

	public TextArea(String label, String path) {
		super(label, path);
	}

	@Override
	public ControlType getControlType() {
		return ControlType.TEXTAREA;
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

		public TextArea createTextArea() {
			return new TextArea(label, path, width, large, enabled);
		}
	}
}
