public enum Department{

    CS("Computer Science"),
    EE("Electrical Engineering"),
    ITI("Informaion Technology and Informatics"),
    MATH("Mathematics"),
    BAIT("Business Analyics and Information Technology");
    

    private final String fullName;

    Department(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return fullName;
    }
}
