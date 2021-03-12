public class Teacher {/*This class creates a object called teacher and it takes in parameters from the main class then returns the full name
 and the subject of the teacher*/
    private String firstname;// this is a private variable and it is only for the teacher's firstname
    private String lastname;//this private variable only for the teacher's lastname
    private String subject;//this variable is only for the teacher's subject

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }



    Teacher(String firstname, String lastname, String subject){/*this constructor takes in the parameter from the main class upon the creation of the object and assigns
    them to private class variables*/
        this.firstname= firstname;// the firstname gets passed in as an parameter and get assigned to the private firstname
        this.lastname=lastname;//the lastname will be assign to the private lastname of this class
        this.subject=subject;//the teacher's subject will also be take in as an parameter and assigned to the private subject of this teacher class
    }

    @Override
    public String toString() {//the toString is need to return the full name and subject because without them random number would appear
        return "Name:" + firstname+ " "+ lastname+ " "+
                "Subject:" + subject;// this overrides the returning process with its own, the full name and the subject will be returned
    }
}