package Iterator.iterator1.chatgpt.run2;

import java.util.ArrayList;
import java.util.List;

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
}

class SocialSpammer {
    public void sendMessages(List<Profile> profiles, String message) {
        for (Profile profile : profiles) {
            System.out.println("Sending email to: " + profile.getEmail());
            System.out.println("Message: " + message);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create some profiles
        Profile profile1 = new Profile("1", "user1@example.com");
        Profile profile2 = new Profile("2", "user2@example.com");
        Profile profile3 = new Profile("3", "user3@example.com");
        Profile profile4 = new Profile("4", "user4@example.com");

        // Add profiles to Facebook
        Facebook facebook = new Facebook();
        facebook.addFriend(profile1);
        facebook.addFriend(profile2);

        // Add profiles to LinkedIn
        LinkedIn linkedIn = new LinkedIn();
        linkedIn.addContact(profile3);
        linkedIn.addContact(profile4);

        // Create SocialSpammer instance
        SocialSpammer spammer = new SocialSpammer();

        // Send spam to all Facebook friends
        System.out.println("Sending spam to Facebook friends:");
        spammer.sendMessages(facebook.getFriends(), "Hello Facebook friend!");

        // Send spam to all LinkedIn contacts
        System.out.println("\nSending spam to LinkedIn contacts:");
        spammer.sendMessages(linkedIn.getContacts(), "Hello LinkedIn contact!");
    }
}

