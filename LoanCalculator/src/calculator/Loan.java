	/**
 * TODO
 * nothing
 */
package calculator;

/**
 * @author micah cooper
 *
 */
public class Loan {

	private int loanAmount;
	private double loanRate;
	private int loanTerm;
	
	/**
	 * an empty constructor, initializes all variables to zero
	 */
	public Loan() {
		super();
		this.setLoanAmount(0);
		this.setLoanRate(0);
		this.setLoanTerm(0);
	}
	
	/**
	 * @param loanAmount the amount of the loan
	 * @param loanRate the yearly loan rate
	 * @param loanTerm the lenght of the loan in years
	 */
	public Loan(int loanAmount, double loanRate, int loanTerm){
		this.setLoanAmount(loanAmount);
		this.setLoanRate(loanRate);
		this.setLoanTerm(loanTerm);
	}
	
	/**
	 * @return the monthly payment
	 */
	protected double getMonthlyPayment(){
		return (this.getLoanAmount() * this.getMonthlyLoanRate() / (1 - (Math.pow( (1 + this.getMonthlyLoanRate()), (-1*this.getLoanTermInMonths())) )));
	}
	
	/**
	 * @return the monthly rate of the interest
	 */
	protected double getMonthlyLoanRate(){
		return (this.loanRate/100)/12;
	}

	/**
	 * @return the length of the loan in months
	 */
	public int getLoanTermInMonths(){
		return this.loanTerm*12;
	}
	
	/**
	 * @return the amount of the loan
	 */
	public int getLoanAmount() {
		return loanAmount;
	}

	/**
	 * @param loanAmount set the amount of the loan
	 */
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	/**
	 * @return the yearly interest rate of the loan
	 */
	public double getLoanRate() {
		return loanRate;
	}

	/**
	 * @param loanRate set the yearly rate of the loan
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
	 * @param loanTerm set the length of the loan in years
	 */
	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}
}
