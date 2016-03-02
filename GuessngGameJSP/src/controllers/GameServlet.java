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
	private GameNumber target,guess;
	int minimum, maximum;
	GameMessage msg;
	HashMap<String, GameLogic> games;
	HashMap<Integer, Double> averages;
       
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
		
		// initialize output parameters
		String url = "/guess.jsp";
		
		if( request.getParameter("minimum") != null )
			minimum = Integer.parseInt(request.getParameter("minimum"));
		if( request.getParameter("maximum") != null ) 
			maximum = Integer.parseInt(request.getParameter("maximum"));
		
		session.setAttribute("minimum", minimum);
		session.setAttribute("maximum", maximum);
		
		//new game, no guesses yet
		if( games.get(session.getId()) == null ){
			
			System.out.println("==NEW GAME: "+session.getId()+" ==");
			if( request.getParameter("minimum") == null )
				url = "/createGame.jsp";
			else{
				games.put( session.getId(), new GameLogic() );
				session.setAttribute("guesses", games.get(session.getId()).getGuesses() );
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}		
		else{
			//we're playing a game, check to see if game has been setup
			System.out.println("we're looking to play the game");
			game = games.get(session.getId());
			
			if ( game.getTarget().getValue() == -1){
				//a new target is not set, let's create one
				game = new GameLogic(minimum,maximum);
				games.put(session.getId(), game);

				session.setAttribute("target", target);
				//session.setAttribute("guesses", game.getGuesses().getValue());
			}
			game = games.get(session.getId());
			
			//grab the new guess from the request object
			if( request.getParameter("guess") == null )
				guess = new GameNumber();
			else
				guess =  new GameNumber(Integer.parseInt(request.getParameter("guess")));
			
			System.out.println( "Guesses:"+game.getGuesses().getValue() );
			session.setAttribute("guesses", game.getGuesses());
			session.setAttribute("target", game.getTarget());
			session.setAttribute("msg", game.getMsg());
			
			if( request.getParameter("guess") != null )
				if(game.checkGuess(guess))
					url="/correct.jsp";
			
			// send control to the next component
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}
}
