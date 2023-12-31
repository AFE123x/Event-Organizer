/**
 * The Location enum defines constants representing various locations, each with a room, a building, and a campus. 
 * It provides methods to get the building, campus, and room of a location and to compare locations by campus.
 *
 * @author Digvijay Singh, Arun Felix
 */

public enum Location{
    /**
     * Hill Center Room 114
     */
    HLL114("HILL114", "Hill Center", "Busch"),
    /**
     * Allison Road Classrooms room 103
     */
    ARC103("ARC103", "Allison Road Classroom", "Busch"),
    /**
     * Beck Hall - Auditorium
     */
    BE_AUD("BE_AUD", "Beck Hall", "Livingston"),
    /**
     * Tillet Hall room 232
     */
    TIL232("TIL232", "Tillett Hall", "Livingston"),
    /**
     * Academic Building room 2225
     */
    AB2225("AB2225", "Academic Building", "College Avenue"),
    /**
     * Murray Hall room 302.
     */
    MU302("MU302", "Murray Hall", "College Avenue");

    private final String building;
    private final String campus;
    private final String room;

     /**
     * Constructs a Location constant with the given room, building, and campus.
     *
     * @param room     The room of the location.
     * @param building The building of the location.
     * @param campus   The campus of the location.
     */
    Location(String room, String building, String campus) {
        this.building = building;
        this.campus = campus;
        this.room = room;
    }

    /** Returns Location
     *
     * @param arg String containing Location.
     * @return Location object based on arg String.
     */
    public static Location getByTitle(String arg){
        switch(arg.toUpperCase()){
            case "HLL114":
                return Location.HLL114;
            case "ARC103":
                return Location.ARC103;
            case "BE_AUD":
                return Location.BE_AUD;
            case "TIL232":
                return Location.TIL232;
            case "AB2225":
                return Location.AB2225;
            case "MU302":
                return Location.MU302;
            default:
                return null;
        }
    }

    /**
     * A getter method for the building
     * @return building
     */
    public String getBuilding() {
        return this.building;
    }

    /**Getter function for Campus
     *
     * @return campus
     */
    public String getCampus() {
        return this.campus;
    }

    /**Getter method for room.
     *
     * @return room string.
     */
    public String getRoom() {
        return this.room;
    }

     /**
     * Compares the campus of this location with the campus of another location lexicographically.
     * 
     * @param o The location to be compared.
     * @return A negative integer, zero, or a positive integer as this campus is less than, equal to, or greater than the specified campus.
     */
    public int comparebyCampus(Location o){
        return this.campus.compareTo(o.campus);
    }

}
