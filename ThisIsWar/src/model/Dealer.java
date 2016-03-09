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
		Deck deck1,deck2;
		deck1 = new Deck();
		deck2 = new Deck();
		
		deck.shuffleDeck();
		System.out.println(this.deck.toString());
		
		while( deck.getCardsLeft() > 0 ){
			deck1.addCard(deck.removeCard());
			deck2.addCard(deck.removeCard());
		}
		System.out.println("Player 1: "+deck1.toString()+" size:"+deck1.getCardsLeft());
		System.out.println("Player 2: "+deck2.toString()+" size:"+deck2.getCardsLeft());
	}
}
