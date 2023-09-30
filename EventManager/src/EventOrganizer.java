import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The EventOrganizer class is responsible for managing user interactions and organizing events.
 * It reads user input and performs the corresponding actions.
 * 
 * @author Digvijay Singh, Arun Felix
 */
public class EventOrganizer {
    private static final boolean ADD = true;
    private static final boolean REMOVE = false;
    private Scanner scanner;
    private String userinput;
    private Boolean isRunning;
    private EventCalendar eventcalendar;
    EventCalendar currentDate;

    // private EventCalendar eventcalendar;

     /**
     * Initializes a new instance of the EventOrganizer class.
     * Sets up the necessary state for the class to function properly.
     * @throws FileNotFoundException
     */
    public EventOrganizer() throws FileNotFoundException {
        System.out.println("Event Organizer running...");
        this.scanner = new Scanner(new File("EventManager\\testcases\\input.txt"));
        this.userinput = "";
        this.isRunning = true;
        this.eventcalendar = new EventCalendar();
    }

    /**
     * Starts the event organizer. Reads user input continuously and performs the corresponding actions until the user exits.
     */
    public void run() {
        while (this.isRunning) {
            userinput = scanner.nextLine();
            System.out.println(userinput);
            if (userinput.equals("Q")) {
                this.isRunning = false;

            } else {
                
                String[] parts = userinput.split("\\s+");
                switch (parts[0]) {
                   
                    case "P":
                        eventcalendar.print();
                        break;
                    case "PE":
                        eventcalendar.printByDate();
                        break;
                    case "PC":
                        eventcalendar.printByCampus();
                        break;
                    case "PD":
                        eventcalendar.printByDepartment();
                        break;
                    case "A":
                        eventcalendar.add(Event.makeevent(parts, ADD));
                        break;
                    case "R":
                        eventcalendar.remove(Event.makeevent(parts, REMOVE));
                    default:
                        System.out.println(parts[0] + " is an invalid command");
                        break;
                }
            }
        }
    }
}
