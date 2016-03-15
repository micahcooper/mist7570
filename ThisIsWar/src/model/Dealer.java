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
	private Deck gameDeck;
	private boolean showCard, timeOfWar;

	/**
	 * @return the showCard
	 */
	public boolean isShowCard() {
		return showCard;
	}

	/**
	 * @param showCard the showCard to set
	 */
	public void setShowCard(boolean showCard) {
		this.showCard = showCard;
	}

	/**
	 * @return the timeOfWar
	 */
	public boolean isTimeOfWar() {
		return timeOfWar;
	}

	/**
	 * @param timeOfWar the timeOfWar to set
	 */
	public void setTimeOfWar(boolean timeOfWar) {
		//if( timeOfWar ) {System.out.println("Gentlemen, we have ourselves a war");}
		this.timeOfWar = timeOfWar;
	}

	public Dealer(){
		super();
		showCard=false;
		timeOfWar=false;
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
		for(int i=0; i<totalSpoils; i++){
			player1.getWarDeck().addCard( player1.getDrawDeck().removeCard(0) );
			player2.getWarDeck().addCard( player2.getDrawDeck().removeCard(0) );
		}
	}
	
	public void addToSpoilsOfWar(Player player, Card card){
		player.resetWarDeck();
		player.getWarDeck().addCard(card);
	}
	
	public void toTheVictorGoesTheSpoils(Player player, Deck spoilsOfWar){
		for( int i=0; i < spoilsOfWar.getCardsLeft(); i++)
			player.getWinDeck().addCard( spoilsOfWar.getCard(i) );
	}
}
