public enum Location{
    // Enum values
    HLL114("HILL114","Hill Center", "Busch"),
    ARC103("ARC103","Allison Road Classroom", "Busch"),
    BE_AUD("BE_AUD","Beck Hall", "Livingston"),
    TIL232("TIL232","Tillett Hall", "Livingston"),
    AB2225("AB2225","Academic Building", "College Avenue"),
    MU302("MU302","Murray Hall", "College Avenue");

    // Enum fields
    private final String building;
    private final String Campus;
    private final String Room;

    Location(String Room, String building, String Campus) {
        this.building = building;
        this.Campus = Campus;
        this.Room = Room;
    }
    // Getter methods for fields (if needed)
    public String getBuilding() {
        return this.building;
    }
    public String getCampus() {
        return this.Campus;
    }
    public String getRoom(){
        return this.Room;
    }

}
