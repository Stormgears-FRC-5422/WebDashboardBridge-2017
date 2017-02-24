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

	public class Builder {
		private String label;
		private String path;
		private byte width = 12;
		private boolean large = false;
		private boolean enabled = true;
		private Select.Option[] options;

		public Builder setLabel(String label) {
			this.label = label;
			return this;
		}

		public Builder setPath(String path) {
			this.path = path;
			return this;
		}

		public Builder setWidth(byte width) {
			this.width = width;
			return this;
		}

		public Builder setLarge(boolean large) {
			this.large = large;
			return this;
		}

		public Builder setEnabled(boolean enabled) {
			this.enabled = enabled;
			return this;
		}

		public Builder setOptions(Select.Option[] options) {
			this.options = options;
			return this;
		}

		public Select createSelect() {
			return new Select(label, path, width, large, enabled, options);
		}
	}
}
