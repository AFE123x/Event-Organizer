public enum Timeslot {
    MORNING(9, 0),      // 9:00 am
    AFTERNOON(14, 0),   // 2:00 pm
    EVENING(19, 0);     // 7:00 pm

    private final int hour;
    private final int minute;

    Timeslot(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public String toString(){
      return String.format("%02d:%02d",hour,minute);
    }
}
