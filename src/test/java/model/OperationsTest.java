package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperationsTest {

    @Test
    public void checkIfIsWinnerShouldReturnSignX() {
        Field[][] fields = new Field[3][3];
        fillFieldsDiagonalDown(fields);
        Operations operations = new Operations(fields);
        assertEquals(Sign.CROSS, operations.checkIfIsWinner());
    }

    @Test
    public void checkIfWinnerHorizontalShouldReturnSignX() {
        Field[][] fields = new Field[7][7];
        fillHorizontal(fields);
        Operations operations = new Operations(fields);
        assertEquals(Sign.CROSS, operations.checkIfIsWinner());
    }

    @Test
    public void checkIfIsWinnerVerticalShouldReturnSignX() {
        Field[][] fields = new Field[5][5];
        fillVertical(fields);
        Operations operations = new Operations(fields);
        assertEquals(Sign.CROSS, operations.checkIfIsWinner());
    }

    @Test
    public void checkIfIsWinnerDiagonalUpShouldReturnSignX() {
        Field[][] fields = new Field[4][4];
        fillFieldsDiagonalUp(fields);
        Operations operations = new Operations(fields);
        assertEquals(Sign.CROSS, operations.checkIfIsWinner());
    }

    private void fillFieldsDiagonalUp(Field[][] fields) {
        int t = fields.length - 1;
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields.length; j++) {
                Field field = new Field();
                field.setX(i);
                field.setY(j);
                if (j == t) {
                    field.setSign(Sign.CROSS);
                } else {
                    field.setSign(Sign.EMPTY);
                }
                fields[i][j] = field;
            }
            t-=1;
        }
    }


    private void fillVertical(Field[][] fields) {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields.length; j++) {
                Field field = new Field();
                field.setX(i);
                field.setY(j);
                if (j == 0) {
                    field.setSign(Sign.CROSS);
                } else {
                    field.setSign(Sign.EMPTY);
                }
                fields[i][j] = field;
            }
        }
    }

    private void fillFieldsDiagonalDown(Field[][] fields) {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields.length; j++) {
                Field field = new Field();
                field.setX(i);
                field.setY(j);
                if (i == j) {
                    field.setSign(Sign.CROSS);
                } else {
                    field.setSign(Sign.EMPTY);
                }
                fields[i][j] = field;
            }
        }
    }

    private void fillHorizontal(Field[][] fields) {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields.length; j++) {
                Field field = new Field();
                field.setX(i);
                field.setY(j);
                if (i == 0) {
                    field.setSign(Sign.CROSS);
                } else {
                    field.setSign(Sign.EMPTY);
                }
                fields[i][j] = field;
            }
        }
    }
}