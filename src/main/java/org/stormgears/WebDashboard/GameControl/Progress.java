package org.stormgears.WebDashboard.GameControl;

/**
 * Creates a progress display in the dashboard. This represents a floating-point value from 0.0 to 1.0.
 */
public class Progress extends GameControl {
	/**
	 * Represents the type of progress display.
	 */
	public enum Type {
		/**
		 * Changes the display style to a progress bar.
		 */
		BAR,

		/**
		 * Changes the display style to a round "spinner."
		 */
		SPINNER
	}

	/**
	 * Specifies whether the progress bar should have stripes.
	 */
	public boolean stripes = true;

	/**
	 * Specifies the type of progress display
	 */
	public Type progressType = Type.BAR;

	/**
	 * Specifies the color of the progress bar
	 */
	public Intent intent = Intent.NONE;

	public Progress(String label, String path, int width, boolean large, boolean enabled, boolean stripes, Type progressType, Intent intent) {
		super(label, path, width, large, enabled);
		this.stripes = stripes;
		this.progressType = progressType;
		this.intent = intent;
	}

	public Progress(String label, String path, boolean stripes, Type progressType, Intent intent) {
		super(label, path);
		this.stripes = stripes;
		this.progressType = progressType;
		this.intent = intent;
	}

	public Progress(String label, String path, int width, boolean large) {
		super(label, path, width, large, true);
	}

	public Progress(String label, String path) {
		super(label, path);
	}

	public Progress(String label, String path, int width, boolean large, boolean stripes, Type progressType) {
		super(label, path, width, large, true);
		this.stripes = stripes;
		this.progressType = progressType;
	}

	public Progress(String label, String path, boolean stripes, Type progressType) {
		super(label, path);
		this.stripes = stripes;
		this.progressType = progressType;
	}

	/**
	 * Builder class to assist the construction of a Progress object
	 */
	public static class Builder {
		private String label;
		private String path;
		private int width = 12;
		private boolean large = false;
		private boolean enabled = true;
		private boolean stripes = true;
		private Type progressType = Type.BAR;
		private Intent intent = Intent.NONE;

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

		public Builder setStripes(boolean stripes) {
			this.stripes = stripes;
			return this;
		}

		public Builder setProgressType(Type progressType) {
			this.progressType = progressType;
			return this;
		}

		public Builder setIntent(Intent intent) {
			this.intent = intent;
			return this;
		}

		public Progress createProgress() {
			return new Progress(label, path, width, large, enabled, stripes, progressType, intent);
		}
	}

	@Override
	public ControlType getControlType() {
		return ControlType.PROGRESS;
	}
}
