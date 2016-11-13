/***************************************************
 * LightningSandView Class                         *
 *                                                 *
 ***************************************************/

package byui.cit260.fireSwamp.view;

import byui.cit260.fireSwamp.controller.DangerControl;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Nikkala Thomson
 */

public class LightningSandView extends View {
    
    private double diameter;
    
    @Override
    public void display() {
        
        //Randomize diameter
        Random r = new Random();
        diameter = r.nextInt(5)+3;
        
        //Display problem
        
        System.out.println(" You see a pit of lightning sand in front of you."
        + "\n To avoid being swallowed up by the sand, you must calculate the"
        + "\n distance you will need to walk around one side of the pit.  "
        + "\n The distance across the pit is " + diameter + ".");
                
        //Collect input
        String input = getInput();
        
        //Validate input
        boolean isCorrect = doAction(input);
        
        //Display results
        if (isCorrect) {
            System.out.println("You made it across");
        } else {
            //Check for rope
            System.err.println("You were consumed by the lightning sand");
        }
    }
    
    @Override
    public String getInput() {
        Scanner in = new Scanner(System.in);  //get infile for keyboard
        String input = " ";  //value to be returned
        boolean validInput = false; //initialize to not valid
        
        while (!validInput) {
            input = in.nextLine();
            input = input.trim();
            input = input.toUpperCase();
            
            try {
                Double.parseDouble(input);
                validInput = true;
                
            } catch (Exception e) {
                System.out.println ("\nPlease enter a number.");
            }
            
        }
        
        return input;        
        
    }
    
    
    @Override
    public boolean doAction(String value) {
        double input = Double.parseDouble(value);
        DangerControl dc = new DangerControl();
        double actualAnswer = dc.calcLightningSandAnswer(diameter);
        
        return ((int)actualAnswer == (int)input);
    }
    
}
