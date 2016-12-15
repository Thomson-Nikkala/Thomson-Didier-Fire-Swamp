/** *************************************************
 * RousView Class                         *
 *                                                 *
 ************************************************** */
package byui.cit260.fireSwamp.view;

import byui.cit260.fireSwamp.controller.DangerControl;
import byui.cit260.fireSwamp.controller.InventoryControl;
import byui.cit260.fireSwamp.enums.ItemType;
import byui.cit260.fireSwamp.exceptions.DangerControlException;
import byui.cit260.fireSwamp.exceptions.GameControlException;
import byui.cit260.fireSwamp.exceptions.InventoryControlException;
import byui.cit260.fireSwamp.model.Item;
import fireswamp.FireSwamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nikkala
 */
public class RousView extends View {

    private double length;
    
    public RousView(double length) {
        this.length = length;
    }

    @Override
    public void display() {

        //Randomize lenth
        length = Math.random() * 12 + 3;  //ROUS length will be [3..15) feet

        //Display problem
        this.console.print("\n A rodent of Unusual Size challenges you."
            + "\n To avoid being bitten by the beast, you must jump over it."
            + "\n The ROUS is ");
        this.console.printf("%.2f", length);
        this.console.printf(" feet long. It is common knowledge that "
            + "\n Rodents of Unusual Size are half as tall as they are long. "
            + "\n How high will you need to jump to clear the rodent by "
            + "\n half a foot? (in feet) ");

        //Collect input
        String input = getInput();

        //Validate input
        boolean isCorrect = doAction(input);

        //Display results
        if (isCorrect) {
            this.console.println("\nYou successfully jump over the ROUS.");
        }
        else {
            //Check for healing potion (itemType 3)
            InventoryControl inControl = new InventoryControl();
            try {
                ArrayList<Item> inventory = FireSwamp.getPlayer().getPlayerInventory();
                inControl.checkInventory(inventory, ItemType.POTION);
            } catch (InventoryControlException ice) {
                ErrorView.display(this.getClass().getName(), ice.getMessage());
                this.console.println("You have no healing potion to save you from the poisonous ROUS bite. ");
                LoseMenuView loseView = new LoseMenuView();
                try {
                    loseView.display();
                } catch (GameControlException ex) {
                    Logger.getLogger(RousView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            this.console.println("\nLucky you! You have a healing potion to neutralize the ROUS' bite poison.\n");
            // need to remove the item once used.
        }
    }

    @Override
    public String getInput() {

        String input = " ";
        boolean valid = false; //initialize to not valid

        while (!valid) {
            try {
                input = this.keyboard.readLine();
                input = input.trim();
                input = input.toUpperCase();
            } catch (IOException ex) {
                Logger.getLogger(RousView.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                Double.parseDouble(input);
                valid = true;

            } catch (NumberFormatException nfe) {
                ErrorView.display(this.getClass().getName(), "Please enter a valid number.");
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
        } catch (DangerControlException de) {
            ErrorView.display(this.getClass().getName(), de.getMessage());
            return false;
        }

    }

}
