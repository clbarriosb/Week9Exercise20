/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.*;

/*
 * @author Carmen_Lucia3
 */
public class AverageSensor implements Sensor{

    ArrayList<Sensor> sensor;
    ArrayList<Integer> readings;
    
    public AverageSensor(){
        this.sensor= new ArrayList<Sensor>();
        this.readings = new ArrayList<Integer>();
    }
    
    public void addSensor (Sensor additional){
        this.sensor.add(additional); 
    }
    
    public List<Integer> readings(){
        return this.readings;
    }
    
    @Override
    public boolean isOn() {
        for (Sensor s : sensor) {
            if (s.isOn()){
                return true;
            }
        }
        return true;
    }

    @Override
    public void on() {
        for (Sensor s : sensor){
            s.on();
        }
    }

    @Override
    public void off() {
        for (Sensor s : sensor){
            s.off();
        }
    }

    @Override
    public int measure() {
        if (!this.isOn() || this.sensor.isEmpty()) {
            throw new IllegalStateException("Thermometers are not on or the sensors are missing.");
        } else {
            int sum = 0;
            int average;

            for (Sensor s : sensor) {
                sum += s.measure();
            }
            
            average = sum / sensor.size();
            readings.add(average);
            
            return average;
        }
    }

}
