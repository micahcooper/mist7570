package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GameNumber;

/**
 * Servlet implementation class GameServlet
 */
@WebServlet(
		description = "A servlet to control our simple guessing game", 
		urlPatterns = { 
				"/GameServlet", 
				"/doGuess"
		})
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		GameNumber target = new GameNumber(Integer.parseInt(request.getParameter("target")));
		GameNumber guesses = new GameNumber(Integer.parseInt(request.getParameter("guesses")));
		
		// initialize output
		String msg = "";
		String url = "/guess.jsp";
		
		// compare the guess with the target
	   if( guess.getValue() == target.getValue() ){
		   // winner
		   msg = "Correct! You got it in " + guesses.getValue() + " guesses.";
		   url = "/correct.jsp";
	   } else {
		   // next guess
		   guesses.increment();
		   if ( guess.getValue() < target.getValue() ) {
			   //low
			   msg = "Incorrect guess! Guess higher next time.";
		   } else {
			   // high
			   msg = "Incorrect guess! Guess lower next time.";
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
