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
		
	}
	
	public void deal(Player player1, Player player2){
		Deck deck1,deck2;
		deck1 = new Deck();
		deck2 = new Deck();
		
		deck.newDeck();
		deck.shuffleDeck();
		
		System.out.println(this.deck.toString());
		
		while( deck.getCardsLeft() > 0 ){
			deck1.addCard(deck.removeCard());
			deck2.addCard(deck.removeCard());
		}
		
		player1.addDeck(deck1);
		player2.addDeck(deck2);;
		
	}
}
