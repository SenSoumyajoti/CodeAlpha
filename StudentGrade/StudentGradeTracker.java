package p2;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    private ArrayList<Double> grades;

    public StudentGradeTracker() {
        grades = new ArrayList<>();
    }

    // Add grades to the list
    public void addGrade(double grade) {
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
        } else {
            System.out.println("Invalid grade. Please enter a value between 0 and 100.");
        }
    }

    // Calculate average grade
    public double calculateAverage() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return (grades.size() > 0) ? sum / grades.size() : 0;
    }

    // Get the highest grade
    public double getHighestGrade() {
        double highest = Double.MIN_VALUE;
        for (double grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return (grades.size() > 0) ? highest : 0;
    }

    // Get the lowest grade
    public double getLowestGrade() {
        double lowest = Double.MAX_VALUE;
        for (double grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return (grades.size() > 0) ? lowest : 0;
    }

    // Display all grades
    public void displayGrades() {
        System.out.println("Grades: " + grades);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGradeTracker tracker = new StudentGradeTracker();

        System.out.println("Enter student grades (-1 to finish):");

        while (true) {
            System.out.print("Grade: ");
            double grade = scanner.nextDouble();
            if (grade == -1) break;
            tracker.addGrade(grade);
        }

        // Display grades and statistics
        tracker.displayGrades();
        System.out.printf("Average Grade: %.2f%n", tracker.calculateAverage());
        System.out.printf("Highest Grade: %.2f%n", tracker.getHighestGrade());
        System.out.printf("Lowest Grade: %.2f%n", tracker.getLowestGrade());

        scanner.close();
    }
}

