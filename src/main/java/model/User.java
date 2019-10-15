package model;

public class User {

    private String nick;
    private Sign sign;
    private boolean isActive;

    public User(String nick) {
        this.nick = nick;
    }

    public String getNick() {
        return nick;
    }

    public Sign getSign() {
        return sign;
    }

    public void setSign(Sign sign) {
        this.sign = sign;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
