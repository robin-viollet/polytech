package ex2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static ex2.MyStreams.polytechCourses;

public class Main {

    public static void main(final String[] args) {
        Predicate<String> polytechTaught = s -> Arrays.asList(polytechCourses).contains(s);
        Predicate<String> longString = s -> !Arrays.asList(polytechCourses).contains(s);

        Function<Set<Teacher>, Set<String>> coursesTaught = teachers -> teachers.stream()
                .map(Teacher::getCourse)
                .collect(Collectors.toSet());

        Function<Set<Teacher>, Set<String>> coursesNotTaught = teachers -> teachers.stream()
                .map(Teacher::getCourse)
                .filter(s -> !Arrays.asList(polytechCourses).contains(s))
                .collect(Collectors.toSet());

        Function<Set<Teacher>, Set<String>> teacherName = teachers -> teachers.stream()
                .map(Teacher::getName)
                .collect(Collectors.toSet());

        Function<Set<Teacher>, Set<String>> fredCourses = teachers -> teachers.stream()
                .filter(teacher -> teacher.getName().equals("fred"))
                .map(Teacher::getCourse)
                .collect(Collectors.toSet());

        Function<Set<Teacher>, Set<String>> fredLongCourses = teachers -> teachers.stream()
                .filter(teacher -> teacher.getName().equals("fred"))
                .map(Teacher::getCourse)
                .filter(s -> s.length() >= 7)
                .collect(Collectors.toSet());

        Predicate<String> polytechLongCourse = s -> Arrays.asList(polytechCourses).contains(s) && s.length() >= 7;

        Set<Teacher> teachersSet = new HashSet<Teacher>();
        teachersSet.add( new Teacher("fred","poo", 17) );
        teachersSet.add( new Teacher("fred","database", 21) );
        teachersSet.add( new Teacher("fred","electronics", 12) );
        teachersSet.add( new Teacher("fred","network", 12) );
        teachersSet.add( new Teacher("peter", "poo", 85) );
        teachersSet.add( new Teacher("peter", "english", 15) );
        teachersSet.add( new Teacher("claudine", "database", 102) );
        teachersSet.add( new Teacher("claudine", "infoTheo", 102) );
        teachersSet.add( new Teacher("igor", "infoTheo", 102) );
        teachersSet.add( new Teacher("igor", "database", 102) );

        System.out.println("* ----------------------------------------------------------- *\n" +
                "* TP java                                                     *\n" +
                "*                                                             *\n" +
                "* @author robin viollet - robin.viollet@etu.univ-cotedazur.fr *\n" +
                "* @version TD8 - ex2                                          *\n" +
                "* ----------------------------------------------------------- *\n");

        System.out.println( "Polytech courses list = " + Arrays.asList(polytechCourses) );
        System.out.println( "teachers name = " + teacherName.apply(teachersSet) );
        System.out.println( "Courses taught = " + coursesTaught.apply(teachersSet) );
        System.out.println( "fred's courses = " + fredCourses.apply(teachersSet) );
        System.out.println( "fred's long courses = " + fredLongCourses.apply(teachersSet) );
        System.out.println( "courses no taught at polytech = " +
                coursesNotTaught.apply(teachersSet) );
        String course = "english";
        Boolean check;
        check = longString.test(course);
        System.out.println("Is the course "+ course + " a long String? " + check);
        check = polytechTaught.test(course);
        System.out.println("Is the course "+ course + " present in the polytech courses list? " +
                check);
        check = polytechLongCourse.test(course);
        System.out.println("Is the course "+ course + " polytech long course? " + check);
    }
}
