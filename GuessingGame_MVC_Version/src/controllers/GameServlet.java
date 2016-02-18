package controllers;

import java.io.IOException;
import java.util.Random;

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
	GameNumber guesses,target;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.maximum = Integer.parseInt(config.getInitParameter("maximum"));
		this.minimum = Integer.parseInt(config.getInitParameter("minimum"));
		this.guesses = new GameNumber( Integer.parseInt(config.getInitParameter("guesses")) );
		
		target = new GameNumber();
		target.setRandom(minimum, maximum);
		
		
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
		// get input - target, guess, number of guesses, minimum and maximum
		GameNumber guess = new GameNumber(Integer.parseInt(request.getParameter("guess")));
		//GameNumber target = new GameNumber(Integer.parseInt(request.getParameter("target")));
		//GameNumber guesses = new GameNumber(Integer.parseInt(request.getParameter("guesses")));
		HttpSession session = request.getSession();
		session.setAttribute("target", this.target);
		
		// initialize output
		String msg = "";
		String url = "/guess.jsp";
		
		// compare the guess with the target
	   if( guess.getValue() == this.target.getValue() ){
		   // winner
		   msg = "Correct! You got it in " + guesses.getValue() + " guesses.";
		   url = "/correct.jsp";
		   init();
	   } else {
		   // next guess
		   this.guesses.increment();
		   session.setAttribute("guesses", guesses);
		   if ( guess.getValue() < target.getValue() ) {
			   //low
			   msg = "Incorrect guess! Guess higher next time."+target.getValue();
		   } else {
			   // high
			   msg = "Incorrect guess! Guess lower next time."+target.getValue();
		   }
	   }
	   
	   // add values to request object to pass to the destination
	   request.setAttribute("msg", msg);
	   request.setAttribute("guesses", guesses);
	   
	   // send control to the next component
	   RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	   dispatcher.forward(request, response);
		
		
	}

}
