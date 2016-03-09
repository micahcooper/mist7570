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
import model.GameLogic;

/**
 * @author mrcooper
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
	public GameLogic warGame;
	public HashMap<String,GameLogic> warGames;
	
	/**
	 * 
	 */
	public WarServlet() {
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
		String url = "/index.jsp";
		PrintWriter out = response.getWriter();
		GameLogic gameLogic = new GameLogic();
		
		gameLogic.start();
		gameLogic.takeTurn();
		
		out.println("hi");
		
		//RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		//dispatcher.forward(request, response);
	}
}
