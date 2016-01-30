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
	private double monthlyPaymentToInterest;
	private double monthlyPaymentToBalance;
	private double currentBalanceAfterPayment;

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
		this.currentBalanceAfterPayment=loan.getLoanAmount();
	}
	
	/**
	 * 
	 */
	public String doAmortization(){
		String buildTable;
		int counter=0;
		
		buildTable = "<table><tr><th>Month</th><th>Payment</th><th>Interest Paid</th></tr>";
		while( counter++ < loan.getLoanTermInMonths() ){
			buildTable += "<tr><td>"+counter+"</td>";
			buildTable += "<td>"+this.loan.getMonthlyPayment()+"</td>";
			buildTable += "<td>"+this.calculateMonthlyPaymentToInterest()+"</td>";
			this.setCurrentBalanceAfterPayment(getCurrentBalanceAfterPayment()-this.loan.getMonthlyPayment());
		}
		buildTable += "</table>";
		return buildTable;
	}
	
	private double calculateMonthlyPaymentToInterest(){
		return this.loan.getMonthlyLoanRate()*this.currentBalanceAfterPayment;
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

	public double getCurrentBalanceAfterPayment() {
		return currentBalanceAfterPayment;
	}

	public void setCurrentBalanceAfterPayment(double currentBalanceAfterPayment) {
		this.currentBalanceAfterPayment = currentBalanceAfterPayment;
	}

}
