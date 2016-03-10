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
	private Dealer dealer;
	private Player player1, player2;
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
	
	public boolean takeTurn(){
		if( player1.getDrawDeck().getCardsLeft() > 0 ){
			
			if( player1.getDrawDeck().getCard(0).getValue() > player2.getDrawDeck().getCard(0).getValue() ){
				player1.getWinDeck().addCard(player2.getDrawDeck().removeCard(0));
				player1.getWinDeck().addCard(player1.getDrawDeck().removeCard(0));
				System.out.println( "Player one wins, deck size:"+player1.getDrawDeck().getCardsLeft() );
			}
			else if( player1.getDrawDeck().getCard(0).getValue() < player2.getDrawDeck().getCard(0).getValue() ){
				player2.getWinDeck().addCard(player1.getDrawDeck().removeCard(0));
				player2.getWinDeck().addCard(player2.getDrawDeck().removeCard(0));
				System.out.println("Player two wins, deck size:"+player2.getDrawDeck().getCardsLeft() );
			}
			else{
				//System.out.println("we have a war");
				int multiplesOfThree;
				
				if( player1.getDrawDeck().getCardsLeft() >= player2.getDrawDeck().getCardsLeft())
					multiplesOfThree = player2.getDrawDeck().getCardsLeft() % 3;
				else
					multiplesOfThree = player1.getDrawDeck().getCardsLeft() % 3;
				
				for(int i=0; i <= multiplesOfThree; i++){
					if( player1.getDrawDeck().getCard(4+4*i).getValue() > player2.getDrawDeck().getCard(4+4*i).getValue() ){
						System.out.println("Player one wins the war");
						i=multiplesOfThree+1;
					}
					else if( player1.getDrawDeck().getCard(4+4*i).getValue() < player2.getDrawDeck().getCard(4+4*i).getValue() ){
						System.out.println("Player two wins the war");
						i=multiplesOfThree+1;
					}
					else{
						System.out.println("its another war");
					}
				}
			}
			
			return true;
		}
		return false;
	}

	/**
	 * @return the player1
	 */
	public Player getPlayer1() {
		return player1;
	}

	/**
	 * @param player1 the player1 to set
	 */
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	/**
	 * @return the player2
	 */
	public Player getPlayer2() {
		return player2;
	}

	/**
	 * @param player2 the player2 to set
	 */
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

}
