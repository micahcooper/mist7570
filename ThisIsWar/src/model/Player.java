/**
 * 
 */
package model;

import java.io.Serializable;

/**
 * @author micah cooper
 *
 */
public class Player implements Serializable {
	private static final long serialVersionUID = 1L;
	private Deck drawDeck,winDeck,memoryDeck,warDeck;
	private String name;

	/**
	 * 
	 */
	public Player() {
		this.winDeck = new Deck();
		name = "unknown";
		System.out.println(this.name+" player created");
	}
	
	public Player(String name) {
		this.name = name;
		System.out.print(this.name+" created with ");
		this.winDeck = new Deck();
		this.memoryDeck = new Deck();
		this.warDeck = new Deck();
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

	public void addDrawDeck(Deck drawDeck){
		this.drawDeck = drawDeck;
		//new drawDeck means we need a new memoryDeck
		this.memoryDeck = new Deck();
		System.out.println(this.getName()+": "+drawDeck.toString()+" size:"+drawDeck.getCardsLeft());
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
	 * @param warDeck the warDeck to set
	 */
	public void setWarDeck(Deck warDeck) {
		this.warDeck = warDeck;
	}
	
	public void resetWarDeck(){
		this.warDeck = new Deck();
	}

	public void keepWarDeck(){
		for( int i=0; i < getWarDeck().getCardsLeft(); i++){
			getWinDeck().addCard( getWarDeck().getCard(i) );
			this.getWinDeck().addCard( this.getWarDeck().getCard(i) );
		}
	}

	public void takeCard(Player loser){
		getWinDeck().addCard(getDrawDeck().removeCard(0));
		getWinDeck().addCard(loser.getDrawDeck().removeCard(0));
	}

	
}
