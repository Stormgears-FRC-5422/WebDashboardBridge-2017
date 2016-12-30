package org.stormgears.WebDashboard;

import com.google.gson.JsonElement;
import io.deepstream.RecordPathChangedCallback;

/**
 * Created by andrew on 12/29/16.
 */
public abstract class RecordListener implements RecordPathChangedCallback {
	public void onRecordPathChanged(String recordName, String path, JsonElement data) {
		recordChanged(path, data);
	}

	public abstract void recordChanged(String path, JsonElement data);
}
