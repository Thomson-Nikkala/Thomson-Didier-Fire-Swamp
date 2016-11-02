/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fireSwamp.controller;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @authors Didier Jourdain and Nikkala Thomson
 */
public class DangerControlTest {

    public DangerControlTest() {
    }

    /**
     * Test of calcLightningSandAnswer method, of class DangerControl.
     */
    @Test
    public void testCalcLightningSandAnswer() {
        System.out.println("calcLightningSandAnswer diameter = 2.0");
        double diameter = 2.0;
        DangerControl instance = new DangerControl();
        double expResult = 3.14;
        double result = instance.calcLightningSandAnswer(diameter);
        assertEquals(expResult, result, 0.01);

        System.out.println("calcLightningSandAnswer diameter = -2.0");
        diameter = -2.0;
        expResult = -1.0;
        result = instance.calcLightningSandAnswer(diameter);
        assertEquals(expResult, result, 0.01);

        System.out.println("calcLightningSandAnswer diameter = 0");
        diameter = 0.0;
        expResult = -1.0;
        result = instance.calcLightningSandAnswer(diameter);
        assertEquals(expResult, result, 0.01);

        System.out.println("calcLightningSandAnswer diameter = 14");
        diameter = 14.0;
        expResult = 21.99;
        result = instance.calcLightningSandAnswer(diameter);
        assertEquals(expResult, result, 0.01);

        System.out.println("calcLightningSandAnswer diameter = 0.1");
        diameter = 0.1;
        expResult = 0.16;
        result = instance.calcLightningSandAnswer(diameter);
        assertEquals(expResult, result, 0.01);

        System.out.println("calcLightningSandAnswer diameter = 30");
        diameter = 30.0;
        expResult = 47.12;
        result = instance.calcLightningSandAnswer(diameter);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of calcFireSpurtAnswer method, of class DangerControl.
     */
    @Test
    public void testCalcFireSpurtAnswer() {
        System.out.println("calcFireSpurtAnswer with L=0, W=0, H= 0");
        double length = 0.0;
        double width = 0.0;
        double height = 0.0;
        DangerControl instance = new DangerControl();
        double expResult = -111.0;
        double result = instance.calcFireSpurtAnswer(length, width, height);
        assertEquals(expResult, result, 0.0);

        System.out.println("calcFireSpurtAnswer with L<3, W=0, H= 0");
        length = 2.9;
        width = 0.0;
        height = 0.0;
        expResult = -111.0;
        result = instance.calcFireSpurtAnswer(length, width, height);
        assertEquals(expResult, result, 0.0);

        System.out.println("calcFireSpurtAnswer with L=15, W=20, H=50");
        length = 15.0;
        width = 20.0;
        height = 50.0;
        expResult = 5000.0;
        result = instance.calcFireSpurtAnswer(length, width, height);
        assertEquals(expResult, result, 0.0);

        System.out.println("calcFireSpurtAnswer with L<=0, W=20, H=50");
        length = -15.0;
        width = 20.0;
        height = 50.0;
        expResult = -1.0;
        result = instance.calcFireSpurtAnswer(length, width, height);
        assertEquals(expResult, result, 0.0);

        System.out.println("calcFireSpurtAnswer with L=15, W<=0, H=50");
        length = 15.0;
        width = -20.0;
        height = 50.0;
        expResult = -10.0;
        result = instance.calcFireSpurtAnswer(length, width, height);
        assertEquals(expResult, result, 0.0);

        System.out.println("calcFireSpurtAnswer with L=15, W=20, H<=0");
        length = 15.0;
        width = 20.0;
        height = -50.0;
        expResult = -100.0;
        result = instance.calcFireSpurtAnswer(length, width, height);
        assertEquals(expResult, result, 0.0);

        System.out.println("calcFireSpurtAnswer with L=0, W=20, H=50");
        length = 0.0;
        width = 20.0;
        height = 50.0;
        expResult = -1.0;
        result = instance.calcFireSpurtAnswer(length, width, height);
        assertEquals(expResult, result, 0.0);

        System.out.println("calcFireSpurtAnswer with L=15, W=0, H=50");
        length = 15.0;
        width = 0.0;
        height = 50.0;
        expResult = -10.0;
        result = instance.calcFireSpurtAnswer(length, width, height);
        assertEquals(expResult, result, 0.0);

        System.out.println("calcFireSpurtAnswer with L=15, W=20, H=0");
        length = 15.0;
        width = 20.0;
        height = 0.0;
        expResult = -100.0;
        result = instance.calcFireSpurtAnswer(length, width, height);
        assertEquals(expResult, result, 0.0);

        System.out.println("calcFireSpurtAnswer with L<3, W<3, H<3");
        length = 2.9;
        width = 2.9;
        height = 2.9;
        expResult = -111.0;
        result = instance.calcFireSpurtAnswer(length, width, height);
        assertEquals(expResult, result, 0.0);

        System.out.println("calcFireSpurtAnswer with L>99, W>99, H>99");
        length = 99.1;
        width = 99.1;
        height = 99.1;
        expResult = -111.0;
        result = instance.calcFireSpurtAnswer(length, width, height);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of calcRousAnswer method, of class DangerControl.
     */
    @Test
    public void testCalcRousAnswer() {
        System.out.println("calcRousAnswer length 3");
        double length = 3.0;
        DangerControl instance = new DangerControl();
        double expResult = 2.0;
        double result = instance.calcRousAnswer(length);
        assertEquals(expResult, result, 0.01);

        System.out.println("calcRousAnswer length -2");
        length = -2.0;
        expResult = -1;
        result = instance.calcRousAnswer(length);
        assertEquals(expResult, result, 0.01);

        System.out.println("calcRousAnswer length 0");
        length = 0.0;
        expResult = -1;
        result = instance.calcRousAnswer(length);
        assertEquals(expResult, result, 0.01);

        System.out.println("calcRousAnswer length 5");
        length = 5.0;
        expResult = 3.0;
        result = instance.calcRousAnswer(length);
        assertEquals(expResult, result, 0.01);

        System.out.println("calcRousAnswer length 1");
        length = 1.0;
        expResult = 1.0;
        result = instance.calcRousAnswer(length);
        assertEquals(expResult, result, 0.01);

        System.out.println("calcRousAnswer length 15");
        length = 15.0;
        expResult = 8.0;
        result = instance.calcRousAnswer(length);
        assertEquals(expResult, result, 0.01);
    }

}
