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
	 * @param loan the loan object to be amortized
	 */
	public Amortization(Loan loan) {
		// TODO Auto-generated constructor stub
		super();
		this.loan = loan;
		this.setCurrentBalance(loan.getLoanAmount());
	}
	
	/**
	 * 
	 */
	public String doAmortization(){
		String buildTable;
		int counter=0;
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		
		buildTable = "<table><tr><th>Month</th><th>Payment</th><th>Interest Paid</th><th>Principal Paid</th><th>Ending Balance</th></tr>";
		
		while( counter++ < loan.getLoanTermInMonths() ){
			
			
			buildTable += "<tr><td>"+counter+"</td>";
			buildTable += "<td>"+nf.format( this.loan.getMonthlyPayment() )+"</td>";
			buildTable += "<td>"+nf.format( this.calculateMonthlyPaymentToInterest() )+"</td>";
			buildTable += "<td>"+nf.format( this.calculateMonthlyPaymentToBalance() )+"</td>";
			this.setCurrentBalance( this.getCurrentBalance()-this.calculateMonthlyPaymentToBalance() );
			buildTable += "<td>"+nf.format( this.calculateCurrentBalanceAfterPayment() )+"</td>";
			
		}
		buildTable += "</table>";
		return buildTable;
	}
	
	private double calculateMonthlyPaymentToInterest(){
		return this.loan.getMonthlyLoanRate()*(this.getCurrentBalance());
	}
	
	private double calculateMonthlyPaymentToBalance(){
		return this.loan.getMonthlyPayment() - this.calculateMonthlyPaymentToInterest();
	}
	
	private double calculateCurrentBalanceAfterPayment(){
		return this.getCurrentBalance() - this.getMonthlyPaymentToBalance();
	}

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
