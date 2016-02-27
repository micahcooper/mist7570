package controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GameNumber;
import model.Message;

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
	private GameNumber guesses,target,maximum,minimum;
	private boolean newGame;
	Message msg;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameServlet() {
        super();
        
        //if the servlet is accessed directly before guess.jsp, setup some initial values
        msg = new Message();
        guesses = new GameNumber(1);
        minimum = new GameNumber(0);
        maximum = new GameNumber(1000);
		//set newGame flag for processing logic
		newGame = true;
		
		//create a target number for the new game
		target = new GameNumber();
		target.setRandom(minimum.getValue(), maximum.getValue());
    }
    
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

	}
	
	private void resetGame(){
		//reset the target, set guesses to 1, and newGame flag to true
		target = new GameNumber();
		target.setRandom(minimum.getValue(), maximum.getValue());
		this.guesses.setValue(1);
		newGame=true;
		System.out.println("here");
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
		GameNumber guess;
		HttpSession session = request.getSession();
		// initialize output parameters
		String url = "/guess.jsp";
		
		if(newGame){
			newGame=false;
			session.setAttribute("target", this.target);
		}
		else{
				target = (GameNumber)session.getAttribute("target");
				guesses = (GameNumber)session.getAttribute("guesses");
				minimum = (GameNumber)session.getAttribute("minimum");
				maximum = (GameNumber)session.getAttribute("maximum");
				msg = (Message)session.getAttribute("msg");
				this.guesses = (GameNumber)session.getAttribute("guesses");
				guess =  new GameNumber(Integer.parseInt(request.getParameter("guess")));
				if(playTheGame(guess))
					url="/correct.jsp";
		}
	   
	   // send control to the next component
	   RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	   dispatcher.forward(request, response);
	}
	
	private boolean playTheGame(GameNumber guess){
		// compare the guess with the target
		   if( guess.getValue() == target.getValue() ){
			   // winner
			   msg.setCorrectMessage("Correct! You got it in " + guesses.getValue() + " guesses.");
			   //url = "/correct.jsp";
			   resetGame();
			   return true;
		   } else {
			   // next guess
			   this.guesses.increment();
			   if ( guess.getValue() < target.getValue() ) {
				   //low
				   msg.setGuessMessage("Incorrect guess! Guess higher next time.");
			   } else {
				   // high
				   msg.setGuessMessage("Incorrect guess! Guess lower next time.");
			   }
			   return false;
		   }
	}
	

}
