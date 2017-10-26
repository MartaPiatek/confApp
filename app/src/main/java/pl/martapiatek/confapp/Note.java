package pl.martapiatek.confapp;


public class Note {

    private int id;
    private String eventTitle;
    private String content;
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Note(int id, String eventTitle, String content, String date) {
        this.id = id;
        this.eventTitle = eventTitle;
        this.content = content;
        this.date = date;
    }

    public Note(String eventTitle, String content, String date) {
        this.eventTitle = eventTitle;
        this.content = content;
        this.date = date;
    }
}
