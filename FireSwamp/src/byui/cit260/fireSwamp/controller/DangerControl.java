/***************************************************
 * DangerControl Class                             *
 *                                                 *
 ***************************************************/
package byui.cit260.fireSwamp.controller;

/**
 *
 * @authors Didier Jourdain and Nikkala Thomson
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
    
    public double calcFireSpurtAnswer(double length, double width, double height){
        
        double answer = 0.0;
        
        // length checking
        if (length <= 0.0) {
            answer = answer -1.0;
        }
        else {
            if (length < 3.0) {
                answer = answer - 2.0;
            }
            else {
                if (length > 99.0) {
                    answer = answer - 4.0;
                }
            }
        }
        
        // width checking
        if (width <= 0.0) {
            answer = answer -10.0;
        }
        else {
            if (width < 3.0) {
                answer = answer - 20.0;
            }
            else {
                if (width > 99.0) {
                    answer = answer - 40.0;
                }
            }
        }
        
        // height checking
        if (height <= 0.0) {
            answer = answer - 100.0;
        }
        else {
            if (height < 3.0) {
                answer = answer - 200.0;
            }
            else {
                if (height > 99.0) {
                    answer = answer - 400.0;
                }
            }
        }
        
        if (answer < 0.0) {
            return answer;
        } else {
            return (length * width * height) / 3;
        }
    }
    
     public double calcRousAnswer (double length) {
         
        if (length >= 1.0 && length <= 15) {
            double answer = length / 2.0 + 0.5;
            return answer;
        } else {
            return -1;
        }
    }
    
}
