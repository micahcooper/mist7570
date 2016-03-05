/**
 * TODO add dynamic message words
 */
package model;

import java.io.Serializable;

/**
 * @author micah cooper
 *
 */
public class GameMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	String message, correctMessage;

	/**
	 * 
	 */
	public GameMessage() {
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

	/**
	 * @return the correctMessage
	 */
	public String getCorrectMessage() {
		return correctMessage;
	}

	/**
	 * @param correctMessage the correctMessage to set
	 */
	public void setCorrectMessage(String correctMessage) {
		this.correctMessage = correctMessage;
	}
	


}
