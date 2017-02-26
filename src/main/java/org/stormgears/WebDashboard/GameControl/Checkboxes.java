package org.stormgears.WebDashboard.GameControl;

/**
 * Creates a group of checkboxes on the dashboard. The checkboxes control a JSON object.
 * <p>
 * For example, if a Checkbox object is bound to the path "checkboxes" and contains the following Checkboxes:
 * <blockquote><pre>
 * {
 *     new Checkbox("a", "Label A"),
 *     new Checkbox("b", "Label B")
 * }
 * </pre></blockquote>
 * the code
 * <blockquote><pre>
 * WebDashboard.set("checkboxes.a", false);
 * WebDashboard.set("checkboxes.b", true);
 * </pre></blockquote>
 * will cause the first checkbox to be unchecked and the second checkbox to be checked. If the following code is run
 * instead:
 * <blockquote><pre>
 * WebDashboard.set("checkboxes", true);
 * </pre></blockquote>
 * then <i>all</i> of the checkboxes will be checked. This is useful if there is only one checkbox.
 */
public class Checkboxes extends GameControl {
	/**
	 * Represents a single checkbox on the dashboard.
	 */
	public static class Checkbox {
		public final String value;
		public final String label;
		public boolean enabled = true;

		public Checkbox(String value, String label) {
			this.value = value;
			this.label = label;
		}

		public Checkbox(String value, String label, boolean enabled) {
			this.value = value;
			this.label = label;
			this.enabled = enabled;
		}
	}

	/**
	 * A list of checkboxes to display.
	 */
	public final Checkbox[] entries;

	/**
	 * Specifies the type of toggles
	 */
	public ToggleType toggleType = ToggleType.DEFAULT;

	public final ControlType type = ControlType.CHECKBOXES;

	public Checkboxes(String label, String path, byte width, boolean large, boolean enabled, Checkbox[] entries) {
		super(label, path, width, large, enabled);
		this.entries = entries;
	}

	public Checkboxes(String label, String path, Checkbox[] entries) {
		super(label, path);
		this.entries = entries;
	}

	public Checkboxes(String label, String path, byte width, boolean large, boolean enabled, Checkbox[] entries, ToggleType toggleType) {
		super(label, path, width, large, enabled);
		this.entries = entries;
		this.toggleType = toggleType;
	}

	public Checkboxes(String label, String path, Checkbox[] entries, ToggleType toggleType) {
		super(label, path);
		this.entries = entries;
		this.toggleType = toggleType;
	}

	/**
	 * Builder class to ease the construction of a Checkboxes object.
	 */
	public static class Builder {
		private String label;
		private String path;
		private byte width = 12;
		private boolean large = false;
		private boolean enabled = true;
		private Checkbox[] entries;
		private ToggleType toggleType = ToggleType.DEFAULT;

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

		public Builder setEntries(Checkbox[] entries) {
			this.entries = entries;
			return this;
		}

		public Builder setToggleType(ToggleType toggleType) {
			this.toggleType = toggleType;
			return this;
		}

		public Checkboxes createCheckboxes() {
			return new Checkboxes(label, path, width, large, enabled, entries);
		}
	}
}
