/**
 * 
 */
package model;

import java.io.Serializable;

/**
 * @author mrcooper
 *
 */
public class GameLogic implements Serializable {
	private Deck deck;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GameLogic() {
		// TODO Auto-generated constructor stub
		System.out.println("create new game logic");
		this.deck = new Deck();
	}
	
	public void deal(){
		System.out.println(this.deck.toString());
	}

}
