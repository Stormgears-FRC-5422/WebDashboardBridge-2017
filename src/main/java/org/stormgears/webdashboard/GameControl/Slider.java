package org.stormgears.webdashboard.GameControl;

/**
 * Creates a slider control in the dashboard. Displays and controls a numerical value.
 */
public class Slider implements GameControl {
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
	 * Specifies whether the user is allowed to make modifications to the control's value.
	 */
	public boolean enabled = true;

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

	public final ControlType type = ControlType.SLIDER;

	public Slider(String label, String path) {
		this.label = label;
		this.path = path;
	}

	public Slider(String label, String path, int width, boolean enabled, double min, double max, double stepSize, double labelStepSize) {
		this.label = label;
		this.path = path;
		this.width = width;
		this.enabled = enabled;
		this.min = min;
		this.max = max;
		this.stepSize = stepSize;
		this.labelStepSize = labelStepSize;
	}

	/**
	 * Builder class to assist the construction of a Slider object.
	 */
	public static class Builder {
		private String label;
		private String path;
		private int width = 12;
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
			return new Slider(label, path, width, enabled, min, max, stepSize, labelStepSize);
		}
	}
}
