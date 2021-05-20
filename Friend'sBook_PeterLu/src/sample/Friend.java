package sample;

public class Friend {
    public String firstname;
    public String lastname;
    private String gender;
    private String hobbies;

    public String getNumber() {
        return number;
    }

    private String number;

    public String getJobs() {
        return jobs;
    }

    private String jobs;
    public String getGender() {
        return gender;
    }
    public String getHobbies() {
        return hobbies;
    }


    Friend(String firstname,String lastname,String gender,String number, String hobbies,String jobs){
        this.firstname=firstname;
        this.lastname=lastname;
        this.gender=gender;
        this.number=number;
        this.hobbies=hobbies;
        this.jobs=jobs;
    }

    @Override
    public String toString() {
        return firstname+" "+lastname+"   "+number;
    }
}