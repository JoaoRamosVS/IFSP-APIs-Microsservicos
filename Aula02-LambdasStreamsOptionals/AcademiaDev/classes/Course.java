package AcademiaDev.classes;

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
}
