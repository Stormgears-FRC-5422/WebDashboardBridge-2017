package org.stormgears.WebDashboard.GameControl;

/**
 * Creates a blank space in the game panel. This can be used for alignment or pushing controls to the next line.
 */
public class Spacer implements GameControl {
	/**
	 * The width of the control, ranging from 1 to 12.
	 */
	public int width = 12;

	/**
	 * Height of the spacer, in lines
	 */
	public int height = 1;

	public final ControlType type = ControlType.SPACER;

	public Spacer(int width) {
		this.width = width;
	}

	public Spacer(int width, int height) {
		this.width = width;
		this.height = height;
	}
}

