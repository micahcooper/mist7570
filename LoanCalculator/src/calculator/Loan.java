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
	
	public double getMonthlyPayment(){
		return (loanAmount * loanRate / (1 - (Math.pow( (1 + loanRate), (-1*getLoanTermInMonths())) )));
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
