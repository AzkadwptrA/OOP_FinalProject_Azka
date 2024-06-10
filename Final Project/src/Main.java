import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                chatRoom.addUser(new User(username, password));
                System.out.println("User registered successfully!");

            } else if (choice == 2) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                User user = chatRoom.findUserByUsername(username);

                if (user != null && user.getPassword().equals(password)) {
                    System.out.println("Login successful!");
                    while (true) {
                        System.out.println("1. Send Message");
                        System.out.println("2. View Messages");
                        System.out.println("3. Logout");
                        int userChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (userChoice == 1) {
                            System.out.print("Enter receiver username: ");
                            String receiverUsername = scanner.nextLine();
                            User receiver = chatRoom.findUserByUsername(receiverUsername);
                            if (receiver != null) {
                                System.out.print("Enter message: ");
                                String content = scanner.nextLine();
                                chatRoom.sendMessage(user, receiver, content);
                                System.out.println("Message sent!");
                            } else {
                                System.out.println("User not found!");
                            }

                        } else if (userChoice == 2) {
                            System.out.print("Enter username to view message history: ");
                            String otherUsername = scanner.nextLine();
                            User otherUser = chatRoom.findUserByUsername(otherUsername);
                            if (otherUser != null) {
                                List<Message> history = chatRoom.getMessageHistory(user, otherUser);
                                for (Message message : history) {
                                    System.out.println(message.getTimestamp() + " " + message.getSender().getUsername() + ": " + message.getContent());
                                }
                            } else {
                                System.out.println("User not found!");
                            }

                        } else if (userChoice == 3) {
                            System.out.println("Logged out!");
                            break;
                        }
                    }

                } else {
                    System.out.println("Invalid username or password!");
                }

            } else if (choice == 3) {
                break;
            }
        }
    }
}