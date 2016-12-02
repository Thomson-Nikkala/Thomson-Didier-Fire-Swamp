package byui.cit260.fireSwamp.view;

import byui.cit260.fireSwamp.exceptions.GameControlException;
import fireswamp.FireSwamp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @authors Nikkala Thomson and Didier Jourdain
 */

public abstract class View implements ViewInterface {
 
    protected String message;
    
    protected final BufferedReader keyboard = FireSwamp.getInFile();
    protected final PrintWriter console = FireSwamp.getOutFile();
    
    public View() {
        
    }
    
    public View(String message) {
        this.message = message;
    }
    
    @Override
    public void display() throws GameControlException {
        
        boolean done = false;
        do {
            //prompt for and get player's input
            String value = this.getInput();
            if (value.toUpperCase().equals("B")) { //user wants to go back
                return; // exit the view
            }
            //do the requested action and display the next view
            try {
                done = this.doAction(value);
            } catch (GameControlException gce) {
                ErrorView.display(this.getClass().getName(), gce.getMessage());
            }

        } while (!done);  //exit the view when done == true
        
    }
    
    @Override
    public String getInput() {
        
        
        String input = null;
        boolean valid = false;
        
        while (!valid) {
            
            try {
                //prompt for player input
                this.console.println(this.message);
                
                input = this.keyboard.readLine();
                input = input.trim();
                
                if (input.length() < 1) {
                    this.console.println("\nInvalid value: value can not be blank");
                }
                
                
                
                break;
            } catch (IOException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
             
        return input;
    }
    
}
