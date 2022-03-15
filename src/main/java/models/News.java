package models;

public class News {
    private int id;
    private String title;
    private String content;
    private int departId;

    public News(int id, String title, String content, int departId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.departId = departId;
    }
    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
