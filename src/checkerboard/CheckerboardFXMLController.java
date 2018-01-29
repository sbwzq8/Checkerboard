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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 *
 * @author SBWin
 */
public class CheckerboardFXMLController implements Initializable {
    
    @FXML private VBox vbox;
    @FXML private MenuBar menuBar;
    @FXML private AnchorPane checkerboard;
    
    
    private Stage stage;
    
    private int gridSize = 8;
    private String colorScheme = "Default";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void start(Stage stage){
        this.stage = stage;
        
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            refresh();
        };
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
        this.checkerboard.widthProperty().addListener(lambdaChangeListener);
        this.checkerboard.heightProperty().addListener(lambdaChangeListener);
        
        refresh();
    }
    
    private void refresh(){
//        setBoxSize(8.0);
        checkerboard.getChildren().clear();
        this.vbox.getChildren().remove(1);

        if(colorScheme.equals("Default")){
            Checkerboard newBoard = new Checkerboard(this.gridSize, this.gridSize, this.stage.getWidth(), this.vbox.getHeight() - 32 , Color.RED, Color.BLACK);
            newBoard.build();
            checkerboard = newBoard.getBoard();
        }else{
            Checkerboard newBoard = new Checkerboard(this.gridSize, this.gridSize, this.stage.getWidth(), this.vbox.getHeight() - 32 , Color.SKYBLUE, Color.DARKBLUE);
            newBoard.build();
            checkerboard = newBoard.getBoard();
        }
        //checkerboard = newBoard.getBoard();
        
//        this.vbox.getChildren().add(newBoard.getBoard());
        vbox.getChildren().add(checkerboard);
        System.out.println("Size of stage: " + stage.getWidth() + ":" + stage.getHeight());
        System.out.println("Size of pane: " + checkerboard.getWidth() + ":" + checkerboard.getHeight());
    }
    
    @FXML
    private void handle3x3(ActionEvent event){
        this.gridSize = 3;
        refresh();
    }
    
    @FXML
    private void handle8x8(ActionEvent event){
        this.gridSize = 8;
        refresh();
    }
    
    @FXML
    private void handle10x10(ActionEvent event){
        this.gridSize = 10;
        refresh();
    }
    
    @FXML
    private void handle16x16(ActionEvent event){
        this.gridSize = 16;
        refresh();
    }
    
    @FXML
    private void handleDefaultColor(ActionEvent event){
        this.colorScheme = "Default";
        refresh();
    }
    
    @FXML
    private void handleBlueColor(ActionEvent event){
        this.colorScheme = "Blue";
        refresh();
    }
}
