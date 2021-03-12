public class Student {
    /*This class creates an object called student and it takes in parameters that are entered
    * through the main class and returns the full name and grade */
    private String firstname; //this is the firstname and it is private meaning that this is only for the student firstnames
    private String lastname;// this is the lastname and it is still only for the students
    private int grade;// this is the student's private grade
    private int studentpen;// this is the student's student number
    private static int pennumber=1000; //this is the number that every student number is going to base off of so it as to be static

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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getStudentpen() {
        return studentpen;
    }

    public void setStudentpen(int studentpen) {
        this.studentpen = studentpen;
    }


    Student(String firstname, String lastname, int grade){ /* this constructor takes in the first and lastname and grades of the student created
    in the main class and sets assigns then to the private class variables*/
        this.firstname=firstname; //this assigns the firstname taken in as an parameter and sets it to the firstname of this class
        this.lastname=lastname;// the parameter will take in lastname as an parameter and assign it to the lastname in this class
        this.grade=grade;//grade will also be assign to the private student grade
        this.studentpen= pennumber;// this is a pen number generator, this will increase by one as it loop in main class send variable through each time therefore creating unique pen numbers
        pennumber++;// this adds one to the original pen number size so the pen number of each student will different each time it loops through
    }
    public String toString() { //this toString is needed because if this is not present then when we print the object the names and grade will come as a weird number
        return "Name:" + firstname +" "+ lastname +" "+
                "Grade:" + grade; //once the object is created and then called upon the this would return the full name and the grade of the student based off of the parameters taken in.
    }

}
