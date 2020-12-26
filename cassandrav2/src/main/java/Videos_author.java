import java.util.Date;

public class Videos_author {
    private String email;
    private int video_id;
    private String upload;
    private String author;

    public Videos_author(String email, String upload, int video_id, String author) {
        this.email = email;
        this.video_id = video_id;
        this.upload = upload;
        this.author = author;
    }

    public String getEmail() {
        return email;
    }

    public int getVideo_id() {
        return video_id;
    }

    public String getUpload() {
        return upload;
    }

    public String getAuthor(){
        return author;
    }
}
