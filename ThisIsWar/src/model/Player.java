/**
 * 
 */
package model;

/**
 * @author mrcooper
 *
 */
public class Player {
	private Deck deck;

	/**
	 * 
	 */
	public Player() {
		// TODO Auto-generated constructor stub
		System.out.println("new player created");
	}

	public Player(Deck deck){
		this.deck = deck;
	}
}
