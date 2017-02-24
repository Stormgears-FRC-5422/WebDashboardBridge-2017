package org.stormgears.WebDashboard.GameControl;

/**
 * Created by andrew on 2/24/17.
 */
public abstract class GameControl {
	public final String label;
	public final String path;
	public byte width = 12;
	public boolean large = false;
	public boolean enabled = true;

	public final ControlType type = ControlType.DEFAULT;

	public GameControl(String label, String path, byte width, boolean large, boolean enabled) {
		this.label = label;
		this.path = path;
		this.width = width;
		this.large = large;
		this.enabled = enabled;
	}

	public GameControl(String label, String path) {
		this.label = label;
		this.path = path;
	}
}
