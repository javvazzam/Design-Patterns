package Iterator.iterator1.basic;

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