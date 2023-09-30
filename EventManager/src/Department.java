/**
 * The Department enum defines constants representing various departments, each with a full name and a title. It provides a method 
 * to get a department by title.
 *
 * @author Digvijay Singh, Arun Felix
 */

public enum Department{
    CS("Computer Science", "CS"),
    EE("Electrical Engineering", "EE"),
    ITI("Information Technology and Informatics", "ITI"),
    MATH("Mathematics", "MATH"),
    BAIT("Business Analytics and Information Technology", "BAIT");

    private final String fullName;
    private final String title;

   /**
    * Constructs a Department constant with the given full name and abbreviation.
    * 
    * @param fullName The full name of the department.
    * @param title The title of the department.
    */
    Department(String fullName, String title) {
        this.fullName = fullName;
        this.title = title;
    }

    //setters and getters
    public String getFullName() {
        return fullName;
    }

    public String getTitle() {
        return title;
    }

    /* This method returns the Department constant corresponding to the given title.
     * @ params a string to be checked
     * @ return a constant matching the string 
     */
    public static Department getByTitle(String title) {
        for (Department dept : values()) {
            if (dept.getAbbreviation().equals(title)) {
                return dept;
            }
        }
        return null;
    }

    /**
     * Compares the current Department instance with another based on their full names and titles.
     * 
     * @param o The Department instance to compare to.
     * @return An integer representing the comparison result.
     */
    public int compareByDept(Department o) {
        int fullNameComparison = this.fullName.compareTo(o.fullName);
        if (fullNameComparison != 0) return fullNameComparison;
        
        return this.title.compareTo(o.title);
    }

}
