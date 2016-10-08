package fireswamp;

import byui.cit260.fireSwamp.model.*;

/**
 *
 * @author Didier Jourdain <maraamu@byui.edu>
 */
public class FireSwamp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Map mainMap = new Map();
        
        mainMap.setMapEntrance.locationRow(3);
        mainMap.setMapEntrance.locationColumn(4);
        
        dangerOne.setDangerDescription("Quicksand that is drier and quicker.");
        dangerOne.setDangerName("Lightning Sand");
        dangerOne.setDangerType(1);
        
        String dangerInfo = dangerOne.toString();
        System.out.println(dangerInfo);
    }
    
}
