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
}
