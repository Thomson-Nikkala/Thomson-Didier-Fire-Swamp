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
public class FireSpurtView {

    private String prompt;
    private String fireSpurtBanner;
    private double pyramidLength;
    private double pyramidWidth;
    private double pyramidHeight;

    public FireSpurtView() {

        this.pyramidLength = this.generateFloat();
        this.pyramidWidth = this.generateFloat();
        this.pyramidHeight = this.generateFloat();

        this.prompt = "What is your guess for the volume: ";
        this.fireSpurtBanner
            = "\n************************************************************"
            + "\n**  You stand before a potential fire spurt. If you don't go"
            + "\n**  around it very carefully you will be toast."
            + "\n**  To avoid your demise, answer this math problem:";
        this.problemStatement(this.pyramidLength, this.pyramidWidth, this.pyramidHeight);
        this.displayBanner();
    }

    private void displayBanner() {

        System.out.println(this.fireSpurtBanner);

    }

    public double generateFloat() {

        return (Math.random() * 96.0) + 3.0;
    }

    private void problemStatement(double pyramidLength, double pyramidWidth, double pyramidHeight) {

        System.out.print("\n>>   What is the volume of a Pyramid of"
            + "\n>>   " + pyramidLength + " feet long,"
            + "\n>>   " + pyramidWidth + " feet wide, and"
            + "\n>>   " + pyramidHeight + "feet tall ?");

    }

}
