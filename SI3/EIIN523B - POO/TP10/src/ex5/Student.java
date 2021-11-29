package ex5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Student implements Comparable<Student>{

    static final Comparator<Student> NAME_COMPARATOR = Comparator.comparing(student -> student.name);
    static final Comparator<Student> NOTE_COMPARATOR = (student, t1) -> (int) (t1.getAdverage() - student.getAdverage());
    static final Comparator<Student> AGE_COMPARATOR = (student, t1) -> t1.age - student.age;

    public Student(String name, String birthdate) throws StudentException{

        boolean validDate = false;

        try {

            String[] parts = birthdate.split("-");

            if (parts.length > 0){

                int day = Integer.parseInt(parts[0]);

                if (day > 0 && day < 32 && parts.length > 1){

                    int month = Integer.parseInt(parts[1]);

                    if (month > 0 && month < 13 && parts.length > 2){

                        int year = Integer.parseInt(parts[2]);

                        age = day + month * 31 + year * 12 * 31;

                        if (year >= 1900 && year <= 2010){

                            validDate = true;

                        }
                    }
                }
            }

        } catch (IllegalArgumentException e){

            throw new StudentException(e.getMessage());

        }

        if (!validDate){

            throw new StudentException("Invalid birthdate '" + birthdate + "'");

        }

        this.name = name;
        this.birthdate = birthdate;
        this.marks = new ArrayList<>();

    }

    private final String name;
    private final String birthdate;
    private int age;
    private final List<Double> marks;

    public double getAdverage(){

        return marks.stream().collect(Collectors.summarizingDouble(Double::doubleValue)).getAverage();

    }

    public void addNote(double mark){

        marks.add(mark);

    }

    public void addNotes(double... marks){

        for (double mark : marks){

            this.marks.add(mark);

        }
    }

    @Override
    public String toString(){

        return "Student [" +
                "name='" + name + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ']';
    }

    @Override
    public int compareTo(Student student){

        int nameResult = NAME_COMPARATOR.compare(this, student);
        int noteResult = NOTE_COMPARATOR.compare(this, student);
        int ageResult = AGE_COMPARATOR.compare(this, student);

        System.out.println("name comparator : " + nameResult);
        System.out.println("notes comparator : " + noteResult);
        System.out.println("age comparator : " + ageResult);

        if (nameResult == 0 && noteResult == 0 && ageResult == 0){

            return 0;

        }

        return nameResult + noteResult * 10 + ageResult * 100;

    }
}
