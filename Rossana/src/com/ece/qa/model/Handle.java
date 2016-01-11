/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ece.qa.model;

import java.util.Observable;

/**
 *
 * @author Robin Desir, Rossana Cammardella
 */
public class Handle extends Observable{
    
    public enum HANDLESTATE{UP,DOWN}
    public HANDLESTATE HandleState;
    
    Handle(){
        HandleState = HANDLESTATE.UP; //already took off
    }
    
    //Setter & Getter
    public HANDLESTATE getHandleState(){return this.HandleState;}
    
    public boolean isDown(){return this.HandleState == HANDLESTATE.DOWN;}
    public boolean isUp(){return this.HandleState == HANDLESTATE.UP;}
    
    public void setHandleState(HANDLESTATE state){
        this.HandleState = state;
        setChanged();
        notifyObservers();
    }
    
}
