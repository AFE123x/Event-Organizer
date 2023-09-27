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

    Location(String room, String building, String campus) {
        this.building = building;
        this.campus = campus;
        this.room = room;
    }

    public String getBuilding() {
        return this.building;
    }

    public String getCampus() {
        return this.campus;
    }

    public String getRoom() {
        return this.room;
    }
    public int comparebyCampus(Location o){
        return this.campus.compareTo(o.campus);
    }

}

