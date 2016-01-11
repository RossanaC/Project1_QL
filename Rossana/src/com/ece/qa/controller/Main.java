/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ece.qa.controller;

import com.ece.qa.view.Cockpit;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author goa
 */
public class Main extends Application{
    
    static public Cockpit cockpit ;
    static public Parent root ;
    
    public static void main(String [] args){
        Cockpit cockpit = new Cockpit();
        /*
        cockpit.printStatus();
        System.out.println("\t\tEXTENDING GEAR");
        cockpit.getCont().toggleHandle();
        cockpit.printStatus();
        System.out.println("\t\tRETRACTING GEAR");
        cockpit.getCont().toggleHandle();
        cockpit.printStatus();
        */
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
         try {
            //root = FXMLLoader.load(getClass().getResource("./panel.fxml"));
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("panel.fxml"));
            root = (Parent) fxmlLoader.load();
            cockpit = (Cockpit) fxmlLoader.getController() ;
            Scene scene = new Scene( root ) ;
            scene.getStylesheets().clear() ;

            primaryStage.setTitle( "Landing Gear System" );
            primaryStage.setScene ( scene ) ;
            primaryStage.setResizable(false);
            primaryStage.show();             
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
