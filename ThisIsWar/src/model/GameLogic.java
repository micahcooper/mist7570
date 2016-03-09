/**
 * 
 */
package model;

import java.io.Serializable;

/**
 * @author micah cooper
 *
 */
public class GameLogic implements Serializable {
	Dealer dealer;

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
		dealer = new Dealer();
	}
	
	public void start(){
		dealer.deal();
	}

}
