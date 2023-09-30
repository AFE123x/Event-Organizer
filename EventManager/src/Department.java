public enum Department{
    CS("Computer Science", "CS"),
    EE("Electrical Engineering", "EE"),
    ITI("Information Technology and Informatics", "ITI"),
    MATH("Mathematics", "MATH"),
    BAIT("Business Analytics and Information Technology", "BAIT");

    private final String fullName;
    private final String title;

    Department(String fullName, String title) {
        this.fullName = fullName;
        this.title = title;
    }

    public String getFullName() {
        return fullName;
    }

    public String getTitle() {
        return title;
    }

    public static Department getByTitle(String title) {
        for (Department dept : values()) {
            if (dept.getAbbreviation().equals(title)) {
                return dept;
            }
        }
        return null;
    }
    public int comparebydept(Department o){
        return this.fullName.compareTo(o.fullName) && this.title.compareTo(o.title);
    }

}
