/**
 * This class compares two dates and prints out the range
 * @author Amy Wong (xoo873)
 *
 */
public class DateRange {
	private String month1, month2;
	private int day1, day2, year1, year2;
	public boolean range;
	
	public DateRange(Date date1, Date date2){
		// if the next date is later than the previous date, set the range
		if(date1.iYear < date2.iYear){
			month1 = date1.month;
			month2 = date2.month;
			day1 = date1.iDay;
			day2 = date2.iDay;
			year1 = date1.iYear;
			year2 = date2.iYear;
			range = true;
		}
		else if(date1.iYear == date2.iYear){
			if((date1.iMonth < date2.iMonth)){ 
				month1 = date1.month;
				month2 = date2.month;
				day1 = date1.iDay;
				day2 = date2.iDay;
				year1 = date1.iYear;
				year2 = date2.iYear;
				range = true;
			}
			else if(date1.iMonth == date2.iMonth){
				if(date1.iDay < date2.iDay){
					month1 = date1.month;
					month2 = date2.month;
					day1 = date1.iDay;
					day2 = date2.iDay;
					year1 = date1.iYear;
					year2 = date2.iYear;
					range = true;
				}
			}
		}
		else
			range = false;
	}
	
	public String toString(){
		return String.format("DateRange: Date: %s %d, %d - %s %d, %d", 
							month1, day1, year1, month2, day2, year2);
	}

}// end class
