/***************************************************
 * RousView Class                         *
 *                                                 *
 ***************************************************/

package byui.cit260.fireSwamp.view;

import byui.cit260.fireSwamp.controller.DangerControl;
import byui.cit260.fireSwamp.controller.InventoryControl;
import byui.cit260.fireSwamp.exceptions.DangerControlException;
import byui.cit260.fireSwamp.exceptions.GameControlException;
import byui.cit260.fireSwamp.exceptions.InventoryControlException;
import byui.cit260.fireSwamp.model.Item;
import fireswamp.FireSwamp;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Nikkala
 */

public class RousView extends View {
    
    private double length;
    
    @Override
    public void display() {
        
        //Randomize lenth
        length = Math.random()*12 + 3;  //ROUS length will be [3..15) feet
       
        //Display problem
        
        System.out.println(" A rodent of Unusual Size challenges you."
        + "\n To avoid being bitten by the beast, you must jump over it."
        + "\n The ROUS is "); 
        System.out.printf("%.2f", length);
        System.out.printf(" feet long. It is common knowledge that "
        + "\n Rodents of Unusual Size are half as tall as they are long. "
        + "\n How high will you need to jump to clear the rodent by "
        + "\n half a foot?");
                
        //Collect input
        String input = getInput();
        
        //Validate input
        boolean isCorrect = doAction(input);
        
        //Display results
        if (isCorrect) {
            System.out.println("You successfully jump over the ROUS.");
        } else {
            //Check for healing potion (itemType 3)
            InventoryControl inControl = new InventoryControl();
            try {
                ArrayList<Item> inventory = FireSwamp.getPlayer().getPlayerInventory();
                inControl.checkInventory(inventory, 3);
            } catch (InventoryControlException ice) {
                System.out.println(ice.getMessage());
                System.out.println("You have no healing potion to save you from the ROUS bite. ");
                LoseMenuView loseView = new LoseMenuView();
                try {
                    loseView.display();
                } catch (GameControlException ex) {
                    Logger.getLogger(RousView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            System.err.println("Alas, that's incorrect, and you have no healing potion. You are bitten by the ROUS and perish.");
            LoseMenuView loseView = new LoseMenuView();
            try {
                loseView.display();
            } catch (GameControlException ex) {
                Logger.getLogger(RousView.class.getName()).log(Level.SEVERE, null, ex);
            }
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
                
            } catch (NumberFormatException nfe) {
                System.out.println ("\nPlease enter a valid number.");
            }  
        }
        return input;          
    }
    
    
    @Override
    public boolean doAction(String value) {
        double userAnswer = Double.parseDouble(value);
        DangerControl newDanger = new DangerControl();
        try {
            double correctAnswer = newDanger.calcRousAnswer(length);
            return (Math.abs(userAnswer - correctAnswer) < 0.01);
        }
        catch (DangerControlException de) {
          System.out.println(de.getMessage());
          return false;
       }    
        
    }

}
