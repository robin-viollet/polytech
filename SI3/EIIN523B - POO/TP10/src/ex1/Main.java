package ex1;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){

        List<Student> students = new ArrayList<>();
        try {
            students.add(new Student("fred", "01-01-1945"));
        } catch (StudentException e){
            e.printStackTrace();
        }
        try {
            students.add(new Student("fred", "03-01-1945"));
        } catch (StudentException e){
            e.printStackTrace();
        }
        try {
            students.add(new Student("obama", "yes we can"));
        } catch (StudentException e){
            e.printStackTrace();
        }
        try {
            students.add(new Student("christophe", "30-02-2002"));
        } catch (StudentException e){
            e.printStackTrace();
        }
        try {
            students.add(new Student("amandine", "03-13-2002"));
        } catch (StudentException e){
            e.printStackTrace();
        }
        try {
            students.add(new Student("helene", "04-03-2002"));
        } catch (StudentException e){
            e.printStackTrace();
        }
        try {
            students.add(new Student("monique", "03-10-2002"));
        } catch (StudentException e){
            e.printStackTrace();
        }
        try {
            students.add(new Student("sandrine", "18-07-1972"));
        } catch (StudentException e){
            e.printStackTrace();
        }
        try {
            students.add(new Student("jean", "11-08-1992"));
        } catch (StudentException e){
            e.printStackTrace();
        }

        students.forEach(System.out::println);
    }
}
