import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EventOrganizer {
        private Scanner scanner;
        private String userinput;
        private Boolean isRunning;
        // private EventCalendar eventcalendar;
        public EventOrganizer(){
            this.scanner = new Scanner(System.in);
            this.userinput = "";
            this.isRunning = true;
            // this.eventcalendar = new EventCalendar();
        }
        
        public void run(){
            while(this.isRunning){
                userinput = scanner.nextLine();
                if(userinput.equals("Q")){
                    this.isRunning = false;

                }
                else{
                    String[] parts = userinput.split("\\s+");
                    switch(parts[0]){
                        case "P":
                            //function()
                            break;
                        case "OE":
                            //function()
                            break;
                        case "PC":
                            //function()
                            break;
                        case "PD":
                            //function()
                            break;
                        case "A":
                            addhelper(parts);
                            break;
                        default:
                            System.out.println("Invalid option");
                            break;
                    }
            } 
        } 
    } 
    private void addhelper(String [] parts){
        ////public Event(Date date, Timeslot startTime, Location location, Contact contact, int duration)
        Date date = extractDate(parts[1]);
        if(date == null){
            System.out.println("Date format incorrect");
            return;
        }
        Timeslot temp = getTimeSlot(parts[2]);
        if(temp == null){
            System.out.println("Invalid Timeslot");
            return;
        }
        System.out.println(temp.getHour() + "    " + date);
        
    }
    private Timeslot getTimeSlot(String mystring){
        switch(mystring.toLowerCase()){
            case "morning":
                return Timeslot.MORNING;
            case "evening":
                return Timeslot.EVENING;
            case "afternoon":
                return Timeslot.AFTERNOON;
            default:
                return null;

        }
    }
    private Date extractDate(String myString){
        if(!isValidDateFormat(myString)){
            return null;
        }
        String [] dateArray = myString.split("/");
        //(int year, int month, int day){
        return new Date(Integer.parseInt(dateArray[2]),Integer.parseInt(dateArray[1]),Integer.parseInt(dateArray[0]));
    }
    
    private static boolean isValidDateFormat(String input) {
        // Define a regular expression pattern for the desired date format
        String pattern = "^(0?[1-9]|1[0-2])/(0?[1-9]|[12][0-9]|3[01])/(\\d{4})$";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Create a Matcher object
        Matcher m = r.matcher(input);

        // Check if the input string matches the pattern
        return m.matches();
    }
}
