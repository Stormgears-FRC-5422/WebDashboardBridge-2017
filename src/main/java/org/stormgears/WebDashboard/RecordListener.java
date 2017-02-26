package org.stormgears.WebDashboard;

import com.google.gson.JsonElement;

/**
 * Interface for record change listener classes.
 */
public interface RecordListener {
	public void recordChanged(String path, JsonElement data);
}
