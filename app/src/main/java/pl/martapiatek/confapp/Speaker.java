package pl.martapiatek.confapp;


class Speaker {

    private int id;
    private String firstName;
    private String lastName;
    private String title;
    private String description;

    public Speaker(int id, String firstName, String lastName, String title, String description) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.description = description;
    }

    public Speaker(String firstName, String lastName, String title, String description) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.description = description;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
}
