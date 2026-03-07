package AcademiaDev.classes;

public class Enrollment {
    private Course course;
    private Student student;
    private Double progress;

    public Enrollment(Course course, Student student) {
        this.course = course;
        this.student = student;
        this.progress = 0.0;
    }

    public Course getCourse() {
        return course;
    }

    public Double getProgress() {
        return progress;
    }

    public Student getStudent() {
        return student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void updateProgress(Double progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "CURSO: " 
               + this.getCourse().getTitle()
               + "\nPROGRESSO: " + this.getProgress() + "%"
               + "\n";
    }
}
