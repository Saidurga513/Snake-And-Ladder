package com.example.snakeladder;

import javafx.util.Pair;

import java.util.ArrayList;

public class Board {
    ArrayList<Pair<Integer,Integer>> positionCoordinates;
    ArrayList<Integer> snakeladder;

    public Board(){
        positionCoordinates=new ArrayList<>();
        populatePositionCoordinates();
        popluateSnakeladderPos();
    }
    private  void  populatePositionCoordinates()
     {
        positionCoordinates.add(new Pair<>(0,0));
        for (int i = 0; i <SnakeLadder.height ; i++)
        {
            for (int j = 0; j < SnakeLadder.width; j++)
            {

                int xCord;
                if (i%2==0)
                {
                    xCord=j*SnakeLadder.tilesize + SnakeLadder.tilesize/2;
                }
                else
                {
                  xCord=  SnakeLadder.tilesize * SnakeLadder.height -(j*SnakeLadder.tilesize)-SnakeLadder.tilesize/2;

                }

                int yCord=SnakeLadder.tilesize * SnakeLadder.height -(i*SnakeLadder.tilesize)-SnakeLadder.tilesize/2;
                positionCoordinates.add(new Pair<>(xCord,yCord));


                
            }
            
        }

    }
    private void popluateSnakeladderPos()
    {
        snakeladder=new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            snakeladder.add(i);
        }
        snakeladder.set(4,25);
        snakeladder.set(13,46);
        snakeladder.set(33,49);
        snakeladder.set(50,69);
        snakeladder.set(27,5);
        snakeladder.set(40,3);
        snakeladder.set(54,31);
        snakeladder.set(62,81);
        snakeladder.set(66,45);
        snakeladder.set(76,58);
        snakeladder.set(74,92);
        snakeladder.set(89,53);
        snakeladder.set(99,41);
        snakeladder.set(42,63);
        snakeladder.set(43,18);

    }
    public int getNewPosition(int currpos)
    {
        if(currpos>0&&currpos<=100)
        {
            return snakeladder.get(currpos);
        }
        return -1;
    }
    int getXCoordinates(int position)
    {
        if(position>=1&&position<=100)
            return positionCoordinates.get(position).getKey();
        return -1;
    }
    int getYCoordinates(int position)
    {
        if(position>=1&&position<=100)
            return positionCoordinates.get(position).getValue();
        return -1;
    }


}
