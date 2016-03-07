package controllers;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;

/**
 * Servlet implementation class GameServlet
 */
@WebServlet(
		description = "A servlet to control our simple guessing game", 
		urlPatterns = { 
				"/GameServlet", 
				"/doGuess"}
		)

public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GameNumber target,guess;
	int minimum, maximum;
	GameMessage msg;
	GameAverage gameAverage;
	//map to store concurrent games
	HashMap<String, GameLogic> games;
	//map to store guess averages and update dynamically
	HashMap<Long, GameAverage> averages;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameServlet() {
        super();
		System.out.println("Servlet constructed");
        //since we are not using initialization values, i'm using the default constructor to setup some values
        //if the servlet is accessed directly before guess.jsp, setup some initial values
        msg = new GameMessage();
		//guess = new GameNumber();
		//create a target number for the new game
		target = new GameNumber();
		//create the hashmap to hold the concurrent games
		games = new HashMap<String,GameLogic>();
		averages = new HashMap<Long, GameAverage>();
    }
    
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

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
		// create the session variable form the request object
		HttpSession session = request.getSession();
		GameLogic game;
		
		// initialize output parameters
		String url = "/guess.jsp";
		
		if( request.getParameter("minimum") != null )
			minimum = Integer.parseInt(request.getParameter("minimum"));
		if( request.getParameter("maximum") != null ) 
			maximum = Integer.parseInt(request.getParameter("maximum"));

		
		//doesn't hurt to do this even if they don't exist, if they do we'll use them later
		session.setAttribute("minimum", minimum);
		session.setAttribute("maximum", maximum);
		
		//new game
		if( games.get(session.getId()) == null ){
			System.out.println("==NEW GAME: "+session.getId()+" ==");
			//we didn't get out initial setup parameters
			if( request.getParameter("minimum") == null )
				url = "/createGame.jsp";
			else{
				//setup the new game by inserting it in the map and throw it in the session
				games.put( session.getId(), new GameLogic() );
				session.setAttribute("guesses", games.get(session.getId()).getGuesses() );
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}		
		else{
			//we're playing a game
			game = games.get(session.getId());
			
			//we don't have a random target yet, so set one up
			if ( game.getTarget().getValue() == -1){
				//a new target is not set, let's create one
				game = new GameLogic(minimum,maximum);
				//System.out.println(session.getId());
				games.put(session.getId(), game);
				session.setAttribute("target", target);
			}
			//we are setting new parameters, as long as the parameter exists
			if( request.getParameter("minimum") != null ){
				game = new GameLogic(minimum,maximum);
				games.put(session.getId(), game);
				session.setAttribute("target", target);
			}
			
			//grab the correct game from the map
			game = games.get(session.getId());
			
			//grab the new guess from the request object
			if( request.getParameter("guess") == null )
				guess = new GameNumber();
			else
				guess =  new GameNumber(Integer.parseInt(request.getParameter("guess")));
			
			//System.out.println( "Guesses:"+game.getGuesses().getValue() );
			//set our session variables
			session.setAttribute("guesses", game.getGuesses());
			session.setAttribute("target", game.getTarget());
			session.setAttribute("msg", game.getMsg());
			session.setAttribute("averages", averages);
			
			
			//if guess is not null, check check the guess
			if( request.getParameter("guess") != null ){
				if(game.checkGuess(guess)){
					url="/correct.jsp";
					
					//if we don't have a gameAverage for the current range, create one
					if( averages.get((long)maximum-minimum) == null )
						gameAverage = new GameAverage( game.getGuesses() );
					else{
						gameAverage = averages.get((long)maximum-minimum);
						gameAverage.updateAverage( game.getGuesses() );
						System.out.println("in the else statement for checking existing avareages");
					}
					//update the gameAverage in the map and throw it in the session
					averages.put((long)maximum-minimum,gameAverage);
					session.setAttribute("averages", averages);
					
					//System.out.println("Totatl guesses: "+averages.get((long)maximum-minimum).getNumberOfTotalGuesses());
					//System.out.println( "SIZE: "+averages.size() );
					//
					//due to my reset funciton, I need a new way to track the total guesses from the last game
					session.setAttribute("lastGameGuesses", game.getGuesses().getValue());
					//reset the game
					game.resetGame();
					
				}
				/**else{
					System.out.println("The guess was wrong");
					if( averages.get((long)maximum-minimum) == null )
						gameAverage = new GameAverage( (GameNumber)session.getAttribute("guesses") );
					else{
						gameAverage.updateAverage( (GameNumber)session.getAttribute("guesses") );
						System.out.println("in the else statement for checking existing avareages");
					}
					averages.put((long)maximum-minimum,gameAverage);
					session.setAttribute("averages", averages);
				}*/
			}
			// send control to the next component
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}
}
