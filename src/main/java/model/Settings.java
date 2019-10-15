package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Settings {

    public Settings() {
    }

    public List<User> getUsers() {
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

    public Board getBoard() {
        System.out.println("Enter size of board.");
        String size = new Scanner(System.in).next();
        Board board = null;
        try {
            board = Board.createBoard(Integer.parseInt(size));
        } catch (NumberFormatException e){
            System.out.println("Entered a wrong data. You should enter number.");
        }
        return board;
    }

}
