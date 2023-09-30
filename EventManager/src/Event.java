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

    // Constructor
    public Event(Date date, Timeslot startTime, Location location, Contact contact, int duration) {
        this.date = date;
        this.startTime = startTime;
        this.location = location;
        this.contact = contact;
        this.duration = duration;
    }
    public Event(String input){

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


    // toString
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

    // equals
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
