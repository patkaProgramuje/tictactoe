package model;

import mythrows.UnavailableField;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Game {

    private List<User> users;
    private Board board;
    private Operations operations;

    public Game() {
    }

    public Game init() {
        List<User> users = new ArrayList<>();
        User firstUser = new User("patka");
        User secondUser = new User("marcin");
        users.add(firstUser);
        users.add(secondUser);

        Board board = Board.createBoard(3);
        Operations operations = new Operations(board.getPlayground());

        Game game = new Game(users, board, operations);
        game.settings();

        game.getBoard().showBoard();
        game.showMessageToUser("Welcome to my game. Start user with nick " +
                game.getActiveUser().getNick() + " and sign " + Sign.RING);

        return game;
    }

    public Game startGame() {
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

    public void showResult() {
        Sign sign = operations.checkIfIsWinner();
        if (sign != Sign.EMPTY) {
            User user = findUserWithSign(sign, users);
            showMessageToUser("Wygrał : " + user.getNick());
        } else if (operations.finishGame()) {
            showMessageToUser("Remis");
        }
    }

    public static boolean playAgain() {
        System.out.println("Do you want to play again ? y/n");
        String playAgain = new Scanner(System.in).next();
        return playAgain.equals("y");
    }

    private Board getBoard() {
        return board;
    }

    private Game(List<User> userList, Board board, Operations operations) {
        this.users = userList;
        this.board = board;
        this.operations = operations;
    }

    private void settings() {
        users.get(0).setSign(Sign.RING);
        users.get(1).setSign(Sign.CROSS);
        users.get(0).setActive(true);
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
                showMessageToUser("Wprowadziłeś złe współrzędne. Współrzędnne nie mogą byc wieksze niż " + (board.getSize() - 1));
            } else {
                return Optional.of(new Pair(x, y));
            }
        } catch (NumberFormatException e) {
            showMessageToUser("Wprowadziłeś niewłaściwy format danych");
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

    private User findUserWithSign(Sign sign, List<User> users) {
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
}
