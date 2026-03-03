package academic.model;

public class Student {
    private String id;
    private String name;
    private int enrollmentYear;
    private String major;

    public Student(String id, String name, int enrollmentYear, String major) {
        this.id = id;
        this.name = name;
        this.enrollmentYear = enrollmentYear;
        this.major = major;
    }

    // Mengoverride toString() untuk format output yang diinginkan
    @Override
    public String toString() {
        return id + "|" + name + "|" + enrollmentYear + "|" + major;
    }
} 