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

    //Returns the Department constant corresponding to the given title.
    public static Department getByTitle(String title) {
        for (Department dept : values()) {
            if (dept.getAbbreviation().equals(title)) {
                return dept;
            }
        }
        return null;
    }

    /* Compares an instance of this department with another department
     * based on full name and title of the department
     */
    public int comparebydept(Department o){
        return this.fullName.compareTo(o.fullName) && this.title.compareTo(o.title);
    }

}
