package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Amortization;
import model.Loan;

/**
 * Servlet implementation class AmortizationServlet
 */
@WebServlet("/doAmortization")
public class AmortizationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AmortizationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String url ="/amortization.jsp";
		
		
		//let's do some error checking!
		try{
			int loanAmount = Integer.parseInt( request.getParameter("loanAmount") );
	    	double loanRate = Double.parseDouble( request.getParameter("loanRate") );
	    	int loanTerm = Integer.parseInt( request.getParameter("loanTerm") );
	    	
	    	//we only care about positive values
	    	if(loanAmount < 0 || loanRate < 0 || loanTerm < 0)
	    		out.println("<html><body><p style='color:red'>You need to specify only postive values.  Please correct and try again. <a href='index.jsp'>Go Back</a></p></body></html>");
	    	else
	    		request.setAttribute("amort", new Amortization(new Loan(loanAmount,loanRate,loanTerm)));
	    	
	    	getServletContext().getRequestDispatcher(url).forward(request, response);
	    	
		}
		catch(NullPointerException error1){
			//this doesn't seem possible for the form but a protection against an attack to send null values
			out.println("<html><body><p style='color:red'>You sent a null value on the input form.  Please correct and try again. <a href='index.jsp'>Go Back</a></p></body></html>");
		}
		catch(NumberFormatException error2){
			//if the user submits a string dispaly this error, also really large numbers appear to be caught here
			out.println("<html><body><p style='color:red'>You probably entered a string or too large of a value.  Please use only reasonable numbers. <a href='index.jsp'>Go Back</a></p></body></html>");
		}
		catch(Exception e){
			//I have no idea what happened...
			out.println("<html><body><p style='color:red'>Something went horribly wrong, abort!</p></body></html>");
		}
	}
}
