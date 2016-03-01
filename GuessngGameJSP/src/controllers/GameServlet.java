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
	private GameNumber guesses,target,maximum,minimum,guess;
	//variable to help with resetting values after the target is correctly guessed
	private boolean newGame;
	GameMessage msg;
	HashMap<String, GameLogic> games;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameServlet() {
        super();
		System.out.println("Servlet constructed: "+this.serialVersionUID);
        //since we are not using initialization values, i'm using the default constructor to setup some values
        //if the servlet is accessed directly before guess.jsp, setup some initial values
        msg = new GameMessage();
        guesses = new GameNumber(1);
        //minimum = new GameNumber(0);
        //maximum = new GameNumber(1000);
		//set newGame flag for processing logic
		newGame = true;
		guess = new GameNumber();
		//create a target number for the new game

		target = new GameNumber();
		//target.setRandom(minimum.getValue(), maximum.getValue());
    }
    
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

	}
	
	/**
	 * resets the game: new target number, flip newGame flag
	 */
	private void resetGame(){
		System.out.println("Reset game, id:"+this.serialVersionUID);
		//reset the target, set guesses to 1, and newGame flag to true
		//target = new GameNumber();
		target.setRandom(minimum.getValue(), maximum.getValue(), "reset game");
		this.guesses.setValue(1);
		newGame=true;
		this.guess = new GameNumber();
		//System.out.println("here");
		msg.setMessage("");
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
		//GameNumber guess;
		HttpSession session = request.getSession();
		String sessionID = session.getId();
		games = new HashMap<String,GameLogic>();
		//grab the new guess from the request object
	try{
		guess =  new GameNumber(Integer.parseInt(request.getParameter("guess")));
	}catch(Exception e){ System.out.println("caught no-guess");guess = new GameNumber();}
		// initialize output parameters
		String url = "/guess.jsp";
		System.out.println("Target: "+target.getValue() + " guess: " +guess.getValue() );
		//if this is a new game put the target in the session variable, else grab all needed values from the session, which should have been set in guess.jsp
		
		//new game, no guesses yet
		if(guess.getValue() == -1){
			System.out.println("==NEW GAME: "+sessionID+" ==");
			newGame = true;
			//target.setRandom(minimum.getValue(), maximum.getValue());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}		
		else{
			//were playing a game, check to see if target has been setup
			if (target.getValue() == -1){
				minimum = (GameNumber)session.getAttribute("minimum");
				maximum = (GameNumber)session.getAttribute("maximum");
					
				target.setRandom(minimum.getValue(), maximum.getValue(),"playing game" );
				//System.out.println("creating new random number: "+target.getValue());
			}
			
			target = (GameNumber)session.getAttribute("target");
			guesses = (GameNumber)session.getAttribute("guesses");
			msg = (GameMessage)session.getAttribute("msg");
				
			//grab the new guess from the request object
			guess =  new GameNumber(Integer.parseInt(request.getParameter("guess")));
			//to make error checking easier, move game logic to it's own method, if a win(true) change url to correct.jsp
			if(playTheGame(guess))
				url="/correct.jsp";
			
			// send control to the next component
			   RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			   dispatcher.forward(request, response);
		}
	}
	
	private boolean playTheGame(GameNumber guess){
		// compare the guess with the target
		   if( guess.getValue() == target.getValue() ){
			   // winner
			   msg.setMessage("Correct! You got it in " + guesses.getValue() + " guesses.");
			   resetGame();
			   return true;
		   } else {
			   // next guess
			   this.guesses.increment();
			   if ( guess.getValue() < target.getValue() ) {
				   //low
				   msg.setMessage("Incorrect guess! Guess higher next time.");
			   } else {
				   // high
				   msg.setMessage("Incorrect guess! Guess lower next time.");
			   }
			   return false;
		   }
	}
	

}
