	/**
 * TODO
 * nothing
 */
package model;

/**
 * @author micah cooper
 *
 */
public class Loan {

	private int loanAmount;
	private double loanRate;
	private int loanTerm;
	
	/**
	 * 
	 */
	public Loan() {
		// TODO Auto-generated constructor stub
	}
	
	public Loan(int loanAmount, double loanRate, int loanTerm){
		this.loanAmount = loanAmount;
		this.loanRate = loanRate;
		this.loanTerm = loanTerm;
	}
	
	protected double getMonthlyPayment(){
		return (this.getLoanAmount() * this.getMonthlyLoanRate() / (1 - (Math.pow( (1 + this.getMonthlyLoanRate()), (-1*this.getLoanTermInMonths())) )));
	}
	
	protected double getMonthlyLoanRate(){
		return (this.loanRate/100)/12;
	}

	public int getLoanTermInMonths(){
		return this.loanTerm*12;
	}
	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getLoanRate() {
		return loanRate;
	}

	public void setLoanRate(double loanRate) {
		this.loanRate = loanRate;
	}

	public int getLoanTerm() {
		return loanTerm;
	}

	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}
}
