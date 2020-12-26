import java.util.Date;
import java.util.List;

public class Video {
    private int id;
    private String author;
    private String title;
    private Date upload;
    private String description;
    private List<String> tags;

    public Video(int id, String author, String title, Date upload, String description, List<String> tags){
        this.id = id;
        this.author = author;
        this.title = title;
        this.upload = upload;
        this.description = description;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Date getUpload() {
        return upload;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getTags() {
        return tags;
    }
}
