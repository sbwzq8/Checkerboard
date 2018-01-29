/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author SBWin
 */
public class Checkerboard extends Application {
    
    private AnchorPane pane;
    private int numRows;
    private int numCols;
    private double boardWidth;
    private double boardHeight;
    private Color darkColor;
    private Color lightColor;
    private double rectangleWidth;
    private double rectangleHeight;
    
    public Checkerboard(){
        
    }
    Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight){
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.rectangleWidth = boardWidth / numCols;
        this.rectangleHeight = boardHeight / numRows;
    }
    
    Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor){
        this(numRows, numCols, boardWidth, boardHeight);
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    CheckerboardFXMLController checkerboard = new CheckerboardFXMLController();
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CheckerboardFXML.fxml"));
        Parent root = loader.load();
        CheckerboardFXMLController controller = loader.getController();
//        Parent root = FXMLLoader.load(getClass().getResource("CheckerboardFXML.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        controller.start(stage);
    }
    
    public AnchorPane build(){
        //AnchorPane newPane = new AnchorPane();
        pane = new AnchorPane();
//        Rectangle rectangle = new Rectangle(this.rectangleWidth, this.rectangleHeight, Color.RED);
//        rectangle.setX(this.rectangleWidth);
//        pane.getChildren().add(rectangle);
        for(int row = 0; row < numRows; row++){
            for(int column = 0; column < numCols; column++){
                if((row % 2 == 0 && column %2 == 0) || (row % 2 != 0 && column % 2 != 0)){
                    Rectangle rectangle = new Rectangle(this.rectangleWidth, this.rectangleHeight, lightColor);
                    rectangle.setX(this.rectangleWidth * column);
                    rectangle.setY(this.rectangleHeight * row);
                    pane.getChildren().add(rectangle);
                }else{
                    Rectangle rectangle = new Rectangle(this.rectangleWidth, this.rectangleHeight, darkColor);
                    rectangle.setX(this.rectangleWidth * column);
                    rectangle.setY(this.rectangleHeight * row);
                    pane.getChildren().add(rectangle);
                }
            }
        }
        return pane;
    }
    
    public AnchorPane getBoard(){
        if(pane != null){
            return pane;
        }
        else  {
            return null;
        }
    }
    
    public int getNumRows(){
        return this.numRows;
    }
    public int getNumCols(){
        return this.numCols;
    }
    public double getWidth(){
        return this.boardWidth;
    }
    public double getHeight(){
        return this.boardHeight;
    }
    public Color getLightColor(){
        return this.lightColor;
    }
    public Color getDarkColor(){
        return this.darkColor;
    }
    public double getRectangleWidth(){
        return this.rectangleWidth;
    }
    public double getRectangleHeight(){
        return this.rectangleHeight;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
