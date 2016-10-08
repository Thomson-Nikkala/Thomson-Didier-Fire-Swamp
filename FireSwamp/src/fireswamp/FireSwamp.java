package fireswamp;

import byui.cit260.fireSwamp.model.*;

/**
 *
 * @authors Didier Jourdain <maraamu@byui.edu>
 *          Nikkala Thomson <nikkalat@gmail.com>
 */
public class FireSwamp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Map mainMap = new Map();
        Danger dangerOne = new Danger();
        Location entryPoint = new Location();
        Location extractionPoint = new Location();
        
        
        
        /* We can't access locationRow and Column this way
        mainMap.setMapEntrance.locationRow(3);
        mainMap.setMapEntrance.locationColumn(4);
        */
        entryPoint.setLocationRow(3);
        entryPoint.setLocationColumn(4);
        mainMap.setMapEntrance(entryPoint);
        
        dangerOne.setDangerDescription("Quicksand that is drier and quicker.");
        dangerOne.setDangerName("Lightning Sand");
        dangerOne.setDangerType(1);
        
        String dangerInfo = dangerOne.toString();
        System.out.println(dangerInfo);
    }
    
}
