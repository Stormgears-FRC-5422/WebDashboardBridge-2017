package org.stormgears.WebDashboard;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.deepstream.*;

import java.lang.reflect.Type;
import java.net.URISyntaxException;

/**
 * Wraps the deepstream library to simplify use with the WebDashboard
 */
public class WebDashboard {
	public static DeepstreamClient client;
	public static Record rec;
	public static Gson gson = new Gson();

	/**
	 * Initializes the WebDashboard class, connecting to the specified server
	 * @param server the server to connect to (i.e. Raspberry Pi)
	 * @throws URISyntaxException If the given server URI is invalid
	 */
	public static void init(String server) throws URISyntaxException {
		client = new DeepstreamClient(server);
		LoginResult result = client.login(new JsonObject());
		if (result.loggedIn()) {
			System.out.println("Logged in!");
			rec = client.record.getRecord("webdashboard");
		} else {
			throw new Error("Oh noes!"); // TODO: properly handle?
		}
	}

	// Getting records in a quasi-typesafe manner

	/**
	 * Gets a value at the specified path
	 * @param path the JSON path to the value
	 * @param classOfT the class to deserialize the value to, such as int.class
	 * @param <T> the class type to return
	 * @return the requested value
	 */
	public static <T> T get(String path, Class<T> classOfT) {
		return gson.fromJson(rec.get(path), classOfT);
	}

	/**
	 * Gets a value at the specified path
	 * @param path the JSON path to the value
	 * @param typeOfT the type to deserialize the value to
	 * @param <T> the type to return
	 * @return the requested value
	 */
	public static <T> T get(String path, Type typeOfT) {
		return gson.fromJson(rec.get(path), typeOfT);
	}

	// Shorthand methods

	/**
	 * Shorthand to get an integer from the dashboard
	 * @param path the JSON path to the integer
	 * @return the integer in the table
	 */
	public static int getInt(String path) {
		return rec.get(path).getAsInt();
	}

	/**
	 * Gets a double from the dashboard
	 * @param path the JSON path to the double
	 * @return the double in the table
	 */
	public static double getDouble(String path) {
		return rec.get(path).getAsDouble();
	}

	/**
	 * Gets a string from the dashboard
	 * @param path the JSON path to the string
	 * @return the string in the table
	 */
	public static String getString(String path) {
		return rec.get(path).getAsString();
	}

	// Setting records

	/**
	 * Sets a value in the dashboard
	 * @param path the JSON path of the value
	 * @param value the value to set
	 */
	public static void set(String path, Object value) {
		rec.set(path, value);
	}

	// Record listeners

	/**
	 * Subscribes a RecordListener to be notified of changes in the table in a certain path
	 * @param path the JSON path to subscribe to
	 * @param recordListener the RecordListener to notify of changes
	 */
	public static void subscribeRecord(String path, final RecordListener recordListener) {
		rec.subscribe(path, new RecordPathChangedCallback() {
			@Override
			public void onRecordPathChanged(String s, String path, JsonElement jsonElement) {
				recordListener.recordChanged(path, jsonElement);
			}
		});
	}

	/**
	 * Subscribes a listener to be notified of any change in the table
	 * @param recordListener the RecordListener to notify (with the entire table) of changes
	 */
	public static void subscribeRecord(final RecordListener recordListener) {
		rec.subscribe(new RecordChangedCallback() {
			@Override
			public void onRecordChanged(String s, JsonElement jsonElement) {
				recordListener.recordChanged("", jsonElement);
			}
		});
	}

	// Events

	/**
	 * Emits an event to the dashboard
	 * @param eventName the name of the event
	 */
	public static void emit(String eventName) {
		client.event.emit(eventName);
	}

	/**
	 * Emits an event to the dashboard, with extra data
	 * @param eventName the name of the event
	 * @param data the data to attach to the event
	 */
	public static void emit(String eventName, Object data) {
		client.event.emit(eventName, data);
	}

	/**
	 * Subscribes to events coming from the dashboard
	 * @param eventName the name of the event
	 * @param eventListener the EventListener to be notified of events
	 */
	public static void subscribeEvent(String eventName, EventListener eventListener) {
		client.event.subscribe(eventName, eventListener);
	}
}
