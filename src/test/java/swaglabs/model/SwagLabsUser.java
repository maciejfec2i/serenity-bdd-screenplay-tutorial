package swaglabs.model;

public enum SwagLabsUser {
    STANDARD_USER("standard_user", "secret_sauce");

    public final String username;
    public final String password;

    SwagLabsUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
