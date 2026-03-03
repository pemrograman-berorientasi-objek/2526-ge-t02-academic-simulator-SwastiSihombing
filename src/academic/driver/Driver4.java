package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.Scanner;

public class Driver4 {

    private static final int MAX_ENTITIES = 100; // Kapasitas maksimum untuk setiap jenis entitas

    private static Course[] courses = new Course[MAX_ENTITIES];
    private static int courseCount = 0;

    private static Student[] students = new Student[MAX_ENTITIES];
    private static int studentCount = 0;

    private static Enrollment[] enrollments = new Enrollment[MAX_ENTITIES];
    private static int enrollmentCount = 0;

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);


        while (true) {
            String line = inputScanner.nextLine();

            if (line.equals("---")) {
                break; // Berhenti membaca input
            }

            // Pisahkan instruksi dari data
            String[] parts = line.split("#", 2); // Split only at the first '#'
            String command = parts[0];
            String data = parts.length > 1 ? parts[1] : "";

            switch (command) {
                case "course-add":
                    if (courseCount >= MAX_ENTITIES) {
                        System.err.println("Peringatan: Kapasitas penyimpanan course penuh.");
                        break;
                    }
                    String[] courseSegments = data.split("#");
                    if (courseSegments.length == 4) { // Kode#Nama#SKS#Nilai
                        String code = courseSegments[0];
                        String name = courseSegments[1];
                        int credits = Integer.parseInt(courseSegments[2]);
                        String grade = courseSegments[3];
                        courses[courseCount++] = new Course(code, name, credits, grade);
                    } else {
                        System.err.println("Format input Course tidak valid: " + line);
                    }
                    break;

                case "student-add":
                    if (studentCount >= MAX_ENTITIES) {
                        System.err.println("Peringatan: Kapasitas penyimpanan student penuh.");
                        break;
                    }
                    String[] studentSegments = data.split("#");
                    if (studentSegments.length == 4) { // ID#Nama#TahunMasuk#Major
                        String id = studentSegments[0];
                        String name = studentSegments[1];
                        int enrollmentYear = Integer.parseInt(studentSegments[2]);
                        String major = studentSegments[3];
                        students[studentCount++] = new Student(id, name, enrollmentYear, major);
                    } else {
                        System.err.println("Format input Student tidak valid: " + line);
                    }
                    break;

                case "enrollment-add":
                    if (enrollmentCount >= MAX_ENTITIES) {
                        System.err.println("Peringatan: Kapasitas penyimpanan enrollment penuh.");
                        break;
                    }
                    String[] enrollmentSegments = data.split("#");
                    if (enrollmentSegments.length == 4) { // KodeCourse#IDStudent#TahunAkademik#Semester
                        String courseCode = enrollmentSegments[0];
                        String studentId = enrollmentSegments[1];
                        String academicYear = enrollmentSegments[2];
                        String semester = enrollmentSegments[3];
                        // Grade secara default "None" di konstruktor Enrollment
                        enrollments[enrollmentCount++] = new Enrollment(courseCode, studentId, academicYear, semester);
                    } else {
                        System.err.println("Format input Enrollment tidak valid: " + line);
                    }
                    break;

                default:
                    break;
            }
        }


        // Tampilkan Course
        for (int i = 0; i < courseCount; i++) {
            System.out.println(courses[i]);
        }

        // Tampilkan Student
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i]);
        }

        // Tampilkan Enrollment
        for (int i = 0; i < enrollmentCount; i++) {
            System.out.println(enrollments[i]);
        }

        inputScanner.close(); // Menutup scanner karena ini adalah akhir dari program.
    }
}