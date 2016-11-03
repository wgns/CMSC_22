import java.io.Serializable;

/**
 * Modified by Wina Gen Sotto on November 3, 2016.
 */

public class Student implements Serializable {
    private String studentNumber;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private String course;
    private int yearLevel;
    private String crushName;
    private Course faveSubject;

    public Student(String studentNumber, String firstName, char middleInitial, String lastName, String course, int yearLevel,
                   String crushName, Course faveSubject) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.course = course;
        this.yearLevel = yearLevel;
        this.crushName = crushName;
        this.faveSubject = faveSubject;
    }

    public String toString() {
        return "Student Number: " + studentNumber +
            "\nName: " + lastName + ", " + firstName + " " + middleInitial +
            ".\nProgram: " + course + "" +
            "\nYear Level: " + yearLevel +
            "\nName of crush: " + crushName +
            "\nFavorite Subject:\n\tCourse Code: " + faveSubject.getCourseCode() +
            "\n\tCourse Description: " + faveSubject.getCourseDescription();
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public char getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(char middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    public String getCrushName() {
        return crushName;
    }

    public void setCrushName(String crushName) {
        this.crushName = crushName;
    }

    public String getFaveSubjectCourseCode() {
        return faveSubject.getCourseCode();
    }

    public void setFaveSubjectCourseCode(String courseCode) {
        this.faveSubject.setCourseCode(courseCode);
    }

    public String getFaveSubjectCourseDescription() {
        return faveSubject.getCourseDescription();
    }

    public void setFaveSubjectCourseDescription(String courseDescription) {
        this.faveSubject.setCourseDescription(courseDescription);
    }
}
