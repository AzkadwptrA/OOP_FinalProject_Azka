import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<Message> messages;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.messages = new ArrayList<>();
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public List<Message> getMessages() {
        return messages;
    }
    public void addMessage(Message message) {
        messages.add(message);
    }
}