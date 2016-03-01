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

import model.GameNumber;
import model.GameLogic;
import model.GameMessage;

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
	//changed minimum,maximum to GameNumber so the session variable can be used in guess.jsp
	private GameNumber target,maximum,minimum,guess;
	//variable to help with resetting values after the target is correctly guessed
	//private boolean newGame;
	GameMessage msg;
	HashMap<String, GameLogic> games;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameServlet() {
        super();
		//System.out.println("Servlet constructed: "+this.serialVersionUID);
        //since we are not using initialization values, i'm using the default constructor to setup some values
        //if the servlet is accessed directly before guess.jsp, setup some initial values
        msg = new GameMessage();
        //guesses = new GameNumber(1);
		//set newGame flag for processing logic
		//newGame = true;
		guess = new GameNumber();
		//create a target number for the new game

		target = new GameNumber();
		//target.setRandom(minimum.getValue(), maximum.getValue());
		
		games = new HashMap<String,GameLogic>();
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
		// get input - guess, grab the session from the request object
		HttpSession session = request.getSession();
		GameLogic game;
		
		//grab the new guess from the request object
		try{
			guess =  new GameNumber(Integer.parseInt(request.getParameter("guess")));
		}catch(Exception e){ System.out.println("Caught empty guess");guess = new GameNumber();}
		
		// initialize output parameters
		String url = "/guess.jsp";
		
		//new game, no guesses yet
		if( games.get(session.getId()) == null ){
			
			System.out.println("==NEW GAME: "+session.getId()+" ==");
			
			games.put(session.getId(), new GameLogic());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}		
		else{
			//were playing a game, check to see if target has been setup
			game = games.get(session.getId());
			
			if ( game.getTarget().getValue() == -1){
				//a new target is not set, let's create one
				minimum = (GameNumber)session.getAttribute("minimum");
				maximum = (GameNumber)session.getAttribute("maximum");
				
				game = new GameLogic(minimum.getValue(),maximum.getValue());
				games.put(session.getId(), game);

				session.setAttribute("target", target);
			}
			game = games.get(session.getId());
			
			//grab the new guess from the request object
			guess =  new GameNumber(Integer.parseInt(request.getParameter("guess")));
			//System.out.println( "Was the guess correct?: "+game.checkGuess(guess) );
			session.setAttribute("guesses", game.getGuesses());
			session.setAttribute("target", game.getTarget());
			session.setAttribute("msg", game.getMsg());
			
			//to make error checking easier
			if(game.checkGuess(guess))
				url="/correct.jsp";
			
			// send control to the next component
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}
}
