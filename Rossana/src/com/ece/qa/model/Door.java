/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ece.qa.model;

import java.util.Observable;
import java.util.Timer;

/**
 *
 * @author Robin Desir, Rossana Cammardella
 */
public class Door extends Observable{
    
    private enum DOORSTATE{OPEN,CLOSED,MOVING,STUCK}
    public static final int MOVING_TIME = 2500;
    private Timer timer = new Timer();
    
    private DOORSTATE _doorState = null;
    
    //Constructor
    public Door(){
        this._doorState = DOORSTATE.CLOSED;
    }
    //Setter & Getter
    public DOORSTATE getDOORSTATE(){return _doorState;}
    public void setDOORSTATE(DOORSTATE state){
        this._doorState = state;
        setChanged();
        notifyObservers();
    }
    public boolean isOpen(){return this._doorState == DOORSTATE.OPEN;}
    public boolean isClosed(){return this._doorState == DOORSTATE.CLOSED;}
    public boolean isMoving(){return this._doorState == DOORSTATE.MOVING;}
   
    
    public void openDoor(){
        moveDoor openDoor = new moveDoor(DOORSTATE.OPEN);
        openDoor.run();
    }
    public void closeDoor(){
        moveDoor closeDoor = new moveDoor(DOORSTATE.CLOSED);
        closeDoor.run();
    }
    public class moveDoor implements Runnable{
        private DOORSTATE _ds;
        
        public moveDoor(DOORSTATE ds){
            this._ds = ds;
        }
        
        @Override
        public void run() {
            try{
                Thread.sleep(Door.MOVING_TIME);
                setDOORSTATE(_ds);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public String toString(){
        if (_doorState == DOORSTATE.CLOSED){
            return new String("CLOSED");
        }else if (_doorState == DOORSTATE.MOVING){
            return new String("MOVING");
        }else
            return new String("OPEN");
    }
}
    

