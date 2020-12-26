import java.util.Date;

public class Events {
    private String user_email;
    private int video_id;
    private String action;
    private Date upload;
    private int video_timestamp;

    public Events(String user_email, int video_id, String action, Date upload, int video_timestamp) {
        this.user_email = user_email;
        this.video_id = video_id;
        this.action = action;
        this.upload = upload;
        this.video_timestamp = video_timestamp;
    }

    public String getUser_email() {
        return user_email;
    }

    public int getVideo_id() {
        return video_id;
    }

    public String getAction() {
        return action;
    }

    public Date getUpload() {
        return upload;
    }

    public int getVideo_timestamp() {
        return video_timestamp;
    }
}
