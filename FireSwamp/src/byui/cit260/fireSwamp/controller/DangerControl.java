/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fireSwamp.controller;

/**
 *
 * @authors Didier Jourdain and Nikkala
 */
public class DangerControl {
    
    public double calcLightningSandAnswer (double diameter) {
        if (diameter > 0.0 && diameter <= 30) {
            double answer = diameter * Math.PI / 2.0;
            return answer;
        } else {
            return -1;
        }
    }
    
}
