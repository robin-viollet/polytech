package ex5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    Student student = null;

    @AfterEach
    void setToNull(){

        student = null;

    }

    @Test
    void test(){//S’assurer que l’attribut student soit l’étudiant nommé Donald né le 02-07-1972

    }

    @Test
    void constructorOK(){ //: le constructeur a créé une instance
        student = new Student("test", "01-01-1970");
    }

    @Test
    void constructorK0(){ //: le constructeur a provoqué une erreur
        assertThrows(StudentException.class, () -> new Student("test", "32-01-2021"));
    }

    @Test
    void equalsTest(){ //: deux étudiants sont identiques (même nom)
        student = new Student("test", "01-01-1970");
        assertEquals(0, student.compareTo(new Student("test", "01-01-1970")));
    }

    @Test
    void notEqualsTest(){ //: plusieurs tests à réaliser parmi lesquels null et une instance de Object
        student = new Student("test", "01-01-1970");
        assertNotEquals(0, student.compareTo(null));
    }

    @Test
    void compare(){ //: comparateur par défaut (plusieurs tests)
    }

    @Test
    void compareAge(){ //: plusieurs tests
    }

    @Test
    void compareName(){//: plusieurs tests
    }

    @Test
    void compareNotes(){//: plusieurs tests
    }
}
