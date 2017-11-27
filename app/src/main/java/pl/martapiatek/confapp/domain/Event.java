package pl.martapiatek.confapp.domain;


import java.util.Date;

public class Event {


    private int id;
    private String date;
    private String location;
    private String title;
    private String description;
    //private Speaker speaker;
    private String speakerName;

    public Event(int id, String date, String location, String title, String description, String speakerName) {
        this.id = id;
        this.date = date;
        this.location = location;
        this.title = title;
        this.description = description;
        this.speakerName = speakerName;
    }
    public Event( String date, String location, String title, String description, String speakerName) {

        this.date = date;
        this.location = location;
        this.title = title;
        this.description = description;
        this.speakerName = speakerName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    // public Speaker getSpeaker() {
   //     return speaker;
   // }

   // public void setSpeaker(Speaker speaker) {
    //    this.speaker = speaker;
   // }
}
