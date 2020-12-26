
public class User {
    private String email;
    private String username;
    private String name;
    private String date;

    public User(String email, String username, String name, String date){
        this.email = email;
        this.username = username;
        this.name = name;
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }
}
