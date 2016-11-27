package byui.cit260.fireSwamp.view;

import byui.cit260.fireSwamp.controller.DangerControl;
import byui.cit260.fireSwamp.exceptions.DangerControlException;
import java.util.Scanner;

/**
 *
 * @author Didier Jourdain and Nikkala Thomson
 */
public class FireSpurtView extends View {

    private double pyramidLength;
    private double pyramidWidth;
    private double pyramidHeight;
    private double volumeGuessed;
    private double volumeComputed;

    public FireSpurtView() throws DangerControlException {
        
        super("\n************************************************************"
            + "\n**  You stand before a potential fire spurt. If you don't go"
            + "\n**  around it very carefully you will be toast unless you have"
            + "\n**  a bucket of water to throw at it.");
        
        DangerControl dc = new DangerControl();

        double volume;
        this.pyramidLength = dc.generateDouble(96.0);
        this.pyramidWidth = dc.generateDouble(96.0);
        this.pyramidHeight = dc.generateDouble(96.0);
    }
    
    @Override
    public void display() {
        //Display problem        
        System.out.println("\n** To avoid your demise, answer this math problem:"
                        +  "\n****************************************************");
        
        System.out.println("\n>>   What is the volume of a Pyramid of"
                         + "\n>>   " + pyramidLength + " feet long,"
                         + "\n>>   " + pyramidWidth + " feet wide, and"
                         + "\n>>   " + pyramidHeight + " feet tall ?");
        
        //Collect input
        String input = getInput();
        
        //Validate input
        boolean isCorrect = doAction(input);
        
        //Display results
        if (isCorrect) {
            System.out.println("You made it across");
        } else {
            //Check for bucket of water (itemType 2) 

            
            System.out.println("Alas, that's incorrect, and you have no bucket "
                             + " of water to cover the flames who roast you.");
            LoseMenuView loseView = new LoseMenuView();
            loseView.display();
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
            } catch (NumberFormatException nf) {
                System.out.println ("\nPlease enter a valid number.");
                return " ";
            }
        }
        
        return input;
           
    }
    
    @Override
    public boolean doAction(String value) {
        double userAnswer = Double.parseDouble(value);
        DangerControl newDanger = new DangerControl();
       try {
           double correctAnswer = newDanger.calcFireSpurtAnswer(pyramidLength, pyramidWidth, pyramidHeight); 
           return (Math.abs(userAnswer - correctAnswer) < 0.01);
       } catch (DangerControlException de) {
          System.out.println(de.getMessage());
          return false;
       }    
    }
    
    public double getPyramidLength() {
        return pyramidLength;
    }

    public void setPyramidLength(double pyramidLength) {
        this.pyramidLength = pyramidLength;
    }

    public double getPyramidWidth() {
        return pyramidWidth;
    }

    public void setPyramidWidth(double pyramidWidth) {
        this.pyramidWidth = pyramidWidth;
    }

    public double getPyramidHeight() {
        return pyramidHeight;
    }

    public void setPyramidHeight(double pyramidHeight) {
        this.pyramidHeight = pyramidHeight;
    }

    public double getVolumeGuessed() {
        return volumeGuessed;
    }

    public void setVolumeGuessed(double volumeGuessed) {
        this.volumeGuessed = volumeGuessed;
    }
    
  

   

}
