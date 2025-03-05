package uni;

import java.util.ArrayList;

public class Student {
    public int id;
    public static ArrayList<Student> studentList = new ArrayList<>();
    public int personID;
    public final int enteranceYear;
    public int majorID;
    public String studentID;

    public Student(int personID, int entranceYear, int majorID) {
        this.personID = personID;
        this.majorID = majorID;
        this.enteranceYear = entranceYear;
        this.id = studentList.size() + 1;
        this.setStudentCode();
        studentList.add(this);
    }


public void setStudentCode() {
    if (this.id < 10 && this.majorID < 10)
        this.studentID = String.valueOf(enteranceYear) + "0" + String.valueOf(majorID) + "0" + String.valueOf(id);
    else if (majorID < 10)
        this.studentID = String.valueOf(enteranceYear) + "0" + String.valueOf(majorID) + String.valueOf(id);
    else if (id < 10)
        this.studentID = String.valueOf(enteranceYear) + String.valueOf(majorID) + "0" + String.valueOf(id);
    else
        this.studentID = String.valueOf(enteranceYear) + String.valueOf(majorID) + String.valueOf(id);
}

    public static Student findByID(int id){
        for(Student student : studentList){
            if(student.id == id)
                return student;
        }
        return null;
    }
}

