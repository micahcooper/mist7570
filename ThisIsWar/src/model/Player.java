/**
 * 
 */
package model;

/**
 * @author micah cooper
 *
 */
public class Player {
	private Deck deck;

	/**
	 * 
	 */
	public Player() {
		// TODO Auto-generated constructor stub
		System.out.println("new player created");
	}

	public Player(Deck deck){
		this.deck = deck;
	}
	
	public void addDeck(Deck deck){
		this.deck = deck;
		
		System.out.println("Player: "+deck.toString()+" size:"+deck.getCardsLeft());
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
}
