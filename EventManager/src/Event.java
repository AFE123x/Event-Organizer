/**
 * The Event class encapsulates the data and behavior for an event, encompassing the date, start time,
 * location, contact, and duration of the event. It provides methods for comparing events and representing
 * the event as a string.
 * @author Digvijay Singh, Arun Felix
 */

public class Event implements Comparable<Event> {
    
    private Date date; // the event date
    private Timeslot startTime; //s the starting time
    private Location location;
    private Contact contact; // include the department name and email
    private int duration; // in minutes

/**
 * Constructs a new Event object with the provided date, start time, location, contact, and duration.
 * 
 * @param date The date of the event.
 * @param startTime The starting time of the event.
 * @param location The location where the event will be held.
 * @param contact The contact details for the event.
 * @param duration The duration of the event in minutes.
 */
   public Event(Date date, Timeslot startTime, Location location, Contact contact, int duration){
    this.date = date;
    this.startTime = startTime;
    this.location = location;
    this.contact = contact;
    this.duration = duration;
   }
   /**
 * Creates and returns an Event object based on the provided input data.    
 *
 * @param input   An array of strings containing event information.
 *    The array should have the following elements in order:
 *  [1] - A valid calendar date (e.g., "MM/DD/YYYY").
 *  [2] - A valid timeslot (e.g., "afternoon,evening,morning").
 *  [3] - A valid location
 *  [4] - A valid department title (only if client is adding).
 *  [5] - A valid contact name (only if 'toadd' (only if client is adding).
 *  [6] - An integer representing the event's duration in minutes (only if client is adding).
 * 
 * @param toadd   A boolean flag indicating whether to add a department and contact to the event.
 * @return An Event object representing the event created from the input data, or null if the input is invalid.
 * @throws NumberFormatException If the duration input is not a valid integer.
 */
  public static Event makeevent(String[] input, boolean toadd) {
      try {
          Date date = Date.makeDate(input[1]);
          if (date == null || !date.isValid()) {
              return null;
          }
          Timeslot startTime = Timeslot.getSlot(input[2]);
          if(startTime == null) return null;
          Location location = Location.getByTitle(input[3]);
          if (location == null) {
              System.out.println(input[3] + ": Invalid Location");
              return null;
          }
          if (toadd == true) {
              Department department = Department.getByTitle(input[4]);
              if (department == null) {
      System.out.println(input[4] + ": Invalid Department");
      return null;
              }
              Contact contact = new Contact(department, input[5]);
              if (!contact.isValid()) {
      System.out.println(input[5] + ": Invalid Contact");
      return null;
              }
              int duration = Integer.parseInt(input[6]);
              if(duration < 30 || duration > 120){
                System.out.println("Event duration must be at least 30 minutes and at most 120 minutes");
                return null;
              }
              return new Event(date, startTime, location, contact, duration);
          } else {
              return new Event(date, startTime, location, null, 0);
          }
      } catch (NumberFormatException e) {
          System.out.println("Invalid duration format. Please provide a valid integer.");
          return null;
      }
  }


    /** Setters and Getters
      * @param date, location, and contact object and also duration int
      * @return date, location, contact objects are returned as well as start time and duration
      */
    public void setDate(Date date){
        this.date = date;
    }
    public Date getDate() {
        return date;
    }
    public void setlocation(Location location){
        this.location = location;
    }
    public Location getLocation() {
        return location;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
    public Contact getContact() {
        return contact;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setStartTime(Timeslot startTime) {
        this.startTime = startTime;
    }

    public Timeslot getStartTime() {
        return startTime;
    }


    /* Here, we return a string representation of the event object containing all relevant details
     * @returns a string representation of the Event object
     */
    @Override
    public String toString() {
        int end = (startTime.getHour() * 60) + (startTime.getMinute() + this.duration);
        int hour = end / 60;
        int minute = end % 60;
        //String endTime = hour + ":" + minute;
        String endTime = hour + ":" + (minute < 10 ? "0" : "") + minute;

        return String.format(
    "[Event Date: %s] [Start: %s] [End: %s] @%s (%s, %s) [Contact: %s, %s]",
    date,
    startTime,
    endTime,
    location.getRoom(),
    location.getBuilding(),
    location.getCampus(),
    contact.getDepartment(),
    contact.getEmail()
        );
    }

    /*Checks the equality of the current event object with another object.
     * @param an object to be compared to the event object
     * @return a boolean true or false 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Event otherEvent = (Event) obj;
        
        // Check for null references before comparing
        if (date == null || startTime == null || location == null) {
            return false;
        }

        return date.equals(otherEvent.date)
            && startTime.equals(otherEvent.startTime)
            && location.equals(otherEvent.location);
    }


    /* This method compares the current event object to another event object based on the date and start time.
     * @param An event object to be compared 
     * @return An int which is the result of the comparison 
     */
    @Override
    public int compareTo(Event other) {
        int dateComparison = this.date.compareTo(other.date);

        if (dateComparison != 0) {
            return dateComparison;
        }

        return this.startTime.compareTo(other.startTime);
    }

    public static void main(String[] args) {
        
    }
}
