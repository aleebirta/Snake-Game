package com.example.snakegame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SnakeGUI extends Application {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private static final int TILE_SIZE = 20;

    private SnakeGame snakeGame;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);

        snakeGame = new SnakeGame();


        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
                snakeGame.getSnake().setDirection(0);
            } else if (event.getCode() == KeyCode.RIGHT) {
                snakeGame.getSnake().setDirection(1);
            } else if (event.getCode() == KeyCode.DOWN) {
                snakeGame.getSnake().setDirection(2);
            } else if (event.getCode() == KeyCode.LEFT) {
                snakeGame.getSnake().setDirection(3);
            }
        });

        GraphicsContext gc = canvas.getGraphicsContext2D();

        new AnimationTimer() {
            long lastTick = 0;

            public void handle(long now) {
                if (lastTick == 0) {
                    lastTick = now;
                    tick(gc);
                    return;
                }

                if (now - lastTick > 1000000000 / 10) {
                    lastTick = now;
                    tick(gc);
                }
            }
        }.start();

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void tick(GraphicsContext gc) {
        snakeGame.moveSnake();

        if (snakeGame.checkCollision()) {
            // Game over
            System.out.println("Game over! Score: " + snakeGame.getScore());
            System.exit(0);
        }

        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, WIDTH, HEIGHT);

        gc.setFill(Color.GREEN);
        gc.fillRect(snakeGame.getSnake().getX() * TILE_SIZE, snakeGame.getSnake().getY() * TILE_SIZE, TILE_SIZE, TILE_SIZE);

        gc.setFill(Color.RED);
        gc.fillRect(snakeGame.getFood().getX() * TILE_SIZE, snakeGame.getFood().getY() * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }
}
