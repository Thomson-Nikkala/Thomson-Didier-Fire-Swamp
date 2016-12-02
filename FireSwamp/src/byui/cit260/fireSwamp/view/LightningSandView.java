/** *************************************************
 * LightningSandView Class                         *
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
 * @author Nikkala Thomson
 */
public class LightningSandView extends View {

    private double diameter;

    @Override
    public void display() {

        //Randomize diameter
        double diameter = Math.random() * 29 + 1;  //diameter will be [1..30)

        //Display problem
        this.console.println(" You see a pit of lightning sand in front of you."
                + "\n To avoid being swallowed up by the sand, you must calculate the"
                + "\n distance you will need to walk around one side of the pit.  "
                + "\n The distance across the pit is ");
        this.console.printf("%.2f", diameter);
        this.console.printf(".");

        //Collect input
        String input = getInput();

        //Validate input
        boolean isCorrect = doAction(input);

        //Display results
        if (isCorrect) {
            this.console.println("You made it across");
        } else {
            //Check for rope (itemType 1) 
            InventoryControl inControl = new InventoryControl();
            try {
                ArrayList<Item> inventory = FireSwamp.getPlayer().getPlayerInventory();
                inControl.checkInventory(inventory, ItemType.ROPE);
            } catch (InventoryControlException ice) {
                this.console.println(ice.getMessage());
                this.console.println("Alas, that's incorrect, and you have no rope "
                             + " to help pull you out.");
                LoseMenuView loseView = new LoseMenuView();
                try {
                    loseView.display();
                } catch (GameControlException ex) {
                    Logger.getLogger(LightningSandView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public String getInput() {
        
        String input = " ";  //value to be returned
        boolean valid = false; //initialize to not valid

        while (!valid) {
            try {
                input = this.keyboard.readLine();
                input = input.trim();
                input = input.toUpperCase();
            } catch (IOException ex) {
                Logger.getLogger(LightningSandView.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                Double.parseDouble(input);
                valid = true;

            } catch (NumberFormatException nfe) {
                ErrorView.display(this.getClass().getName() ,"Please enter a valid number.");
            }

        }

        return input;

    }

    @Override
    public boolean doAction(String value) {
        double userAnswer = Double.parseDouble(value);
        DangerControl newDanger = new DangerControl();
        try {
            double correctAnswer = newDanger.calcLightningSandAnswer(diameter);
            return (Math.abs(userAnswer - correctAnswer) < 0.01);
        } catch (DangerControlException de) {
            this.console.println(de.getMessage());
            return false;
        }
    }

}
