public class EventCalendar {
    //constants
    private static final int NOT_FOUND = -1;
    private static final int INITIAL_CAPACITY = 4;
    private static final int CAPACITY_INCRMENT = 4;
    
    private Event[] events;
    private int numEvents;

    private int find(Event event){
    for(int i = 0; i < numEvents;i++){
            if(events[i].equals(event)){
                return i;
            }
        }
        return NOT_FOUND;
    }

    private void grow(){

    }
    public boolean add(Event event){

    }
    public boolean remove(Event event){

    }
    public boolean contains(Event event){

    }
    public void print(){

    }
    public void printByDate(){

    }
    public void printByCampus(){

    }
    public void printByDepartment(){

    }
}
