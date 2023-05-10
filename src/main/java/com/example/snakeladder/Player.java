package com.example.snakeladder;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import java.util.Stack;

public class Player {
  private   Circle coin;
    private  int currentPosition;
  private   String name;
  //  static  Board gameboard=new Board();
 private     Board gameboard=new Board();
  public   Player(int tileSize, Color coinColor,String playerName)
    {
    coin =new Circle(tileSize/2);
    coin.setFill(coinColor);
    currentPosition=0;
    movePlayer(1);
    name=playerName;
    }
    public void movePlayer(int dice)
    {
        if (currentPosition+dice<=100){
            currentPosition+=dice;
            TranslateTransition secondmove=null,firstmove =translateAnimation(dice);
            int newPosition= gameboard.getNewPosition(currentPosition);
            if (newPosition!=currentPosition &&newPosition!=-1)
            {
                currentPosition=newPosition;
              secondmove=  translateAnimation(6);
            }
            if (secondmove==null)
            {
                firstmove.play();
            }
            else
            {
                SequentialTransition st=new SequentialTransition(firstmove,new
                        PauseTransition(Duration.millis(1000)),secondmove);
                st.play();
            }


        }
        //        int x=gameboard.getXCoordinates(currentPosition);
//        int y=gameboard.getYCoordinates(currentPosition);
//        coin.setTranslateX(x);
//        coin.setTranslateY(y);

    }
    private TranslateTransition translateAnimation(int dicevalue)
    {
        TranslateTransition animate=new TranslateTransition(Duration.millis(200*dicevalue),coin);
        animate.setToX(gameboard.getXCoordinates(currentPosition));
        animate.setToY(gameboard.getYCoordinates(currentPosition));
        animate.setAutoReverse(false);
        animate.play();
        return  animate;
    }
    public void startingpos()
    {
        currentPosition=0;
        movePlayer(0);
    }
    boolean playerWon()
    {
        if (currentPosition==100)
            return true;
        return false;
    }
    public Circle getCoin() {
        return coin;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getName() {
        return name;
    }
}
