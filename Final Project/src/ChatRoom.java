import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private List<User> users;
    private List<Message> messages;

    public ChatRoom() {
        this.users = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public void sendMessage(User sender, User receiver, String content) {
        Message message = new Message(sender, receiver, content);
        sender.addMessage(message);
        receiver.addMessage(message);
        messages.add(message);
    }

    public List<Message> getMessageHistory(User user1, User user2) {
        List<Message> history = new ArrayList<>();
        for (Message message : messages) {
            if ((message.getSender().equals(user1) && message.getReceiver().equals(user2)) ||
                    (message.getSender().equals(user2) && message.getReceiver().equals(user1))) {
                history.add(message);
            }
        }
        return history;
    }
}