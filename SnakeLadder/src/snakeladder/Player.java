/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakeladder;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 *
 * @author HANIFA
 */
public class Player {
    
   private Circle coin;
    
   private int curPosition;
    
   private String name;
    
   private static Board game = new Board();
    
    public Player(int tileSize, Color c, String pName){
        
      coin = new Circle(tileSize/2);
      coin.setFill(c);
      curPosition = 0;
      movePlayer(1);
      name = pName; 
    }
    
    public void movePlayer(int diceValue){
    
    if(curPosition + diceValue <= 100){
        curPosition += diceValue;
        
        TranslateTransition firstMove = translateAnimation(diceValue);
        TranslateTransition secondMove = null;
        
        
        int newPosition = game.getNewPosition(curPosition);
        
        if(newPosition != curPosition && newPosition != -1){
          curPosition = newPosition;
          secondMove = translateAnimation(diceValue);
        }
        
        if(secondMove == null) firstMove.play();
        else{
            SequentialTransition sqt = new SequentialTransition(firstMove,new PauseTransition(Duration.millis(500)),secondMove);
            sqt.play();
        }
     }
    }
    public boolean isWinner(){
        if(curPosition == 100) return true;
        return false;
    }
    private TranslateTransition translateAnimation(int diceValue){
    TranslateTransition anime = new TranslateTransition(Duration.millis(200*diceValue),coin);
    anime.setToX(game.getX(curPosition));
    anime.setToY(game.getY(curPosition));
    anime.setAutoReverse(false);
    return anime;
    }

    public Circle getCoin() {
        return coin;
    }

    public int getCurPosition() {
        return curPosition;
    }

    public String getName() {
        return name;
    }
      
    
}
