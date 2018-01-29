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
    
    //fields
    private AnchorPane pane;
    private int numRows;
    private int numCols;
    private double boardWidth;
    private double boardHeight;
    private Color darkColor;
    private Color lightColor;
    private double rectangleWidth;
    private double rectangleHeight;
    
    //default no arg constructor
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
    
    @Override
    public void start(Stage stage) throws Exception {
        //create fxmlLoader instance
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CheckerboardFXML.fxml"));
        Parent root = loader.load();
        CheckerboardFXMLController controller = loader.getController();
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        //call controller start method to create changelisteners
        controller.start(stage);
    }
    
    public AnchorPane build(){
        //create new anchorpane
        pane = new AnchorPane();

        //create rectangles for grid. If row and column are both even or both odd, set it to light color. else set rectangle to dark color. set rectangle to coordinates
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
        //return pane. Dunno why this method has a return type. Seems redundant with getBoard()
        return pane;
    }
    
    public AnchorPane getBoard(){
        //if anchorpane is not null, send it!
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
