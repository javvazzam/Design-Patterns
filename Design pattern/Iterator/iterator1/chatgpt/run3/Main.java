package Iterator.iterator1.chatgpt.run3;

import java.util.ArrayList;
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

// Iterator interface
interface ProfileIterator {
    boolean hasNext();
    Profile getNext();
    void reset();
}

// Facebook Iterator class
class FacebookIterator implements ProfileIterator {
    private List<Profile> friends;
    private int currentPosition = 0;

    public FacebookIterator(List<Profile> friends) {
        this.friends = friends;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < friends.size();
    }

    @Override
    public Profile getNext() {
        if (!hasNext()) {
            return null;
        }
        return friends.get(currentPosition++);
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }
}

// Facebook class
class Facebook {
    private List<Profile> friends;

    public Facebook() {
        friends = new ArrayList<>();
    }

    public void addFriend(Profile friend) {
        friends.add(friend);
    }

    public List<Profile> getFriends() {
        return friends;
    }

    public ProfileIterator createIterator() {
        return new FacebookIterator(friends);
    }
}

// LinkedIn Iterator class
class LinkedInIterator implements ProfileIterator {
    private List<Profile> contacts;
    private int currentPosition = 0;

    public LinkedInIterator(List<Profile> contacts) {
        this.contacts = contacts;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < contacts.size();
    }

    @Override
    public Profile getNext() {
        if (!hasNext()) {
            return null;
        }
        return contacts.get(currentPosition++);
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }
}

// LinkedIn class
class LinkedIn {
    private List<Profile> contacts;

    public LinkedIn() {
        contacts = new ArrayList<>();
    }

    public void addContact(Profile contact) {
        contacts.add(contact);
    }

    public List<Profile> getContacts() {
        return contacts;
    }

    public ProfileIterator createIterator() {
        return new LinkedInIterator(contacts);
    }
}

// SocialSpammer class
class SocialSpammer {
    public void sendMessages(ProfileIterator iterator, String message) {
        while (iterator.hasNext()) {
            Profile profile = iterator.getNext();
            System.out.println("Sending email to: " + profile.getEmail());
            System.out.println("Message: " + message);
        }
    }
}

// Main class to demonstrate usage
public class Main {
    public static void main(String[] args) {
        // Creating Facebook instance and adding friends
        Facebook facebook = new Facebook();
        facebook.addFriend(new Profile("1", "friend1@facebook.com"));
        facebook.addFriend(new Profile("2", "friend2@facebook.com"));

        // Creating LinkedIn instance and adding contacts
        LinkedIn linkedIn = new LinkedIn();
        linkedIn.addContact(new Profile("1", "contact1@linkedin.com"));
        linkedIn.addContact(new Profile("2", "contact2@linkedin.com"));

        // Creating SocialSpammer instance
        SocialSpammer spammer = new SocialSpammer();

        // Sending messages to Facebook friends
        System.out.println("Sending messages to Facebook friends:");
        ProfileIterator fbIterator = facebook.createIterator();
        spammer.sendMessages(fbIterator, "Hello Facebook friends!");

        // Sending messages to LinkedIn contacts
        System.out.println("\nSending messages to LinkedIn contacts:");
        ProfileIterator lnIterator = linkedIn.createIterator();
        spammer.sendMessages(lnIterator, "Hello LinkedIn contacts!");
    }
}

