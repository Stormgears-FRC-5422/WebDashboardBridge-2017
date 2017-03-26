package org.stormgears.WebDashboard.GameControl;

/**
 * Creates a slider control in the dashboard. Displays and controls a numerical value.
 */
public class Slider extends GameControl {
	/**
	 * The minimum value of the slider
	 */
	public double min = 0;

	/**
	 * The maximum value of the slider.
	 */
	public double max = 10;

	/**
	 * The size of the slider movement steps.
	 */
	public double stepSize = 1;

	/**
	 * The frequency of the labels on the slider
	 */
	public double labelStepSize = 1;

	public Slider(String label, String path, int width, boolean large, boolean enabled, double min, double max, double stepSize, double labelStepSize) {
		super(label, path, width, large, enabled);
		this.min = min;
		this.max = max;
		this.stepSize = stepSize;
		this.labelStepSize = labelStepSize;
	}

	public Slider(String label, String path, double min, double max, double stepSize, double labelStepSize) {
		super(label, path);
		this.min = min;
		this.max = max;
		this.stepSize = stepSize;
		this.labelStepSize = labelStepSize;
	}

	public Slider(String label, String path, int width, boolean large, boolean enabled) {
		super(label, path, width, large, enabled);
	}

	public Slider(String label, String path) {
		super(label, path);
	}

	@Override
	public ControlType getControlType() {
		return ControlType.SLIDER;
	}

	/**
	 * Builder class to assist the construction of a Slider object.
	 */
	public static class Builder {
		private String label;
		private String path;
		private int width = 12;
		private boolean large = false;
		private boolean enabled = true;
		private double min = 0;
		private double max = 10;
		private double stepSize = 1;
		private double labelStepSize = 1;

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

		public Builder setMin(double min) {
			this.min = min;
			return this;
		}

		public Builder setMax(double max) {
			this.max = max;
			return this;
		}

		public Builder setStepSize(double stepSize) {
			this.stepSize = stepSize;
			return this;
		}

		public Builder setLabelStepSize(double labelStepSize) {
			this.labelStepSize = labelStepSize;
			return this;
		}

		public Slider createSlider() {
			return new Slider(label, path, width, large, enabled, min, max, stepSize, labelStepSize);
		}
	}
}
