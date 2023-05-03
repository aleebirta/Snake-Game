package com.example.snakegame;

public class SnakeGame {
    private Snake snake;
    private int score;
    private Food food;

    public SnakeGame() {
        this.snake = new Snake(10, 10);
        this.score = 0;
        this.food = new Food(10);
    }

    public void moveSnake() {
        switch (snake.getDirection()) {
            case 0:
                snake.setY(snake.getY() - 1);
                break;
            case 1:
                snake.setX(snake.getX() + 1);
                break;
            case 2:
                snake.setY(snake.getY() + 1);
                break;
            case 3:
                snake.setX(snake.getX() - 1);
                break;
        }

        // check if snake hit the food
        if (snake.getX() == food.getX() && snake.getY() == food.getY()) {
            snake.setLength(snake.getLength() + 1);
            score++;
            food.randomizePosition();
        }
    }

    public boolean checkCollision() {
        int x = snake.getX();
        int y = snake.getY();
        return (x < 0 || y < 0 || x >= 20 || y >= 20);
    }

    public void incrementScore() {
        score++;
    }

    public Snake getSnake() {
        return snake;
    }

    public int getScore() {
        return score;
    }
    public Food getFood() {
        return food;
    }

}
