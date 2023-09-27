public enum Department {
    CS("Computer Science", "CS"),
    EE("Electrical Engineering", "EE"),
    ITI("Information Technology and Informatics", "ITI"),
    MATH("Mathematics", "MATH"),
    BAIT("Business Analytics and Information Technology", "BAIT");

    private final String fullName;
    private final String abbreviation;

    Department(String fullName, String abbreviation) {
        this.fullName = fullName;
        this.abbreviation = abbreviation;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public static Department getByAbbreviation(String abbreviation) {
        for (Department dept : values()) {
            if (dept.getAbbreviation().equals(abbreviation)) {
                return dept;
            }
        }
        return null;
    }
}

