package org.stormgears.WebDashboard;

/**
 * Interface for record change listener classes.
 */
public interface RecordListener {
	public void recordChanged(String path, JsonElement data);
}
