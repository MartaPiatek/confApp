package pl.martapiatek.confapp.domain;


public class CalendarEvent {


    private int id;
    private String date;
    private String location;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public CalendarEvent(int id, String date, String location, String title) {
        this.id = id;
        this.date = date;
        this.location = location;
        this.title = title;
    }

    public CalendarEvent(String date, String location, String title) {
        this.date = date;
        this.location = location;
        this.title = title;
    }
}



