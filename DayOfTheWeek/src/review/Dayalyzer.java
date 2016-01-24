/**
 * 
 */
package review;

/**
 * @author micah cooper
 *
 */
public class Dayalyzer {
	private int day,month,year;

	/**
	 * basic constructor
	 */
	public Dayalyzer() {
		super();
		System.out.println("dayalyzer");
	}
	
	public Dayalyzer(int day, int month, int year){
		this.day=day;
		this.month=month;
		this.year=year;
	}

	public String analyze(){
		int days, monthCounter = 1;
		days = ((this.year-1900)*365)+((this.year-1900)/4)+this.day;
		System.out.println("Days "+days);
		
		if(year%4==0)
			if(this.month==1 || this.month==2)
				days--;
		
		while(monthCounter != this.month ){
			System.out.println(monthCounter);
			switch (monthCounter++){
				case 1: days += 31;break;
				case 2: days += 28;break;
				case 3: days += 31;break;
				case 4: days += 30;break;
				case 5: days += 31;break;
				case 6: days += 30;break;
				case 7: days += 31;break;
				case 8: days += 31;break;
				case 9: days += 30;break;
				case 10: days += 31;break;
				case 11: days += 30;break;
				case 12: days += 0;break;
			}
		}
		
		switch (days%7){
			case 0: return "Sunday";
			case 1: return "Monday";
			case 2: return "Tuesday";
			case 3: return "Wednesday";
			case 4: return "Thursday";
			case 5: return "Friday";
			case 6: return "Saturday";
		}
		
		return "hi";
	}
}
