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
public class Gear extends Observable{
   
    public enum GEARSTATE{UP,DOWN,MOVING,STUCK}
    public static final int MOVING_TIME = 5000;
    private Timer timer = new Timer();
    
    private GEARSTATE _state = null;
    
    public Gear(){
        _state = GEARSTATE.UP;
    }
    
    
    public boolean isUp(){return this._state == GEARSTATE.UP;}
    public boolean isDown(){return this._state == GEARSTATE.DOWN;}
    public boolean isMoving(){return this._state == GEARSTATE.MOVING;}
    
    public GEARSTATE getGEARSTATE(){return _state;}
    public void setGEARSTATE(GEARSTATE state){
        this._state = state;
        setChanged();
        notifyObservers();
    }
    
    public void retractGear(){
        moveGear retract = new moveGear(GEARSTATE.UP);
        retract.run();
    }
    public void extendGear(){
        moveGear extend = new moveGear(GEARSTATE.DOWN);
        extend.run();
    }
    public class moveGear implements Runnable{

        private GEARSTATE _gs;
        
        public moveGear(GEARSTATE gs){this._gs = gs;}
        
        @Override
        public void run() {
            try{        
                Thread.sleep(Gear.MOVING_TIME);
                setGEARSTATE(_gs);
            }catch (Exception e){
                e.printStackTrace();//To change body of generated methods, choose Tools | Templates.
            }
        }
    }
    
    @Override
    public String toString(){
        if (_state == GEARSTATE.DOWN){
            return new String("DOWN");
        }else if (_state == GEARSTATE.MOVING){
            return new String("MOVING");
        }else 
            return new String("UP");
    }
}
