package com.ece.qa.view;


import com.ece.qa.controller.Controller;
import com.ece.qa.model.*;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class Cockpit extends JFrame implements Observer {

    private Plane plane = null;
    private Controller controlPanel = null;

    @FXML Circle redLight1;
    @FXML Circle redLight2;
    @FXML Circle redLight3;
    @FXML Circle orangeLight1;
    @FXML Circle orangeLight2;
    @FXML Circle orangeLight3;
    @FXML Circle greenLight1;
    @FXML Circle greenLight2;
    @FXML Circle greenLight3;
    @FXML TextField MessageArea;
    
  
    
    public Cockpit () {

        this.plane = new Plane();
        plane.getLight().addObserver(this);
        plane.getHandle().addObserver(this);
        plane.getGear().addObserver(this);
        plane.getDoor().addObserver(this);
        this.controlPanel = new Controller(plane);
        
    }
    //UPDATE VIEW
    @Override
    public void update(Observable o, Object arg) {
        if (o == plane.getLight()){
            if(this.plane.getLight().getLightState() == Light.LIGHTSTATE.GREEN){
                //Load GREEN image
                turnOnGreen() ;
                turnOffOrange() ;
                turnOffRed() ;
            }
            else if(this.plane.getLight().getLightState() == Light.LIGHTSTATE.ORANGE){
                //Load ORANGE image
                turnOffGreen();
            	turnOnOrange();
            	turnOffRed();
            }
            else if(this.plane.getLight().getLightState() == Light.LIGHTSTATE.RED){
                //Load RED image
                turnOffGreen();
            	turnOffOrange();
            	turnOnRed();
            }
            else if(this.plane.getLight().getLightState() == Light.LIGHTSTATE.OFF){
                //Load VOID image
                turnOffGreen();
            	turnOffOrange();
            	turnOffRed();
            }
            System.out.println("Light changed " + this.plane.getLight().getLightState().toString());            
        }
        else if(o == plane.getHandle()){
            System.out.println("Handle change : Status => " + this.plane.getHandle().getHandleState().toString());
        }
        else if(o == plane.getGear()){
            System.out.println("Gear change : Status => " + this.plane.getGear().getGEARSTATE().toString());
        }
        else if(o == plane.getDoor()){
            System.out.println("Door change : status => " + this.plane.getDoor().getDOORSTATE());
        }
     System.out.println("");
    }
    
    public void printStatus(){
        System.out.println("GLOBAL STATUS : ");
        System.out.println("Gear : " + plane.getGear().getGEARSTATE().toString());
        System.out.println("Door : " + plane.getDoor().getDOORSTATE());
        System.out.println("Handle : " + plane.getHandle().getHandleState().toString());
    }
    
    //handleUP
    @FXML
    public void handleUP( ActionEvent event )
    {	
            //change state
    	if(this.plane.getHandle().getHandleState() == Handle.HANDLESTATE.DOWN)
    		this.controlPanel.toggleHandle();
    	else
    		MessageArea.setText("The handle is already pushed up");
    }

    //handleDOWN
    @FXML
    public void handleDOWN( ActionEvent event )
    {
		//change state
    	if(this.plane.getHandle().getHandleState() == Handle.HANDLESTATE.UP)
    		this.controlPanel.toggleHandle();
    	else
    		MessageArea.setText("The handle is already pushed down");
    }
    public Plane getPlane(){ return this.plane;}
    public Controller getCont(){return this.controlPanel;}
    
     @FXML
    public void exitApp( ActionEvent event )
    {	
            Platform.exit();
            System.exit(0);
    }

    //turn on green light
    protected void turnOnGreen()
    {
            greenLight1.setStyle("-fx-fill: #008000; -fx-stroke-width:1");
            greenLight2.setStyle("-fx-fill: #008000; -fx-stroke-width:1");
            greenLight3.setStyle("-fx-fill: #008000; -fx-stroke-width:1");
    }
    //turn off green light
    protected void turnOffGreen()
    {
            greenLight1.setStyle("-fx-fill: #DBDBDB; -fx-stroke-width:1");
            greenLight2.setStyle("-fx-fill: #DBDBDB; -fx-stroke-width:1");
            greenLight3.setStyle("-fx-fill: #DBDBDB; -fx-stroke-width:1");
    }
    //turn on red light
    protected void turnOnRed()
    {
    		redLight1.setStyle("-fx-fill: #FF0000; -fx-stroke-width:1");
    		redLight2.setStyle("-fx-fill: #FF0000; -fx-stroke-width:1");
    		redLight3.setStyle("-fx-fill: #FF0000; -fx-stroke-width:1");
    }
    //turn off red light
    protected void turnOffRed()
    {
            redLight1.setStyle("-fx-fill: #DBDBDB; -fx-stroke-width:1");
            redLight2.setStyle("-fx-fill: #DBDBDB; -fx-stroke-width:1");
            redLight3.setStyle("-fx-fill: #DBDBDB; -fx-stroke-width:1");
    }
    //turn on orange light
    protected void turnOnOrange()
    {
    		orangeLight1.setStyle("-fx-fill: #FFA500; -fx-stroke-width:1");
    		orangeLight2.setStyle("-fx-fill: #FFA500; -fx-stroke-width:1");
    		orangeLight3.setStyle("-fx-fill: #FFA500; -fx-stroke-width:1");
    }
    //turn off orange light
    protected void turnOffOrange()
    {
            orangeLight1.setStyle("-fx-fill: #DBDBDB; -fx-stroke-width:1");
            orangeLight2.setStyle("-fx-fill: #DBDBDB; -fx-stroke-width:1");
            orangeLight3.setStyle("-fx-fill: #DBDBDB; -fx-stroke-width:1");
    }
}
