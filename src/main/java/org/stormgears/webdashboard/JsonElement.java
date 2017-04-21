package org.stormgears.webdashboard;

import com.google.gson.JsonArray;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * A class representing an element of Json. It could either be a {@link JsonObject}, a
 * {@link JsonArray}, a {@link JsonPrimitive} or a {@link JsonNull}.
 */
public class JsonElement {
	private com.google.gson.JsonElement actual;

	JsonElement(com.google.gson.JsonElement actual) {
		this.actual = actual;
	}

	/**
	 * provides check for verifying if this element is an array or not.
	 *
	 * @return true if this element is of type {@link JsonArray}, false otherwise.
	 */
	public boolean isJsonArray() {
		return actual.isJsonArray();
	}

	/**
	 * provides check for verifying if this element is a Json object or not.
	 *
	 * @return true if this element is of type {@link JsonObject}, false otherwise.
	 */
	public boolean isJsonObject() {
		return actual.isJsonObject();
	}

	/**
	 * provides check for verifying if this element is a primitive or not.
	 *
	 * @return true if this element is of type {@link JsonPrimitive}, false otherwise.
	 */
	public boolean isJsonPrimitive() {
		return actual.isJsonPrimitive();
	}

	/**
	 * provides check for verifying if this element represents a null value or not.
	 *
	 * @return true if this element is of type {@link JsonNull}, false otherwise.
	 * @since 1.2
	 */
	public boolean isJsonNull() {
		return actual.isJsonNull();
	}

	/**
	 * convenience method to get this element as a {@link JsonObject}. If the element is of some
	 * other type, a {@link IllegalStateException} will result. Hence it is best to use this method
	 * after ensuring that this element is of the desired type by calling {@link #isJsonObject()}
	 * first.
	 *
	 * @return get this element as a {@link JsonObject}.
	 * @throws IllegalStateException if the element is of another type.
	 */
	public JsonObject getAsJsonObject() {
		return actual.getAsJsonObject();
	}

	/**
	 * convenience method to get this element as a {@link JsonArray}. If the element is of some
	 * other type, a {@link IllegalStateException} will result. Hence it is best to use this method
	 * after ensuring that this element is of the desired type by calling {@link #isJsonArray()}
	 * first.
	 *
	 * @return get this element as a {@link JsonArray}.
	 * @throws IllegalStateException if the element is of another type.
	 */
	public JsonArray getAsJsonArray() {
		return actual.getAsJsonArray();
	}

	/**
	 * convenience method to get this element as a {@link JsonPrimitive}. If the element is of some
	 * other type, a {@link IllegalStateException} will result. Hence it is best to use this method
	 * after ensuring that this element is of the desired type by calling {@link #isJsonPrimitive()}
	 * first.
	 *
	 * @return get this element as a {@link JsonPrimitive}.
	 * @throws IllegalStateException if the element is of another type.
	 */
	public JsonPrimitive getAsJsonPrimitive() {
		return actual.getAsJsonPrimitive();
	}

	/**
	 * convenience method to get this element as a {@link JsonNull}. If the element is of some
	 * other type, a {@link IllegalStateException} will result. Hence it is best to use this method
	 * after ensuring that this element is of the desired type by calling {@link #isJsonNull()}
	 * first.
	 *
	 * @return get this element as a {@link JsonNull}.
	 * @throws IllegalStateException if the element is of another type.
	 * @since 1.2
	 */
	public JsonNull getAsJsonNull() {
		return actual.getAsJsonNull();
	}

	/**
	 * convenience method to get this element as a boolean value.
	 *
	 * @return get this element as a primitive boolean value.
	 * @throws ClassCastException    if the element is of not a {@link JsonPrimitive} and is not a valid
	 *                               boolean value.
	 * @throws IllegalStateException if the element is of the type {@link JsonArray} but contains
	 *                               more than a single element.
	 */
	public boolean getAsBoolean() {
		return actual.getAsBoolean();
	}

	/**
	 * convenience method to get this element as a {@link Number}.
	 *
	 * @return get this element as a {@link Number}.
	 * @throws ClassCastException    if the element is of not a {@link JsonPrimitive} and is not a valid
	 *                               number.
	 * @throws IllegalStateException if the element is of the type {@link JsonArray} but contains
	 *                               more than a single element.
	 */
	public Number getAsNumber() {
		return actual.getAsNumber();
	}

	/**
	 * convenience method to get this element as a string value.
	 *
	 * @return get this element as a string value.
	 * @throws ClassCastException    if the element is of not a {@link JsonPrimitive} and is not a valid
	 *                               string value.
	 * @throws IllegalStateException if the element is of the type {@link JsonArray} but contains
	 *                               more than a single element.
	 */
	public String getAsString() {
		return actual.getAsString();
	}

