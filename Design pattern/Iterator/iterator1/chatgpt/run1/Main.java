package Iterator.iterator1.chatgpt.run1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Profile class
class Profile {
    private String id;
    private String email;

    public Profile(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}

// Iterator for Facebook
class FacebookIterator implements Iterator<Profile> {
    private Iterator<Profile> iterator;

    public FacebookIterator(Iterator<Profile> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Profile next() {
        return iterator.next();
    }
}

// Iterator for LinkedIn
class LinkedInIterator implements Iterator<Profile> {
    private Iterator<Profile> iterator;

    public LinkedInIterator(Iterator<Profile> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Profile next() {
        return iterator.next();
    }
}

// Facebook class with Iterator
class Facebook {
    private List<Profile> friends;

    public Facebook() {
        friends = new ArrayList<>();
    }

    public void addFriend(Profile friend) {
        friends.add(friend);
    }

    public Iterator<Profile> iterator() {
        return new FacebookIterator(friends.iterator());
    }
}

// LinkedIn class with Iterator
class LinkedIn {
    private List<Profile> contacts;

    public LinkedIn() {
        contacts = new ArrayList<>();
    }

    public void addContact(Profile contact) {
        contacts.add(contact);
    }

    public Iterator<Profile> iterator() {
        return new LinkedInIterator(contacts.iterator());
    }
}

// SocialSpammer class
class SocialSpammer {
    public void sendMessages(Iterator<Profile> profiles, String message) {
        while (profiles.hasNext()) {
            Profile profile = profiles.next();
            System.out.println("Sending email to: " + profile.getEmail());
            System.out.println("Message: " + message);
            System.out.println();
        }
    }
}

// Main class to run the example
public class Main {
    public static void main(String[] args) {
        // Create some profiles
        Profile alice = new Profile("1", "alice@example.com");
        Profile bob = new Profile("2", "bob@example.com");

        // Facebook setup
        Facebook facebook = new Facebook();
        facebook.addFriend(alice);
        facebook.addFriend(bob);

        // LinkedIn setup
        LinkedIn linkedin = new LinkedIn();
        linkedin.addContact(alice);
        linkedin.addContact(bob);

        // Create a SocialSpammer
        SocialSpammer spammer = new SocialSpammer();

        // Send messages to Facebook friends
        System.out.println("Facebook spam:");
        spammer.sendMessages(facebook.iterator(), "Check out our new product!");

        // Send messages to LinkedIn contacts
        System.out.println("LinkedIn spam:");
        spammer.sendMessages(linkedin.iterator(), "We have a special offer for you!");
    }
}

//I want to create iterators in order to send spam to different types of profiles
