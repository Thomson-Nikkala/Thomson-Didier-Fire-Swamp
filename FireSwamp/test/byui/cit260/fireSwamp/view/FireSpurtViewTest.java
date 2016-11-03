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
    public void testSomeMethod() {
        System.out.println("Try generateFloat function");
        FireSpurtView instance = new FireSpurtView();
        double expResult = 3.14;
        double result = instance.generateFloat();
        assert assertEquals(expResult, result, 0.01);
    }

}
