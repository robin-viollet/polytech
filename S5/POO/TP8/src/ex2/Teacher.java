package ex2;

public class Teacher {
    public Teacher(String name, String course, int hours){

        this.name = name;
        this.course = course;
        this.hours = hours;

    }

    private final String name;
    private final String course;
    private final int hours;

    public String getName(){

        return name;
    }

    public String getCourse(){

        return course;
    }

    public int getHours(){

        return hours;
    }
}
