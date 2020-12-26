import java.util.Date;

public class Comments_video {
    private int video_id;
    private String user_email;
    private String username;
    private String comment;
    private String upload;

    public Comments_video(int video_id, String upload, String comment, String user_email, String username) {
        this.video_id = video_id;
        this.user_email = user_email;
        this.username = username;
        this.comment = comment;
        this.upload = upload;
    }

    public int getVideo_id() {
        return video_id;
    }

    public String getUser_email() {
        return user_email;
    }

    public String getUsername() {
        return username;
    }

    public String getComment() {
        return comment;
    }

    public String getUpload() {
        return upload;
    }
}
