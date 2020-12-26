import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

import java.util.Date;

public class CassandraMain {
    public static void main(String[] args){
        // Escolhidas tabelas User, Videos_author, Comments_video, Comments_username e Follower
        // Initialize
        String serverIp = "127.0.0.1";
        String keyspace = "ex3";
        CassandraConnect cc = new CassandraConnect(serverIp, keyspace);

        // Data
        User user1 = new User("user1@ua.pt", "user1", "RealName1", "2020-12-26 12:02:29.234000+0000");
        User user2 = new User("user2@ua.pt", "user2", "RealName2", "2020-12-26 12:02:29.234000+0000");
        User user3 = new User("user3@ua.pt", "user3", "RealName3", "2020-12-26 12:02:29.234000+0000");

        Videos_author va1 = new Videos_author("user1@ua.pt","2020-12-26 12:14:43.802000+0000", 1, "user1");
        Videos_author va2 = new Videos_author("user2@ua.pt","2020-12-26 12:14:43.803000+0000", 2, "user2");

        Comments_video cv1 = new Comments_video(2, "2020-12-26 14:43:59.715000+0000", "Comment 9", "user12@ua.pt", "user12");
        Comments_video cv2 = new Comments_video(2, "2020-12-26 14:43:59.700000+0000", "Comment 3", "user4@ua.pt", "user4");
        Comments_video cv3 = new Comments_video(2,  "2020-12-26 14:43:59.698000+0000", "Comment 2", "user2@ua.pt", "user2");

        Comments_username cu1 = new Comments_username("user2", "2020-12-26 12:44:34.936000+0000", "Bye", "user2@ua.pt", 12);
        Comments_username cu2 = new Comments_username("user2", "2020-12-26 12:44:34.937000+0000", "Cya", "user2@ua.pt", 6);

        Follower f1 = new Follower(2,"user1@ua.pt");
        Follower f2 = new Follower(2,"user4@ua.pt");
        Follower f3 = new Follower(2,"user6@ua.pt");

        // Creating tables
        cc.createTableUser();
        cc.createTableCommentsUsername();
        cc.createTableFollower();
        cc.createTableCommentsVideo();
        cc.createTableVideosAuthor();


        // Inserting data into tables
        cc.insertUser(user1);
        cc.insertUser(user2);
        cc.insertUser(user3);

        cc.insertVideosAuthor(va1);
        cc.insertVideosAuthor(va2);

        cc.insertCommentsVideo(cv1);
        cc.insertCommentsVideo(cv2);
        cc.insertCommentsVideo(cv3);

        cc.insertCommentsUsername(cu1);
        cc.insertCommentsUsername(cu2);

        cc.insertFollower(f1);
        cc.insertFollower(f2);
        cc.insertFollower(f3);

        // Alter data (users)
        System.out.println("1) SELECT* from juser;");
        ResultSet res1 = cc.alterUserData("user1@ua.pt", "Anthony");
        for (Row row : res1) {
            System.out.println(row);
        }
        ResultSet res2 = cc.alterUserData("user1@ua.pt", "user1");
        System.out.println();

        //Pesquisa de registos (users)
        System.out.println("2) SELECT* from juser;");
        ResultSet rss = cc.selectAllUsers();
        for (Row row : rss) {
            System.out.println(row);
        }
        System.out.println();

        // Queries
        System.out.println("SELECT * FROM jvideos_author WHERE user_email = 'user1@ua.pt';");
        ResultSet rs1 = cc.getSession().execute("SELECT * FROM jvideos_author WHERE user_email = 'user1@ua.pt';");
        for (Row row : rs1) {
            System.out.println(row);
        }
        System.out.println();
        System.out.println("SELECT * FROM jcomments_username  WHERE user_username = 'user2';");
        ResultSet rs2 = cc.getSession().execute("SELECT * FROM jcomments_username  WHERE user_username = 'user2';");
        for (Row row : rs2) {
            System.out.println(row);
        }
        System.out.println();
        System.out.println("SELECT * FROM jcomments_video  WHERE video_id = 2;");
        ResultSet rs3 = cc.getSession().execute("SELECT * FROM jcomments_video  WHERE video_id = 2;");
        for (Row row : rs3) {
            System.out.println(row);
        }

        System.out.println();
        System.out.println("SELECT * from jfollower  WHERE video_id = 2;");
        ResultSet rs4 = cc.getSession().execute("SELECT * from jfollower  WHERE video_id = 2;");
        for (Row row : rs4) {
            System.out.println(row);
        }







    }

}
