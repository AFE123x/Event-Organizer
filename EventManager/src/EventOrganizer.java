import java.util.Scanner;
import java.util.Calendar;
public class EventOrganizer {
    private Scanner scanner;
    private String userinput;
    private Boolean isRunning;
    private EventCalendar eventcalendar;
    Calendar currentDate;

    // private EventCalendar eventcalendar;
    public EventOrganizer() {
        System.out.println("Event Organizer running...");
        this.scanner = new Scanner(System.in);
        this.userinput = "";
        this.isRunning = true;
        this.eventcalendar = new EventCalendar();
    }

    public void run() {
        while (this.isRunning) {
            userinput = scanner.nextLine();
            if (userinput.equals("Q")) {
                this.isRunning = false;

            } else {
                String[] parts = userinput.split("\\s+");
                switch (parts[0]) {
                    case "P":
                        eventcalendar.print();
                        break;
                    case "PE":
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
                        System.out.println(parts[0] + "is an invalid command");
                        break;
                }
            }
        }
    }

    private void addhelper(String[] parts) {
        ////public Event(Date date, Timeslot startTime, Location location, Contact contact, int duration)
        
        Date date = extractDate(parts[1]);
        if(!date.isValid()){
            System.out.println("Invalid date");
        }
        
        
        Timeslot temp = getTimeSlot(parts[2]);
        if (temp == null) {
            System.out.println("Invalid Timeslot");
            return;
        }
        System.out.println(temp.getHour() + "    " + date);

        Location eventLocation = getLocation(parts[3]);
        if(eventLocation == null){
            System.out.println("Invalid Location");
            return;
        }
        Department dept = Department.getByAbbreviation(parts[4]);
            if(dept != null) {
            System.out.println(dept.getFullName());
            } else {
            System.out.println("Invalid Contact Information");
            }
        
        String clientMail = parts[5];
        Contact contact = new Contact(dept, clientMail);
        if(!contact.isValid()){
            System.out.println("Invalid Contact Information");
        return;
        }
        


    }
    private boolean isValidDate(Date date){
         if (date == null) {
            System.out.println("Date format incorrect");
            return false;
        }
        currentDate = Calendar.getInstance();
        currentDate.add(Calendar.MONTH, 6);
        int year = currentDate.get(Calendar.YEAR);
        int month = currentDate.get(Calendar.MONTH) + 1; // Adding 1 to the month since it is 0-based
        int day = currentDate.get(Calendar.DAY_OF_MONTH);
        if (date.getDay() <= day && date.getmonth() <= month && date.getyear() <= year){
            return true;
        }
        else{
            System.out.println(date.getmonth() + "/" + date.getDay() + "/" + date.getyear() + ": " + "Event date must be within 6 months!");
            return false;
        }
    }


     private Location getLocation(String locationString) {
        for (Location location : Location.values()) {
            if (locationString.equalsIgnoreCase(location.getRoom())) {
                return location;
            }
        }
        return null;
    }

    private Timeslot getTimeSlot(String mystring) {
        switch (mystring.toLowerCase()) {
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

    private Date extractDate(String myString) {
        try {
            String[] dateArray = myString.split("/");
            int day = Integer.parseInt(dateArray[0]);
            int month = Integer.parseInt(dateArray[1]);
            int year = Integer.parseInt(dateArray[2]);
            return new Date(year, month, day);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            return null; // Returns null if the date string is invalid.
        }
    }
}
    

