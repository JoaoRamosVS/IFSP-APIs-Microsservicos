package AcademiaDev.classes;

public class SupportTicket {
    private String title;
    private String message;

    public SupportTicket(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }
}
