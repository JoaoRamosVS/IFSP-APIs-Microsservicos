package AcademiaDev.classes;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import AcademiaDev.classes.enums.DifficultyLevel;
import AcademiaDev.exceptions.EnrollmentException;

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

    public static void listStudentsEnrollments(List<Enrollment> enrollmentsList, String studentEmail){
        List<Enrollment> matriculasAlunoLogado = enrollmentsList.stream()
                                                .filter(enrollment -> enrollment.getStudent().getEmail().equals(studentEmail))
                                                .toList();

        for (Enrollment studentEnrollment : matriculasAlunoLogado) {
            System.out.println("Curso - " + studentEnrollment.getCourse().getTitle());
        }
    }

    public static Double getStudentsProgressAverage(List<Enrollment> enrollmentsList) {
        return enrollmentsList.stream()
                              .mapToDouble(e -> e.getProgress())
                              .average()
                              .orElseThrow(() -> new EnrollmentException("Não foi possível calcular a média."));
    }

    public static void showStudentWithMostEnrollments(List<Enrollment> enrollmentsList) {
        Optional<Student> studentWithMostEnrollments = enrollmentsList.stream()
                                                                      .collect(Collectors.groupingBy(Enrollment::getStudent, Collectors.counting()))
                                                                      .entrySet()
                                                                      .stream()
                                                                      .max(Comparator.comparingLong(Map.Entry::getValue))
                                                                      .map(Map.Entry::getKey);
        
    }

    @Override
    public String toString() {
        return "CURSO: " 
               + this.getCourse().getTitle()
               + "\nPROGRESSO: " + this.getProgress() + "%"
               + "\n";
    }
}
