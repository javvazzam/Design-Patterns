package observer.observer1.chatgpt.run1;

import java.util.ArrayList;
import java.util.List;

// Enum representing different news topics
enum Topic {
    TECHNOLOGIES, SPORTS, POLITICS
}

// Observer interface that defines the update method
interface Observer {
    void update(News news);
}

// User class that implements the Observer interface
class User implements Observer {
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

    @Override
    public void update(News news) {
        if (news.getTopic() == this.interest) {
            System.out.println("Notification to " + this.name + ": " + news.getTitle());
        }
    }
}

// News class representing a news item
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

// NewsChannel class that manages observers and publishes news
class NewsChannel {
    private News latestNews;
    private List<Observer> observers;

    public NewsChannel() {
        this.observers = new ArrayList<>();
    }

    public void subscribe(Observer observer) {
        this.observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        this.observers.remove(observer);
    }

    public void publishNews(News news) {
        this.latestNews = news;
        notifyAllObservers();
    }

    private void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(latestNews);
        }
    }
}

// Main class to demonstrate the functionality
public class Main {
    public static void main(String[] args) {
        // Create a news channel
        NewsChannel newsChannel = new NewsChannel();

        // Create users with different interests
        User user1 = new User("Alice", Topic.TECHNOLOGIES);
        User user2 = new User("Bob", Topic.SPORTS);
        User user3 = new User("Charlie", Topic.POLITICS);

        // Subscribe users to the news channel
        newsChannel.subscribe(user1);
        newsChannel.subscribe(user2);
        newsChannel.subscribe(user3);

        // Publish some news
        News news1 = new News("New AI breakthrough", "An AI has passed the Turing test!", Topic.TECHNOLOGIES);
        newsChannel.publishNews(news1);

        News news2 = new News("Football World Cup", "The finals are set!", Topic.SPORTS);
        newsChannel.publishNews(news2);

        News news3 = new News("Election Results", "The new president has been elected.", Topic.POLITICS);
        newsChannel.publishNews(news3);
    }
}
