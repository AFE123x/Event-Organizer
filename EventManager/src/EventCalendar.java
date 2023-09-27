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
        NewEvents[numEvents++] = event;
        return true;
    }
    public boolean remove(Event event) {
        for (int i = 0; i < numEvents.length; i++) {
            if (event.equals(numEvents[i])) {
                numEvents[i] = null;
                shiftLeft(i);
                return true;
            }
        }
        return false;
        
    }

    private void shiftLeft(int startIndex) {
        for (int i = startIndex; i < numEvents.length - 1; i++) {
            numEvents[i] = numEvents[i + 1];
        }
        numEvents[numEvents.length - 1] = null;
    }

    public boolean contains(Event event){
        return find(event) != NOT_FOUND;
    }
    public void print(){

    }
    public void printByDate(){

    }
    public void printByCampus(){

    }
    public void printByDepartment(){

    }
private void quicksort(int left, int right,int decision) {
    if (right <= left) {
        return;
    }
    
    // Choose a pivot element
    Event pivot = numEvents[left];
    
    // Initialize pointers
    int i = left + 1;
    int j = right;
    
    while (true) {
        while (i <= j && numEvents[i].compareTo(pivot) <= 0) {
            i++;
        }
        while (j >= i && numEvents[j].compareTo(pivot) >= 0) {
            j--;
        }
        if (i <= j) {
            swap(i, j);
        } else {
            break;
        }
    }
    
    // Swap pivot with the element at index j
    swap(left, j);
    
    // Recursively sort the two partitions
    quicksortDate(left, j - 1);
    quicksortDate(j + 1, right);
}
private void swap(int i, int j) {
    Event temp = numEvents[i];
    numEvents[i] = numEvents[j];
    numEvents[j] = temp;
}
/**
 * public void printByDate() { }
public void printByCampus() { } 
public void printByDepartment(){ } 
 */
private int comparechoice(Event L, Event R,int decision){
switch(decision){
    case 1:
        return L.
}
}

}
