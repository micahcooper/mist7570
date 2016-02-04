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
	private int loanAmount;
	private double loanRate;
	private int loanTerm;
       
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
		// TODO Auto-generated method stub
		int loanAmount = Integer.parseInt( request.getParameter("loanAmount") );
    	double loanRate = Double.parseDouble( request.getParameter("loanRate") );
    	int loanTerm = Integer.parseInt( request.getParameter("loanTerm") );
    	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
    	out.println("<html>");
    	out.println("<head>");
    	out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
    	out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"stylesheet.css\" />");
    	out.println("<title>Loan Amortization Results</title>");
    	out.println("</head>");
    	out.println("<body>");
    	out.println("<div id=container>");
    	out.println("<h1>Loan Amortization Results</h1>");
    	out.println("<p><a href='index.jsp'>Try another</a></p>");
    	
    	Loan loan = new Loan(loanAmount, loanRate, loanTerm);
    	Amortization amort = new Amortization(loan);
    	
    	out.println(amort.doAmortization());
    	
    	out.println("<p><a href='index.jsp'>Try another</a></p>");
    	out.println("</div>");
    	out.println("</body>");
    	out.println("</html>");
		doGet(request, response);
	}

}
