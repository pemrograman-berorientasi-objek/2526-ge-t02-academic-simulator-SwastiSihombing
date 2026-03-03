package academic.model;

public class Enrollment {
    private String courseCode;
    private String studentId;
    private String academicYear; // e.g., "2021/2022"
    private String semester;     // e.g., "even"
    private String grade;        // Default "None" if not yet given

    public Enrollment(String courseCode, String studentId, String academicYear, String semester) {
        this(courseCode, studentId, academicYear, semester, "None"); // Default grade to "None"
    }

    public Enrollment(String courseCode, String studentId, String academicYear, String semester, String grade) {
        this.courseCode = courseCode;
        this.studentId = studentId;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return courseCode + "|" + studentId + "|" + academicYear + "|" + semester + "|" + grade;
    }

    // Getter untuk properti Enrollment (opsional, tapi good practice)
    public String getCourseCode() { return courseCode; }
    public String getStudentId() { return studentId; }
    public String getAcademicYear() { return academicYear; }
    public String getSemester() { return semester; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
} 