package academic.model;

public class Course {
    private String code;
    private String name;
    private int credits;
    private String grade;

    public Course(String code, String name, int credits, String grade) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.grade = grade;
    }

    // Overriding toString() method to provide desired output format
    @Override
    public String toString() {
        return code + "|" + name + "|" + credits + "|" + grade;
    }
}    