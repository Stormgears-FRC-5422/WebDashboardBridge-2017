package org.stormgears.WebDashboard;

import com.google.gson.JsonElement;

/**
 * Created by andrew on 12/29/16.
 */
public interface RecordListener {
	public void recordChanged(String path, JsonElement data);
}
