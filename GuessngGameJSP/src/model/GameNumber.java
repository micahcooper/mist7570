/**
 * 
 */
package model;

import java.io.Serializable;
import java.util.Random;


public class GameNumber implements Serializable {
	private static final long serialVersionUID = 1L;
	private int value;

	/**
	 * 
	 */
	public GameNumber() {
		value = -1;
	}

	/**
	 * @param value
	 */
	public GameNumber(int value) {
		if (value < 0) {
			this.value = 0;
		} else {
		   this.value = value;
		}
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		if (value < 0) {
			this.value = 0;
		} else {
		   this.value = value;
		}
	}
	
	/**
	 * 
	 * A simple method that sets value to a random integer between minimum and maximum
	 * @param minimum the minimum value in the range
	 * @param maximum the maximum value in the range
	 */
	public void setRandom(int minimum, int maximum){
		Random random = new Random();
		this.value = random.nextInt(maximum - minimum) + minimum;
	}
	public void setRandom(int minimum, int maximum, String caller){
		
		Random random = new Random();
		this.value = random.nextInt(maximum - minimum) + minimum;
		System.out.println("GameNumber: create random number: "+this.value+", from: "+caller);
	}
	
	/**
	 * a simple method to adjust the value up 1 unit
	 */
	public void increment(){
		this.value++;
	}
	

}
