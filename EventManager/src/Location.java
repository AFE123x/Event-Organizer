public class Location implements Comparable<Location>{
    //Variables
    private String Room;
    private String building;
    private String Campus;
    //Locations
    public static final Location HLL114 = new Location("HLL114", "Hill Center", "Busch");
    public static final Location ARC103 = new Location("ARC103", "Allison Road Classroom", "Busch");
    public static final Location BE_AUD = new Location("BE_AUD", "Beck Hall", "Livingston");
    public static final Location TIL232 = new Location("TIL232", "Tillett Hall", "Livingston");
    public static final Location AB2225 = new Location("AB2225", "Academic Building", "College Avenue");
    public static final Location MU302 = new Location("MU302", "Murray Hall", "College Avenue");
    
    private Location(String Room, String building, String Campus){
        this.Room = Room;
        this.building = building;
        this.Campus = Campus;
    }

    @Override
    public int compareTo(Location o) {
        return 0;
    }
}
