package org.stormgears.WebDashboard.GameControl;

/**
 * Created by andrew on 2/24/17.
 */
public class Text extends GameControl {
	public boolean numbersOnly = false;

	public final ControlType type = ControlType.TEXT;

	public Text(String label, String path, byte width, boolean large, boolean enabled, boolean numbersOnly) {
		super(label, path, width, large, enabled);
		this.numbersOnly = numbersOnly;
	}

	public Text(String label, String path, boolean numbersOnly) {
		super(label, path);
		this.numbersOnly = numbersOnly;
	}

	public Text(String label, String path, byte width, boolean large, boolean enabled) {
		super(label, path, width, large, enabled);
	}

	public Text(String label, String path) {
		super(label, path);
	}
}
