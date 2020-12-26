import java.util.Date;

public class Comments_username {
    private String user_email;
    private String username;
    private int video_id;
    private String comment;
    private String upload;

    public Comments_username(String username, String upload, String comment, String user_email, int video_id) {
        this.user_email = user_email;
        this.username = username;
        this.video_id = video_id;
        this.comment = comment;
        this.upload = upload;
    }

    public String getUser_email() {
        return user_email;
    }

    public String getUsername() {
        return username;
    }

    public int getVideo_id() {
        return video_id;
    }

    public String getComment() {
        return comment;
    }

    public String getUpload() {
        return upload;
    }
}
