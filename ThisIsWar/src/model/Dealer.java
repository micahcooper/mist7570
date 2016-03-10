/**
 * 
 */
package model;

import java.io.Serializable;

/**
 * @author micah cooper
 *
 */
public class Dealer implements Serializable{
	private Deck deck;
	private static final long serialVersionUID = 1L;

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
		
		player1.addDrawDeck(deck1);
		player2.addDrawDeck(deck2);;
		
	}
}
