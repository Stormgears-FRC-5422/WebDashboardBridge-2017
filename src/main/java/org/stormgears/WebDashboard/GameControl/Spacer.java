package org.stormgears.WebDashboard.GameControl;

/**
 * Creates a blank space in the game panel. This can be used for alignment or pushing controls to the next line.
 */
public class Spacer extends GameControl {
	public final ControlType type = ControlType.SPACER;

	public Spacer(byte width) {
		super("", "", width, false, true);
	}
}
