/**
 * 
 */
package model;

/**
 * @author micah cooper
 *
 */
public class Dealer {
	private Deck deck;

	public Dealer(){
		
		this.deck = new Deck();
		deck.newDeck();
	}
	
	public void deal(){
		String deck1,deck2;
		deck.shuffleDeck();
		System.out.println(this.deck.toString());
		
		for(int i=0; i<deck.getCardsLeft(); i++){
			//deck1 = deck.
		}
	}
}
