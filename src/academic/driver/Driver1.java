package academic.driver;

import academic.model.Course;
import java.util.Scanner;

public class Driver1 {

    // Maximum capacity for the course array
    private static final int MAX_COURSES = 100; // You can adjust this limit
    private static Course[] courses = new Course[MAX_COURSES];
    private static int courseCount = 0; // To keep track of the number of courses added

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        while (true) {
            String line = inputScanner.nextLine();

            if (line.equals("---")) {
                break; // Stop reading input
            }

            // Check if array capacity is reached
            if (courseCount >= MAX_COURSES) {
                System.err.println("Peringatan: Kapasitas penyimpanan course sudah penuh. Data baru tidak dapat ditambahkan.");
                continue; // Skip processing this line
            }

            // Parse the input line
            String[] segments = line.split("#");

            // Assuming input is always valid as per prompt (no specific validation required)
            String code = segments[0];
            String name = segments[1];
            int credits = Integer.parseInt(segments[2]); // Convert String to int
            String grade = segments[3];

            // Create a new Course object
            Course newCourse = new Course(code, name, credits, grade);

            // Store the Course object in the array
            courses[courseCount] = newCourse;
            courseCount++;
        }

        // Display all stored courses in the specified output format
        for (int i = 0; i < courseCount; i++) {
            System.out.println(courses[i]);
        }

        inputScanner.close();
    }
}
