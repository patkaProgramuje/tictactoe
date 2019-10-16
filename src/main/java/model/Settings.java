package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Settings {

    private Board board;

    public Settings() {
    }

    List<User> getUsers() {
        List<User> users = new ArrayList<>();
        int x = 1;
        while (x <= 2) {
            System.out.printf("Enter nick for user nr. %s:", x);
            String nick = new Scanner(System.in).next();
            User user = new User(nick);
            x++;
            users.add(user);
        }
        users.get(0).setSign(Sign.RING);
        users.get(0).setActive(true);
        users.get(1).setSign(Sign.CROSS);
        users.get(1).setActive(false);
        return users;
    }

    public void createBoardWithSize() {
        System.out.println("Enter size of board.");
        Scanner sc = new Scanner(System.in);
        String size = sc.next();
        while (!validateInput(size)) {
            System.out.println("Entered invalid data.");
            size = sc.next();
        }
        board = Board.createBoard(Integer.parseInt(size));
    }

    private boolean validateInput(String size) {
        try {
            Integer.parseInt(size);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Board getBoard() {
        return this.board;
    }
}
