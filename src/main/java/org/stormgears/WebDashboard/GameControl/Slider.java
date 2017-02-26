package org.stormgears.WebDashboard.GameControl;

/**
 * Creates a slider control in the dashboard. Displays and controls a numerical value.
 */
public class Slider extends GameControl {
	/**
	 * The minimum value of the slider
	 */
	public int min = 0;

	/**
	 * The maximum value of the slider.
	 */
	public int max = 10;

	/**
	 * The size of the slider movement steps.
	 */
	public int stepSize = 1; // FIXME: https://github.com/palantir/blueprint/issues/725

	/**
	 * The frequency of the labels on the slider
	 */
	public int labelStepSize = 1;

	public final ControlType type = ControlType.SLIDER;

	public Slider(String label, String path, byte width, boolean large, boolean enabled, int min, int max, int stepSize, int labelStepSize) {
		super(label, path, width, large, enabled);
		this.min = min;
		this.max = max;
		this.stepSize = stepSize;
		this.labelStepSize = labelStepSize;
	}

	public Slider(String label, String path, int min, int max, int stepSize, int labelStepSize) {
		super(label, path);
		this.min = min;
		this.max = max;
		this.stepSize = stepSize;
		this.labelStepSize = labelStepSize;
	}

	public Slider(String label, String path, byte width, boolean large, boolean enabled) {
		super(label, path, width, large, enabled);
	}

	public Slider(String label, String path) {
		super(label, path);
	}

	/**
	 * Builder class to assist the construction of a Slider object.
	 */
	public static class Builder {
		private String label;
		private String path;
		private byte width = 12;
		private boolean large = false;
		private boolean enabled = true;
		private int min = 0;
		private int max = 10;
		private int stepSize = 1;
		private int labelStepSize = 1;

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

		public Builder setMin(int min) {
			this.min = min;
			return this;
		}

		public Builder setMax(int max) {
			this.max = max;
			return this;
		}

		public Builder setStepSize(int stepSize) {
			this.stepSize = stepSize;
			return this;
		}

		public Builder setLabelStepSize(int labelStepSize) {
			this.labelStepSize = labelStepSize;
			return this;
		}

		public Slider createSlider() {
			return new Slider(label, path, width, large, enabled, min, max, stepSize, labelStepSize);
		}
	}
}
