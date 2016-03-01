import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * This class contains the main method and a dateValid method.
 * This program will read in input file that contains dates and print them out.
 * If the next date is later than the previous date, a date range will 
 * be printed out.
 * @author Amy Wong (xoo873)
 *
 */

public class Lab3 {
	/**
	 * This is the main method. This method reads the input file 
	 * and uses Date class and DateRange class to produce the output.
	 * @param args command line argument
	 */
	public static void main(String[] args) {
		Date date1 = null;
		Date date2 = null;
		
		Scanner in = null;
		try {
		    in = new Scanner(new File("dates.txt"));
		} catch (FileNotFoundException exception) {
		    System.err.println("failed to open dates.txt");
		    System.exit(1);
		}
		while (in.hasNext()) {
			String month = in.next();
			// Remove "." from input
			month = month.replace(".", "");
			String day = in.next();
			//Remove "," from input
			day = day.replaceAll(",", "");
			String year = in.next();
			// Change strings day and year to ints
			int iDay = Integer.parseInt(day);
			int iYear = Integer.parseInt(year);

			// if the date is invalid, print out error 
			if(dateValid(month, iDay, iYear) == false){
				System.out.println("Invalid Date");
				if(date2 !=null){
					date1 = date2;
					date2 = null;
				}
			}
			else{
				if(date1 == null){
					date1 = new Date(month, iDay, iYear);
					System.out.println(date1);
				}
				else if (date1 != null && date2 == null){
					date2 = new Date(month, iDay, iYear);
					System.out.println(date2);
				}
				// if input has been at least 2 dates, look to print out range
				else if(date1 != null && date2 != null){
					DateRange range = new DateRange(date1, date2);
					if(range.range == true){
					System.out.println(range);
					date1 = date2;
					date2 = new Date(month, iDay, iYear);
					System.out.println(date2);
					}
					else if(range.range == false){
						date1 = date2;
						date2 = new Date(month, iDay, iYear);
						System.out.println(date2);
					}
				}
			}	
		} 
	} // end main
	

	/**
	 * This method checks if the dates are valid
	 * @param month
	 * @param iDay
	 * @param iYear
	 * @return false if the date is invalid and true if valid.
	 */
	public static boolean dateValid(String month, int iDay, int iYear){
		if(month.contains("Apr")||month.contains("Jun")|| 
				month.contains("Sept")||month.contains("Nov")){
			if(iDay > 30)
				return false;
		}
		else if(month.contains("Jan")||month.contains("Mar")||month.contains("May")||
				month.contains("Jul")||month.contains("Aug")||month.contains("Oct")||
				month.contains("Dec")){
			if(iDay > 31)
				return false;
		}
		else if(month.contains("Feb")){
			// Check for leap year
			if(iYear % 400 == 0 || (iYear % 4 == 0 && iYear % 100 != 0)){
				if (iDay > 29)
					return false;
			}
			else if(iDay > 28)
				return false;
		}
		return true;
	}

} // end class
