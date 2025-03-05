package uni;

import base.Person;

import java.util.HashMap;

public class Transcript {
    public int studentID;
    public HashMap<Integer, Double> transcript = new HashMap<>();
    public Transcript(int studentID) {
        this.studentID = studentID;
    }
    public void setGrade(int presentedCourseID, double grade){
        PresentedCourse course = PresentedCourse.findByID(presentedCourseID);
        if (!(course.studentIDs.contains(this.studentID)))
            return;

        transcript.put(course.id , grade);
    }
    public void printTranscript() {
        System.out.println(Person.findByID(Student.findByID(studentID).personID).name + " " + Student.findByID(studentID).studentID);
        transcript.forEach((key, value) ->{
            System.out.println(Course.findByID(PresentedCourse.findByID(key).courseID).title + " : " + value);
        });
    }
    public double getGPA() {
        double[] sum = new double[1];
        int[] unit = new int[1];

        transcript.forEach((key , value) -> {
            int temp = Course.findByID(PresentedCourse.findByID(key).courseID).units;
            unit[0] += temp;
            sum[0] += temp * value;
        });
        return sum[0]/unit[0];
    }
}
