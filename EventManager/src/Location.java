public enum Location{
    // Enum values
    HLL114("Hill Center", "Busch"),
    ARC103("Allison Road Classroom", "Busch"),
    BE_AUD("Beck Hall", "Livingston"),
    TIL232("Tillett Hall", "Livingston"),
    AB2225("Academic Building", "College Avenue"),
    MU302("Murray Hall", "College Avenue");

    // Enum fields
    private final String building;
    private final String Campus;

    Location(String Room, String building, String Campus) {
        this.building = building;
        this.Campus = Campus;
    }
    // Getter methods for fields (if needed)
    public String getBuilding() {
        return this.building;
    }
    public String getCampus() {
        return this.Campus;
    }
}
