package model;

import mythrows.UnavailableField;

public class Board {

    private int size;
    private Field[][] playground;

    private Board(int size) {
        this.size = size;
        this.playground = new Field[size][size];
    }

    static Board createBoard(int size) {
        Board board = new Board(size);
        board.fillBoard();
        return board;
    }

    private void fillBoard() {
        for (int i = 0; i < playground.length; i++) {
            for (int j = 0; j < playground.length; j++) {
                Field field = new Field();
                field.setSign(Sign.EMPTY);
                playground[i][j] = field;
            }
        }
    }

    int getSize() {
        return size;
    }

    public Field[][] getPlayground() {
        return playground;
    }

    void setSign(int x, int y, Sign sign) throws UnavailableField {
        if (playground[x][y].getSign() != Sign.EMPTY) {
            throw new UnavailableField("This field is already occupied.");
        } else {
            playground[x][y].setSign(sign);
        }
    }

    void showBoard() {
        for (int i = 0; i < playground.length; i++) {
            for (int j = 0; j < playground.length; j++) {
                if (playground[i][j].getSign() != Sign.EMPTY) {
                    System.out.printf("  %s  ", playground[i][j].getSign());
                } else {
                    System.out.printf("(%s,%s)", i, j);
                }
            }
            System.out.println();
        }
    }
}