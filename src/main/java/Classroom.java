import java.util.*;
public class Classroom {
     private Student[] students;
     private int numOfStudents;
     public Classroom(int maxNumberOfStudents){
          this.students = new Student[maxNumberOfStudents];
          this.numOfStudents = 0;
     }
     public Classroom(Student[] students){
          this.students = students;
          this.numOfStudents = students.length;
     }
     public Classroom(){
          this.students = new Student[30];
          this.numOfStudents = 0;
     }
     public Student[] getStudents(){
          return students;
     }
     public double getAverageExamScore(){
          return getAverageExamScore() / students.length;
     }
     public void addStudent(Student student){
          if(numOfStudents < students.length) {
               students[numOfStudents] = student;
               numOfStudents++;
          } else {
               System.out.println("The classroom appears to be full!");
          }
     }
     public void removeStudent(String firstName, String lastName){
          int indexRemove = -1;
          for(int i = 0; i < numOfStudents; i++){
               if(students[i].getFirstName().equals(firstName) && students[i].getLastName().equals(lastName)) {
                    indexRemove = 1;
                    break;
               }
          }
          if(indexRemove != -1){
               for(int i = indexRemove; i < numOfStudents-1; i++){
                    students[i] = students[i+1];
               }
               numOfStudents = -1;
               students[numOfStudents -1] = null;
          } else {
               System.out.println("Student not found!");
          }
          System.out.println("Removed student: " + firstName + " " + lastName);
     }
     public void getStudentByScore(){
          Student[] sortedListOfStudents = Arrays.copyOf(students, numOfStudents);
          Arrays.sort(sortedListOfStudents, Comparator.comparingDouble(Student::getAverageScore)); //gathers and sorts students by grade
          System.out.println(Arrays.toString(sortedListOfStudents));
     }
     public Map<Student, String>  getGradeBook(){
          Student[] sortedListOfStudents = Arrays.copyOf(students, numOfStudents);
          Arrays.sort(sortedListOfStudents, Comparator.comparingDouble(Student::getAverageScore)); //gathers and sorts students by grade

          Map<Student, String> grades = new HashMap<>();

          int upper10thPercentile = (int) (0.1 * numOfStudents);
          int upper11thPercentile = (int) (0.11 * numOfStudents);
          int upper29thPercentile = (int) (0.29 * numOfStudents);
          int upper30thPercentile = (int) (0.3 * numOfStudents);
          int upper50thPercentile = (int) (0.5 * numOfStudents);
          int lower89thPercentile = (int) (0.89 * numOfStudents);
          int lower11thPercentile = (int) (0.11 * numOfStudents);

          for (int i = 0; i < numOfStudents; i++) {
               if (i < upper10thPercentile) {
                    grades.put(students[i], "A");
               } else if (i < upper29thPercentile) {
                    grades.put(students[i], "B");
               } else if (i < upper50thPercentile) {
                    grades.put(students[i], "C");
               } else if (i < lower89thPercentile) {
                    grades.put(students[i], "D");
               } else {
                    grades.put(students[i], "F");
               }
          }
          return grades;
     }
}
