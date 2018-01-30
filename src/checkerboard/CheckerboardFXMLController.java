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
        //retrieve stage from main java file
        this.stage = stage;
        
        //create lambda expression for changelisteners for calculating the stage size and rectangle sizes
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            refresh();
        };
        //add changelisteners to stage and checkerboard Anchorpane
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
        this.checkerboard.widthProperty().addListener(lambdaChangeListener);
        this.checkerboard.heightProperty().addListener(lambdaChangeListener);
        
        refresh();
    }
    
    private void refresh(){
        //clear checkerboard Anchorpane and remove it from vbox
        checkerboard.getChildren().clear();
        this.vbox.getChildren().remove(1);
        
        Color lightColor = Color.RED;
        Color darkColor = Color.BLACK;
        
        //select color for constructor based on selected color scheme.
        if(!colorScheme.equals("Default")){
            lightColor = Color.SKYBLUE;
            darkColor = Color.DARKBLUE;
        }
        //construct new checkerboard object. Load new anchorpane and set checkerboard equal to returned anchorpane. Height for pane is vbox height minus height of menubar
        Checkerboard newBoard = new Checkerboard(this.gridSize, this.gridSize, this.stage.getWidth(), this.vbox.getHeight() - menuBar.getHeight(), lightColor, darkColor);
        
        //construct checkerboard anchorpane
        newBoard.build();
        
        //retrieve checkerboard anchorpane from checkerboard object
        checkerboard = newBoard.getBoard();
        
        //add checkerboard to vbox
        vbox.getChildren().add(checkerboard);
    }
    
    //handle different grid sizes. I would much rather have had 1 method and get number of rows and columns from the menuitem title but cant figure that out
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
    
    //handle color schemes.
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
