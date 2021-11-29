package ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Student {

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
}
