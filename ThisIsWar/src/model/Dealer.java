/**
 * 
 */
package model;

import java.io.Serializable;

/**
 * @author micah cooper
 * 
 * Dealer class to help handle some utility methods for the war game like deal, distributing the won cards
 *
 */
public class Dealer implements Serializable{
	private static final long serialVersionUID = 1L;
	private Deck gameDeck;
	private boolean showCard, timeOfWar;

	/**
	 * setup class variables
	 */
	public Dealer(){
		super();
		showCard=false;
		timeOfWar=false;
		System.out.print("Dealer created with ");
		this.gameDeck = new Deck();
	}
	
	/**
	 * @param player1 
	 * @param player2
	 * @param isTestGame  true means to deal the test stacked deck, false is deal a normal game
	 */
	public void dealCards(Player player1, Player player2, boolean isTestGame){
		Deck deck1,deck2;
		deck1 = new Deck();
		deck2 = new Deck();
		
		if(!isTestGame){
			gameDeck.newDeck();
			gameDeck.shuffleDeck();
			
			while( gameDeck.getCardsLeft() > 0 ){
				deck1.addCard(gameDeck.removeCard());
				deck2.addCard(gameDeck.removeCard());
			}
		}
		else{
			deck1.stackDeck();
			deck2.stackDeckAlternate();
		}
		
		
		player1.addDrawDeck(deck1);
		player2.addDrawDeck(deck2);;
		
	}
	
	/**
	 * @param player1
	 * @param player2
	 * @param totalSpoils the number of cards that can be laid down for a war round (not including the current card or needed war card)
	 */
	public void addToSpoilsOfWar(Player player1, Player player2, int totalSpoils){
		System.out.println("spoils of war size: "+totalSpoils);
		System.out.println( player1.getName()+": "+player1.getDrawDeck().toString()+" size:"+player1.getDrawDeck().getCardsLeft() );
		System.out.println( player2.getName()+": "+player2.getDrawDeck().toString()+" size:"+player2.getDrawDeck().getCardsLeft() );
		
		player1.resetWarDeck();
		player2.resetWarDeck();
		
		//add current card
		player1.getWarDeck().addCard(player1.getDrawDeck().removeCard(0));
		player2.getWarDeck().addCard(player2.getDrawDeck().removeCard(0));
		
		for(int i=0; i<totalSpoils; i++){
			player1.getWarDeck().addCard( player1.getDrawDeck().removeCard(0) );
			player2.getWarDeck().addCard( player2.getDrawDeck().removeCard(0) );
		}
		
		//take war card from drawdeck
		player1.setWarCard( player1.getDrawDeck().removeCard(0) );
		player2.setWarCard( player2.getDrawDeck().removeCard(0) );
	}
	
	/**
	 * @param winner
	 * @param loser
	 */
	public void toTheVictorGoesTheSpoils(Player winner, Player loser){
		
		for( int i=0; i < loser.getWarDeck().getCardsLeft(); i++){
			winner.getWinDeck().addCard( loser.getWarDeck().getCard(i) );
			winner.getWinDeck().addCard( winner.getWarDeck().getCard(i) );
		}
		
		winner.getWinDeck().addCard( loser.getWarCard() );
		winner.getWinDeck().addCard( winner.getWarCard() );
		
		//winner.resetWarDeck();
		//loser.resetWarDeck();
	}
	
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
}
