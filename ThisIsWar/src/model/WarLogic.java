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
		//check to see if there are any cards left
		if( player1.getDrawDeck().getCardsLeft() > 0 ){
			//player1 wins
			if( player1.getDrawDeck().getCard(0).getValue() > player2.getDrawDeck().getCard(0).getValue() ){
				player1.getWinDeck().addCard(player2.getDrawDeck().removeCard(0));
				player1.getWinDeck().addCard(player1.getDrawDeck().removeCard(0));
				System.out.println( "Player one wins, deck size:"+player1.getDrawDeck().getCardsLeft() );
			}
			//player2 wins
			else if( player1.getDrawDeck().getCard(0).getValue() < player2.getDrawDeck().getCard(0).getValue() ){
				player2.getWinDeck().addCard(player1.getDrawDeck().removeCard(0));
				player2.getWinDeck().addCard(player2.getDrawDeck().removeCard(0));
				System.out.println("Player two wins, deck size:"+player2.getDrawDeck().getCardsLeft() );
			}
			//it's a tie, time for war
			else{
				war();
			}
			
			return true;
		}
		return false;
	}
	
	private void war(){
		int totalSpoils;
		System.out.println("Player: "+player1.getDrawDeck().toString()+" size:"+player1.getDrawDeck().getCardsLeft());
		System.out.println("Player: "+player2.getDrawDeck().toString()+" size:"+player2.getDrawDeck().getCardsLeft());
		//check to see who has the least amount of cards, calculate the spoils
		if( player1.getDrawDeck().getCardsLeft() <= player2.getDrawDeck().getCardsLeft())
			if( player1.getDrawDeck().getCardsLeft() >= 4 )
				totalSpoils = 3;
			else
				totalSpoils = player1.getDrawDeck().getCardsLeft();
		else
			if( player2.getDrawDeck().getCardsLeft() >= 4 )
				totalSpoils = 3;
			else
				totalSpoils = player2.getDrawDeck().getCardsLeft();
		
		
		//now we know how many cards to play in war
		dealer.addToSpoilsOfWar(player1, player2, totalSpoils);
		
		//player1 wins the war
		if( player1.getDrawDeck().getCard(0).getValue() > player2.getDrawDeck().getCard(0).getValue() ){
			System.out.println("Player one wins the war, p1:"+player1.getDrawDeck().getCard(0).getValue()+" p2:"+player2.getDrawDeck().getCard(0).getValue());
			dealer.toTheVictorGoesTheSpoils(player1);
			player1.getWinDeck().addCard( player2.getDrawDeck().removeCard(0) );
		}
		//player2 wins the war
		else if( player1.getDrawDeck().getCard(0).getValue() < player2.getDrawDeck().getCard(0).getValue() ){
			System.out.println("Player two wins the war, p1:"+player1.getDrawDeck().getCard(0).getValue()+" p2:"+player2.getDrawDeck().getCard(0).getValue());
			dealer.toTheVictorGoesTheSpoils(player2);
			player2.getWinDeck().addCard( player1.getDrawDeck().removeCard(0) );
		}
		
		else{
			System.out.println("its another war, p1:"+player1.getDrawDeck().getCard(0).getValue()+" p2:"+player2.getDrawDeck().getCard(0).getValue());
			dealer.addToSpoilsOfWar( player1.getDrawDeck().removeCard(0) );
			dealer.addToSpoilsOfWar( player2.getDrawDeck().removeCard(0) );
			//we need to wait for the user to press the button, so it can't be truly recursive
			//war();
		}
		
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
