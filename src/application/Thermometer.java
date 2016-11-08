/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author Carmen_Lucia3
 */
public class Thermometer implements Sensor {
    
    Random random;
    Boolean thermometer;
    
    public Thermometer() {
        this.random= new Random();
        this.thermometer = false;
    }
    
    @Override
    public boolean isOn() {
        return this.thermometer;
    }

    @Override
    public void on() {
        this.thermometer = true;
    }

    @Override
    public void off() {
        this.thermometer = false;
    }

    @Override
    public int measure() {
        if (this.isOn()){
            int number = random.nextInt(30 - (-30) + 1) - 30;
            return number;
        }        
        else {
            throw new IllegalStateException("Thermometer is turned off");
        }
    }
    
}
