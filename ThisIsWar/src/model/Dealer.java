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
		System.out.print("Dealer created with ");
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
	
	public void test(Player player1, Player player2){
		Deck deck1,deck2;
		System.out.print(player1.getName()+" gets a ");
		deck1 = new Deck();
		System.out.print(player2.getName()+" gets a ");
		deck2 = new Deck();
		
		deck1.stackDeck();
		deck2.stackDeck();
		
		player1.addDrawDeck(deck1);
		player2.addDrawDeck(deck2);;
	}
	
	public void addToSpoilsOfWar(Player player1, Player player2, int totalSpoils){
		if(spoilsOfWar == null){
			System.out.print("spoils of war created with ");
			spoilsOfWar =  new Deck();
		}
		
		//indexed at 1 because 0 is being used in the war
		for(int i=0; i<totalSpoils; i++){
			spoilsOfWar.addCard( player1.getDrawDeck().removeCard(0) );
			spoilsOfWar.addCard( player2.getDrawDeck().removeCard(0) );
			
		}
		System.out.println( "spoils of war size: "+spoilsOfWar.getCardsLeft() );//+" with: "+spoilsOfWar.toString() );
	}
	
	public void addToSpoilsOfWar(Card card){
		if(spoilsOfWar == null){
			System.out.print("spoils of war created with ");
			spoilsOfWar =  new Deck();
		}
		
		spoilsOfWar.addCard(card);
		System.out.println( "spoils of war size: "+spoilsOfWar.getCardsLeft() );//+" with: "+spoilsOfWar.toString() );
	}
	
	public void toTheVictorGoesTheSpoils(Player player){
		while( spoilsOfWar.getCardsLeft() > 0 )
			player.getWinDeck().addCard( spoilsOfWar.removeCard() );
	}
}
