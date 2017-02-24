package org.stormgears.WebDashboard.GameControl;

/**
 * Created by andrew on 2/24/17.
 */
public class Progress extends GameControl {
	public enum Type {
		BAR,
		SPINNER
	}
	public boolean stripes = true;
	public Type progressType = Type.BAR;

	public ControlType type = ControlType.PROGRESS;

	public Progress(String label, String path, byte width, boolean large, boolean enabled) {
		super(label, path, width, large, enabled);
	}

	public Progress(String label, String path) {
		super(label, path);
	}

	public Progress(String label, String path, byte width, boolean large, boolean enabled, boolean stripes, Type progressType) {
		super(label, path, width, large, enabled);
		this.stripes = stripes;
		this.progressType = progressType;
	}

	public Progress(String label, String path, boolean stripes, Type progressType) {
		super(label, path);
		this.stripes = stripes;
		this.progressType = progressType;
	}

	public static class Builder {
		private String label;
		private String path;
		private byte width = 12;
		private boolean large = false;
		private boolean enabled = true;
		private boolean stripes = true;
		private Type progressType = Type.BAR;

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

		public Builder setStripes(boolean stripes) {
			this.stripes = stripes;
			return this;
		}

		public Builder setProgressType(Type progressType) {
			this.progressType = progressType;
			return this;
		}

		public Progress createProgress() {
			return new Progress(label, path, width, large, enabled);
		}
	}
}
