/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package snakeladder;


import java.util.HashSet;
import java.util.Set;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


/**
 *
 * @author HANIFA
 */
public class SnakeLadder extends Application {
    
    public static final int tileSize = 50,height = 10, width = 10;
    public static final int buttonLine = height*tileSize + 30, infoLine = buttonLine + 40;
    
    private static Dice dice = new Dice();
    private Player playerA, playerB;
            
    private boolean startGame = false, p1 = false, p2 = false;
    
    private Pane createContent(){
      Pane root = new Pane();
      root.setPrefSize(200+tileSize*width, height*tileSize + 100);
      
      for(int i=0;i<height;i++){
          for(int j=0;j<width;j++){
         
            Tile tile = new Tile(tileSize);
            tile.setTranslateX(j*tileSize);
            tile.setTranslateY(i*tileSize);
            root.getChildren().add(tile);
              
          }
      }
//     playerA = new Player(tileSize,Color.BLACK,"KUMAR");
//     playerB = new Player(tileSize-10,Color.SPRINGGREEN,"SANTO");
     
     Image img = new Image("F:\\Kumaresh\\Java projects\\SnakeLadder\\src\\boardImage.jpg");
     ImageView board = new ImageView();
     board.setImage(img);
     board.setFitHeight(tileSize*height);
     board.setFitWidth(tileSize*width);   
     root.getChildren().add(board);
     
     Image btmimg = new Image("F:\\Kumaresh\\Java projects\\SnakeLadder\\src\\woodhr.jpg");
     ImageView brd1 = new ImageView();
     brd1.setImage(btmimg);
     brd1.setTranslateX(0);
     brd1.setTranslateY(tileSize*height);   
     root.getChildren().add(brd1);
     
     Image sideimg = new Image("F:\\Kumaresh\\Java projects\\SnakeLadder\\src\\woodvr.jpg");
     ImageView brd2 = new ImageView();
     brd2.setImage(sideimg);
     brd2.setTranslateX(tileSize*width);
     brd2.setTranslateY(0);   
     root.getChildren().add(brd2);
     
     Image symimg = new Image("F:\\Kumaresh\\Java projects\\SnakeLadder\\src\\sLsymbol.png");
     ImageView brd3 = new ImageView();
     brd3.setImage(symimg);
     brd3.setTranslateX(tileSize*width+50);
     brd3.setTranslateY(290);   
     root.getChildren().add(brd3);
     
     Label l3 = new Label("Snake & Ladder!!");
     l3.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 20));
     l3.setTranslateX(tileSize*width + 5);
     l3.setTranslateY(395);
     l3.setTextFill(Color.DARKBLUE);
     
     Button player1 = new Button("PLAYER 1");
     player1.setBackground(Background.fill(Color.AQUA));
     player1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
     player1.setBorder(Border.stroke(Color.WHITE));
     
     Button player2 = new Button("PLAYER 2");
     player2.setBackground(Background.fill(Color.AQUA));
     player2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
     player2.setBorder(Border.stroke(Color.WHITE));
     
     Button start = new Button("START");
     start.setBackground(Background.fill(Color.LAWNGREEN));
     start.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
     start.setBorder(Border.stroke(Color.WHITE));
     
     Label l1 = new Label("PLAYER 1 Name :");
     l1.setTranslateX(520);
     l1.setTranslateY(100);
     l1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.ITALIC, 16));
     TextField tf1 = new TextField();
     tf1.setTranslateX(520);
     tf1.setTranslateY(120);
     
     Label l2 = new Label("PLAYER 2 Name :");
     l2.setTranslateX(520);
     l2.setTranslateY(200);
     l2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.ITALIC, 16));
     TextField tf2 = new TextField();
     tf2.setTranslateX(520);
     tf2.setTranslateY(220);
     
        
     
     Label diceLabel = new Label("!Start Game!");
     diceLabel.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 20));
     diceLabel.setTextFill(Color.RED);
     
     Label player1Label = new Label("Player1");
     player1Label.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 12));
     player1Label.setTextFill(Color.BLACK);
     
     Label player2Label = new Label("Player2");
     player2Label.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 12));
     player2Label.setTextFill(Color.BLACK);
     
     player1.setTranslateX(50);
     player1.setTranslateY(buttonLine);
     
     player2.setTranslateX(380);
     player2.setTranslateY(buttonLine);
             
     start.setTranslateX(550);
     start.setTranslateY(450);
     
     diceLabel.setTranslateX(180);
     diceLabel.setTranslateY(infoLine-30);
     
     
     player1Label.setTranslateX(50);
     player1Label.setTranslateY(infoLine);
     
     player2Label.setTranslateX(380);
     player2Label.setTranslateY(infoLine);
     
    
     
     player1.setDisable(true);
     player2.setDisable(true);
     
     player1.setOnAction(new EventHandler<ActionEvent>(){
          @Override
          public void handle(ActionEvent event) {
              
              if(startGame){
                if(p1){              
                     int diceVal = dice.getRandomDiceValue();
                     diceLabel.setText("Dice Value : "+diceVal);
                     playerA.movePlayer(diceVal);
                     
                     if(playerA.isWinner()){
                       diceLabel.setText(playerA.getName()+" won the game!!");
                       start.setDisable(false);
                       start.setText("Restart");
                       
                        startGame = false;
                        
                        p1 = false;
                        player1.setDisable(true);
                        player1Label.setText("");

                        p2 = false;
                        player2.setDisable(true);
                        player2Label.setText("");
                        
                        root.getChildren().removeAll(playerA.getCoin(),playerB.getCoin());
                        tf1.setDisable(false);
                        tf2.setDisable(false);
                        
                     }
                     else{        
                     p1 = false;
                     player1.setDisable(true);
                     player1Label.setText("");
                     
                     p2 = true;
                     player2.setDisable(false);
                     player2Label.setText("YOUR TURN "+playerB.getName());
                     }
                }
              }
              
          } 
     });
     
     player2.setOnAction(new EventHandler<ActionEvent>(){
          @Override
          public void handle(ActionEvent event) {
              if(startGame){
                if(p2){              
                     int diceVal = dice.getRandomDiceValue();
                     diceLabel.setText("Dice Value : "+diceVal);
                     playerB.movePlayer(diceVal);
                     
                     if(playerB.isWinner()){
                       diceLabel.setText(playerB.getName()+" won the game!!");
                       start.setDisable(false);
                       start.setText("Restart");
                       
                        startGame = false;
                        
                        p1 = false;
                        player1.setDisable(true);
                        player1Label.setText("");

                        p2 = false;
                        player2.setDisable(true);
                        player2Label.setText("");
                        
                        root.getChildren().removeAll(playerA.getCoin(),playerB.getCoin());
                        tf1.setDisable(false);
                        tf2.setDisable(false);                               
                     }
                     else {
                       p2 = false;
                       player2.setDisable(true);
                       player2Label.setText("");
                     
                        p1 = true;
                        player1.setDisable(false);
                        player1Label.setText("YOUR TURN "+playerA.getName());  
                         
                     }                            
                }
              }
          } 
     });
     
     start.setOnAction(new EventHandler<ActionEvent>(){
          @Override
          public void handle(ActionEvent event) {
              startGame = true;
              playerA = new Player(tileSize,Color.BLACK,tf1.getText().toUpperCase());
              playerB = new Player(tileSize-10,Color.SPRINGGREEN,tf2.getText().toUpperCase());
              tf1.setDisable(true);
              tf2.setDisable(true);
              root.getChildren().add(playerA.getCoin());
              root.getChildren().add(playerB.getCoin());
              p1 = true;
              diceLabel.setText("!!Game Started!!");
              player1.setDisable(false);
              player1Label.setText("Your TURN "+playerA.getName());
              start.setDisable(true);
          }
     
     });
     
     
     root.getChildren().addAll(player1,player2,start,diceLabel,player1Label,player2Label,
             l1,l2,l3,tf1,tf2);
      
      return root;
    }
    
     
   @Override
    public void start(Stage primaryStage) {
          
        Scene scene = new Scene(createContent());
        
        primaryStage.setTitle("--Snake&Ladder--");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
