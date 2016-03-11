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
	private static final long serialVersionUID = 1L;
	private Deck gameDeck, spoilsOfWar;

	public Dealer(){
		super();
		this.gameDeck = new Deck();
	}
	
	public void deal(Player player1, Player player2){
		Deck deck1,deck2;
		deck1 = new Deck();
		deck2 = new Deck();
		
		gameDeck.newDeck();
		gameDeck.shuffleDeck();
		
		System.out.println(this.gameDeck.toString());
		
		while( gameDeck.getCardsLeft() > 0 ){
			deck1.addCard(gameDeck.removeCard());
			deck2.addCard(gameDeck.removeCard());
		}
		
		player1.addDrawDeck(deck1);
		player2.addDrawDeck(deck2);;
		
	}
	
	public void addToSpoilsOfWar(Player player1, Player player2, int totalSpoils){
		if(spoilsOfWar == null)
			spoilsOfWar =  new Deck();
		
		//indexed at 1 because 0 is being used in the war
		for(int i=0; i<totalSpoils; i++){
			spoilsOfWar.addCard( player1.getDrawDeck().removeCard(1) );
			spoilsOfWar.addCard(player2.getDrawDeck().removeCard(1));
		}
	}
	
	public void addToSpoilsOfWar(Card card){
		if(spoilsOfWar == null)
			spoilsOfWar =  new Deck();
		
		spoilsOfWar.addCard(card);
	}
	
	public void toTheVictorGoesTheSpoils(Player player){
		while( spoilsOfWar.getCardsLeft() > 0 )
			player.getWinDeck().addCard( spoilsOfWar.removeCard() );
	}
}
