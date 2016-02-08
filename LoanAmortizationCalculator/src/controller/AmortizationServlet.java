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
		
		//let's do some error checking!
		try{
			int loanAmount = Integer.parseInt( request.getParameter("loanAmount") );
	    	double loanRate = Double.parseDouble( request.getParameter("loanRate") );
	    	int loanTerm = Integer.parseInt( request.getParameter("loanTerm") );
	    	
	    	//we only care about positive values
	    	if(loanAmount < 0 || loanRate < 0 || loanTerm < 0)
	    		out.println("<html><body><p style='color:red'>You need to specify only postive values.  Please correct and try again. <a href='index.jsp'>Go Back</a></p></body></html>");
	    	else
	    		out.println( writeAmortizationResults(loanAmount, loanRate, loanTerm) );
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
    	
		
		
		
		
//deprecated code that doesn't work with my update error logic
/*		
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
    	out.println("<html>");
    	out.println("<head>");
    	out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
    	out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"stylesheet.css\" />");
    	out.println("<title>Loan Amortization Results</title>");
    	out.println("</head>");
    	out.println("<body>");
    	out.println("<div style='height:15px;background-color:#0086FF	;'>&nbsp;</div>");
    	out.println("<div id=container>");
    	out.println("<h1>Loan Amortization Results</h1>");
    	out.println("<p><form action='index.jsp' method='post'><input type='submit' value='Try Another!'/></form></p>");
    	
    	Loan loan = new Loan(loanAmount, loanRate, loanTerm);
    	Amortization amort = new Amortization(loan);
    	
    	out.println(amort.doAmortization());
    	
    	out.println("<p><form action='index.jsp' method='post'><input type='submit' value='Try Another!'/></form></p>");
    	out.println("</div>");
    	out.println("<div style='height:15px;background-color:#0086FF;'>&nbsp;</div>");
    	out.println("</body>");
    	out.println("</html>");
		doGet(request, response);
*/
	}
	
	private String writeAmortizationResults(int loanAmount, double loanRate, int loanTerm){
		String buildTable;
		
		buildTable = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">";
		buildTable += "<html>";
		buildTable += "<head>";
		buildTable += "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">";
		buildTable += "<link rel=\"stylesheet\" type=\"text/css\" href=\"stylesheet.css\" />";
		buildTable += "<title>Loan Amortization Results</title>";
		buildTable += "</head>";
		buildTable += "<body>";
		buildTable += "<div style='height:15px;background-color:#0086FF	;'>&nbsp;</div>";
		buildTable += "<div id=container>";
		buildTable += "<h1>Loan Amortization Results</h1>";
		buildTable += "<p><form action='index.jsp' method='post'><input type='submit' value='Try Another!'/></form></p>";
    	
    	Loan loan = new Loan(loanAmount, loanRate, loanTerm);
    	Amortization amort = new Amortization(loan);
    	
    	//with our new Loan object and Amortization object, we can build the results
    	buildTable += amort.doAmortization();
    	
    	buildTable += "<p><form action='index.jsp' method='post'><input type='submit' value='Try Another!'/></form></p>";
    	buildTable += "</div>";
    	buildTable += "<div style='height:15px;background-color:#0086FF;'>&nbsp;</div>";
    	buildTable += "</body>";
    	buildTable += "</html>";
    	
    	return buildTable;
	}

}
