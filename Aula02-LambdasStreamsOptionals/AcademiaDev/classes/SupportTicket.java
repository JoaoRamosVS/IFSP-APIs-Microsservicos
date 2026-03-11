package AcademiaDev.classes;

import AcademiaDev.classes.enums.TicketStatus;

public class SupportTicket {
    private String title;
    private String message;
    private TicketStatus status;
    private String response=null;

    public SupportTicket(String title, String message) {
        this.title = title;
        this.message = message;
        this.status = TicketStatus.PENDENTE;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public String getResponse() {
        return response;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
