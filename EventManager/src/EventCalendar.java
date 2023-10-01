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
    
    //Instance Variables
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
        for(int i = 0; i < INITIAL_CAPACITY; i++){
            events[i] = new Event(null,null,null,null,0);
        }
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
     * Adds a new event to the list of events. If the current array is full, it increases the array’s capacity before adding the new event.
     * Event will not be added if it conflicts with another event.
     * @param event The event to add.
     * @return true if the event is successfully added.
     */
    public boolean add(Event event){
        if(event != null && (numEvents == 0 || !exists(event)) ){
            
            if(numEvents >= events.length){
                grow();
            }
            events[numEvents++] = event;
            System.out.println("Event added to the calendar.");
            return true;
        }
        else if(event != null){
            System.out.println("The event is already on the calendar.");
        }
        return false;
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
    private boolean exists(Event x) {
        if (events == null) {
            return false;
        }
        
        for (int i = 0; i < numEvents; i++) {
            if (events[i] != null && events[i] .equals(x)) {
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

    /** Checks if an Event exists in the Event Calender or not 
     * @param An event object to be checked
     * @return true if the event exists else false
     */
    public boolean contains(Event event){
        return find(event) != NOT_FOUND;
    }

    /**
     * Prints all events in the current list to the console.
     */
    public void print(){
        if(numEvents == 0){
            System.out.println("Event calendar is empty!");
            return;
        }
        for(int i = 0; i < numEvents; i++){
             System.out.println(events[i]);
           
        }
    }

    /**
     * Sorts and prints the list of events by date.
     */
    public void printByDate(){
        quicksort(0, numEvents-1, 1);
        print();
    }

      /**
     * Sorts and prints the list of events by campus.
     */
    public void printByCampus(){
        quicksort(0, numEvents-1, 2);
        print();
    }


    /**
     * Sorts and prints the list of events by department.
     */
    public void printByDepartment(){
        quicksort(0, numEvents-1, 3);
        print();
    }

    
    private void quicksort(int left, int right, int decision) {
        if (right <= left) {
            return;
        }
    
        // Choose a pivot element
        Event pivot = events[left];
    
        // Initialize pointers
        int i = left + 1;
        int j = right;
    
        while (i <= j) {
            while (i <= j && comparechoice(events[i], pivot, decision) < 0) {
                i++;
            }
            while (i <= j && comparechoice(events[j], pivot, decision) >= 0) {
                j--;
            }
            if (i <= j) {
                swap(events, i, j);
            } else {
                break; // Exit the loop when i > j
            }
        }
    
        swap(events, left, j);
    
        quicksort(left, j - 1, decision);
        quicksort(j + 1, right, decision);
    }
    
    private void swap(Event [] events, int i, int j) {
        Event temp = events[i];
        events[i] = events[j];
        events[j] = temp;
    }

private int comparechoice(Event L, Event R,int decision){
switch(decision){
    case 1:
        return L.getDate().compareTo(R.getDate());
    case 2:
        return L.getLocation().comparebyCampus(R.getLocation());
    default:
        return L.getContact().getDepartment().CompareByDept(R.getContact().getDepartment());
}
}

}
