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

