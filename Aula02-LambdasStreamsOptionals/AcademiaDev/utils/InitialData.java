package AcademiaDev.utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import AcademiaDev.classes.*;
import AcademiaDev.classes.enums.*;

public class InitialData {
    
    public static HashMap<String, User> getUsers() {
        HashMap<String, User> users = new HashMap<String, User>();
        users.put("alice@academia.com", new Admin("Alice Johnson", "alice@academia.com"));
        users.put("bob@academia.com", new Admin("Bob Smith", "bob@academia.com"));
        users.put("charlie@student.com", new Student("Charlie Brown", "charlie@student.com", SubscriptionPlan.BASIC_PLAN));
        users.put("diana@student.com", new Student("Diana Prince", "diana@student.com", SubscriptionPlan.PREMIUM_PLAN));
        users.put("eve@student.com", new Student("Eve Adams", "eve@student.com", SubscriptionPlan.BASIC_PLAN));
     
        return users;
    }

    public static HashMap<String,Student> getStudents() {
        HashMap<String, Student> students = new HashMap<String, Student>();
        students.put("charlie@student.com", new Student("Charlie Brown", "charlie@student.com", SubscriptionPlan.BASIC_PLAN));
        students.put("diana@student.com", new Student("Diana Prince", "diana@student.com", SubscriptionPlan.PREMIUM_PLAN));
        students.put("eve@student.com", new Student("Eve Adams", "eve@student.com", SubscriptionPlan.BASIC_PLAN));
        return students;
    }
    
    public static HashMap<String, Course> getCourses() {
        HashMap<String, Course> courses = new HashMap<String, Course>();
        courses.put("Java Basics", new Course("Java Basics", "Introduction to Java programming", "Matthew", 40, DifficultyLevel.BEGINNER, Status.ACTIVE));
        courses.put("Advanced Java", new Course("Advanced Java", "Deep dive into Java features", "Matthew", 60, DifficultyLevel.ADVANCED, Status.ACTIVE));
        courses.put("Database Design", new Course("Database Design", "Fundamentals of relational databases", "Carlos", 45, DifficultyLevel.INTERMEDIATE, Status.ACTIVE));
        courses.put("Web Development", new Course("Web Development", "Building websites with HTML, CSS and JS", "Ana", 55, DifficultyLevel.BEGINNER, Status.ACTIVE));
        courses.put("Python for Beginners", new Course("Python for Beginners", "Learn Python from scratch", "Maria Alice", 50, DifficultyLevel.BEGINNER, Status.INACTIVE));
        return courses;
    }
    
    public static List<Enrollment> getEnrollments() {
        HashMap<String, Student> students = getStudents();
        HashMap<String, Course> courses = getCourses();
        List<Enrollment> enrollments = new ArrayList<>();

        if (!students.isEmpty() && !courses.isEmpty()) {
            enrollments.add(new Enrollment(courses.get("Java Basics"), students.get("charlie@student.com")));
            enrollments.add(new Enrollment(courses.get("Advanced Java"), students.get("diana@student.com")));
            enrollments.add(new Enrollment(courses.get("Web Development"), students.get("charlie@student.com")));
            enrollments.add(new Enrollment(courses.get("Advanced Java"), students.get("charlie@student.com")));
        }
        return enrollments;
    }
    
    public static Queue<SupportTicket> getSupportTickets() {
        Queue<SupportTicket> supportTickets = new ArrayDeque<SupportTicket>();
        supportTickets.add(new SupportTicket("Login Issue", "Unable to log in to the platform"));
        supportTickets.add(new SupportTicket("Course Access", "Cannot access the advanced course"));
        supportTickets.add(new SupportTicket("Payment Problem", "Payment not processed"));
        return supportTickets;
    }
    
}
