package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persist.PersistenceModule;
import persist.PersistenceModuleFactory;

/**
 * Servlet implementation class UpdateFormServlet
 */
@WebServlet(description = "This will get a product and use the data to fill in a table for updating the record", urlPatterns = { "/search" })
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
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
		// Create a ReadQuery helper objects
				PersistenceModule persist;
				String sku = request.getParameter("sku");
				
				try {
					persist = PersistenceModuleFactory.createPersistenceModule();

					// Get the html table from the REadQuery object
					
					String table = persist.getHTMLTable( persist.doSearch(sku) );
					
					// pass execution control to read.jsp along with the table
					request.setAttribute("table", table);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String url = "/search.jsp";
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);

	}

}
