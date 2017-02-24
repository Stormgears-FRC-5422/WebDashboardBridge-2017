package org.stormgears.WebDashboard.GameControl;

/**
 * Created by andrew on 2/24/17.
 */
public class Select extends GameControl {
	public static class Option {
		public final String label;
		public final String value;

		public Option(String label, String value) {
			this.label = label;
			this.value = value;
		}
	}

	public final Option[] options;

	public final ControlType type = ControlType.SELECT;

	public Select(String label, String path, byte width, boolean large, boolean enabled, Option[] options) {
		super(label, path, width, large, enabled);
		this.options = options;
	}

	public Select(String label, String path, Option[] options) {
		super(label, path);
		this.options = options;
	}
}
