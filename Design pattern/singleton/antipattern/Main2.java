package singleton.antipattern;

import java.util.HashMap;
import java.util.Map;

class UserSettings {
    private String theme;
    private String language;

    public UserSettings(String theme, String language) {
        this.theme = theme;
        this.language = language;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "UserSettings{" +
                "theme='" + theme + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}

class UserSettingsManager {
    private Map<String, UserSettings> userSettingsMap = new HashMap<>();

    public UserSettings getUserSettings(String userId) {
        return userSettingsMap.getOrDefault(userId, new UserSettings("light", "en"));
    }

    public void updateUserSettings(String userId, String theme, String language) {
        userSettingsMap.put(userId, new UserSettings(theme, language));
    }
}

class Main {
    public static void main(String[] args) {
        UserSettingsManager settingsManager = new UserSettingsManager();

        settingsManager.updateUserSettings("user1", "dark", "en");
        settingsManager.updateUserSettings("user2", "light", "es");

        UserSettings user1Settings = settingsManager.getUserSettings("user1");
        UserSettings user2Settings = settingsManager.getUserSettings("user2");

        System.out.println("Configuración de user1: " + user1Settings);
        System.out.println("Configuración de user2: " + user2Settings);
    }
}