	/**
	 * convenience method to get this element as a primitive double value.
	 *
	 * @return get this element as a primitive double value.
	 * @throws ClassCastException    if the element is of not a {@link JsonPrimitive} and is not a valid
	 *                               double value.
	 * @throws IllegalStateException if the element is of the type {@link JsonArray} but contains
	 *                               more than a single element.
	 */
	public double getAsDouble() {
		return actual.getAsDouble();
	}

	/**
	 * convenience method to get this element as a primitive float value.
	 *
	 * @return get this element as a primitive float value.
	 * @throws ClassCastException    if the element is of not a {@link JsonPrimitive} and is not a valid
	 *                               float value.
	 * @throws IllegalStateException if the element is of the type {@link JsonArray} but contains
	 *                               more than a single element.
	 */
	public float getAsFloat() {
		return actual.getAsFloat();
	}

	/**
	 * convenience method to get this element as a primitive long value.
	 *
	 * @return get this element as a primitive long value.
	 * @throws ClassCastException    if the element is of not a {@link JsonPrimitive} and is not a valid
	 *                               long value.
	 * @throws IllegalStateException if the element is of the type {@link JsonArray} but contains
	 *                               more than a single element.
	 */
	public long getAsLong() {
		return actual.getAsLong();
	}

	/**
	 * convenience method to get this element as a primitive integer value.
	 *
	 * @return get this element as a primitive integer value.
	 * @throws ClassCastException    if the element is of not a {@link JsonPrimitive} and is not a valid
	 *                               integer value.
	 * @throws IllegalStateException if the element is of the type {@link JsonArray} but contains
	 *                               more than a single element.
	 */
	public int getAsInt() {
		return actual.getAsInt();
	}

	/**
	 * convenience method to get this element as a primitive byte value.
	 *
	 * @return get this element as a primitive byte value.
	 * @throws ClassCastException    if the element is of not a {@link JsonPrimitive} and is not a valid
	 *                               byte value.
	 * @throws IllegalStateException if the element is of the type {@link JsonArray} but contains
	 *                               more than a single element.
	 * @since 1.3
	 */
	public byte getAsByte() {
		return actual.getAsByte();
	}

	/**
	 * convenience method to get this element as a primitive character value.
	 *
	 * @return get this element as a primitive char value.
	 * @throws ClassCastException    if the element is of not a {@link JsonPrimitive} and is not a valid
	 *                               char value.
	 * @throws IllegalStateException if the element is of the type {@link JsonArray} but contains
	 *                               more than a single element.
	 * @since 1.3
	 */
	public char getAsCharacter() {
		return actual.getAsCharacter();
	}

	/**
	 * convenience method to get this element as a {@link BigDecimal}.
	 *
	 * @return get this element as a {@link BigDecimal}.
	 * @throws ClassCastException    if the element is of not a {@link JsonPrimitive}.
	 *                               * @throws NumberFormatException if the element is not a valid {@link BigDecimal}.
	 * @throws IllegalStateException if the element is of the type {@link JsonArray} but contains
	 *                               more than a single element.
	 * @since 1.2
	 */
	public BigDecimal getAsBigDecimal() {
		return actual.getAsBigDecimal();
	}

	/**
	 * convenience method to get this element as a {@link BigInteger}.
	 *
	 * @return get this element as a {@link BigInteger}.
	 * @throws ClassCastException    if the element is of not a {@link JsonPrimitive}.
	 * @throws NumberFormatException if the element is not a valid {@link BigInteger}.
	 * @throws IllegalStateException if the element is of the type {@link JsonArray} but contains
	 *                               more than a single element.
	 * @since 1.2
	 */
	public BigInteger getAsBigInteger() {
		return actual.getAsBigInteger();
	}

	/**
	 * convenience method to get this element as a primitive short value.
	 *
	 * @return get this element as a primitive short value.
	 * @throws ClassCastException    if the element is of not a {@link JsonPrimitive} and is not a valid
	 *                               short value.
	 * @throws IllegalStateException if the element is of the type {@link JsonArray} but contains
	 *                               more than a single element.
	 */
	public short getAsShort() {
		return actual.getAsShort();
	}

	/**
	 * Returns a String representation of this element.
	 */
	public String toString() {
		return actual.toString();
	}

	public int hashCode() {
		return actual.hashCode();
	}

	public boolean equals(Object obj) {
		return actual.equals(obj);
	}

//	protected Object clone() throws CloneNotSupportedException {
//		return actual.clone();
//	}
//
//	protected void finalize() throws Throwable {
//		actual.finalize();
//	}
}
