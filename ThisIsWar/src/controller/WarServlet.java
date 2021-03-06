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
	public WarLogic warGame;
	public HashMap<String,WarLogic> warGames;
	
	/**
	 * empty constructor to setup only the HashMap for holding concurrent war games
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
		String player1name, player2name;
		String url = "/index.jsp";
		
		//check for existing war game, if none exist create a new one
		if( warGames.get( request.getSession().getId() ) == null )
		{
			warGame = new WarLogic();
			
			warGame.start(false);
			warGames.put( request.getSession().getId(), warGame );
		}
		else{
			warGame = warGames.get( request.getSession().getId() );
		}
		
		
		//reset and re-deal the decks for a normal game
		if( request.getParameter("reset") != null ){
			System.out.println(request.getParameter("reset"));
			warGame = new WarLogic();
			//isTestGame=false
			warGame.start(false);
			warGame.getDealer().setShowCard(false);
			warGames.put( request.getSession().getId(), warGame );
		}
		
		//button to stack the decks and give identical ones to each player
		if( request.getParameter("test") != null ){
			System.out.println(request.getParameter("test"));
			warGame = new WarLogic();
			//isTestGame=true
			warGame.start(true);
			warGames.put( request.getSession().getId(), warGame );
		}
		
		//we have a request to draw a card
		if( request.getParameter( "draw" ) != null){
			//System.out.println("Request to start game");
			
			
			
			if( request.getParameter("player1Name") != null ){
				player1name = (String) request.getParameter("player1Name");
				if(!player1name.equals("")){
					warGame.getPlayer1().setName(player1name);
					request.getSession().setAttribute("name1Set", true);
				}
			}
			
			if( request.getParameter("player2Name") != null ){
				player2name = (String) request.getParameter("player2Name");
				if(!player2name.equals("")){
					warGame.getPlayer2().setName(player2name);
					request.getSession().setAttribute("name1Set", true);
				}
			}
			
			warGame.getDealer().setShowCard(true);
			if( !warGame.takeTurn() ){
				System.out.println("Game Over");
			}
		}
		
		//we have a request to show war card
		if( request.getParameter( "goToWar" ) != null ){
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
