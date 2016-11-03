/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fireSwamp.view;

import byui.cit260.fireSwamp.controller.DangerControl;
import java.util.Scanner;

/**
 *
 * @author Didier Jourdain and Nikkala Thomson
 */
public class FireSpurtView {

    private String promptGuess;
    private String fireSpurtBanner;
    private double pyramidLength;
    private double pyramidWidth;
    private double pyramidHeight;
    private double volumeGuessed;
    private double volumeComputed;

    public FireSpurtView(double length, double width, double height) {

        double volume;
        this.pyramidLength = length;
        this.pyramidWidth = width;
        this.pyramidHeight = height;

        this.promptGuess = "\n--- What is your guess for the volume: ";

        this.fireSpurtBanner
            = "\n**  To avoid your demise, answer this math problem:"
            + "\n************************************************************"
            + "\n**  You stand before a potential fire spurt. If you don't go"
            + "\n**  around it very carefully you will be toast.";

        this.displayBanner();
        this.problemStatement(this.pyramidLength, this.pyramidWidth, this.pyramidHeight);

        this.volumeGuessed = 192.901;
        DangerControl fireSpurtDanger = new DangerControl();
        volume = fireSpurtDanger.calcFireSpurtAnswer(this.pyramidLength, this.pyramidWidth, this.pyramidHeight);
        this.doAction(this.volumeGuessed, this.volumeComputed);
    }

    public FireSpurtView() {

        double volume;
        this.pyramidLength = this.generateFloat();
        this.pyramidWidth = this.generateFloat();
        this.pyramidHeight = this.generateFloat();

        this.promptGuess = "\n--- What is your guess for the volume: ";

        this.fireSpurtBanner
            = "\n**  To avoid your demise, answer this math problem:"
            + "\n************************************************************"
            + "\n**  You stand before a potential fire spurt. If you don't go"
            + "\n**  around it very carefully you will be toast.";

        this.displayBanner();
        this.problemStatement(this.pyramidLength, this.pyramidWidth, this.pyramidHeight);

        this.volumeGuessed = this.playerGuess();
        DangerControl fireSpurtDanger = new DangerControl();
        volume = fireSpurtDanger.calcFireSpurtAnswer(this.pyramidLength, this.pyramidWidth, this.pyramidHeight);
        this.doAction(this.volumeGuessed, this.volumeComputed);

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

    private void displayBanner() {

        System.out.println(this.fireSpurtBanner);

    }

    public double generateFloat() {

        double aFloat;
        aFloat = Math.random() * 96.0;
        aFloat += 3;
        aFloat = aFloat * 10;
        aFloat = (Math.ceil(aFloat)) / 10;

        return aFloat;
    }

    private void problemStatement(double pyramidLength, double pyramidWidth, double pyramidHeight) {

        System.out.println("\n>>   What is the volume of a Pyramid of"
            + "\n>>   " + pyramidLength + " feet long,"
            + "\n>>   " + pyramidWidth + " feet wide, and"
            + "\n>>   " + pyramidHeight + " feet tall ?");

    }

    private double playerGuess() {

        Scanner keyboard = new Scanner(System.in);
        double value = 0.0;
        boolean valid = false;

        while (!valid) {
            System.out.println("\n" + this.promptGuess);

            value = keyboard.nextDouble();

            /*if (value.length() < 1) {
                System.out.println("\nInvalid value: value can not be blank");
            } else {
                valid = true;
            }
             */
            valid = true;
        }

        return value;
    }

    private void doAction(double volumeGuessed, double volumeComputed) {

        System.out.println("\n*** doAction() function called from FireSpurtView ***");
    }

}
