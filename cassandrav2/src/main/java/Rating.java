public class Rating {
    private int review_id;
    private int video_id;
    private int value;

    public Rating(int review_id, int video_id, int value) {
        this.review_id = review_id;
        this.video_id = video_id;
        this.value = value;
    }

    public int getReview_id() {
        return review_id;
    }

    public int getVideo_id() {
        return video_id;
    }

    public int getValue() {
        return value;
    }
}
