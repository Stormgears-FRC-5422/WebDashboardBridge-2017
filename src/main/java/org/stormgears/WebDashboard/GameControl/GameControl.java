package org.stormgears.WebDashboard.GameControl;

/**
 * Abstract class with fields for most game controls. An array of GameControls can be added to the dashboard using
 * <code>WebDashboard.set("config.controls", new GameControl[]{...});</code>
 *
 * @author Andrew Sun
 */
public abstract class GameControl {
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
	 * <p>
	 *     WebDashboard displays controls in a twelve-column grid. Controls are added to this grid, with the specified
	 *     width. When the width in a single row exceeds the 12 column grid width, the control will wrap to the next
	 *     line.
	 * </p>
	 */
	public int width = 12;

	/**
	 * Specifies whether the control is displayed with large text.
	 */
	public boolean large = false;

	/**
	 * Specifies whether the user is allowed to make modifications to the control's value.
	 */
	public boolean enabled = true;

	public final ControlType type = getControlType();

	public GameControl(String label, String path, int width, boolean large, boolean enabled) {
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

	public abstract ControlType getControlType();
}
