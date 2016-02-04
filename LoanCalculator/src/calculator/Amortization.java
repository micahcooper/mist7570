/**
 * TODO
 * 1- create instance variables
 * 2- getters/setters
 * 3- calculate instance variables
 * 4- create amort table spit out
 */
package calculator;

import java.text.NumberFormat;

/**
 * @author micah cooper
 *
 */
public class Amortization {
	
	private Loan loan;
	private double monthlyPaymentToInterest;
	private double monthlyPaymentToBalance;
	private double currentBalance;

	/**
	 * Constructor with no arguments
	 */
	public Amortization() {
		// TODO Auto-generated constructor stub
		super();
		this.loan = new Loan();
	}
	
	/**
	 * @param loan the Loan object to be amortized
	 */
	public Amortization(Loan loan) {
		// TODO Auto-generated constructor stub
		super();
		this.loan = loan;
		//keep track of the current balance of the loan
		this.setCurrentBalance(loan.getLoanAmount());
	}
	
	/**
	 * the method uses the Loan instance variable to calculate the amortization table
	 * this built as a Sting in html and returned
	 * 
	 * @return String the html table
	 */
	public String doAmortization(){
		String buildTable;
		int counter=0;
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		
		buildTable = "<table><tr><th>Month</th><th>Payment</th><th>Interest Paid</th><th>Principal Paid</th><th>Ending Balance</th></tr>";
		
		for( int i=0; i < loan.getLoanTermInMonths(); i++ ){
			
			buildTable += "<tr><td>"+i+"</td>";
			buildTable += "<td>"+nf.format( this.loan.getMonthlyPayment() )+"</td>";
			buildTable += "<td>"+nf.format( this.calculateMonthlyPaymentToInterest() )+"</td>";
			buildTable += "<td>"+nf.format( this.calculateMonthlyPaymentToBalance() )+"</td>";
			this.setCurrentBalance( this.getCurrentBalance()-this.calculateMonthlyPaymentToBalance() );
			buildTable += "<td>"+nf.format( this.calculateCurrentBalanceAfterPayment() )+"</td></tr>";
			
		}
		buildTable += "</table>";
		
		return buildTable;
	}
	
	/**
	 * @return the amount of the monthly payment that goes toward the interest on the Loan object
	 */
	private double calculateMonthlyPaymentToInterest(){
		return this.loan.getMonthlyLoanRate()*(this.getCurrentBalance());
	}
	
	
	
	
	/**
	 * @return the amount of the monthly payment that goes to the principal of the Loan object
	 */
	private double calculateMonthlyPaymentToBalance(){
			return this.loan.getMonthlyPayment() - this.calculateMonthlyPaymentToInterest();
		}
	
	/**
	 * @return the current balance of the loan after applying the current monthly payment
	 */
	private double calculateCurrentBalanceAfterPayment(){
			return this.getCurrentBalance() - this.getMonthlyPaymentToBalance();
	}

	/**
	 * @return the Loan object
	 */
	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public double getMonthlyPaymentToInterest() {
		return monthlyPaymentToInterest;
	}

	public void setMonthlyPaymentToInterest(double monthlyPaymentToInterest) {
		this.monthlyPaymentToInterest = monthlyPaymentToInterest;
	}

	public double getMonthlyPaymentToBalance() {
		return monthlyPaymentToBalance;
	}

	public void setMonthlyPaymentToBalance(double monthlyPaymentToBalance) {
		this.monthlyPaymentToBalance = monthlyPaymentToBalance;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

}
