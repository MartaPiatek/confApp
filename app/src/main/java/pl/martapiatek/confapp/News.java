package pl.martapiatek.confapp;

public class News {


    private int id;
    private String date;
    private String title;
    private String content;
    private String place;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public News(String date, String title, String content) {
        this.date = date;
        this.title = title;
        this.content = content;
    }

    public News(String date, String title, String content, String place) {
        this.date = date;
        this.title = title;
        this.content = content;
        this.place = place;
    }
}
