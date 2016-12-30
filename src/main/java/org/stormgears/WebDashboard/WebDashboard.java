package org.stormgears.WebDashboard;

import com.google.gson.Gson;
import io.deepstream.DeepstreamClient;
import io.deepstream.LoginResult;
import io.deepstream.Record;
import io.deepstream.RecordChangedCallback;

import java.lang.reflect.Type;
import java.net.URISyntaxException;

/**
 * Created by andrew on 12/29/16.
 */
public class WebDashboard {
	static DeepstreamClient client;
	static Record rec;
	static Gson gson = new Gson();

	static void init(String server) throws URISyntaxException {
		client = new DeepstreamClient(server);
		LoginResult result = client.login();
		if (result.loggedIn()) {
			System.out.println("Logged in!");
			rec = client.record.getRecord("webdashboard");
		} else {
			throw new Error("Oh noes!"); // TODO: properly handle?
		}
	}

	// Getting records in a quasi-typesafe manner
	static <T> T get(String path, Class<T> classOfT) {
		return gson.fromJson(rec.get(path), classOfT);
	}
	static <T> T get(String path, Type typeOfT) {
		return gson.fromJson(rec.get(path), typeOfT);
	}
	// Shorthand methods
	static int getInt(String path) {
		return rec.get(path).getAsInt();
	}
	static double getDouble(String path) {
		return rec.get(path).getAsDouble();
	}
	static String getString(String path) {
		return rec.get(path).getAsString();
	}

	// Setting records
	static void set(String path, Object value) {
		rec.set(path, value);
	}

	// Record listeners
	static void subscribeRecord(String path, RecordListener recordListener) {
		rec.subscribe(path, recordListener);
	}
	static void subscribeRecord(RecordListener recordListener) {
		rec.subscribe((RecordChangedCallback) recordListener); // ewww
	}

	// Events
	static void emit(String eventName) {
		client.event.emit(eventName);
	}
	static void emit(String eventName, Object data) {
		client.event.emit(eventName, data);
	}
	static void subscribeEvent(String eventName, EventListener eventListener) {
		client.event.subscribe(eventName, eventListener);
	}
}
