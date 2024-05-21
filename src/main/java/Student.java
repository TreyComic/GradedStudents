import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores = new ArrayList<>();

    public Student(String firstName, String lastName, double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        for(int i = 0; i < testScores.length; i++) {
            examScores.add(testScores[i]);
        }
    }

    public String getExamScores(){
        StringBuilder result = new StringBuilder("Exam Scores:\n");
        for(int i = 0; i < examScores.size(); i++) {
            result.append("Exam ").append(i+1).append(" -> ").append(examScores.get(i)).append("\n");
        }
        return result.toString();
    }

    public void addExamScore(double examScore){
        examScores.add(examScore);
    }

    public void setExamScore(int examNumber, double newScore){
        examScores.set(examNumber, newScore);
    }

    public double getAverageScore(){
        double sum = 0;
        for(Double score: examScores) {
            sum += score;
        }
        double average = sum / examScores.size();
        return average;
    }

    @Override
    public String toString() {
        return "Student Name: " + getFirstName() + " " + getLastName() + "\n" +
                "Average Score: " + getAverageScore() + "\n" + getExamScores();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
