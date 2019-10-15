package model;

public class Operations {

    private Field[][] array;
    private int length;

    public Operations(Field[][] field) {
        this.array = field;
        this.length = array.length;
    }

    public boolean finishGame() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j].getSign() == Sign.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public Sign checkIfIsWinner() {
        if (checkHorizontal() != Sign.EMPTY) {
            return checkHorizontal();
        } else if (checkVertical() != Sign.EMPTY) {
            return checkVertical();
        } else if (checkDownDiagonal() != Sign.EMPTY) {
            return checkDownDiagonal();
        } else {
            return checkUpDiagonal();
        }
    }

    private Sign checkVertical() {
        int subArray = 1;
        int j = 0;
        while (j < array.length) {
            for (int i = 0; i < array.length; i++) {
                if (i < array.length - 1) {
                    if (array[i][j].getSign().sign.equals(array[i + 1][j].getSign().sign)) {
                        subArray += 1;
                        if (subArray == length) {
                            return array[i][j].getSign();
                        }
                    } else {
                        subArray = 1;
                    }
                }
            }
            j += 1;
        }
        return Sign.EMPTY;
    }

    private Sign checkUpDiagonal() {
        int subArray = 1;
        int j = 0;
        for (int i = array.length - 1; i > 0; i--) {
            if (j < array.length - 1) {
                if (array[i][j].getSign().sign.equals(array[i - 1][j + 1].getSign().sign)) {
                    subArray += 1;
                    if (subArray == length) {
                        return array[i][j].getSign();
                    }
                } else {
                    subArray = 1;
                }
            }
            j += 1;
        }
        return Sign.EMPTY;
    }

    private Sign checkHorizontal() {
        int subArray = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (j < array.length - 1) {
                    if (array[i][j].getSign().sign.equals(array[i][j + 1].getSign().sign)) {
                        subArray += 1;
                        if (subArray == length) {
                            return array[i][j].getSign();
                        }
                    } else {
                        subArray = 1;
                    }
                }
            }
        }
        return Sign.EMPTY;
    }

    private Sign checkDownDiagonal() {
        int subArray = 1;
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (j < array.length - 1) {
                if (array[i][j].getSign().sign.equals(array[i + 1][j + 1].getSign().sign)) {
                    subArray += 1;
                    if (subArray == length) {
                        return array[i][j].getSign();
                    }
                } else {
                    subArray = 1;
                }
            }
            j += 1;
        }
        return Sign.EMPTY;
    }
}
