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
		System.out.println("create new war game logic");
		dealer = new Dealer();
		player1 = new Player("john");
		player2 = new Player("sue");
	}
	
	public void start(){
		dealer.deal(player1, player2);
	}
	
	public void test(){
		dealer.test(player1, player2);
	}
	
	public boolean takeTurn(){
		System.out.println("\n ============ NEW ROUND ============= \n");
		//check to see if there are any cards left
		if( player1.getDrawDeck().getCardsLeft() > 0 ){
			//player1 wins
			if( player1.getDrawDeck().getCard(0).getValue() > player2.getDrawDeck().getCard(0).getValue() ){
				player1.getWinDeck().addCard(player2.getDrawDeck().removeCard(0));
				player1.getWinDeck().addCard(player1.getDrawDeck().removeCard(0));
				System.out.println( player1.getName()+" wins, deck size:"+player1.getDrawDeck().getCardsLeft() );
			}
			//player2 wins
			else if( player1.getDrawDeck().getCard(0).getValue() < player2.getDrawDeck().getCard(0).getValue() ){
				player2.getWinDeck().addCard(player1.getDrawDeck().removeCard(0));
				player2.getWinDeck().addCard(player2.getDrawDeck().removeCard(0));
				System.out.println( player2.getName()+" wins, deck size:"+player2.getDrawDeck().getCardsLeft() );
			}
			//it's a tie, time for war
			else{
				System.out.println("Gentlemen, we have ourselves a war");
				war();
			}
			
			return true;
		}
		return false;
	}
	
	private boolean war(){
		int totalSpoils;
				
		//check to see who has the least amount of cards, then calculate the cards available for the spoils of war
		if( player1.getDrawDeck().getCardsLeft() <= player2.getDrawDeck().getCardsLeft())
			if( player1.getDrawDeck().getCardsLeft() > 4 )
				totalSpoils = 3;
			else
				totalSpoils = player1.getDrawDeck().getCardsLeft()-2;
		else
			if( player2.getDrawDeck().getCardsLeft() > 4 )
				totalSpoils = 3;
			else
				totalSpoils = player2.getDrawDeck().getCardsLeft()-2;
		
		
		//now we know how many cards to use in war
		dealer.addToSpoilsOfWar( player1.getDrawDeck().removeCard(0) );
		dealer.addToSpoilsOfWar( player2.getDrawDeck().removeCard(0) );
		dealer.addToSpoilsOfWar(player1, player2, totalSpoils);
		System.out.println("spoils size: "+totalSpoils);
		System.out.println( player1.getName()+": "+player1.getDrawDeck().toString()+" size:"+player1.getDrawDeck().getCardsLeft() );
		System.out.println( player2.getName()+": "+player2.getDrawDeck().toString()+" size:"+player2.getDrawDeck().getCardsLeft() );
		
		//we're out of cards, time to end this
		if( totalSpoils > 0 ){
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
				System.out.println("a war within a war, just like inception, p1:"+player1.getDrawDeck().getCard(0).getValue()+" p2:"+player2.getDrawDeck().getCard(0).getValue());
				//we need to wait for the user to press the button, so it can't be recursive
				//war();
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
