package com.example.snakegame;

public class Snake {
    private int length;
    private int x;
    private int y;
    private int direction;

    public Snake(int x, int y) {
        this.length = 1;
        this.x = x;
        this.y = y;
        this.direction = 1;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

}
