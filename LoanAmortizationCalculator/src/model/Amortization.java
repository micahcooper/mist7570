/**
 * TODO
 * 1- create instance variables
 * 2- getters/setters
 * 3- calculate instance variables
 * 4- create amort table spit out
 */
package model;

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
	private double totalInterest;

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
		this.totalInterest=0;
	}
	
	/**
	 * the method uses the Loan instance variable to calculate the amortization table
	 * this built as a Sting in html and returned
	 * 
	 * @return String the html table
	 */
	public String doAmortization(){
		String buildTable;
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		int counter = 0;
		
		//begin building the html syntax that will house our amortization table
		buildTable = "<table><tr><th width='80px'>Month</th><th width='125px'>Monthly Payment</th><th width='161px'>Monthly Interest Paid</th><th width='150px'>Total Interest Paid</th><th width='165px'>Monthly Principal Paid</th><th>Unpaid Balance</th></tr></table>";
		buildTable += "<div id=table-div><table><tbody>";
		//add a row to the table until we have paid off the loan, counting this way helps with odd loan amounts, like zero
		while( (int)currentBalance > 0 ){
			
			if(counter++ % 2 == 0)
				buildTable += "<tr class='even'>";
			else
				buildTable += "<tr class='odd'>";
			
			buildTable += "<td width='80px'>"+counter+"</td>";
			buildTable += "<td width='125px'>"+nf.format( this.loan.getMonthlyPayment() )+"</td>";
			buildTable += "<td width='161px'>"+nf.format( this.calculateMonthlyPaymentToInterest( this.getCurrentBalance()) )+"</td>";
			buildTable += "<td width='150px'>"+nf.format( this.calculateTotalInterestPaid( this.getCurrentBalance() ) )+"</td>";
			buildTable += "<td width='165px'>"+nf.format( this.calculateMonthlyPaymentToBalance( this.getCurrentBalance() ) )+"</td>";
			buildTable += "<td>"+nf.format( this.calculateCurrentBalanceAfterPayment() )+"</td>";
			buildTable += "</tr>\n\r";
			
		}
		buildTable += "</tbody></table></div>";
		
		return buildTable;
	}
	
	/**
	 * @param currentBalance
	 * @return the amount of the monthly payment that goes toward the interest on the Loan object
	 */
	private double calculateMonthlyPaymentToInterest( double currentBalance ){
		return this.loan.getMonthlyLoanRate()*(currentBalance);
	}
	
	/**
	 * @param currentBalance
	 * @return the amount of the monthly payment that goes to the principal of the Loan object
	 */
	private double calculateMonthlyPaymentToBalance( double currentBalance ){
		if( this.loan.getMonthlyPayment() > currentBalance)
			return currentBalance;
	
		return this.loan.getMonthlyPayment() - this.calculateMonthlyPaymentToInterest( currentBalance );
	}
	
	/**
	 * @return the current balance of the loan after applying the current monthly payment
	 */
	private double calculateCurrentBalanceAfterPayment(){
		System.out.println("Balance: "+currentBalance+" - amount paid: "+this.calculateMonthlyPaymentToBalance(currentBalance));
		this.currentBalance -= this.calculateMonthlyPaymentToBalance(currentBalance);
		return this.currentBalance;
	}

	/**
	 * @param currentBalance
	 * @return
	 */
	private double calculateTotalInterestPaid( double currentBalance ){
		this.totalInterest += this.calculateMonthlyPaymentToInterest(currentBalance);
		return totalInterest;
	}
	
	/**
	 * @return the Loan object
	 */
	public Loan getLoan() {
		return loan;
	}

	/**
	 * @param loan the Loan object of the Amortization class
	 */
	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	/**
	 * @return the instance variable of the monthly payment that goes towards interest
	 */
	public double getMonthlyPaymentToInterest() {
		return monthlyPaymentToInterest;
	}

	/**
	 * @param monthlyPaymentToInterest the amount of the monthly payment going to interest
	 */
	public void setMonthlyPaymentToInterest(double monthlyPaymentToInterest) {
		this.monthlyPaymentToInterest = monthlyPaymentToInterest;
	}

	/**
	 * @return the amount of the monthly payment that goes to the principal
	 */
	public double getMonthlyPaymentToBalance() {
		return monthlyPaymentToBalance;
	}

	/**
	 * @param monthlyPaymentToBalance the amount of the monthly payment that goes to the principal
	 */
	public void setMonthlyPaymentToBalance(double monthlyPaymentToBalance) {
		this.monthlyPaymentToBalance = monthlyPaymentToBalance;
	}

	/**
	 * @return the running total of the current balance of the original loan amount
	 */
	public double getCurrentBalance() {
		return currentBalance;
	}

	/**
	 * @param currentBalance the current balance of the loan
	 */
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	/**
	 * @return the total interest
	 */
	public double getTotalInterest() {
		return totalInterest;
	}

	/**
	 * @param totalInterest the amount of the total interest
	 */
	public void setTotalInterest(double totalInterest) {
		this.totalInterest = totalInterest;
	}

}
