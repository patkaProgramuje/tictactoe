package main;

import model.Game;

public class Main {

    public static void main(String[] args) {
        do {
            new Game().init().startGame().showResult();
        } while (Game.playAgain());
    }
}