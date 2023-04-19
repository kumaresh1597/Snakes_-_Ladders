/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakeladder;

/**
 *
 * @author HANIFA
 */
public class Dice {
    
    public int getRandomDiceValue(){   
        return (int) (Math.random()*6+1);
    }
    
    
//    public static void main(String[] args) {
//        Dice d = new Dice();
//        
//        System.out.println(d.getRandomDiceValue());
//    }
}
