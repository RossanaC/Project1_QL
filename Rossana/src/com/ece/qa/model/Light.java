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
public class Light extends Observable{
    
    public enum LIGHTSTATE{GREEN,ORANGE,RED,OFF}
    
    private LIGHTSTATE lightState;

    public Light() {
        lightState = LIGHTSTATE.OFF; // Gears retracted.
    }
    
    
    //Getter & Setter
    public void setLightState(LIGHTSTATE ls){
        this.lightState = ls;
        setChanged();
        notifyObservers();
    }
    public LIGHTSTATE getLightState(){return this.lightState;}
    
}
