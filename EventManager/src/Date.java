import java.util.Calendar;
public class Date implements Comparable<Date>{

    // constants
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;
    public static final int JAN = 1;
    public static final int FEB = 2;
    public static final int MAR = 3;
    public static final int APR = 4;
    public static final int MAY = 5;
    public static final int JUN = 6;
    public static final int JUL = 7;
    public static final int AUG = 8;
    public static final int SEP = 9;
    public static final int OCT = 10;
    public static final int NOV = 11;
    public static final int DEC = 12;
    

    private int year;
    private int month;
    private int day;
    Date (int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public static Date makeDate(String input){
      try {
        String [] dateArray = input.split("/");
        int month = Integer.parseInt(dateArray[0]);
        int day = Integer.parseInt(dateArray[1]);
        int year = Integer.parseInt(dateArray[2]);
        return new Date(year,month,day);
      } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
        return null;
      }
    }
    public int getyear(){
        return this.year;
    }
    public int getmonth(){
        return this.month;
    }
    public int getDay(){
        return this.day;
    }

    public Boolean isValid() {
        Calendar currCalendar = Calendar.getInstance();
        Date currDate = new Date(currCalendar.get(Calendar.YEAR), currCalendar.get(Calendar.MONTH) + 1, currCalendar.get(Calendar.DAY_OF_MONTH));
        
        // Checking if month is valid
        if (month < JAN || month > DEC) return false;
        
        // Checking day validity
        if (day < 1) return false;
        if (month == FEB) {
            if (isLeapYear(year)) {
                if (day > 29) return false;
            } else if (day > 28) return false;
        } else if (month == APR || month == JUN || month == SEP || month == NOV) {
            if (day > 30) return false;
        } else if (day > 31) return false; 
        
        // Checking if date is in the future
        if (this.compareTo(currDate) < 0) {
            System.out.println(toString() + ": Event date must be a future date!");
            return false;
        }
        
        // Checking if date is within six months from the current date
        currCalendar.add(Calendar.MONTH, 6);
        Date sixMonthsLater = new Date(currCalendar.get(Calendar.YEAR), currCalendar.get(Calendar.MONTH) + 1, currCalendar.get(Calendar.DAY_OF_MONTH));
        
        if (this.compareTo(sixMonthsLater) > 0) {
            System.out.println(toString() + ": Event date must be within 6 months!");
            return false;
        }
        
        return true;
    }
    
    private boolean isLeapYear(int year) {
        if (year % QUADRENNIAL != 0) {
            return false;
        }
        
        if (year % CENTENNIAL != 0) {
            return true;
        }

        return year % QUATERCENTENNIAL == 0;
    }


    @Override
    public int compareTo(Date o) {
        if(this.year != o.year){
            return this.year - o.year;
        };
        if(this.month != o.month){
            return this.month - o.month;
        }
        else return this.day - o.day;
    }

    @Override
    public String toString(){
        return this.month + "/" + this.day + "/" + this.year;
    }

    public static void main(String[] args) {
        // Test with invalid month
        testDateValidity(2023, 13, 15, false);
    
        // Test with invalid day
        testDateValidity(2023, 11, 31, false);
    
        // Test with a date in the past
        testDateValidity(2023, 9, 24, false);
    
        // Test with a valid date more than 6 months in the future
        testDateValidity(2024, 10, 15, false);
    
        // Test with a valid leap year date
        testDateValidity(2024, 2, 29, true);
    
        // Test with a valid non-leap year date
        testDateValidity(2023, 2, 29, false);
    
        // Test with a valid date within the next 6 months
        testDateValidity(2023, 10, 28, true);
    }
    
    private static void testDateValidity(int year, int month, int day, boolean expected) {
        Date date = new Date(year, month, day);
        boolean isValid = date.isValid();
        String result = isValid == expected ? "PASSED" : "FAILED";
        System.out.printf("Testing Date: %s Expected: %s Actual: %s Result: %s%n", date, expected, isValid, result);
    }
    

}
