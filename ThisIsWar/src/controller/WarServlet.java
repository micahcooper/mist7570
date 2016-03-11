/**
 * 
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
		urlPatterns = { 
				"/warGame"}
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
		// TODO Auto-generated constructor stub
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
		
		if( request.getParameter("reset") != null ){
			System.out.println(request.getParameter("reset"));
			warGame = new WarLogic();
			warGame.start();
			warGames.put( request.getSession().getId(), warGame );
			request.getSession().setAttribute("warGame", warGame);
		}
		
		//we have a new game
		if( warGames.get( request.getSession().getId() ) == null )
		{
			System.out.println("start new game in warServlet");
			warGame = new WarLogic();
			warGame.start();
			warGames.put( request.getSession().getId(), warGame );
			request.getSession().setAttribute("warGame", warGame);
		}
		
		//we have a request to play a turn
		if( request.getParameter( "playTurn" ) != null){
			//check to see if we can play more another round, are there cards, if no, game over
			if( !warGame.takeTurn() )
				System.out.println("Game Over");
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
