package com.ece.qa.controller;

import com.ece.qa.model.*;

/**
 * Created by Robin Desir, Rossana Cammardella
 */
public class Controller {

    private Plane plane = null ;


    public Controller (Plane pl) {
        this.plane = pl;
    }

    private Plane getPlane() {
        return this.plane;
    }
    
    public void toggleHandle(){
        if (!(this.getPlane().getGear().isMoving() && this.getPlane().getDoor().isMoving())){
            if (this.getPlane().getHandle().isDown()){
                this.retractSequence();
            }
            else if(this.getPlane().getHandle().isUp()){
                this.extendSequence();
            }
        }
    }
    private void retractSequence(){
        plane.getDoor().openDoor();
        plane.getLight().setLightState(Light.LIGHTSTATE.ORANGE);
        plane.getGear().retractGear();
        plane.getDoor().closeDoor();
        plane.getLight().setLightState(Light.LIGHTSTATE.OFF);
        plane.getHandle().setHandleState(Handle.HANDLESTATE.UP);
    }
    private void extendSequence(){
        plane.getDoor().openDoor();
        plane.getLight().setLightState(Light.LIGHTSTATE.ORANGE);
        plane.getGear().extendGear();
        plane.getDoor().closeDoor();
        plane.getLight().setLightState(Light.LIGHTSTATE.GREEN);
        plane.getHandle().setHandleState(Handle.HANDLESTATE.DOWN);
    }
}
