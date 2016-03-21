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
	private String message;
	private static final long serialVersionUID = 1L;

	/**
	 * empty constructor, setup some default initial values, instantiate class variables
	 */
	public WarLogic() {
		System.out.println("create new war game logic");
		dealer = new Dealer();
		player1 = new Player("Player 1");
		player2 = new Player("Player 2");
		message = "";
	}
	
	/**
	 * empty constructor, setup some default initial values, instantiate class variables
	 */
	public WarLogic(String player1name, String player2name) {
		System.out.println("create new war game logic");
		dealer = new Dealer();
		player1 = new Player(player1name);
		player2 = new Player(player2name);
		message = "";
	}
	
	/**
	 * @param isTestGame is this a test game (true) or real game (false)
	 */
	public void start(boolean isTestGame){
		dealer.dealCards(player1, player2, isTestGame);
		dealer.setShowCard(true);
		message = "";
	}
		
	/**
	 * @return can we continue taking turns (true) if not then false
	 */
	public boolean takeTurn(){
		System.out.println("\n ============ NEW TURN ============= \n");
		player1.resetWarDeck();
		player2.resetWarDeck();
		
		//check to see if there are any cards left
		if( player1.getDrawDeck().getCardsLeft() > 0 ){
			this.memorizePlayersDrawDeck();

			//player1 wins
			if( player1.getDrawDeck().getCard(0).getValue() > player2.getDrawDeck().getCard(0).getValue() ){
				player1.takesCard(player2);
				message = "player 1 wins";
				System.out.println( player1.getName()+" wins with "+player1.getWinDeck().getLastCard()+", deck size:"+player1.getDrawDeck().getCardsLeft() );
			}
			//player2 wins
			else if( player1.getDrawDeck().getCard(0).getValue() < player2.getDrawDeck().getCard(0).getValue() ){
				player2.takesCard(player1);
				message = "player 2 wins";
				System.out.println( player2.getName()+" wins with "+player2.getWinDeck().getLastCard()+", deck size:"+player2.getDrawDeck().getCardsLeft() );
			}
			//it's a tie, time for war
			else{
				message = "New war game.";
				dealer.setTimeOfWar(true);
			}
			return true;
		}
		
		//refactoring needed here since the method only returns false
		return gameOver();
	}

	/**
	 * @return only the false value for the game is over
	 */
	private boolean gameOver() {
		dealer.setShowCard(false);
		
		if( player1.getScore() > player2.getScore())
			message = "Game Over, player 1 wins. Click reset to play again.";
		else if (player1.getScore() < player2.getScore())
			message = "Game Over, player 2 wins. Click reset to play again.";
			else
				message = "Game ends in a draw. Click reset to play again.";
		return false;
	}
	
	/**
	 * @return only a false value since 1 round of war is played
	 */
	public boolean war(){
		//now we know how many cards to use in war
		int totalSpoils = this.calculateSpoilsOfWar();
		
		dealer.addToSpoilsOfWar(player1, player2, totalSpoils);
		
		//make sure we're not out of cards, time to end this
		if( totalSpoils > 0 ){
			//player1 wins the war
			if( player1.getWarCard().getValue() > player2.getWarCard().getValue() ){
				dealer.toTheVictorGoesTheSpoils(player1, player2);
				message = "Player 1 wins";
			}
			//player2 wins the war
			else if( player1.getWarCard().getValue() < player2.getWarCard().getValue() ){
				dealer.toTheVictorGoesTheSpoils(player2, player1);
				message = "Player 2 wins";
			}
			//tie, players get to keep their cards
			else{
				message = "War ends in a draw!";
				player1.keepWarDeck();
				player2.keepWarDeck();
			}
		}
		//since we're only doing one war round, just return false for continue another war round
		return false;
	}
	
	/**
	 * @return the number of cards to lay down in war
	 */
	private int calculateSpoilsOfWar(){
			int totalSpoils;
		
			//need five cards for normal war round, current card+3 lay down+war card
			if( player1.getDrawDeck().getCardsLeft() > 5 )
				totalSpoils = 3;
			else
				totalSpoils = player1.getDrawDeck().getCardsLeft()-2;
		
		return totalSpoils;
	}
	
	/**
	 * create a memory deck of the cards played for use later in the jsp page
	 */
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

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
