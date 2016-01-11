/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ece.qa.model;

/**
 *
 * @author Robin Desir, Rossana Cammardella
 */
public class Plane {
    
    private Light _light = new Light();
    private Handle _handle = new Handle();
    private Door _door = new Door();
    private Gear _gear = new Gear();
    
    public Light getLight(){return this._light;}
    public Handle getHandle(){ return this._handle;}
    public Door getDoor(){return this._door;}
    public Gear getGear(){return this._gear;}

}
