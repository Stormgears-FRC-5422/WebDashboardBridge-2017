package org.stormgears.WebDashboard.GameControl;

/**
 * Created by andrew on 2/24/17.
 */
public class TextArea extends GameControl {
	public final ControlType type = ControlType.TEXTAREA;

	public TextArea(String label, String path, byte width, boolean large, boolean enabled) {
		super(label, path, width, large, enabled);
	}

	public TextArea(String label, String path) {
		super(label, path);
	}

	public static class Builder {
		private String label;
		private String path;
		private byte width = 12;
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

		public TextArea createTextArea() {
			return new TextArea(label, path, width, large, enabled);
		}
	}
}
