

/**
 * This class stores the dates from the input in Lab3.java 
 * into a Date object. 
 * @author Amy Wong (xoo873)
 *
 */
public class Date implements Comparable<Date>{
	String month;
	int iDay;
	int iYear;
	int iMonth;

	
	private String[] monthName  = {"", "January", "February", "March", "April",
			"May", "June", "July", "August", "September", "October", 
			"November", "December"};
	
	public Date(String month, int iDay, int iYear){
		this.month = month;
		this.iDay = iDay;
		this.iYear = iYear;	
		//Change the names of the months to the full name
		int i = 0;
		while (i++ < monthName.length -1){
			if(monthName[i].contains(this.month)){
				this.month = monthName[i];
				iMonth = i;
			}
		}
	}
	
	public String toString(){
		return String.format("Date: %s %d, %d", this.month, this.iDay, this.iYear);
	}

	@Override
	public int compareTo(Date nextDate) {
		return 0;
	}

} // end class 
