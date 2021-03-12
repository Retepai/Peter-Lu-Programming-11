import java.util.ArrayList;

public class School {

    /* this class creates an object called school upon creation a school name,location,and rank is set
     and in it it holds the teacher's list, the student list and the course list (that all can be modified in the main class).
     This class also holds the methods to delete, add and show all student and teachers from the list */


    private ArrayList<Student> studentlist = new ArrayList<>(); //this is a private string array that holds an array list of students
    private ArrayList<Teacher> teacherlist=new ArrayList<>();//this is a private string array that holds an array list of teachers
    private ArrayList<String> courselist=new ArrayList<>();// this is a private string array that holds an array list of courses

    private String schoolname;//the school name used in this class
    private String location;// the location used in this class
    private int schoolrank;// the school rank for this class

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSchoolrank() {
        return schoolrank;
    }

    public void setSchoolrank(int schoolrank) {
        this.schoolrank = schoolrank;
    }

    School(String schoolname,String location,int schoolrank){/*this is the constructor for object school, upon creation it takes in the parameter in the main class
    and passes them in and assigns them to local variables*/
        this.schoolname=schoolname;// the variable schoolname is passed in from the main class and set to the private variable school name in this class to crete the object
        this.location=location;//this happens with all the other variables
        this.schoolrank=schoolrank;
    }

    public void addteacher(Teacher teacher){
        /*this is a methode for adding a teacher to the teacher's list. This accomplishes this by taking in the teacher object as an parameter and then using the add function
        to add the new to teacher to the arraylist*/
        teacherlist.add(teacher);
    }
    public void addstudent(Student student){
        /*this is the methode for adding a student to the student's list. This does that by taking the student object in as an parameter and then add it to the student
         list by using the add function  */
        studentlist.add(student);
    }
    public void deleteteacher(int i){
        /*this is the methode for deleting a teacher from the arraylist. To do that we must know the position of where we are going to remove the teacher, so that would be passed in
         as an integer parameter to tell where to remove. And then by using the remove function the teacher at the position i will be removed from the list*/
        teacherlist.remove(i);
    }
    public void deletestudent(int i){
        /* this is methode for removing a student from list. This methode will take the position of where the student is and remove that student from the list by using the remove
        function. */
        studentlist.remove(i);
    }
    public void showAllTeachers(){
        /* this is a methode to print out all the teachers. It accomplishes that by using a for loop to loop though all the position of the arraylist and by teacherlist.get to
        get the all the teacher information (name and subject) on each position and then print them out */
        System.out.println("All teachers:");
        for(int i=0;i<teacherlist.size();i++){
            System.out.println(teacherlist.get(i));
        }
    }
    public void showAllStudents(){
        /*This is a methode to print all the students. It uses the for loop and loops through all the position of the studentlist and then using the studentlist.get function, it will
        get all the student information on each position and then print them out*/
        System.out.println("All student:");
        for(int i=0;i<studentlist.size();i++){
            System.out.println(studentlist.get(i));
        }
    }





}
















