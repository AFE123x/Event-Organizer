/**
 * The Timeslot enum defines constants representing various timeslots, each with a specified hour and minute.
 * It provides methods to get the hour and the minute of a timeslot and a method to represent the timeslot as a string.
 *
 * @author Digvijay Singh, Arun Felix
 */

public enum Timeslot {
    /**
     * Morning Time: 9:00 am.
     */
    MORNING(9, 0),      // 9:00 am
    /**
     * Afternoon time: 2:00 pm.
     */
    AFTERNOON(14, 0),   // 2:00 pm
    /**
     * Evening time: 7:00 pm.
     */
    EVENING(19, 0);     // 7:00 pm

    //Instance Variables
    private final int hour;
    private final int minute;

     /**
     * Constructs a Timeslot constant with the given hour and minute.
     * 
     * @param hour The hour of the timeslot.
     * @param minute The minute of the timeslot.
     */
    Timeslot(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    /**
     * Returns the hour in TimeSlot.
     * @return Hour as integer.
     */
    public int getHour() {
        return hour;
    }

    /**
     * Returns the minute in TimeSlot.
     * @return minute
     */

    public int getMinute() {
        return minute;
    }
    /**Checks a string entered by the user against the timeslots in the enum class
     *  and returns the appropriate timeslot
     * @param input spring from user.
     * @return An allocated timeslot.
     */
    public static Timeslot getSlot(String input){
        switch (input.toLowerCase()) {
            case "morning":
                return Timeslot.MORNING;
            case "evening":
                return Timeslot.EVENING;
            case "afternoon":
                return Timeslot.AFTERNOON;
            default:
                System.out.println("Invalid time slot!");
                return null;
        }
    }
    /**
     * Returns a string representation of this timeslot. The string consists of 
     * two characters representing the hour of the day and two characters representing 
     * the minute within the hour.
     *
     * @return A string representation of this timeslot.
     */
    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }


}
