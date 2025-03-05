package uni;

import java.util.ArrayList;

public class PresentedCourse {
    public int id;
    public static ArrayList<PresentedCourse> presentedCourseList = new ArrayList<>();
    public int courseID;
    public int professorID;
    public int capacity;
    public ArrayList<Integer> studentIDs = new ArrayList<>();

    public PresentedCourse(int maxCapacity, int courseID, int professorID) {
        this.capacity = maxCapacity;
        this.courseID = courseID;
        this.professorID = professorID;
        this.id = presentedCourseList.size() + 1;
        presentedCourseList.add(this);
    }

    public static PresentedCourse findByID(int id) {
        for(PresentedCourse presentedCourse : presentedCourseList){
            if(presentedCourse.id == id)
                return presentedCourse;
        }
        return null;
    }

    public void addStudent(int studentID) {
        if(studentIDs.size() == capacity)
            System.out.println("this course is full!");
        else
            studentIDs.add(studentID);
    }
}
