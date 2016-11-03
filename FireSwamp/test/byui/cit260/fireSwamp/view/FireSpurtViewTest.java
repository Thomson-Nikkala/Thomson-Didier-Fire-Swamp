package byui.cit260.fireSwamp.view;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Didier Jourdain
 */
public class FireSpurtViewTest {

    public FireSpurtViewTest() {
    }

    @Test
    public void testFireSpurtView() {
        System.out.println("FireSpurtView");
        // use constructor with parameters
        FireSpurtView instance = new FireSpurtView(79.1, 73.9, 99.0);
        double expResult = 192.9;
        double result = instance.getVolumeGuessed();
        System.out.println("\n expected result = " + expResult);
        System.out.println("\n result = " + result);
        assertEquals(expResult, result, 0.1);

    }

}
