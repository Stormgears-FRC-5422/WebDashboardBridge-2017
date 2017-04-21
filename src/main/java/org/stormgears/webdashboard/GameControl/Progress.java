package org.stormgears.webdashboard.GameControl;

/**
 * Creates a progress display in the dashboard. This represents a floating-point value from 0.0 to 1.0.
 */
public class Progress implements GameControl {
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
	 * Specifies whether the progress bar should have stripes.
	 */
	public boolean stripes = true;

	/**
	 * Specifies whether the progress bar should be animated.
	 */
	public boolean animated = false;

	/**
	 * Specifies the color of the progress bar
	 */
	public Intent intent = Intent.NONE;

	public final ControlType type = ControlType.PROGRESS;

	public Progress(String label, String path) {
		this.label = label;
		this.path = path;
	}

	public Progress(String label, String path, int width, boolean stripes, boolean animated, Intent intent) {
		this.label = label;
		this.path = path;
		this.width = width;
		this.stripes = stripes;
		this.animated = animated;
		this.intent = intent;
	}

	/**
	 * Builder class to assist the construction of a Progress object
	 */
	public static class Builder {
		private String label;
		private String path;
		private int width = 12;
		private boolean stripes = true;
		private boolean animated = false;
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

		public Builder setStripes(boolean stripes) {
			this.stripes = stripes;
			return this;
		}

		public Builder setAnimated(boolean animated) {
			this.animated = animated;
			return this;
		}

		public Builder setIntent(Intent intent) {
			this.intent = intent;
			return this;
		}

		public Progress createProgress() {
			return new Progress(label, path, width, stripes, animated, intent);
		}
	}
}
