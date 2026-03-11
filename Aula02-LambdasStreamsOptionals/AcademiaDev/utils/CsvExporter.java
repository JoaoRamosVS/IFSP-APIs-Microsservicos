package AcademiaDev.utils;

import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import AcademiaDev.classes.Course;
import AcademiaDev.classes.Enrollment;
import AcademiaDev.classes.Student;
import AcademiaDev.classes.SupportTicket;

/**
 * Utilitário para exportar dados em formato CSV com colunas selecionáveis dinamicamente.
 */
public final class CsvExporter {

    private CsvExporter() {}

    public static String escapeCsvValue(Object value) {
        if (value == null) return "";
        String s = value.toString();
        if (s.contains(",") || s.contains("\"") || s.contains("\n") || s.contains("\r")) {
            return "\"" + s.replace("\"", "\"\"") + "\"";
        }
        return s;
    }

    private static String buildCsvLine(List<?> values) {
        return values.stream()
                .map(CsvExporter::escapeCsvValue)
                .collect(Collectors.joining(","));
    }

    // ---------- Alunos (Student) ----------
    public static final List<String> STUDENT_COLUMNS = List.of(
            "nome", "email", "plano"
    );

    public static String exportStudentsToCsv(Collection<Student> students, List<String> columns) {
        List<String> validColumns = columns.stream()
                .filter(STUDENT_COLUMNS::contains)
                .distinct()
                .toList();
        if (validColumns.isEmpty()) validColumns = STUDENT_COLUMNS;

        StringBuilder sb = new StringBuilder();
        sb.append(buildCsvLine(validColumns)).append("\n");

        for (Student s : students) {
            List<Object> row = validColumns.stream()
                    .map(col -> getStudentColumnValue(s, col))
                    .toList();
            sb.append(buildCsvLine(row)).append("\n");
        }
        return sb.toString();
    }

    private static Object getStudentColumnValue(Student s, String column) {
        return switch (column) {
            case "nome" -> s.getName();
            case "email" -> s.getEmail();
            case "plano" -> s.getSubscriptionPlan();
            default -> "";
        };
    }

    // ---------- Cursos (Course) ----------
    public static final List<String> COURSE_COLUMNS = List.of(
            "titulo", "descricao", "instrutor", "cargaHoraria", "dificuldade", "status"
    );

    public static String exportCoursesToCsv(Collection<Course> courses, List<String> columns) {
        List<String> validColumns = columns.stream()
                .filter(COURSE_COLUMNS::contains)
                .distinct()
                .toList();
        if (validColumns.isEmpty()) validColumns = COURSE_COLUMNS;

        StringBuilder sb = new StringBuilder();
        sb.append(buildCsvLine(validColumns)).append("\n");

        for (Course c : courses) {
            List<Object> row = validColumns.stream()
                    .map(col -> getCourseColumnValue(c, col))
                    .toList();
            sb.append(buildCsvLine(row)).append("\n");
        }
        return sb.toString();
    }

    private static Object getCourseColumnValue(Course c, String column) {
        return switch (column) {
            case "titulo" -> c.getTitle();
            case "descricao" -> c.getDescription();
            case "instrutor" -> c.getInstructor();
            case "cargaHoraria" -> c.getDurationInHours();
            case "dificuldade" -> c.getDifficultyLevel();
            case "status" -> c.getStatus();
            default -> "";
        };
    }

    // ---------- Matrículas (Enrollment) ----------
    public static final List<String> ENROLLMENT_COLUMNS = List.of(
            "aluno", "emailAluno", "curso", "progresso"
    );

    public static String exportEnrollmentsToCsv(Collection<Enrollment> enrollments, List<String> columns) {
        List<String> validColumns = columns.stream()
                .filter(ENROLLMENT_COLUMNS::contains)
                .distinct()
                .toList();
        if (validColumns.isEmpty()) validColumns = ENROLLMENT_COLUMNS;

        StringBuilder sb = new StringBuilder();
        sb.append(buildCsvLine(validColumns)).append("\n");

        for (Enrollment e : enrollments) {
            List<Object> row = validColumns.stream()
                    .map(col -> getEnrollmentColumnValue(e, col))
                    .toList();
            sb.append(buildCsvLine(row)).append("\n");
        }
        return sb.toString();
    }

    private static Object getEnrollmentColumnValue(Enrollment e, String column) {
        return switch (column) {
            case "aluno" -> e.getStudent().getName();
            case "emailAluno" -> e.getStudent().getEmail();
            case "curso" -> e.getCourse().getTitle();
            case "progresso" -> e.getProgress();
            default -> "";
        };
    }

    // ---------- Tickets de suporte ----------
    public static final List<String> TICKET_COLUMNS = List.of(
            "assunto", "mensagem"
    );

    public static String exportTicketsToCsv(Queue<SupportTicket> tickets, List<String> columns) {
        List<String> validColumns = columns.stream()
                .filter(TICKET_COLUMNS::contains)
                .distinct()
                .toList();
        if (validColumns.isEmpty()) validColumns = TICKET_COLUMNS;

        StringBuilder sb = new StringBuilder();
        sb.append(buildCsvLine(validColumns)).append("\n");

        List<SupportTicket> ticketList = StreamSupport.stream(tickets.spliterator(), false).toList();
        for (SupportTicket t : ticketList) {
            List<Object> row = validColumns.stream()
                    .map(col -> getTicketColumnValue(t, col))
                    .toList();
            sb.append(buildCsvLine(row)).append("\n");
        }
        return sb.toString();
    }

    private static Object getTicketColumnValue(SupportTicket t, String column) {
        return switch (column) {
            case "assunto" -> t.getTitle();
            case "mensagem" -> t.getMessage();
            default -> "";
        };
    }
}