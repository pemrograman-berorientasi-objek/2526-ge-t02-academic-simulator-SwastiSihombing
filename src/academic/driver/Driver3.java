package academic.driver;

import academic.model.Enrollment;
import java.util.Scanner;

public class Driver3 {

    private static final int MAX_ENROLLMENTS = 200; // Kapasitas maksimum untuk pendaftaran
    private static Enrollment[] enrollments = new Enrollment[MAX_ENROLLMENTS];
    private static int enrollmentCount = 0;

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);


        while (true) {
            String line = inputScanner.nextLine();

            if (line.equals("---")) {
                break;
            }

            if (enrollmentCount >= MAX_ENROLLMENTS) {
                System.err.println("Peringatan: Kapasitas penyimpanan enrollment sudah penuh. Data baru tidak dapat ditambahkan.");
                continue;
            }

            String[] segments = line.split("#");
            String courseCode = segments[0];
            String studentId = segments[1];
            String academicYear = segments[2];
            String semester = segments[3];

            // Grade secara default akan "None" sesuai permintaan output
            Enrollment newEnrollment = new Enrollment(courseCode, studentId, academicYear, semester);
            enrollments[enrollmentCount] = newEnrollment;
            enrollmentCount++;
        }

        for (int i = 0; i < enrollmentCount; i++) {
            System.out.println(enrollments[i]);
        }

        inputScanner.close(); // Menutup scanner karena ini adalah akhir dari program.
    }
}