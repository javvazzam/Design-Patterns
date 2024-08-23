package observer.observer1.basic;

enum Topic {
    TECHNOLOGIES, SPORTS, POLITICS
}

class NewsChannel {
    private News latestNews;

    public NewsChannel() {
    }

    public void publishNews(News news) {
        this.latestNews = news;
    }
}

class User {
    private String name;
    private Topic interest;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Topic getInterest() {
        return this.interest;
    }
}

class News {
    private String title;
    private String description;
    private Topic topic;

    public News(String title, String description) {
        this.title = title;
        this.description = description;
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

// I want to notify every user about every news about the topic they are interested in