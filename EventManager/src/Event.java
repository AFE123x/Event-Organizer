/**
 * The Event class encapsulates the data and behavior for an event, encompassing the date, start time,
 * location, contact, and duration of the event. It provides methods for comparing events and representing
 * the event as a string.
 * @author Digvijay Singh, Arun Felix
 */

public class Event implements Comparable<Event> {
    
    private Date date; // the event date
    private Timeslot startTime; // the starting time
    private Location location;
    private Contact contact; // include the department name and email
    private int duration; // in minutes
    private boolean validobj;

/**
 * Constructs a new Event object with the provided date, start time, location, contact, and duration.
 * 
 * @param date The date of the event.
 * @param startTime The starting time of the event.
 * @param location The location where the event will be held.
 * @param contact The contact details for the event.
 * @param duration The duration of the event in minutes.
 */
    public Event(Date date, Timeslot startTime, Location location, Contact contact, int duration) {
        this.date = date;
        this.startTime = startTime;
        this.location = location;
        this.contact = contact;
        this.duration = duration;
    }
  //  R 2/29/2023 MORNING hll114
  //  A 10/21/2023 afternoon hll114 cs cs@rutgers.edu 60
  public static Event makeevent(String[] input, boolean toadd) {
      try {
          // Attempt to create a Date object from input[1]
          Date date = Date.makeDate(input[1]);
          if (date == null || !date.isValid()) {
              System.out.println(input[1] + ": Invalid calendar date!");
              return null;
          }

          Timeslot startTime;
          switch (input[2].toLowerCase()) {
              case "morning":
                  startTime = Timeslot.MORNING;
                  break;
              case "evening":
                  startTime = Timeslot.EVENING;
                  break;
              case "afternoon":
                  startTime = Timeslot.AFTERNOON;
                  break;
              default:
                  System.out.println("Invalid time slot!");
                  return null;
          }

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
              return new Event(date, startTime, location, contact, duration);
          } else {
              return new Event(date, startTime, location, null, 0);
          }
      } catch (NumberFormatException e) {
          System.out.println("Invalid duration format. Please provide a valid integer.");
          return null;
      } catch (Exception e) {
          System.out.println("An unexpected error occurred: " + e.getMessage());
          return null;
      }
  }


    // Setters and Getters
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
        return date.equals(otherEvent.date)
                && startTime.equals(otherEvent.startTime)
                && location.equals(otherEvent.location);
    }

    /* This method compares the current event object to another event object based on the date and start time.
    */
    @Override
    public int compareTo(Event other) {
        int dateComparison = this.date.compareTo(other.date);

        if (dateComparison != 0) {
            return dateComparison;
        }

        return this.startTime.compareTo(other.startTime);
    }

}
