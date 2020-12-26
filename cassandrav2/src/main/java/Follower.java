public class Follower {
    private int video_id;
    private String user_email;

    public Follower(int video_id, String user_email) {
        this.video_id = video_id;
        this.user_email = user_email;
    }

    public int getVideo_id() {
        return video_id;
    }

    public String getUser_email() {
        return user_email;
    }
}
