/**
 * 
 */
package model;

/**
 * @author micah cooper
 *
 */
public class Player {
	private Deck drawDeck,winDeck;
	private String name;

	/**
	 * 
	 */
	public Player() {
		// TODO Auto-generated constructor stub
		System.out.println("new player created");
		this.winDeck = new Deck();
	}

	public Player(Deck drawDeck){
		this.drawDeck = drawDeck;
		this.winDeck = new Deck();
	}
	
	public void addDrawDeck(Deck drawDeck){
		this.drawDeck = drawDeck;
		
		System.out.println("Player: "+drawDeck.toString()+" size:"+drawDeck.getCardsLeft());
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
