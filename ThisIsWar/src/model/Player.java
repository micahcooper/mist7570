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
	private Deck drawDeck,winDeck;
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
	}
	
	public void addDrawDeck(Deck drawDeck){
		this.drawDeck = drawDeck;
		
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

	
}
