/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fireSwamp.view;

/**
 *
 * @author Didier Jourdain and Nikkala Thomson
 */
public class WinGameView extends View {

    public WinGameView() {
        
      super("\n******************************************************"
         +  "\n*  You are safe. A white horse is waiting for you.    *"
         +  "\n*  You climb on the horse's back and you are          *"
         +  "\n*  transported to your loved ones.                    *"
         +  "\n******************************************************"
         +  "\n*  Are you happy (y/n)? ");
   }
    
    @Override
    public boolean doAction(String choice) {
        
        choice = choice.toUpperCase();
        
        if (choice.compareTo("N")==0) {
            this.console.println("\nYou mean you'd rather be in the swamp?"
                             + "\nWell too bad, you are going home."
                             + "\nAnd the game is over, and you are alive."
                             + "\nPlease do count your blessings.");            
        } else if (choice.compareTo("Y") == 0) {
            this.console.println("\nFor your return, your loved ones are"
                             + "\npreparing a feast. But first you need"
                             + "\nto take a bath, get a massage, to"
                             + "\nrelax those sore muscles, and get your"
                             + "\nhair done. You deserved it.");
        } else {
            this.console.println("\nYou are still catching your breath,"
                             + "\nI assume. Take your time, but"
                             + "\nremember to count your blessings!");
        }           
        
        System.exit(0);
        // this line is never executed.
        return false;
    }
    
   
    
    
}
