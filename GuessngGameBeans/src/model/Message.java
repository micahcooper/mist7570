/**
 * TODO add dynamic message words
 */
package model;

import java.io.Serializable;

/**
 * @author micah cooper
 *
 */
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	String message;

	/**
	 * 
	 */
	public Message() {
		// setup blank values to avoid errors
		message = "";
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	


}
