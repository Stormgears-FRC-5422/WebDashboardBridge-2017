package org.stormgears.webdashboard;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.deepstream.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.*;

/**
 * Wraps the deepstream library to simplify use with the WebDashboard
 */
public class WebDashboard {
	public static DeepstreamClient client;
	public static Record rec;
	public static Gson gson = new Gson();

	private static final String discoPacket = "WEBDASHBOARD_DISCO";
	private static final String discoReqPacket = "WEBDASHBOARD_REQUEST";

	/**
	 * Initializes the WebDashboard class, connecting to the specified server
	 * @throws URISyntaxException If the given server URI is invalid
	 */
	public static void init() throws URISyntaxException, IOException {
		// Discover the server
		DatagramSocket datagram = new DatagramSocket(null);
		datagram.setSoTimeout(10000);
		datagram.setReuseAddress(true);
		datagram.bind(new InetSocketAddress("0.0.0.0", 5802));

		// Unicast request
		datagram.send(new DatagramPacket(discoReqPacket.getBytes(), discoReqPacket.length(), InetAddress.getByName("10.54.22.5"), 5803));

		// Multicast request
		datagram.send(new DatagramPacket(discoReqPacket.getBytes(), discoReqPacket.length(), InetAddress.getByName("224.0.0.251"), 5353));

		// Listen for a response
		String server = "";
		while (true) {
			byte[] buf = new byte[discoPacket.length()];
			DatagramPacket pack = new DatagramPacket(buf, discoPacket.length());

			datagram.receive(pack);

			String s = new String(pack.getData());
			if (s.equals(discoPacket)) {
				String host = pack.getAddress().getHostAddress();
				System.out.println("Discovered WebDashboard server: " + host);
				server = host + ":5802";

				datagram.close();
				break;
			}
		}

		client = new DeepstreamClient(server);

		JsonObject loginData = new JsonObject();
		loginData.addProperty("username", "robot");
		LoginResult result = client.login(loginData);

		if (result.loggedIn()) {
			System.out.println("Connected to WebDashboard server");
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
	 * @param record the sub-record to get from
	 * @param path the JSON path to the value
	 * @param classOfT the class to deserialize the value to, such as int.class
	 * @param <T> the class type to return
	 * @return the requested value
	 */
	public static <T> T get(String record, String path, Class<T> classOfT) {
		return gson.fromJson(client.record.getRecord("webdashboard/" + record).get(path), classOfT);
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

	/**
	 * Gets a value at the specified path
	 * @param record the sub-record to get from
	 * @param path the JSON path to the value
	 * @param typeOfT the type to deserialize the value to
	 * @param <T> the type to return
	 * @return the requested value
	 */
	public static <T> T get(String record, String path, Type typeOfT) {
		return gson.fromJson(client.record.getRecord("webdashboard/" + record).get(path), typeOfT);
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
	 * Shorthand to get an integer from the dashboard
	 * @param record the sub-record to get from
	 * @param path the JSON path to the integer
	 * @return the integer in the table
	 */
	public static int getInt(String record, String path) {
		return client.record.getRecord("webdashboard/" + record).get(path).getAsInt();
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
	 * Gets a double from the dashboard
	 * @param record the sub-record to get from
	 * @param path the JSON path to the double
	 * @return the double in the table
	 */
	public static double getDouble(String record, String path) {
		return client.record.getRecord("webdashboard/" + record).get(path).getAsDouble();
	}

	/**
	 * Gets a string from the dashboard
	 * @param path the JSON path to the string
	 * @return the string in the table
	 */
	public static String getString(String path) {
		JsonElement thing = rec.get(path);
		if (thing.isJsonNull()) {
			return null;
		}
		return thing.getAsString();
	}

	/**
	 * Gets a string from the dashboard
	 * @param record the sub-record to get from
	 * @param path the JSON path to the string
	 * @return the string in the table
	 */
	public static String getString(String record, String path) {
		JsonElement thing = client.record.getRecord("webdashboard/" + record).get(path);
		if (thing.isJsonNull()) {
			return null;
		}
		return thing.getAsString();
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

	/**
	 * Sets a value in the dashboard
	 * @param record the sub-record to set
	 * @param path the JSON path of the value
	 * @param value the value to set
	 */
	public static void set(String record, String path, Object value) {
		client.record.getRecord("webdashboard/" + record).set(path, value);
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
				recordListener.recordChanged(path, new org.stormgears.webdashboard.JsonElement(jsonElement));
			}
		});
	}

	/**
	 * Subscribes a RecordListener to be notified of changes in the table in a certain path
	 * @param record the sub-record to listen to
	 * @param path the JSON path to subscribe to
	 * @param recordListener the RecordListener to notify of changes
	 */
	public static void subscribeRecord(String record, String path, final RecordListener recordListener) {
		client.record.getRecord("webdashboard/" + record).subscribe(path, new RecordPathChangedCallback() {
			@Override
			public void onRecordPathChanged(String s, String path, JsonElement jsonElement) {
				recordListener.recordChanged(path, new org.stormgears.webdashboard.JsonElement(jsonElement));
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
				recordListener.recordChanged("", new org.stormgears.webdashboard.JsonElement(jsonElement));
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
