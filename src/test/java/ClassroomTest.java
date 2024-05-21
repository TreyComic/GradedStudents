import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ClassroomTest {
    private Classroom classroom;
    private Student studentUno;
    private Student studentDos;
    @BeforeEach
    public void setUp(){
        studentUno = new Student("John", "Doe",  new double[]{73.2, 80.4, 60.32});
        studentDos = new Student("Jack", "Black",  new double[]{70.2, 80.4, 60.32});
        classroom = new Classroom(new Student[] {studentUno, studentDos});
    }
    @Test
    void getStudents() {
        Student[] students = classroom.getStudents();
        int actual = students.length;
        assertEquals(2, actual);
        assertEquals(studentUno, students[0]);
        assertEquals(studentDos, students[1]);
    }

    @Test
    void getAverageExamScore() {
        double expected = (studentUno.getAverageScore() + studentDos.getAverageScore()) / 2;
        double actual = classroom.getAverageExamScore();
        assertEquals(expected, actual);
    }

    @Test
    void addStudent() {
        int expected = 2;
        Classroom classOf2020 = new Classroom(expected);
        classOf2020.addStudent(studentUno);
        classOf2020.addStudent(studentDos);
        assertEquals(expected, classroom.getStudents().length);
    }

    @Test
    void removeStudent() {
        Student[] students = classroom.getStudents();
        classroom.removeStudent("Jack", "Black");
        assertEquals(1, students.length);
    }

    @Test
    void getStudentByScore() {
        Student[] students = classroom.getStudents();
        classroom.getStudentByScore();
        assertEquals(studentUno, students[0]);
        assertEquals(studentDos, students[1]);
    }

    @Test
    void getGradeBook() {
        Map<Student, String> grades = classroom.getGradeBook();
        assertEquals("C", grades.get(studentUno));
        assertEquals("F", grades.get(studentDos));
    }
}