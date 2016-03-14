/**
 * 
 */
package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.smartcardio.Card;

import model.Deck;
import model.WarLogic;

/**
 * @author micah cooper
 *
 */
@WebServlet(
	description = "A servlet to control our simple guessing game", 
	urlPatterns = {"/warGame"}
)
public class WarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Card card;
	public Deck deck;
	public WarLogic warGame;
	public HashMap<String,WarLogic> warGames;
	
	/**
	 * 
	 */
	public WarServlet() {
		warGames = new HashMap<String,WarLogic>();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/index.jsp";
		
		//reset and re-deal the decks
		if( request.getParameter("reset") != null ){
			System.out.println(request.getParameter("reset"));
			warGame = new WarLogic();
			warGame.start();
			warGames.put( request.getSession().getId(), warGame );
		}
		
		//button to stack the decks and give identical ones to each player
		if( request.getParameter("test") != null ){
			System.out.println(request.getParameter("test"));
			warGame = new WarLogic();
			warGame.test();
			warGames.put( request.getSession().getId(), warGame );
		}
		
		//we have a request to draw a card
		if( request.getParameter( "draw" ) != null){
			//System.out.println("Request to start game");
			//we have a new game
			if( warGames.get( request.getSession().getId() ) == null )
			{
				System.out.println("start new game in warServlet");
				warGame = new WarLogic();
				warGame.start();
				warGames.put( request.getSession().getId(), warGame );
			}
			
			if( !warGame.takeTurn() ){
				System.out.println("Game Over");
				
			}
		}
		
		//we have a request to show war card
		if( request.getParameter( "goToWar" ) != null){
			System.out.println("Request to show war card");
			//check to see if we can play more another round, are there cards, if no, game over
			if( warGame.getDealer().isTimeOfWar() ){
				System.out.println("Gentlemen, we have ourselves a war");
				request.setAttribute("showWarCard", true);
			}
			if( !warGame.war() ){
				System.out.println("No longer in a war");
				warGame.getDealer().setTimeOfWar(false);
			}
			
		}
		
		request.getSession().setAttribute("warGame", warGame);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
