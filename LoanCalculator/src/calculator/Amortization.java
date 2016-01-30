/**
 * TODO
 * 1- create instance variables
 * 2- getters/setters
 * 3- calculate instance variables
 * 4- create amort table spit out
 */
package calculator;

/**
 * @author micah cooper
 *
 */
public class Amortization {
	
	private Loan loan;

	/**
	 * Constructor with no arguments
	 */
	public Amortization() {
		// TODO Auto-generated constructor stub
		super();
		this.loan = new Loan();
	}
	
	/**
	 * @param loan the loan object to be amortized
	 */
	public Amortization(Loan loan) {
		// TODO Auto-generated constructor stub
		super();
		this.loan = loan;
	}
	
	/**
	 * 
	 */
	public String doAmortization(){
		String buildTable;
		
		buildTable = "<table><tr><th>Month</th></tr>";
		/*logic*/
		buildTable += "</table>";
		return buildTable;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

}
