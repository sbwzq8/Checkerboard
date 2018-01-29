/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 *
 * @author SBWin
 */
public class CheckerboardFXMLController implements Initializable {
    
    @FXML private VBox vbox;
    @FXML private AnchorPane checkerboard;
    
    private Stage stage;
    
    private double gridSize;
    private String colorScheme;
    private double rectangleHeight;
    private double rectangleWidth;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void viewDidLoad(){
        //btn.setText(Double.toString(checkerboard.getHeight()));
        //btn.setText("Poop");
    }
    
    public void start(Stage stage){
        this.stage = stage;
        
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            refresh();
        };
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.widthProperty().addListener(lambdaChangeListener);
        refresh();
    }
    
    private void refresh(){
        System.out.println(this.stage.getWidth());
        this.checkerboard.getChildren().clear();
        setBoxSize(8.0);
        for(int i=0; i<64; i++){
            Rectangle rectangle = new Rectangle(this.rectangleWidth, this.rectangleHeight, Color.RED);
            this.checkerboard.getChildren().add(0, rectangle);
        }
        
//        Rectangle rectangle = new Rectangle(this.rectangleWidth, this.rectangleHeight, Color.RED);
//        this.checkerboard.getChildren().add(rectangle,1,1);
    }
    
    private void setBoxSize(double gridSize){
        this.rectangleWidth = this.stage.getWidth() / gridSize;
        this.rectangleHeight = this.stage.getHeight() / gridSize;
        
    }
}
