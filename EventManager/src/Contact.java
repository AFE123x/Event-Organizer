public class Contact {
    private Department department;
    private String email;
    public Contact(Department department, String email){
        this.department = department;
        this.email = email;
    }
    //getters and setters
    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    // is valid method
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
        // if(email == null || department == null){
        //     return false;
        // }
    
        // String mailEnd = "@rutgers.edu";
        // boolean isEmailValid = email.length() > mailEnd.length() && email.endsWith(mailEnd);
        
        // boolean isDepartmentValid = false;
        // for(Department d: Department.values()){
        //     if(department.equals(d.getAbbreviation())){
        //         isDepartmentValid = true;
        //         break; 
        //     }
        // }
        // return isEmailValid && isDepartmentValid;
    }

    // toString
    @Override
    public String toString() {
        return "Contact{ department=" + department + ", email='" + email + "' }";
    }
    
    // equals 
    @Override
    public boolean equals(Object o) {
        if(o instanceof Contact){
             if (this == o){ 
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Contact contact = (Contact) o;
        return department == contact.department && email.equals(contact.email);
        }
        return false;
       
    }
}
