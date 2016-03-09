/**
 * 
 */
package model;

import java.io.Serializable;

/**
 * @author craigpiercy
 * 
 * This class models a single playing card with a suit and a value
 */

public class Card implements Serializable {
	private static final long serialVersionUID = 1L;
	private String suit;  // suit: Spade, Club, Heart, Diamond
	private int value;    // value: 1-13, 1 = Ace; 11 = Jack; 12 = Queen; King = 13

	/**
	 * default constructor - defaults to Ace of Spades
	 */
	public Card() {
		this.suit = "Spade";
		this.value = 1;
		System.out.print("card created ");
	}

	/**
	 * @param suit
	 * @param value
	 * overloaded constructor - sets card to provided suit and value
	 */
	public Card(String suit, int value) {
		this.suit = suit;
		this.value = value;
	}

	/**
	 * @return the suit
	 */
	public String getSuit() {
		return suit;
	}

	/**
	 * @param suit the suit to set
	 */
	public void setSuit(String suit) {
		this.suit = suit;
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
		this.value = value;
	}

	/**
	 * returns a string describing the current card
	 */
	public String getCardString(){
		String card = "";
		switch(this.value){
		case 0:
		     card = "Joker";
		     break;		    
		case 1:
			card = "Ace of " + this.suit;
			break;
		case 11:
			card = "Jack of " + this.suit;
			break;	
		case 12:
			card = "Queen of " + this.suit;
			break;
		case 13:
			card = "King of " + this.suit;
			break;
		default:
			card = this.value + " of " + this.suit;
			break;
		}
		
		return card;
	}
	
	/**
	 * returns the color of the current card
	 */
	public String getColorString(){
		String color = "Red";
		if(this.suit.equals("Spade")||this.suit.equals("Spade")){
			color = "Black";
		}
		return color;
	}
	
	/**
	 * returns a string in the form of *value*suit*. For example,
	 *   Ace of Spades returns "1S"
	 */
	public String toString(){
		String card = "";
		card = "" + this.value+this.suit.charAt(0);
		return card;
	}
	

}
