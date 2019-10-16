package model;

import mythrows.UnavailableField;

import java.util.*;

public class Game {

    private List<User> users;
    private Board board;

    public Game() {
    }

    public Game init(Settings settings) {

        List<User> users = settings.getUsers();
        Board board = settings.getBoard();
        return new Game(users, board);
    }

    public Game showInformation() {
        getBoard().showBoard();
        showMessageToUser("Welcome to my game. Start user with nick " +
                getActiveUser().getNick() + " and sign " + Sign.RING);
        return this;
    }

    public Game startGame(Operations operations) {
        do {
            getValidDataFromUser().ifPresent(this::setSignToBoardAndChangeUser);
        } while (operations.checkIfIsWinner() == Sign.EMPTY && !operations.finishGame());
        return this;
    }

    private void setSignToBoardAndChangeUser(Pair pair) {
        try {
            board.setSign(pair.getX(), pair.getY(), getActiveUser().getSign());
        } catch (UnavailableField unavailableField) {
            showMessageToUser(unavailableField.getMessage());
        }
        board.showBoard();
        changeActiveUser();
    }

    public void showResult(Operations operations) {
        Sign sign = operations.checkIfIsWinner();
        if (sign != Sign.EMPTY) {
            User user = findUserWithSign(sign, users);
            showMessageToUser("The winner is : " + user.getNick());
        } else if (operations.finishGame()) {
            showMessageToUser("Draw.");
        }
    }

    public static boolean playAgain() {
        System.out.println("Do you want to play again ? y/n");
        String playAgain = new Scanner(System.in).next();
        return playAgain.equals("y");
    }

    Board getBoard() {
        return this.board;
    }

    Game(List<User> userList, Board board) {
        this.users = userList;
        this.board = board;
    }

    private User getActiveUser() {
        User active = null;
        for (User user : users) {
            if (user.isActive()) active = user;
        }
        return active;
    }

    private Optional<Pair> getValidDataFromUser() {
        String xValue = new Scanner(System.in).next();
        String yValue = new Scanner(System.in).next();
        try {
            int x = Integer.parseInt(xValue);
            int y = Integer.parseInt(yValue);
            if (x >= board.getSize() || y >= board.getSize()) {
                showMessageToUser("You entered wrong co-ordinates. Co-ordinates values can not be more than " + (board.getSize() - 1));
            } else {
                return Optional.of(new Pair(x, y));
            }
        } catch (NumberFormatException e) {
            showMessageToUser("You entered the wrong data.");
        }
        return Optional.empty();
    }

    private void changeActiveUser() {
        for (User user : users) {
            if (user.isActive()) {
                user.setActive(false);
            } else {
                user.setActive(true);
            }
        }
    }

    User findUserWithSign(Sign sign, List<User> users) {
        User user = null;
        for (User i : users) {
            if (i.getSign().equals(sign))
                user = i;
        }
        return user;
    }

    private void showMessageToUser(String s) {
        System.out.println(s);
    }

    private class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() {
            return x;
        }

        int getY() {
            return y;
        }
    }

    public List<User> getUsers() {
        return users;
    }
}
