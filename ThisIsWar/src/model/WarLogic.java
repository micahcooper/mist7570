/**
 * 
 */
package model;

import java.io.Serializable;

/**
 * @author micah cooper
 *
 */
public class WarLogic implements Serializable {
	Dealer dealer;
	Player player1, player2;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public WarLogic() {
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
		
		if( player1.getDrawDeck().getCard(1).getValue() > player2.getDrawDeck().getCard(1).getValue() ){
			player1.getWinDeck().addCard(player2.getDrawDeck().removeCard(1));
			player1.getWinDeck().addCard(player1.getDrawDeck().removeCard(1));
			System.out.println( "Player one wins, deck size:"+player1.getDrawDeck().getCardsLeft() );
		}
		else{
			player2.getWinDeck().addCard(player1.getDrawDeck().removeCard(1));
			player2.getWinDeck().addCard(player2.getDrawDeck().removeCard(1));
			System.out.println("Player two wins, deck size:"+player2.getDrawDeck().getCardsLeft() );
		}
	}

}
