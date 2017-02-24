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
}
