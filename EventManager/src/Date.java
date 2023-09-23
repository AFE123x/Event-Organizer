public class Date implements Comparable<Date>{

    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;

    private int year;
    private int month;
    private int day;
    Date (int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public Boolean isValid(){
        if(month < 1 )
        return null;
    }


    @Override
    public int compareTo(Date o) {
        return 0;
    }
    public String toString(){
        return this.month + "/" + this.day + "/" + this.year;
    }
}
