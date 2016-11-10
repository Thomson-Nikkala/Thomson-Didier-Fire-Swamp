package byui.cit260.fireSwamp.view;

import java.util.Scanner;

/**
 *
 * @authors Nikkala Thomson and Didier Jourdain
 */

public abstract class View implements ViewInterface {
 
    protected String displayMessage;
    
    public View() {
        
    }
    
    public View(String message) {
        this.displayMessage = message;
    }
    
    @Override
    public void display() {
        
        boolean done = false;
        do {
            //prompt for and get player's input
            String value = this.getInput();
            if (value.toUpperCase().equals("B")) { //user wants to go back
                return; // exit the view
            }
            //do the requested action and display the next view
            done = this.doAction(value);

        } while (!done);  //exit the view when done == true
        
    }
    
    @Override
    public String getInput() {
        
        Scanner keyboard = new Scanner(System.in);
        String value = null;
        boolean valid = false;
        
        //while a valid input has not been retrieved
        while (!valid) {
            
            //prompt for player input
            System.out.print("\n" + this.displayMessage);
           
            //get the value entered from the keyboard
            value = keyboard.nextLine();
            value = value.trim();
            
            if (value.length() < 1) { //blank value entered
                System.out.println("\nInvalid value: value can not be blank");
                continue;
            }
            
            break;
        }
             
        return value;  //return the input
    }
    
}
