/**
 * 
 */
package model;

import java.io.Serializable;

/**
 * @author mrcooper
 *
 */
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	String correctMessage, guessMessage;

	/**
	 * 
	 */
	public Message() {
		// TODO Auto-generated constructor stub
		guessMessage = "";
		correctMessage = "";
	}
	
	private String generateGuessMessage(){
		String[] exclamationList = {"Almost!","Good try"};
		return "";
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

	/**
	 * @return the guessMessage
	 */
	public String getGuessMessage() {
		return guessMessage;
	}

	/**
	 * @param guessMessage the guessMessage to set
	 */
	public void setGuessMessage(String guessMessage) {
		this.guessMessage = guessMessage;
	}

}
