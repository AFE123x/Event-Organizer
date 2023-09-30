/**
 * The EventCalendar class represents a calendar that holds a list of events. It provides methods 
 * for adding, removing, and printing events, and also offers the ability to print events based 
 * on specific criteria such as Date, Campus, and Department.
 *
 * @author Digvijay Singh, Arun Felix
 */

public class EventCalendar {
    //constants
    private static final int NOT_FOUND = -1;
    private static final int INITIAL_CAPACITY = 4;
    private static final int CAPACITY_INCREMENT = 4;
    
    private Event[] events;
    private int numEvents;

    // Class Constructor
    /**
     * Initializes a new EventCalendar object with no events and an initial array capacity 
     * for holding Event objects.
     */
    public EventCalendar(){
        this.numEvents = 0;
        this.events = new Event[INITIAL_CAPACITY];
    }

    // Helper Methods
    /**
     * Searches for the provided event in the list of events and returns its index if found, 
     * or NOT_FOUND if the event is not in the list.
     *
     * @param event The event to search for.
     * @return The index of the event in the list, or NOT_FOUND if not found.
     */
    private int find(Event event){
    for(int i = 0; i < numEvents;i++){
            if(events[i].equals(event)){
                return i;
            }
        }
        return NOT_FOUND;
    }

     /**
     * Increases the capacity of the internal array holding events by CAPACITY_INCREMENT 
     * when the current array is full.
     */
    private void grow(){
    Event NewEvents[] = new Event[events.length + CAPACITY_INCREMENT];
        for(int i = 0 ; i < events.length;i++){
            NewEvents[i] = events[i];
        }
        events = NewEvents;
    }

    /**
     * Adds a new event to the list of events. If the current array is full, 
     * it increases the array’s capacity before adding the new event.
     *
     * @param event The event to add.
     * @return true if the event is successfully added.
     */
    public boolean add(Event event){

        if(numEvents >= events.length){
            grow();
        }
        events[numEvents++] = event;
        return true;
    }

     /**
     * Removes the specified event from the list if it exists.
     *
     * @param event The event to remove.
     * @return true if the event was found and removed; false otherwise.
     */
    public boolean remove(Event event) {
        if(event == null){
          return false;
        }
        for (int i = 0; i < events.length; i++) {
            if (event.equals(events[i])) {
                events[i] = null;
                shiftLeft(i);
                return true;
            }
        }
        return false;
        
    }

    /**
     * Shifts all events to the left in the list, starting from the specified index.
     *
     * @param startIndex The index from where the shift operation should begin.
     */
    private void shiftLeft(int startIndex) {
        for (int i = startIndex; i < events.length - 1; i++) {
            events[i] = events[i + 1];
        }
        events[events.length - 1] = null;
    }

    public boolean contains(Event event){
        return find(event) != NOT_FOUND;
    }

    /**
     * Prints all events in the current list to the console.
     */
    public void print(){
        for(Event a : events){
            System.out.println(a);
        }
    }

    /**
     * Sorts and prints the list of events by date.
     */
    public void printByDate(){
        quicksort(0, this.events.length, 1);
    }

      /**
     * Sorts and prints the list of events by campus.
     */
    public void printByCampus(){
        quicksort(0, this.events.length, 2);
    }


    /**
     * Sorts and prints the list of events by department.
     */
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
