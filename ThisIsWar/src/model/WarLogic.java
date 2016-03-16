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
		System.out.println("create new war game logic");
		dealer = new Dealer();
		player1 = new Player("john");
		player2 = new Player("sara");
	}
	
	public void start(){
		dealer.deal(player1, player2);
		dealer.setShowCard(true);
	}
	
	public void test(){
		dealer.test(player1, player2);
		dealer.setShowCard(true);
	}
	
	public boolean takeTurn(){
		System.out.println("\n ============ NEW TURN ============= \n");
		//check to see if there are any cards left
		if( player1.getDrawDeck().getCardsLeft() > 0 ){
			this.memorizePlayersDrawDeck();
			//player1 wins
			if( player1.getDrawDeck().getCard(0).getValue() > player2.getDrawDeck().getCard(0).getValue() ){
				dealer.takeCard(player1, player2);
				System.out.println( player1.getName()+" wins with "+player1.getWinDeck().getLastCard()+", deck size:"+player1.getDrawDeck().getCardsLeft() );
			}
			//player2 wins
			else if( player1.getDrawDeck().getCard(0).getValue() < player2.getDrawDeck().getCard(0).getValue() ){
				dealer.takeCard(player2, player1);
				System.out.println( player2.getName()+" wins with "+player2.getWinDeck().getLastCard()+", deck size:"+player2.getDrawDeck().getCardsLeft() );
			}
			//it's a tie, time for war
			else{
				dealer.setTimeOfWar(true);
			}
			return true;
		}
		return false;
	}
	
	public boolean war(){
		//now we know how many cards to use in war
		int totalSpoils = this.calculateSpoilsOfWar();
		
		dealer.addToSpoilsOfWar(player1, player2, totalSpoils);
			
		//make sure we're not out of cards, time to end this
		if( totalSpoils > 0 ){
			//player1 wins the war
			if( player1.getWarDeck().getLastCard().getValue() > player2.getWarDeck().getLastCard().getValue() ){
				System.out.println(player1.getName()+" wins the war, p1:"+player1.getWarDeck().getLastCard().getValue()+" p2:"+player2.getWarDeck().getLastCard().getValue());
				
				dealer.toTheVictorGoesTheSpoils(player1, player2.getWarDeck());
			}
			//player2 wins the war
			else if( player1.getWarDeck().getLastCard().getValue() < player2.getWarDeck().getLastCard().getValue() ){
				System.out.println(player2.getName()+" wins the war, p1:"+player1.getWarDeck().getLastCard().getValue()+" p2:"+player2.getWarDeck().getLastCard().getValue());
				
				dealer.toTheVictorGoesTheSpoils(player2, player1.getWarDeck());
			}
			//tie, players get to keep their cards
			else{
				dealer.toTheVictorGoesTheSpoils(player1, player1.getWarDeck());
				dealer.toTheVictorGoesTheSpoils(player2, player2.getWarDeck());
			}
		}
		//since we're only doing one war round, just return false for continue another war round
		return false;
	}
	
	private int calculateSpoilsOfWar(){
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
		
		return totalSpoils;
	}
	
	private void memorizePlayersDrawDeck(){
		player1.getMemoryDeck().addCard(player1.getDrawDeck().getCard(0));
		player2.getMemoryDeck().addCard(player2.getDrawDeck().getCard(0));
		
		System.out.println( player1.getName()+" wins "+player1.getWinDeck().getLastCard()+", deck size:"+player1.getDrawDeck().getCardsLeft() );
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
	
	/**
	 * @return the dealer
	 */
	public Dealer getDealer() {
		return dealer;
	}

	/**
	 * @param dealer the dealer to set
	 */
	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

}
