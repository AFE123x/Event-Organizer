/**
* The contact class that defines the contact object, contains three methods: isValid to confirm validity, equals to check equality, and 
* toString to print out the contact object.

* @author Digvijay Singh, Arun Felix
*/

public class Contact {
    /**
     * Department object inside Contact class.
     */
    private Department department;
    /**
     * Email String containing Contact's email.
     */
    private String email;


    /**
     * Constructs a Contact object with the specified department and email.
     * 
     * @param department The department associated with the contact.
     * @param email The email of the contact.
     */
    public Contact(Department department, String email){
        this.department = department;
        this.email = email;
    }

    /**
     * Sets the Department object
     * @param department
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /** Returns the Department associated with contact.
     *
     * @returns Department associated with contact.
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Sets email in the Contact object.
     * @param email
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**This method returns the email associated with contact.
     *
     * @return email address
     */
    public String getEmail() {
        return email;
    }

    /* This method validates the contact object, checking if the email and department 
     * are correct.
     * @return true if the contact is valid.
     */
    public boolean isValid(){
        if(this.email == null || this.department == null){
           return false;
        }
        String [] emailarr = this.email.split("@");
        if(emailarr.length != 2){
            return false;
        }
        if(!emailarr[1].toLowerCase().equals("rutgers.edu")){
            return false;
        }
        String icon = emailarr[0].toLowerCase();
        return icon.equals("cs") || icon.equals("ee") || icon.equals("iti") || icon.equals("math") || icon.equals("bait");
    }

    /* This method returns a string representation of the contact object containing the department 
     * and the email.
     * @return a string representation of the contents of a contact object
     */
    @Override
    public String toString() {
        return "Contact{ department=" + department + ", email='" + email + "' }";
    }
    
    /* This method checks if the current contact object is equal to another object.
     * @return true if the object is equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)return true;
        
        if (!(o instanceof Contact)) return false;
        
        Contact contact = (Contact) o;
        
        return department == contact.department && email.equals(contact.email);
        }
    }
