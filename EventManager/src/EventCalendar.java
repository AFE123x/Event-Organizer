public class EventCalendar {
    //constants
    private static final int NOT_FOUND = -1;
    private static final int INITIAL_CAPACITY = 4;
    private static final int CAPACITY_INCREMENT = 4;
    
    private Event[] events;
    private int numEvents;
    public EventCalendar(){
        this.numEvents = 0;
        this.events = new Event[INITIAL_CAPACITY];
    }
    private int find(Event event){
    for(int i = 0; i < numEvents;i++){
            if(events[i].equals(event)){
                return i;
            }
        }
        return NOT_FOUND;
    }

    private void grow(){
    Event NewEvents[] = new Event[events.length + CAPACITY_INCREMENT];
        for(int i = 0 ; i < events.length;i++){
            NewEvents[i] = events[i];
        }
        events = NewEvents;
    }
    public boolean add(Event event){

        if(numEvents >= events.length){
            grow();
        }
        events[numEvents++] = event;
        return true;
    }
    public boolean remove(Event event) {
        for (int i = 0; i < events.length; i++) {
            if (event.equals(events[i])) {
                events[i] = null;
                shiftLeft(i);
                return true;
            }
        }
        return false;
        
    }

    private void shiftLeft(int startIndex) {
        for (int i = startIndex; i < events.length - 1; i++) {
            events[i] = events[i + 1];
        }
        events[events.length - 1] = null;
    }

    public boolean contains(Event event){
        return find(event) != NOT_FOUND;
    }
    public void print(){

    }
    public void printByDate(){
        quicksort(0, this.events.length, 1);
    }
    public void printByCampus(){
        quicksort(0, this.events.length, 2);
    }
    public void printByDepartment(){
        quicksort(0, this.events.length, 3);
    }
private void quicksort(int left, int right,int decision) {
    if (right <= left) {
        return;
    }
    
    // Choose a pivot element
    Event pivot = events[left];
    
    // Initialize pointers
    int i = left + 1;
    int j = right;
    
    while (true) {
        while (i <= j && comparechoice(events[i], pivot, decision) < 0) {
            i++;
        }
        while (j >= i && comparechoice(events[i], pivot, decision) >= 0) {
            j--;
        }
        if (i <= j) {
            swap(events,i, j);
        } else {
            break;
        }
    }
    
    swap(events,left, j);
    
    quicksort(left, j - 1,decision);
    quicksort(j + 1, right,decision);
}
private void swap(Event [] events, int i, int j) {
    Event temp = events[i];
    events[i] = events[j];
    events[j] = temp;
}
/**
 * public void printByDate() { }
public void printByCampus() { } 
public void printByDepartment(){ } 
 */
private int comparechoice(Event L, Event R,int decision){
switch(decision){
    case 1:
        return L.getDate().compareTo(R.getDate());
    case 2:
        return L.getLocation().comparebyCampus(R.getLocation());
    default:
        return L.getContact().getDepartment().comparebydept(R.getContact().getDepartment());
}
}

}
