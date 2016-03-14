/**
 * 
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author micah cooper
 *
 */
public class Dealer implements Serializable{
	private static final long serialVersionUID = 1L;
	private Deck gameDeck, spoilsOfWar;
	private boolean showCard, timeOfWar;
	ArrayList<String> spoilsOfWarWithoutLoopingInJSPCheat;




	/**
	 * @return the showCard
	 */
	public boolean isShowCard() {
		return showCard;
	}

	/**
	 * @param showCard the showCard to set
	 */
	public void setShowCard(boolean showCard) {
		this.showCard = showCard;
	}

	/**
	 * @return the timeOfWar
	 */
	public boolean isTimeOfWar() {
		return timeOfWar;
	}

	/**
	 * @param timeOfWar the timeOfWar to set
	 */
	public void setTimeOfWar(boolean timeOfWar) {
		//if( timeOfWar ) {System.out.println("Gentlemen, we have ourselves a war");}
		this.timeOfWar = timeOfWar;
	}

	public Dealer(){
		super();
		showCard=false;
		timeOfWar=false;
		System.out.print("Dealer created with ");
		this.gameDeck = new Deck();
	}
	
	/**
	 * @return the spoilsOfWar
	 */
	public Deck getSpoilsOfWar() {
		return spoilsOfWar;
	}
	
	/**
	 * @return the spoilsOfWar
	 */
	public ArrayList<String> getSpoilsOfWarWithoutLoopingInJSPCheat() {
		return spoilsOfWarWithoutLoopingInJSPCheat;
	}
	
	protected ArrayList<String> setSpoilsOfWarWithoutLoopingInJSPCheat() {
		this.spoilsOfWarWithoutLoopingInJSPCheat = new ArrayList<String>();
		
		System.out.print("cheat: ");
		System.out.println(this.spoilsOfWar.getCardsLeft());
		for( int i=0; i<this.spoilsOfWar.getCardsLeft(); i++){
			spoilsOfWarWithoutLoopingInJSPCheat.add("<img src='classic-cards/"+this.spoilsOfWar.getCard(i).toString()+".png' />");
		}
		
		return spoilsOfWarWithoutLoopingInJSPCheat;
	}

	/**
	 * @param spoilsOfWar the spoilsOfWar to set
	 */
	public void setSpoilsOfWar(Deck spoilsOfWar) {
		this.spoilsOfWar = spoilsOfWar;
	}

	public void deal(Player player1, Player player2){
		Deck deck1,deck2;
		deck1 = new Deck();
		deck2 = new Deck();
		
		gameDeck.newDeck();
		gameDeck.shuffleDeck();
		
		System.out.println(this.gameDeck.toString());
		
		while( gameDeck.getCardsLeft() > 0 ){
			deck1.addCard(gameDeck.removeCard());
			deck2.addCard(gameDeck.removeCard());
		}
		
		player1.addDrawDeck(deck1);
		player2.addDrawDeck(deck2);;
		
	}
	
	public void test(Player player1, Player player2){
		Deck deck1,deck2;
		System.out.print(player1.getName()+" gets a ");
		deck1 = new Deck();
		System.out.print(player2.getName()+" gets a ");
		deck2 = new Deck();
		
		deck1.stackDeck();
		deck2.stackDeck();
		
		player1.addDrawDeck(deck1);
		player2.addDrawDeck(deck2);;
	}
	
	public void addToSpoilsOfWar(Player player1, Player player2, int totalSpoils){
		if(spoilsOfWar == null){
			System.out.print("spoils of war created with ");
			spoilsOfWar =  new Deck();
		}
		
		//indexed at 1 because 0 is being used in the war
		for(int i=0; i<totalSpoils; i++){
			spoilsOfWar.addCard( player1.getDrawDeck().removeCard(0) );
			spoilsOfWar.addCard( player2.getDrawDeck().removeCard(0) );
			
		}
		System.out.println( "spoils of war size: "+spoilsOfWar.getCardsLeft() );//+" with: "+spoilsOfWar.toString() );
	}
	
	public void addToSpoilsOfWar(Card card){
		if(spoilsOfWar == null){
			System.out.print("spoils of war created with ");
			spoilsOfWar =  new Deck();
		}
		
		spoilsOfWar.addCard(card);
		System.out.println( "spoils of war size: "+spoilsOfWar.getCardsLeft() );//+" with: "+spoilsOfWar.toString() );
	}
	
	public void toTheVictorGoesTheSpoils(Player player){
		setSpoilsOfWarWithoutLoopingInJSPCheat();
		while( spoilsOfWar.getCardsLeft() > 0 )
			player.getWinDeck().addCard( spoilsOfWar.removeCard() );
	}
}
