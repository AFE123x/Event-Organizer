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
            if(events[i] != null && events[i].equals(event)){
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
        if(event == null) {
            return false;
        }
        if(exists(event)){
            System.out.println("The event is already on the calendar.");
            return false;
        }
        ensureCapacity();
        events[numEvents++] = event;
        System.out.println("Event added to the calendar.");
        return true;
    }

    
    /**
     * Ensures there is sufficient capacity in the events array, growing it if necessary.
     */
    private void ensureCapacity() {
        if(numEvents >= events.length){
            grow();
        }
    }

     /**
     * Removes the specified event from the events array. 
     * If the event is found and successfully removed, all the subsequent events are shifted to the left.
     * Prints an appropriate message to the console indicating whether or not the removal was successful.
     *
     * @param event the event to be removed from the events array.
     * @return true if the event was found and successfully removed, false otherwise.
     * If the event is null, or if it is not found in the array, the method returns false.
     */
    public boolean remove(Event event) {
         if(event == null){
          return false;
        }

        int index = find(event);
        if(index == NOT_FOUND){
            System.out.println("Cannot Remove! Event is not in calendar");
            return false;
        }
        events[index] = null;
        shiftLeft(index);
        System.out.println("Event Removed from the calendar");
        return true;
        
    }

    /**
     * Checks if an event already exists in the events array.
     *
     * @param x the event to check for existence.
     * @return true if the event exists in the array, false otherwise.
     */
    private boolean exists(Event x) {
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
        if(startIndex < 0 || startIndex >= numEvents){
            return;
        }
        for (int i = startIndex; i < events.length - 1; i++) {
            events[i] = events[i + 1];
        }
        events[events.length - 1] = null;
        numEvents--;
    }

    /** Checks if an Event exists in the Event Calendar or not 
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
        System.out.println("*Event Calender*");
        if(numEvents == 0){
            System.out.println("Event calendar is empty!");
            return;
        }
        for(int i = 0; i < numEvents; i++){
             System.out.println(events[i]);
        }
        System.out.println("*Event Calendar Ends*");
        
    }

    /**
     * Sorts and prints the list of events by date.
     */
    public void printByDate(){
        System.out.println("Sorting by Date: ");
        quicksort(0, numEvents-1, 1);
        print();
    }

      /**
     * Sorts and prints the list of events by campus.
     */
    public void printByCampus(){
        System.out.println("Sorting by Campus: ");
        quicksort(0, numEvents-1, 2);
        print();
    }


    /**
     * Sorts and prints the list of events by department.
     */
    public void printByDepartment(){
        System.out.println("Sorting by Department: ");
        quicksort(0, numEvents-1, 3);
        print();
    }


    /**
     * Sorts the 'events' array in place between the provided 'left' and 'right' indices using QuickSort algorithm, 
     * based on the given 'decision' criterion.
     * The method recursively calls itself to sort the subarrays on each side of the pivot element.
     *
     * @param left The left boundary of the array or subarray to be sorted.
     * @param right The right boundary of the array or subarray to be sorted.
     * @param decision Integer indicating the criterion to be used for sorting.
     *                 1: Sort by Date,
     *                 2: Sort by Campus,
     *                 3: Sort by Department.
     */
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

     /**
     * Swaps the elements at the specified positions in the 'events' array.
     *
     * @param events The array containing the elements to be swapped.
     * @param i The index of one element to be swapped.
     * @param j The index of the other element to be swapped.
     */
    private void swap(Event [] events, int i, int j) {
        Event temp = events[i];
        events[i] = events[j];
        events[j] = temp;
    }

      /**
     * Compares two 'Event' objects based on the specified 'decision' criterion.
     *
     * @param L The first 'Event' object to be compared.
     * @param R The second 'Event' object to be compared.
     * @param decision Integer indicating the criterion to be used for comparison.
     *                 1: Compare by Date,
     *                 2: Compare by Campus,
     *                 3: Compare by Department.
     * @return A negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     */
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
