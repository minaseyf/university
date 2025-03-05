import base.Person;
import uni.*;

import java.util.ArrayList;
class Main {
    public static void main(String[] args) {
        Person mina = new Person("mina", "0260696500");
        Person maryam = new Person("maryam", "0123456789");
        Person neda = new Person("neda", "0111122222");
        Person mohamad = new Person("mohamad", "3333344444");
        Person mahdi = new Person("mahdi", "6666677777");

        Major math = new Major("math", 10);
        Major cs = new Major("cs", 10);

        Student minaStu = new Student(mina.id, 403, math.id);
        Student maryamStu = new Student(maryam.id, 400, math.id);
        Student nedaStu = new Student(neda.id, 404, cs.id);

        System.out.println((Person.findByID(minaStu.personID)).name + " : " + minaStu.studentID);
        System.out.println((Person.findByID(maryamStu.personID)).name + " : " + maryamStu.studentID);
        System.out.println((Person.findByID(nedaStu.personID)).name + " : " + nedaStu.studentID);
        System.out.println();

        Professor mohamadPro = new Professor(mohamad.id, math.id);
        Professor mahdiPro = new Professor(mahdi.id, cs.id);

        System.out.println((Person.findByID(mohamadPro.personID).name) + " : " + mohamadPro.id);
        System.out.println((Person.findByID(mahdiPro.personID).name) + " : " + mahdiPro.id);
        System.out.println();

        Course physics = new Course("physics",5);
        Course chemistry = new Course("chemistry", 6);
        Course mathematics = new Course("mathematics", 3);

        PresentedCourse physicsPre = new PresentedCourse(20, physics.id, mohamadPro.id);
        PresentedCourse chemistryPre = new PresentedCourse(30, chemistry.id, mohamadPro.id);
        PresentedCourse mathematicsPre = new PresentedCourse(40, mathematics.id, mahdiPro.id);

        physicsPre.addStudent(minaStu.id);
        physicsPre.addStudent(maryamStu.id);
        chemistryPre.addStudent(minaStu.id);
        chemistryPre.addStudent(maryamStu.id);
        chemistryPre.addStudent(nedaStu.id);
        mathematicsPre.addStudent(nedaStu.id);

        Transcript minaTranscript = new Transcript(minaStu.id);
        minaTranscript.setGrade(physicsPre.id , 12.5);
        minaTranscript.setGrade(chemistryPre.id, 16.5);

        Transcript maryamTranscript = new Transcript(maryamStu.id);
        maryamTranscript.setGrade(physicsPre.id,17);
        maryamTranscript.setGrade(chemistryPre.id,19);

        Transcript nedaTranscript = new Transcript(nedaStu.id);
        nedaTranscript.setGrade(chemistryPre.id, 15.75);
        nedaTranscript.setGrade(mathematicsPre.id, 18.96);

        minaTranscript.printTranscript();
        System.out.println();
        maryamTranscript.printTranscript();
        System.out.println();
        nedaTranscript.printTranscript();
        System.out.println();

        System.out.println("mina GPA : " + minaTranscript.getGPA());
        System.out.println("maryam GPA : " + maryamTranscript.getGPA());
        System.out.println("neda GPA : " + nedaTranscript.getGPA());







    }
}


