package org.stormgears.WebDashboard.GameControl;

/**
 * Created by andrew on 2/24/17.
 */
public class Slider extends GameControl {
	public int min = 0;
	public int max = 10;
	public int stepSize = 1; // FIXME: https://github.com/palantir/blueprint/issues/725
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
}
