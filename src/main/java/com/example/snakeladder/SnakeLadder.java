package com.example.snakeladder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.BufferedInputStream;
import java.io.IOException;

public class SnakeLadder extends Application {
    // these variables are bock size
    public  static  final int tilesize=40,height=10,width=10;
    public  static  final int buttonLine=height*tilesize + 50,infoLine=buttonLine-30;
    private  static Dice dice=new Dice();
    private Player playerOne,playerTwo;
    private  boolean gamestated=false,playerOneTurn=false,playerTwoTurn=false;
    private  Image im;
    private  Pane createContent()
    {
        Pane root=new Pane();
        // set default size
        // 400,450
        // board height width
        root.setPrefSize(width*tilesize , height*tilesize +90);
        // creating board
        for (int i = 0; i <height ; i++) {
            for (int j = 0; j < width; j++) {
                // creating an object for Tile class
                Tile tile=new Tile(tilesize);
                tile.setTranslateX(j*tilesize);
                tile.setTranslateY(i*tilesize);
                root.getChildren().add(tile);
            }
        }
        // set the image
        Image img=new Image("C:\\Users\\saidu\\IdeaProjects\\SnakeLadder\\src\\main\\snakeladder.jpg");
        ImageView board=new ImageView();
        board.setImage(img);
        board.setFitHeight(height*tilesize);
        board.setFitWidth(width*tilesize);
      //  root.getChildren().add(board);

        //buttons create the player1 and player2
        Button playerOneButton=new Button("Player 1");
        Button playerTwoButton=new Button("Player 2");
        Button startButton=new Button("Start");
        playerOneButton.setTranslateY(buttonLine);
        playerOneButton.setTranslateX(40);
        playerTwoButton.setTranslateY(buttonLine);
        playerTwoButton.setTranslateX(300);
        startButton.setTranslateY(buttonLine);
        startButton.setTranslateX(165);

        Label playerOneLabel=new Label("");
        Label playerTwoLabel=new Label("");
        Label diceLabel=new Label("Start the Game");
        playerOneLabel.setTranslateY(infoLine);
        playerOneLabel.setTranslateX(30);
        playerTwoLabel.setTranslateY(infoLine);
        playerTwoLabel.setTranslateX(290);
        diceLabel.setTranslateY(infoLine-10);
        diceLabel.setTranslateX(170);

        playerOne=new Player(tilesize, Color.BLACK,"Jaya sri");
        playerTwo=new Player(tilesize-5,Color.WHITE,"dimpu");
        playerOneButton.setText(playerOne.getName());
        playerTwoButton.setText(playerTwo.getName());
        playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gamestated)
                {
                    if (playerOneTurn)
                    {
                        int dicevalue =dice.getRolledDiceValue();
                        diceLabel.setText("");
                            if(dicevalue==6)
                            {
                                Image img=new Image("C:\\Users\\saidu\\IdeaProjects\\SnakeLadder\\src\\main\\resources\\dice6.jpeg");
                                ImageView il=new ImageView(img);
                                il.setFitHeight(40);
                                il.setPreserveRatio(true);
                                diceLabel.setGraphic(il);
                            }
                            else if (dicevalue==5) {
                                diceLabel.setText("");
                                Image img=new Image("C:\\Users\\saidu\\IdeaProjects\\SnakeLadder\\src\\main\\resources\\dice5.jpg");
                                ImageView il=new ImageView(img);
                                il.setFitHeight(40);
                                il.setPreserveRatio(true);
                                diceLabel.setGraphic(il);
                            }
                            else if (dicevalue==4) {
                                diceLabel.setText("");
                                Image img=new Image("C:\\Users\\saidu\\IdeaProjects\\SnakeLadder\\src\\main\\resources\\dice4.jpg");
                                ImageView il=new ImageView(img);
                                il.setFitHeight(40);
                                il.setPreserveRatio(true);
                                diceLabel.setGraphic(il);

                            }
                            else if (dicevalue==3) {
                                diceLabel.setText("");
                                Image img=new Image("C:\\Users\\saidu\\IdeaProjects\\SnakeLadder\\src\\main\\resources\\dice3.jpg");
                                ImageView il=new ImageView(img);
                                il.setFitHeight(40);
                                il.setPreserveRatio(true);
                                diceLabel.setGraphic(il);
                            }
                            else if (dicevalue==2) {
                                diceLabel.setText("");
                                Image img=new Image("C:\\Users\\saidu\\IdeaProjects\\SnakeLadder\\src\\main\\resources\\dice2.jpg");
                                ImageView il=new ImageView(img);
                                il.setFitHeight(40);
                                il.setPreserveRatio(true);
                                diceLabel.setGraphic(il);
                            }
                            else if (dicevalue==1) {
                                diceLabel.setText("");
                                Image img=new Image("C:\\Users\\saidu\\IdeaProjects\\SnakeLadder\\src\\main\\resources\\dice1.jpg");
                                ImageView il=new ImageView(img);
                                il.setFitHeight(40);
                                il.setPreserveRatio(true);
                                diceLabel.setGraphic(il);
                            }
                        // diceLabel.setText("Dice value : " +dicevalue);
                        playerOne.movePlayer(dicevalue);
                        if (playerOne.playerWon()){
                            diceLabel.setText("Winner is " +playerOne.getName());
                            playerTwoTurn=false;
                            playerTwoButton.setDisable(true);
                            playerTwoLabel.setText("");
                            playerOneTurn=true;
                            playerOneButton.setDisable(true);
                            playerOneLabel.setText("");
                            startButton.setDisable(false);
                            startButton.setText("Restart");
                        }
                        else {
                            playerTwoTurn = true;
                            playerTwoButton.setDisable(false);
                            playerTwoLabel.setText("Your turn " + playerTwo.getName());
                            playerOneTurn = false;
                            playerOneButton.setDisable(true);
                            playerOneLabel.setText("");
                        }
                     }
                }

            }
        });
        playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gamestated)
                {
                    if (playerTwoTurn)
                    {
                        int dicevalue =dice.getRolledDiceValue();
                        if(dicevalue==6)
                        {
                            diceLabel.setText("");
                            Image img=new Image("C:\\Users\\saidu\\IdeaProjects\\SnakeLadder\\src\\main\\resources\\dice6.jpeg");
                            ImageView il=new ImageView(img);
                            il.setFitHeight(40);
                            il.setPreserveRatio(true);
                            diceLabel.setGraphic(il);
                        }
                        else if (dicevalue==5) {
                            diceLabel.setText("");
                            Image img=new Image("C:\\Users\\saidu\\IdeaProjects\\SnakeLadder\\src\\main\\resources\\dice5.jpg");
                            ImageView il=new ImageView(img);
                            il.setFitHeight(40);
                            il.setPreserveRatio(true);
                            diceLabel.setGraphic(il);
                        }
                        else if (dicevalue==4) {
                            diceLabel.setText("");
                            Image img=new Image("C:\\Users\\saidu\\IdeaProjects\\SnakeLadder\\src\\main\\resources\\dice4.jpg");
                            ImageView il=new ImageView(img);
                            il.setFitHeight(40);
                            il.setPreserveRatio(true);
                            diceLabel.setGraphic(il);

                        }
                        else if (dicevalue==3) {
                            diceLabel.setText("");
                            Image img=new Image("C:\\Users\\saidu\\IdeaProjects\\SnakeLadder\\src\\main\\resources\\dice3.jpg");
                            ImageView il=new ImageView(img);
                            il.setFitHeight(40);
                            il.setPreserveRatio(true);
                            diceLabel.setGraphic(il);
                        }
                        else if (dicevalue==2) {
                            diceLabel.setText("");
                            Image img=new Image("C:\\Users\\saidu\\IdeaProjects\\SnakeLadder\\src\\main\\resources\\dice2.jpg");
                            ImageView il=new ImageView(img);
                            il.setFitHeight(40);
                            il.setPreserveRatio(true);
                            diceLabel.setGraphic(il);
                        }
                        else if (dicevalue==1) {
                            diceLabel.setText("");
                            Image img=new Image("C:\\Users\\saidu\\IdeaProjects\\SnakeLadder\\src\\main\\resources\\dice1.jpg");
                            ImageView il=new ImageView(img);
                            il.setFitHeight(30);
                            il.setPreserveRatio(true);
                            diceLabel.setGraphic(il);
                        }
                        //diceLabel.setText("Dice value : " + dicevalue);
                        playerTwo.movePlayer(dicevalue);
                        if (playerTwo.playerWon())
                        {
                            diceLabel.setText("Winner is " +playerTwo.getName());
                            playerOneTurn=false;
                            playerOneButton.setDisable(true);
                            playerOneLabel.setText("");
                            playerTwoTurn=true;
                            playerTwoButton.setDisable(true);
                            playerTwoLabel.setText("");
                            startButton.setDisable(false);
                            startButton.setText("Restart");
                        }
                        else {
                            playerOneTurn = true;
                            playerOneButton.setDisable(false);
                            playerOneLabel.setText("Your turn " + playerOne.getName());
                          //  playerOne.startingpos();
                            playerTwoTurn = true;
                            playerTwoButton.setDisable(true);
                            playerTwoLabel.setText("");
                           // playerTwo.startingpos();
                        }
                    }
                }

            }
        });
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                gamestated=true;
                diceLabel.setText("Game Started :");
                startButton.setDisable(true);
                playerOneTurn=true;
                playerOneLabel.setText("Your Turn: "+ playerOne.getName());
                playerOneButton.setDisable(false);
                playerOne.startingpos();
                playerTwoTurn=false;
                playerTwoButton.setDisable(true);
                playerTwoLabel.setText("");
                playerTwo.startingpos();
            }
        });
        root.getChildren().addAll(
                board,playerOneButton,playerTwoButton,startButton
                ,playerOneLabel,playerTwoLabel,diceLabel,playerOne.getCoin(),playerTwo.getCoin()
        );
        return  root;
    }
    public void start(Stage stage) throws IOException
    {
        Scene scene = new Scene(createContent());
        stage.setTitle("Snake & Ladder !");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}