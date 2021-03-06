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

/**
 * Servlet implementation class GameServlet
 */
@WebServlet(
		description = "A servlet to control our simple guessing game", 
		urlPatterns = { 
				"/GameServlet", 
				"/doGuess"},
		initParams = { 
				@WebInitParam(name = "minimum", value = "0", description = "min guess range"),
				@WebInitParam(name = "maximum", value = "1000", description = "max guess range"),
				@WebInitParam(name = "guesses", value = "1", description = "num of guesses")
		})

public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int maximum,minimum;
	private GameNumber guesses,target;
	private boolean newGame;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameServlet() {
        super();
    }
    
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		//setup the servlet init variables
		this.maximum = Integer.parseInt(config.getInitParameter("maximum"));
		this.minimum = Integer.parseInt(config.getInitParameter("minimum"));
		this.guesses = new GameNumber( Integer.parseInt(config.getInitParameter("guesses")) );
		
		//create a target number for the new game
		target = new GameNumber();
		target.setRandom(minimum, maximum);
		
		//set newGame flag for processing logic
		newGame = true;
	}
	
	private void resetGame(){
		//reset the target, set guesses to 1, and newGame flag to true
		target = new GameNumber();
		this.target.setRandom(1, 1000);
		this.guesses.setValue(1);
		newGame=true;
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
		String msg = "";
		String url = "/guess.jsp";
		boolean error = false;

		try{
			guess =  new GameNumber(Integer.parseInt(request.getParameter("guess")));
			
			if(newGame){
				session.setAttribute("target", this.target);
				session.setAttribute("guesses", guesses);
				newGame=false;
			}
			else{
					target = (GameNumber)session.getAttribute("target");
					guesses = (GameNumber)session.getAttribute("guesses");
			}
		
			// compare the guess with the target
		   if( guess.getValue() == target.getValue() ){
			   // winner
			   msg = "Correct! You got it in " + guesses.getValue() + " guesses.";
			   url = "/correct.jsp";
			   resetGame();
		   } else {
			   // next guess
			   this.guesses.increment();
			   if ( guess.getValue() < target.getValue() ) {
				   //low
				   msg = "Incorrect guess! Guess higher next time.";
			   } else {
				   // high
				   msg = "Incorrect guess! Guess lower next time.";
			   }
		   }
		}catch( Exception e ){
			init();
			newGame = true;
			error = true;
			msg = "<p>Please be aware that two or more people are playing this game right now.</p>";
			url = "/index.jsp";
			// add values to request object to pass to the destination
			 request.setAttribute("msg", msg);
			   
			   // send control to the next component
			  RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			  dispatcher.forward(request, response);
		}
	   if(!error){
		   // add values to request object to pass to the destination
		   request.setAttribute("msg", msg);
		   
		   // send control to the next component
		   RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		   dispatcher.forward(request, response);
	   }
		
	}
	
	

}
