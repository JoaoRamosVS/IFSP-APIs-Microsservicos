package AcademiaDev.classes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import AcademiaDev.classes.enums.DifficultyLevel;
import AcademiaDev.classes.enums.Status;

public class Course {
    private String title;
    private String description;
    private String instructor;
    private Integer durationInHours;
    private DifficultyLevel difficultyLevel;
    private Status status;

    public Course(String title, String description, String instructor, Integer durationInHours, DifficultyLevel difficultyLevel, Status status) {
        this.title = title;
        this.description = description;
        this.instructor = instructor;
        this.durationInHours = durationInHours;
        this.difficultyLevel = difficultyLevel;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getInstructor() {
        return instructor;
    }

    public Integer getDurationInHours() {
        return durationInHours;
    }
    
    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public Status getStatus() {
        return status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
    
    public void setDurationInHours(Integer durationInHours) {
        this.durationInHours = durationInHours;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static void ListCoursesOrderByDifficultyLevel(HashMap<String, Course> coursesList) {
        List<Course> cursosOrdenadosPorDificuldade = coursesList.values()
                                                                .stream()
                                                                .sorted((c1, c2) -> c1.getDifficultyLevel().compareTo(c2.getDifficultyLevel()))
                                                                .toList();
        for (Course course : cursosOrdenadosPorDificuldade) {
            System.out.println("CURSO: " 
                               + course.getTitle() 
                               + " | CARGA HORÁRIA: " 
                               + course.getDurationInHours() 
                               + "\nDIFICULDADE: " + course.getDifficultyLevel()
                               + " | INSTRUTOR: " 
                               + course.getInstructor() 
                               + "\nDESCRIÇÃO: " 
                               + course.getDescription() 
                               + "\nSTATUS: " 
                               + course.getStatus()
                               + "\n");
        }
    }

    public static void listActiveCoursesInstructors(HashMap<String, Course> coursesList) {
        Set<String> activeCoursesInstructors = coursesList.values()
                                                            .stream()
                                                            .filter(c -> c.getStatus().equals(Status.ACTIVE))
                                                            .map(c -> c.getInstructor())
                                                            .collect(Collectors.toSet());

        for (String instructor : activeCoursesInstructors) {
            System.out.println(instructor + "\n");
        }
    }
}
