package org.stormgears.WebDashboard;

import com.google.gson.Gson;
import io.deepstream.DeepstreamClient;
import io.deepstream.LoginResult;
import io.deepstream.Record;
import io.deepstream.RecordChangedCallback;

import java.lang.reflect.Type;
import java.net.URISyntaxException;

/**
 * Wraps the deepstream library to simplify use with the WebDashboard
 */
public class WebDashboard {
	static DeepstreamClient client;
	static Record rec;
	static Gson gson = new Gson();

	/**
	 * Initializes the WebDashboard class, connecting to the specified server
	 * @param server the server to connect to (i.e. Raspberry Pi)
	 * @throws URISyntaxException
	 */
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

	/**
	 * Gets a value at the specified path
	 * @param path the JSON path to the value
	 * @param classOfT the class to deserialize the value to, such as int.class
	 * @param <T> the class type to return
	 * @return the requested value
	 */
	static <T> T get(String path, Class<T> classOfT) {
		return gson.fromJson(rec.get(path), classOfT);
	}

	/**
	 * Gets a value at the specified path
	 * @param path the JSON path to the value
	 * @param typeOfT the type to deserialize the value to
	 * @param <T> the type to return
	 * @return the requested value
	 */
	static <T> T get(String path, Type typeOfT) {
		return gson.fromJson(rec.get(path), typeOfT);
	}

	// Shorthand methods

	/**
	 * Shorthand to get an integer from the dashboard
	 * @param path the JSON path to the integer
	 * @return the integer in the table
	 */
	static int getInt(String path) {
		return rec.get(path).getAsInt();
	}

	/**
	 * Gets a double from the dashboard
	 * @param path the JSON path to the double
	 * @return the double in the table
	 */
	static double getDouble(String path) {
		return rec.get(path).getAsDouble();
	}

	/**
	 * Gets a string from the dashboard
	 * @param path the JSON path to the string
	 * @return the string in the table
	 */
	static String getString(String path) {
		return rec.get(path).getAsString();
	}

	// Setting records

	/**
	 * Sets a value in the dashboard
	 * @param path the JSON path of the value
	 * @param value the value to set
	 */
	static void set(String path, Object value) {
		rec.set(path, value);
	}

	// Record listeners

	/**
	 * Subscribes a RecordListener to be notified of changes in the table in a certain path
	 * @param path the JSON path to subscribe to
	 * @param recordListener the RecordListener to notify of changes
	 */
	static void subscribeRecord(String path, RecordListener recordListener) {
		rec.subscribe(path, recordListener);
	}

	/**
	 * Subscribes a listener to be notified of any change in the table
	 * @param recordListener the RecordListener to notify of changes
	 */
	static void subscribeRecord(RecordListener recordListener) {
		rec.subscribe((RecordChangedCallback) recordListener); // ewww
	}

	// Events

	/**
	 * Emits an event to the dashboard
	 * @param eventName the name of the event
	 */
	static void emit(String eventName) {
		client.event.emit(eventName);
	}

	/**
	 * Emits an event to the dashboard, with extra data
	 * @param eventName the name of the event
	 * @param data the data to attach to the event
	 */
	static void emit(String eventName, Object data) {
		client.event.emit(eventName, data);
	}

	/**
	 * Subscribes to events coming from the dashboard
	 * @param eventName the name of the event
	 * @param eventListener the EventListener to be notified of events
	 */
	static void subscribeEvent(String eventName, EventListener eventListener) {
		client.event.subscribe(eventName, eventListener);
	}
}
