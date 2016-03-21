/**
 * 
 */
package model;

import java.io.Serializable;

/**
 * @author micah cooper
 * 
 * player class to represent the players in the game
 *
 */
public class Player implements Serializable {
	private static final long serialVersionUID = 1L;
	private Deck drawDeck,winDeck,memoryDeck,warDeck;
	private String name;
	private Card warCard;

	/**
	 * setup some default values for class variables
	 */
	public Player() {
		this.winDeck = new Deck();
		name = "unknown";
		System.out.println(this.name+" player created");
	}
	
	/**
	 * @param name name of the player
	 */
	public Player(String name) {
		this.name = name;
		System.out.print(this.name+" created with ");
		this.winDeck = new Deck();
		this.memoryDeck = new Deck();
		this.warDeck = new Deck();
	}
	
	/**
	 * @param drawDeck the deck that holds the cards to be played
	 */
	public void addDrawDeck(Deck drawDeck){
		this.drawDeck = drawDeck;
		//new drawDeck means we need a new memoryDeck
		this.memoryDeck = new Deck();
		System.out.println(this.getName()+": "+drawDeck.toString()+" size:"+drawDeck.getCardsLeft());
	}
	
	/**
	 * empty the warDeck, occurs after a war round and after the jsp page has accessed it
	 */
	public void resetWarDeck(){
		this.warDeck = new Deck();
	}

	/**
	 * method to add cards from a draw back to the winDeck
	 */
	public void keepWarDeck(){
		for( int i=0; i < getWarDeck().getCardsLeft(); i++){
			getWinDeck().addCard( getWarDeck().getCard(i) );
		}
	}

	/**
	 * @param loser player that lost the round
	 */
	public void takesCard(Player loser){
		getWinDeck().addCard(loser.getDrawDeck().removeCard(0));
		getWinDeck().addCard(getDrawDeck().removeCard(0));
	}

	/**
	 * @return the drawDeck
	 */
	public Deck getDrawDeck() {
		return drawDeck;
	}

	/**
	 * @param drawDeck the drawDeck to set
	 */
	public void setDrawDeck(Deck drawDeck) {
		this.drawDeck = drawDeck;
	}

	/**
	 * @return the winDeck
	 */
	public Deck getWinDeck() {
		return winDeck;
	}

	/**
	 * @param winDeck the winDeck to set
	 */
	public void setWinDeck(Deck winDeck) {
		this.winDeck = winDeck;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the warDeck
	 */
	public Deck getWarDeck() {
		return warDeck;
	}
	
	/**
	 * @return the warCard
	 */
	public Card getWarCard() {
		return warCard;
	}

	/**
	 * @param warCard the warCard to set
	 */
	public void setWarCard(Card warCard) {
		this.warCard = warCard;
	}

	/**
	 * @param warDeck the warDeck to set
	 */
	public void setWarDeck(Deck warDeck) {
		this.warDeck = warDeck;
	}

	public int getScore(){
		return this.winDeck.getCardsLeft();
	}
	
	/**
	 * @return the memoryDeck
	 */
	public Deck getMemoryDeck() {
		return memoryDeck;
	}

	/**
	 * @param memoryDeck the memoryDeck to set
	 */
	public void setMemoryDeck(Deck memoryDeck) {
		this.memoryDeck = memoryDeck;
	}
}
