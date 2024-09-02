package chainofresposability.antipattern;

class User {
    private String password;
    private String twoFactorCode;
    private String fingerprint;

    public User(String password, String twoFactorCode, String fingerprint) {
        this.password = password;
        this.twoFactorCode = twoFactorCode;
        this.fingerprint = fingerprint;
    }

    public String getPassword() {
        return password;
    }

    public String getTwoFactorCode() {
        return twoFactorCode;
    }

    public String getFingerprint() {
        return fingerprint;
    }
}

class AuthenticationService {
    
    public boolean authenticate(User user) {
        if (!user.getPassword().equals("correctPassword")) {
            System.out.println("Password authentication failed.");
            return false;
        }
        System.out.println("Password authenticated.");
        
        if (!user.getTwoFactorCode().equals("123456")) {
            System.out.println("2FA authentication failed.");
            return false;
        }
        System.out.println("2FA authenticated.");
        
        if (!user.getFingerprint().equals("validFingerprint")) {
            System.out.println("Fingerprint authentication failed.");
            return false;
        }
        System.out.println("Fingerprint authenticated.");

        return true;
    }
}

class AuthenticationExample {
    public static void main(String[] args) {
        User user = new User("correctPassword", "123456", "validFingerprint");

        AuthenticationService authService = new AuthenticationService();
        if (authService.authenticate(user)) {
            System.out.println("User authenticated successfully.");
        } else {
            System.out.println("Authentication failed.");
        }
    }
}

