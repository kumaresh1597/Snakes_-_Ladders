/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakeladder;

import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author HANIFA
 */
public class Board {
    
    ArrayList<Pair<Integer,Integer>> positions;
    ArrayList<Integer> SLmoves;
    
    public Board(){
    positions = new ArrayList<>();
    getPositions(); 
    addSnakeLadderPositions();
    }
   
    public void getPositions(){
        positions.add(new Pair<>(0,0));
        for (int i = 0; i < SnakeLadder.height; i++) {
            for (int j = 0; j < SnakeLadder.width; j++) {
                int xcord;
                if( i % 2 == 0){
                 xcord = j*SnakeLadder.tileSize + (SnakeLadder.tileSize/2);
                }
                else {
                 xcord = SnakeLadder.tileSize*SnakeLadder.width - (j*SnakeLadder.tileSize) - (SnakeLadder.tileSize/2);
                }
                
                int ycord = SnakeLadder.tileSize*SnakeLadder.width - (i*SnakeLadder.tileSize) - (SnakeLadder.tileSize/2);
                
                positions.add(new Pair<>(xcord,ycord));
            }     
        }
    }
    
    public void addSnakeLadderPositions(){
        SLmoves = new ArrayList<>(); 
        for(int i =0;i<101;i++){
            SLmoves.add(i);
        }
        // Ladders
        SLmoves.set(3,20);
        SLmoves.set(6,14);
        SLmoves.set(11,28);
        SLmoves.set(15,34);
        SLmoves.set(17,74);
        SLmoves.set(22,37);
        SLmoves.set(38,59);
        SLmoves.set(49,67);
        SLmoves.set(57,76);
        SLmoves.set(61,78);
        SLmoves.set(73,86);
        SLmoves.set(81,98);
        SLmoves.set(88,91);
        
        //Snakes
        SLmoves.set(8,4);
        SLmoves.set(18,1);
        SLmoves.set(26,10);
        SLmoves.set(39,5);
        SLmoves.set(51,6);
        SLmoves.set(54,36);
        SLmoves.set(56,1);
        SLmoves.set(60,23);
        SLmoves.set(75,28);
        SLmoves.set(83,45);
        SLmoves.set(85,59);
        SLmoves.set(90,48);
        SLmoves.set(92,25);
        SLmoves.set(97,87);
        SLmoves.set(99,63);
                
        
    }
    
    public int getNewPosition(int curPos){
        
        if(curPos > 0 && curPos <= 100) {
            return SLmoves.get(curPos);
        }
        return -1;
    }
    
    int getX(int pos) {
     
        if(pos >= 1 && pos <= 100) return positions.get(pos).getKey();
        
        return -1;
     
    }

    int getY(int pos) {
       
        if(pos >= 1 && pos <= 100) return positions.get(pos).getValue();
        return -1;
       
    }
//    public static void main(String[] args) {
//        Board p = new Board();
//        
//        for (int i = 0; i < p.positions.size(); i++) {
//            
//           System.out.println(i+" :"+ p.positions.get(i));
//        }
//    }
    
}
