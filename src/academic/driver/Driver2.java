package academic.driver;


import java.util.Scanner;
import academic.model.Student;

public class Driver2 {

    private static final int MAX_STUDENTS = 100; // Kapasitas maksimum array
    private static Student[] students = new Student[MAX_STUDENTS];
    private static int studentCount = 0; // Melacak jumlah student yang sudah ditambahkan

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        while (true) {
            String line = inputScanner.nextLine();

            if (line.equals("---")) {
                break; // Berhenti membaca input
            }

            if (studentCount >= MAX_STUDENTS) {
                System.err.println("Peringatan: Kapasitas penyimpanan student sudah penuh. Data baru tidak dapat ditambahkan.");
                continue;
            }

            String[] segments = line.split("#");
            String id = segments[0];
            String name = segments[1];
            int enrollmentYear = Integer.parseInt(segments[2]);
            String major = segments[3];

            Student newStudent = new Student(id, name, enrollmentYear, major);
            students[studentCount] = newStudent;
            studentCount++;
        }

        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i]);
        }

        inputScanner.close(); // Menutup scanner karena ini adalah akhir dari program.
    }
}