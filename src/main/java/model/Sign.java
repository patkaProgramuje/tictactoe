package model;

public enum Sign {
    RING("O"),
    CROSS("X"),
    EMPTY(" ");

    String sign;

    Sign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return sign;
    }
}
