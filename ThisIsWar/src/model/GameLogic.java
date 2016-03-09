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
	Player player1, player2;

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
		player1 = new Player();
		player2 = new Player();
	}
	
	public void start(){
		dealer.deal(player1, player2);
	}
	
	public void takeTurn(){
		
		if( player1.getDeck().getCard(1).getValue() > player2.getDeck().getCard(1).getValue() )
			System.out.println("Player one wins");
		else
			System.out.println("Player two wins");
	}

}
