package main;

import model.Game;
import model.Operations;
import model.Settings;

public class Main {

    public static void main(String[] args) {
        do {
            Settings settings = new Settings();
            Operations operations = new Operations(settings.getBoard().getPlayground());
            new Game()
                    .init(settings)
                    .showInformation()
                    .startGame(operations)
                    .showResult(operations);
        } while (Game.playAgain());
    }
}