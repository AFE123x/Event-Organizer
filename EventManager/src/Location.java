/**
 * The Location enum defines constants representing various locations, each with a room, a building, and a campus. 
 * It provides methods to get the building, campus, and room of a location and to compare locations by campus.
 *
 * @author Digvijay Singh, Arun Felix
 */

public enum Location{
    HLL114("HILL114", "Hill Center", "Busch"),
    ARC103("ARC103", "Allison Road Classroom", "Busch"),
    BE_AUD("BE_AUD", "Beck Hall", "Livingston"),
    TIL232("TIL232", "Tillett Hall", "Livingston"),
    AB2225("AB2225", "Academic Building", "College Avenue"),
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

    //Getters for all instance variables 
    public String getBuilding() {
        return this.building;
    }

    public String getCampus() {
        return this.campus;
    }

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

