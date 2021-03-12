public class Main {
    public static void main(String[] args) {
        School school= new School("R.A. McMath","Richmond",30); /*first off a school has to be created the parameter that is inputted here will be
        sent the constructor and it would then create an school object with these info*/

        // the code below is the first names for the students it will later on be used to create student objects
        String[] sfirstname = new String[]{"Michael", "Christopher", "Jessica", "Matthew", "Ashley", "Jennifer", "Joshua", "Amanda", "Daniel", "David"};
        // the code below is the last names for students
        String[] slastname = new String[]{"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez"};


        //this code below is for the firstnames of teachers
        String[] tfirstname = new String[]{"Robert","Jason","Kerrie"};

        //this is for the last names of teachers
        String[] tlastname= new String[]{"Ariey","Belonio","Caldwell"};

        //this is the subject that each teacher teach
        String[] subject = new String[]{"Math","Physics","Chemistry","Computer Science"};

       //the for loop below will add 10 students to the student arraylist

        for(int i=0;i<10;i++){ //this for loop loops through all the index position of the student firstname and lastname list created above
            /* everytime a new student will be created with first and lastname at the current index position and a grade that is randomly created that is
            between 1 and 10. This then get sent to the student class and a student will be created with these parameters*/
            Student student = new Student(sfirstname[i],slastname[i],(int)(1+Math.random()*10));
            school.addstudent(student); // this call the add student methode that is created in the school class and adds the student that was just created into the arraylist of students
        }

        // the for loop below will add 3 teachers to the teacher arraylist
        for(int i=0;i<3;i++){//this for loop loops through all the index position of the teacher firstname and lastname list created above
            /* everytime a new teacher will be created with first and lastname and subject at the current index position.
            This then get sent to the teacher class and a teacher will be created with these parameters*/
            Teacher teacher = new Teacher(tfirstname[i],tlastname[i],subject[i]);
            school.addteacher(teacher);// this calls the add teacher methode that is created in the school class and adds the teacher that was just created into the arraylist of teachers
        }

        school.showAllStudents();// this calls the showallstudents methode in the school and print all the items in the student arraylist

        school.showAllTeachers();// this calls the showallteachers methode in the school and print all the items in the teacher arraylist

        school.deletestudent((int)(Math.random()*9));/*Calls the delete student methode in the school class and sends in a random position (0-9) and the deletestudent methode will
       delete the student at the selected position*/

        school.deletestudent((int)(Math.random()*9));

        school.deleteteacher((int)(Math.random()*3));/*Calls the delete teacher methode in the school class and sends in a random position (0-3) and the deleteteacher methode will
       delete the teacher at the selected position*/

        school.showAllStudents();//this once again prints all the students information in the student array list

        school.showAllTeachers();//this prints all the teachers information in the teacher array list



    }
}
