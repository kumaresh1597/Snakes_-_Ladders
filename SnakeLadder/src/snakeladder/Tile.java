/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakeladder;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



/**
 *
 * @author HANIFA
 */
public class Tile extends Rectangle{
    
    public Tile(int tileSize){
        
        setWidth(tileSize);
        setHeight(tileSize);
        setFill(Color.AQUAMARINE);
        setStroke(Color.BLACK);
        
    }
    
}
