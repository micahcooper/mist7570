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
	 * not much doing blank constructor
	 */
	public Loan() {
		super();
	}
	
	/**
	 * @param loanAmount the amount of the initial loan
	 * @param loanRate the interest rate of the loan
	 * @param loanTerm the length of the loan in years
	 */
	public Loan(int loanAmount, double loanRate, int loanTerm){
		this.loanAmount = loanAmount;
		this.loanRate = loanRate;
		this.loanTerm = loanTerm;
	}
	
	/**
	 * @return the amount of the montly payment
	 */
	protected double getMonthlyPayment(){
		if(this.getMonthlyLoanRate() == 0){
			return (double)this.getLoanAmount() / (double)this.getLoanTermInMonths();			
		}
		else
			return (this.getLoanAmount() * this.getMonthlyLoanRate() / (1 - (Math.pow( (1 + this.getMonthlyLoanRate()), (-1*this.getLoanTermInMonths())) )));
	}
	
	/**
	 * @return the interest rate by month
	 */
	protected double getMonthlyLoanRate(){
		if(this.loanRate == 0){
			return 0;
		}
		else
			return (this.loanRate/100)/12;
	}

	/**
	 * @return the length of the loan in months
	 */
	public int getLoanTermInMonths(){
		//if no years are given, then I assume repayment in 1 month
		if( this.getLoanTerm() == 0)
			return 1;
		else
			return this.loanTerm*12;
	}
	
	/**
	 * @return the amount of the initial loan
	 */
	public int getLoanAmount() {
		return loanAmount;
	}

	/**
	 * @param loanAmount the amount of the initial loan
	 */
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	/**
	 * @return the annual interest rate
	 */
	public double getLoanRate() {
		return loanRate;
	}

	/**
	 * @param loanRate the annual interest rate
	 */
	public void setLoanRate(double loanRate) {
		this.loanRate = loanRate;
	}

	/**
	 * @return the length of the loan in years
	 */
	public int getLoanTerm() {
		return loanTerm;
	}

	/**
	 * @param loanTerm the length of the loan in years
	 */
	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}
}
