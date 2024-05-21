import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private Student student;

    @BeforeEach
    public void setUp(){
        student = new Student("Trey", "Greene", new double[]{73.2, 80.4, 60.32});
    }
    @org.junit.jupiter.api.Test
    void getExamScores() {
        String expected = "Exam Scores:\n" +
                "Exam 1 -> 73.2\n" +
                "Exam 2 -> 80.4\n" +
                "Exam 3 -> 60.32\n";
        assertEquals(expected, student.getExamScores());
    }

    @org.junit.jupiter.api.Test
    void addExamScore() {
        student.addExamScore(100.0);
        String expected = "Exam Scores:\n" +
                "Exam 1 -> 73.2\n" +
                "Exam 2 -> 80.4\n" +
                "Exam 3 -> 60.32\n" +
                "Exam 4 -> 100.0\n";
        assertEquals(expected, student.getExamScores());
    }

    @org.junit.jupiter.api.Test
    void setExamScore() {
        student.setExamScore(1, 79.0);
        String expected = "Exam Scores:\n" +
                "Exam 1 -> 73.2\n" +
                "Exam 2 -> 79.0\n" +
                "Exam 3 -> 60.32\n" +
                "Exam 4 -> 100.0\n";
        assertEquals(expected, student.getExamScores());
    }

    @org.junit.jupiter.api.Test
    void getAverageScore() {
        double expected = 73.2 + 80.4 + 60.32 / 3;
        assertEquals(expected, student.getAverageScore());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }

    @org.junit.jupiter.api.Test
    void getFirstName() {
        assertEquals("Trey", student.getFirstName());
    }

    @org.junit.jupiter.api.Test
    void setFirstName() {
        student.setFirstName("John");
        assertEquals("John", student.getFirstName());
    }

    @org.junit.jupiter.api.Test
    void getLastName() {
        assertEquals("Greene", student.getLastName());
    }

    @Test
    void setLastName() {
        student.setLastName("Doe");
        assertEquals("Doe", student.getLastName());
    }
}