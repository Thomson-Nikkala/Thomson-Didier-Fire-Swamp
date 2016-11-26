/** *************************************************
 * DangerControl Class                             *
 *                                                 *
 ************************************************** */
package byui.cit260.fireSwamp.controller;

import byui.cit260.fireSwamp.exceptions.DangerControlException;

/**
 *
 * @authors Didier Jourdain and Nikkala Thomson
 */
public class DangerControl {

    public double calcLightningSandAnswer(double diameter) throws DangerControlException {

        if (diameter > 0.0 && diameter <= 30) {
            double answer = diameter * Math.PI / 2.0;
            return answer;
        } else {
            throw new DangerControlException("Diameter must be positive and less than 30.");
        }
    }

    public double calcFireSpurtAnswer(double length, double width, double height) throws DangerControlException {

        double answer = 0.0;

        // length checking
        if (length < 3.0 || length > 99.0) {
            throw new DangerControlException("Length must be between 3 and 99.");
        }

        // width checking
        if (width < 3.0 || width > 99.0) {
            throw new DangerControlException("Width must be between 3 and 99.");
        }

        // height checking
        if (height < 3.0 || height > 99.0) {
            throw new DangerControlException("Height must be between 3 and 99.");
        }

        return (length * width * height) / 3;
        
    }

    public double calcRousAnswer(double length) throws DangerControlException {

        if (length >= 1.0 && length <= 15) {
            double answer = length / 2.0 + 0.5;
            return answer;
        } else {
           throw new DangerControlException("Length must be between 1 and 15.");
        }
    }

}
