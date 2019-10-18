package model;

class User {

    private String nick;
    private Sign sign;
    private boolean isActive;

    User(String nick) {
        this.nick = nick;
    }

    String getNick() {
        return nick;
    }

    Sign getSign() {
        return sign;
    }

    void setSign(Sign sign) {
        this.sign = sign;
    }

    boolean isActive() {
        return isActive;
    }

    void setActive(boolean active) {
        isActive = active;
    }
}
