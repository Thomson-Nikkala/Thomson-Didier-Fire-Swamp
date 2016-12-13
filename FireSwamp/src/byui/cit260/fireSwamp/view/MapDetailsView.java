package byui.cit260.fireSwamp.view;

import byui.cit260.fireSwamp.enums.DangerType;
import byui.cit260.fireSwamp.enums.ItemType;
import byui.cit260.fireSwamp.exceptions.GameControlException;
import byui.cit260.fireSwamp.model.Location;
import byui.cit260.fireSwamp.model.Map;
import fireswamp.FireSwamp;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Didier Jourdain <maraamu at byui.edu>
 */
public class MapDetailsView extends View {

    public MapDetailsView() {
        super("\nMap Statistics Report.\n");
    }

    @Override
    public String getInput() {

        boolean valid = false;
        String input = null;

        while (!valid) {
            try {
                //prompt for player input
                this.console.println("\n\nWhere should I save the map statistics report? ");

                input = this.keyboard.readLine();
                input = input.trim();

                if (input.length() < 1) {
                    this.console.println("\nInvalid value: value can not be blank");
                }
                else {
                    break;
                }

            }
            catch (IOException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return input;
    }

    @Override
    public boolean doAction(String value) throws GameControlException {
        return true;
    }

    /**
     *
     * @param filepath
     * @throws GameControlException
     */
    public void MapDetailsReport(String filepath) throws GameControlException {

        // Prepare the stats variables
        // Dangers
        int numROUS = 0;
        int numFlameSpurt = 0;
        int numLightningSand = 0;
        int numNoDangers = 0;
        
        ArrayList<Location> locROUS = new ArrayList<>();
        ArrayList<Location> locFlameSpurt = new ArrayList<>();
        ArrayList<Location> locLightningSand = new ArrayList<>();
        ArrayList<Location> locNoDanger = new ArrayList<>();

        // Items
        int numRope = 0;
        int numBucket = 0;
        int numPotion = 0;
        int numNoItem = 0;

        ArrayList<Location> locRope = new ArrayList<>();
        ArrayList<Location> locBucket = new ArrayList<>();
        ArrayList<Location> locPotion = new ArrayList<>();
        ArrayList<Location> locNoItem = new ArrayList<>();

        // Map characteristics
        // will come from the mapReport
        Map mapReport = FireSwamp.getCurrentGame().getGameMap();

        // Map survey
        for (int row = 0; row < Map.ROWS; row++) {
            for (int col = 0; col < Map.COLUMNS; col++) {

                DangerType dangerFound = mapReport.getLocationAt(row, col).getLocationType();
                switch (dangerFound) {
                    case NONE:
                        numNoDangers++;
                        locNoDanger.add(mapReport.getLocationAt(row, col));
                        break;
                    case FLAMESPURT:
                        numFlameSpurt++;
                        locFlameSpurt.add(mapReport.getLocationAt(row, col));
                        break;
                    case ROUS:
                        numROUS++;
                        locROUS.add(mapReport.getLocationAt(row, col));
                        break;
                    case LIGHTNINGSAND:
                        numLightningSand++;
                        locLightningSand.add(mapReport.getLocationAt(row, col));
                        break;
                }
                // In order for this line to work Map.init() must also create locations with no item               
                ItemType itemFound = mapReport.getLocationAt(row, col).getItem().getItemType();
                switch (itemFound) {
                    case NONE:
                        numNoItem++;
                        locNoItem.add(mapReport.getLocationAt(row, col));
                        break;
                    case BUCKET:
                        numBucket++;
                        locBucket.add(mapReport.getLocationAt(row, col));
                        break;
                    case ROPE:
                        numRope++;
                        locRope.add(mapReport.getLocationAt(row, col));
                        break;
                    case POTION:
                        numPotion++;
                        locPotion.add(mapReport.getLocationAt(row, col));
                        break;
                }
            }
        }

        //Prepare report
        String strHeader = "\t\tMap Statistics Report\n" +
                           "\t\t---------------------\n\n";

        String strDangers = "Dangers :\n" +
                            "---------\n\n"
                + "\tR.O.U.S in the swamp:         " + numROUS + "\n"
                + "\tFlamespurts in the swamp:     " + numFlameSpurt + "\n"
                + "\tLightning Sands in the swamp: " + numLightningSand + "\n";

        String strPosROUS = "\tR.O.U.S are located at:\n";
        for (Location location : locROUS) {
            strPosROUS += "\t\trow: " + location.getLocationRowForPeople() + " column: " + location.getLocationColumnForPeople() + "\n";
        }

        String strPosLightningSand = "\tLightning Sands are located at:\n";
        for (Location location : locLightningSand) {
            strPosLightningSand += "\t\trow: " + location.getLocationRowForPeople() + " column: " + location.getLocationColumnForPeople() + "\n";
        }

        String strPosFlameSpurt = "\tFlamespurts are located at:\n";
        for (Location location : locFlameSpurt) {
            strPosFlameSpurt += "\t\trow: " + location.getLocationRowForPeople() + " column: " + location.getLocationColumnForPeople() + "\n";
        }

        String strPosNoDangers = null;
        if (numNoDangers == 0) {
            strPosNoDangers = "\n\tThis swamp is a very dangerous place, no sanctuary to be found!\n";
        }
        else if (numNoDangers == 1) {
            strPosNoDangers = "\n\tThere is only one \"safe\" place in the swamp located at:\n";
            for (Location location : locNoDanger) {
                strPosNoDangers += "\t\trow: " + location.getLocationRowForPeople() + " column: " + location.getLocationColumnForPeople() + "\n";
            }
        }
        else if (numNoDangers > 1) {
            strPosNoDangers = "\n\tThere are " + numNoDangers + " \"safe\" places in the swamp located at:\n";
            for (Location location : locNoDanger) {
                strPosNoDangers += "\t\trow: " + location.getLocationRowForPeople() + " column: " + location.getLocationColumnForPeople() + "\n";
            }
        }
        else {
            // improbable but not impossible?
        }

        // Both totals should add up to COLUMNS * ROWS.
        String strRemarkDangers = "Adding the total number of dangers and the danger free zone should yield "
                + (Map.COLUMNS * Map.ROWS) + ".\n";

        String strTotalDangers = "This swamp is infested by " + ((Map.COLUMNS * Map.ROWS) - numNoDangers) + " deadly dangers.\n";

        String strSafeLocations = "This swamp has only " + ((Map.COLUMNS * Map.ROWS) - (numROUS + numFlameSpurt + numLightningSand)) + " danger free spots.\n";

        String strItems = "\n\nItems that can help you in crossing the swamp :\n"
                + "\tRopes :  " + numRope + "\n"
                + "\tBucket : " + numBucket + "\n"
                + "\tPotion : " + numPotion + "\n";

        String strPosRope = "\tRopes can be found at:\n";
        for (Location location : locRope) {
            strPosRope += "\t\trow: " + location.getLocationRowForPeople() + " column: " + location.getLocationColumnForPeople() + "\n";
        }

        String strPosBucket = "\tBuckets can be found at:\n";
        for (Location location : locBucket) {
            strPosBucket += "\t\trow: " + location.getLocationRowForPeople() + " column: " + location.getLocationColumnForPeople() + "\n";
        }

        String strPosPotion = "\tPotions can be found at:\n";
        for (Location location : locPotion) {
            strPosPotion += "\t\trow: " + location.getLocationRowForPeople() + " column: " + location.getLocationColumnForPeople() + "\n";
        }

        String strPosNoItem = "\tThere are no items at these locations :\n";
        for (Location location : locNoItem) {
            strPosNoItem += "\t\trow: " + location.getLocationRowForPeople() + " column: " + location.getLocationColumnForPeople() + "\n";
        }

        String strMapSize = "\n\n\tThe map is a grid of " + Map.ROWS + " X " + Map.COLUMNS + ".\n";
        String strMapEntrance = null;
        strMapEntrance = "\tThe game starts at row " + mapReport.getMapEntranceRow()           
         + " and column " + mapReport.getMapEntranceColumn() + ".\n";

        String strMapExit = null;
            strMapExit = "\n\n\tTo win the game you have to get to row " + mapReport.getMapExitRow()
                + " and column " + mapReport.getMapExitColumn() + " without dying on the way!\n";
        
  
        
  
        String strDisclaimer = "\n\n\t\tUsing the information on this report is considered cheating!\n"
                + "\t\tBut I haven't included the answer to the dangers questions. Never will!\n";

        String[] text = {
            strHeader,
            strDangers,
            strPosROUS,
            strPosLightningSand,
            strPosFlameSpurt,
            strPosNoDangers,
            strRemarkDangers,
            strTotalDangers,
            strSafeLocations,
            strItems,
            strPosRope,
            strPosBucket,
            strPosPotion,
            strPosNoItem,
            strMapSize,
            strMapEntrance,
            strMapExit,
            strDisclaimer,};
        
        System.out.println("after text array declaration and initialization/n");

        //Write Map Stats to file
        FileWriter report = null;

        try {
            report = new FileWriter(filepath);
            for (String output : text) {
                report.write(output);
            }
            report.flush();
        }

        catch (IOException ex1) {
            System.out.println("Error writing stats to file " + filepath);
        }
        finally {
            if (report != null) {
                try {
                    report.close();
                }
                catch (IOException ex2) {
                    System.out.println("Error closing file " + filepath);
                }
            }
        }

    }

}