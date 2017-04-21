package org.stormgears.webdashboard;

/**
 * Interface for record change listener classes.
 */
public interface RecordListener {
	public void recordChanged(String path, JsonElement data);
}
