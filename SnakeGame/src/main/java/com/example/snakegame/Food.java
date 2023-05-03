package com.example.snakegame;

import java.util.Random;

public class Food {
    private int x;
    private int y;
    private int size;

    public Food(int size) {
        this.size = size;
        Random random = new Random();
        this.x = random.nextInt(20);
        this.y = random.nextInt(20);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public void randomizePosition() {
        Random random = new Random();
        this.x = random.nextInt(20);
        this.y = random.nextInt(20);
    }
}
