package observer.observer1.chatgpt.run2;

import java.util.ArrayList;
import java.util.List;

// Enum representing different news topics
enum Topic {
    TECHNOLOGIES, SPORTS, POLITICS
}

// Class representing a News Channel that publishes news and notifies users
class NewsChannel {
    private News latestNews;
    private List<User> users;

    public NewsChannel() {
        this.users = new ArrayList<>();
    }

    // Method to subscribe a user to the news channel
    public void subscribe(User user) {
        this.users.add(user);
    }

    // Method to publish news and notify users interested in that topic
    public void publishNews(News news) {
        this.latestNews = news;
        notifyUsers(news);
    }

    // Private method to notify users about the news if it matches their interest
    private void notifyUsers(News news) {
        for (User user : users) {
            if (user.getInterest() == news.getTopic()) {
                System.out.println("Notifying " + user.getName() + " about news: " + news.getTitle());
            }
        }
    }
}

// Class representing a User who subscribes to a news channel
class User {
    private String name;
    private Topic interest;

    public User(String name, Topic interest) {
        this.name = name;
        this.interest = interest;
    }

    public String getName() {
        return this.name;
    }

    public Topic getInterest() {
        return this.interest;
    }
}

// Class representing a News article with a title, description, and topic
class News {
    private String title;
    private String description;
    private Topic topic;

    public News(String title, String description, Topic topic) {
        this.title = title;
        this.description = description;
        this.topic = topic;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public Topic getTopic() {
        return this.topic;
    }
}

// Main class to demonstrate the use of the above classes
public class Main {
    public static void main(String[] args) {
        // Create some users with their interests
        User user1 = new User("Alice", Topic.TECHNOLOGIES);
        User user2 = new User("Bob", Topic.SPORTS);
        User user3 = new User("Charlie", Topic.POLITICS);

        // Create a news channel and subscribe users
        NewsChannel channel = new NewsChannel();
        channel.subscribe(user1);
        channel.subscribe(user2);
        channel.subscribe(user3);

        // Publish some news
        News news1 = new News("New AI Technology", "Latest advancements in AI.", Topic.TECHNOLOGIES);
        channel.publishNews(news1);

        News news2 = new News("Sports Championship", "Highlights of the sports championship.", Topic.SPORTS);
        channel.publishNews(news2);

        News news3 = new News("Election Results", "Latest election results.", Topic.POLITICS);
        channel.publishNews(news3);
    }
}

