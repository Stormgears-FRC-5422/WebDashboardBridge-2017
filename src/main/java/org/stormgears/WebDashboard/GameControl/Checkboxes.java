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
public class Checkboxes implements GameControl {
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

	/**
	 * A list of checkboxes to display.
	 */
	public final Checkbox[] entries;

	public final ControlType type = ControlType.CHECKBOXES;

	public Checkboxes(String label, String path, Checkbox[] entries) {
		this.label = label;
		this.path = path;
		this.entries = entries;
	}

	public Checkboxes(String label, String path, int width, boolean large, boolean enabled, Checkbox[] entries) {
		this.label = label;
		this.path = path;
		this.width = width;
		this.large = large;
		this.enabled = enabled;
		this.entries = entries;
	}

	/**
	 * Builder class to assist the construction of a Progress object
	 */
	public static class Builder {
		private String label;
		private String path;
		private int width;
		private boolean large;
		private boolean enabled;
		private Checkboxes.Checkbox[] entries;

		public Builder setLabel(String label) {
			this.label = label;
			return this;
		}

		public Builder setPath(String path) {
			this.path = path;
			return this;
		}

		public Builder setWidth(int width) {
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

		public Builder setEntries(Checkboxes.Checkbox[] entries) {
			this.entries = entries;
			return this;
		}

		public Checkboxes createCheckboxes() {
			return new Checkboxes(label, path, width, large, enabled, entries);
		}
	}
}
