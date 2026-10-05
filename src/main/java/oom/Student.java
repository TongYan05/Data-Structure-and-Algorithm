package oom;

import java.util.SplittableRandom;

public record Student(int id, String name, String major, double gpa) {
    public Student{
        if (id <= 0) {
            throw new IllegalArgumentException("id must be greater than 0");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null or blank");
        }
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException("gpa must be between 0.0 and 4.0");
        }
    }
    public String level(){
        if (gpa >= 3.5) return "Excellent";
        if (gpa >= 3.0) return "Good";
        if (gpa >= 2.0) return "Average";
        return "Needs Improvement";
    }
}
