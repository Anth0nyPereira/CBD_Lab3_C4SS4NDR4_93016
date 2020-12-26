import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class CassandraConnect {

    private Cluster cluster;
    private Session session;

    public CassandraConnect(String serverIp, String keyspace) {
        Cluster.Builder b = Cluster.builder().addContactPoints(serverIp);
        cluster = b.build();
        session = cluster.connect(keyspace);
    }

    public Session getSession() {
        return session;
    }

    public void close() {
        session.close();
        cluster.close();
    }


    public void createTableUser() {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ")
                .append("juser").append("(")
                .append("email text PRIMARY KEY, ")
                .append("username text,")
                .append("name text,")
                .append("reg_timestamp timestamp);");

        String query = sb.toString();
        session.execute(query);
    }

    public void createTableCommentsUsername() {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ")
                .append("jcomments_username").append("(")
                .append("user_email text, ")
                .append("user_username text, ")
                .append("video_id int, ")
                .append("comment text, ")
                .append("upload_timestamp timestamp, ")
                .append("PRIMARY KEY (user_username, upload_timestamp)) ")
                .append("WITH CLUSTERING ORDER BY (upload_timestamp DESC);");

        String query = sb.toString();
        session.execute(query);
    }

    public void createTableVideosAuthor() {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ")
                .append("jvideos_author").append("(")
                .append("user_email text, ")
                .append("author text, ")
                .append("video_id int, ")
                .append("upload_timestamp timestamp,")
                .append("PRIMARY KEY(user_email, upload_timestamp, video_id));");

        String query = sb.toString();
        session.execute(query);
    }

    public void createTableCommentsVideo() {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ")
                .append("jcomments_video").append("(")
                .append("video_id int, ")
                .append("user_email text, ")
                .append("user_username text, ")
                .append("comment text, ")
                .append("upload_timestamp timestamp, ")
                .append("PRIMARY KEY(video_id, upload_timestamp)) ")
                .append("WITH CLUSTERING ORDER BY (upload_timestamp DESC);");

        String query = sb.toString();
        session.execute(query);
    }

    public void createTableFollower() {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ")
                .append("jfollower").append("(")
                .append("video_id int, ")
                .append("user_email text, ")
                .append("PRIMARY KEY(video_id, user_email));");

        String query = sb.toString();
        session.execute(query);
    }

    public ResultSet alterUserData(String email, String new_name){
        // UPDATE emp SET emp_city='Delhi',emp_sal=50000
        //   WHERE emp_id=2;
        StringBuilder sb = new StringBuilder("UPDATE ")
                .append("juser ")
                .append("SET username='")
                .append(new_name)
                .append( "' WHERE email='")
                .append(email)
                .append("';");

        String query = sb.toString();
        session.execute(query);

        ResultSet rs = session.execute("SELECT * FROM juser;");
        return rs;
    }

    public void insertUser(User user) {
        StringBuilder sb = new StringBuilder("INSERT INTO ")
                .append("juser")
                .append("(email, name, reg_timestamp, username) ")
                .append("VALUES ('").append(user.getEmail()).append("', '")
                .append(user.getName()).append("', '")
                .append(user.getDate()).append("', '")
                .append(user.getUsername()).append("');");

        String query = sb.toString();
        session.execute(query);
    }

    public void insertCommentsUsername(Comments_username cu) {
        StringBuilder sb = new StringBuilder("INSERT INTO ")
                .append("jcomments_username")
                .append("(user_username, upload_timestamp, comment, user_email, video_id) ")
                .append("VALUES ('").append(cu.getUsername()).append("', '")
                .append(cu.getUpload()).append("', '")
                .append(cu.getComment()).append("', '")
                .append(cu.getUser_email()).append("', ")
                .append(cu.getVideo_id()).append(");");

        String query = sb.toString();
        session.execute(query);
    }

    public void insertVideosAuthor(Videos_author vidsa) {
        StringBuilder sb = new StringBuilder("INSERT INTO ")
                .append("jvideos_author")
                .append("(user_email, upload_timestamp, video_id, author) ")
                .append("VALUES ('").append(vidsa.getEmail()).append("', '")
                .append(vidsa.getUpload()).append("', ")
                .append(vidsa.getVideo_id()).append(", '")
                .append(vidsa.getAuthor()).append("');");

        String query = sb.toString();
        session.execute(query);
    }

    public void insertCommentsVideo(Comments_video cv) {
        StringBuilder sb = new StringBuilder("INSERT INTO ")
                .append("jcomments_video")
                .append("(video_id, upload_timestamp, comment, user_email, user_username) ")
                .append("VALUES (").append(cv.getVideo_id()).append(", '")
                .append(cv.getUpload()).append("', '")
                .append(cv.getComment()).append("', '")
                .append(cv.getUser_email()).append("', '")
                .append(cv.getUsername()).append("');");

        String query = sb.toString();
        session.execute(query);
    }

    public void insertFollower(Follower follower) {
        StringBuilder sb = new StringBuilder("INSERT INTO ")
                .append("jfollower")
                .append("(video_id, user_emaIl) ")
                .append("VALUES (").append(follower.getVideo_id()).append(", '")
                .append(follower.getUser_email()).append("');");

        String query = sb.toString();
        session.execute(query);
    }

    public ResultSet selectAllUsers(){
        ResultSet rs = session.execute("SELECT * from juser;");
        return rs;
    }
}
