package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author craigpiercy
 * 
 * This class models a deck of playing cards
 */

public class Deck implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Card> cards;  // the deck is basically an arraylist of cards
	private boolean hasJokers;      // boolean: true = deck has jokers, false = deck has no jokers
	
	/**
	 * @param cards
	 * @param hasJokers
	 * 
	 * Default constructor
	 */
	public Deck() {
		this.cards = new ArrayList<Card>();
		this.hasJokers = false;
		System.out.println("new deck..");
	}
	
	/**
	 * @return the cards
	 */
	public ArrayList<Card> getCards() {
		return cards;
	}

	/**
	 * @param cards the cards to set
	 */
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	/**
	 * @param cards
	 * @param hasJokers
	 * 
	 * Overloaded constructor - sets to provided list of cards and joker status
	 */
	public Deck(ArrayList<Card> cards, boolean hasJokers) {
		this.cards = cards;
		this.hasJokers = hasJokers;
	}
	
	/**
	 * @param deckString
	 * @param hasJokers
	 * 
	 * Overloaded constructor - sets to provided string representation of list of cards and joker status
	 */	
	public Deck(String deckString, boolean hasJokers){
		this.cards = new ArrayList<Card>();
		this.hasJokers = hasJokers;
		int value = 0;
		String suit = "";
		String[] cards = deckString.split(",");
		// 
		for (int i=0; i<cards.length; i++){
			// get suit off of each card string in the array
			int l = cards[i].length();
			char s = cards[i].charAt(l-1);
			if (s == 'H'){
				suit="Heart";
			}
			if (s == 'S'){
				suit="Spade";
			}
			if (s == 'D'){
				suit="Diamond";
			}
			if (s == 'C'){
				suit="Club";
			}
			value = Integer.parseInt(cards[i].substring(0, l-1));
			
			Card c = new Card(suit, value);
			this.cards.add(c);
		
			System.out.println(c.getCardString());
		}
	}
	
	/**
	 * creates a new, not shuffled, standard deck of cards
	 */
	public void newDeck(){
		for (int s = 0; s < 4; s++){   // each suit
			for (int v = 1; v < 14; v++){ // each card value
				String suit = "";
				switch(s){
				case 0:
					suit = "Heart";
					break;
				case 1:
					suit = "Diamond";
					break;					
				case 2:
					suit = "Spade";
					break;
				case 3:
					suit = "Club";	
					break;
				}
				Card card = new Card(suit, v);
				cards.add(card);
			}
		}
		if (this.hasJokers){
			cards.add(new Card("Joker",0));
			cards.add(new Card("Joker",0));
		}
		
	}
	
	
	/**
	 * randomly shuffles the current deck once
	 */	
	public void shuffleDeck(){
		Collections.shuffle(cards);
	}
	
	/**
	 * @param times
     * randomly shuffles the current deck a provided number of times
	 */		
	public void shuffleDeck(int times){
		for(int i = 0; i < times; i++ )
		Collections.shuffle(cards);
	}
	
	/**
	 * @param index
	 * provides a card at a given location of the deck
	 */	
	public Card getCard(int index){
		return cards.get(index);
	}
	
	public Card getTopCard(){
		if( !cards.isEmpty() )
			return cards.get(0);
		
		return new Card(999);
	}
	
	public Card getLastCard(){
		if( !cards.isEmpty() )
			return cards.get(cards.size()-1);
		
		return new Card(999);
	}

	/**
	 * @param index
	 * removes a card at a given location of the deck
	 */	
	public Card removeCard(int index){
		//cards.remove(index);
		return cards.remove(index);
	}
	
	/**
	 * @param index
	 * removes a card at a given location of the deck
	 */	
	public Card removeCard(){
		//cards.remove(index);
		return cards.remove(cards.size()-1);
	}
	
	/**
	 * @param card
	 * add a card
	 */	
	public boolean addCard(Card card){
		return cards.add(card);
	}
	
	/**
	 * provides the number of cards left in the deck
	 */	
	public int getCardsLeft(){
		return cards.size();
	}

	/**
	 * Provides a String representation of the deck. The result is a comma separated list
	 *  of the cards in the form "1S,11D,5C,..."
	 */	
	public String toString(){
		String deck = "";		
		for (Card card:cards){
			deck += card.toString() + ",";
		}		
		return deck;
	}
	
	/**
	 * sets the deck to a predetermined order - useful for testing
	 */	
	public void stackDeck(){
		this.cards = new ArrayList<Card>();
		int value = 0;
		String suit = "";
		String deckString = "12S,5D,10S,1S,3C,3D,12D,10D,7S,6C,8S,9D,11D,7C,13S,13H,1C,8D,7H,11H,2C,9H,9S,9C,6S,2H,6D,2S,5C,3H,10C,5H,7D,4C,2D,10H,8C,13C,1D,12C,11S,4H,12H,6H,1H,8H,4D,4S,11C,5S,3S,13D,";
		String[] cards = deckString.split(",");
		// 
		for (int i=0; i<cards.length; i++){
			// get suit off of each card string in the array
			int l = cards[i].length();
			char s = cards[i].charAt(l-1);
			if (s == 'H'){
				suit="Heart";
			}
			if (s == 'S'){
				suit="Spade";
			}
			if (s == 'D'){
				suit="Diamond";
			}
			if (s == 'C'){
				suit="Club";
			}
			value = Integer.parseInt(cards[i].substring(0, l-1));
			
			Card c = new Card(suit, value);
			this.cards.add(c);
		
			//System.out.println(c.getCardString());
		}
	}
}
