/***************************************************
 * Item Class                                    *
 *                                                 *
 ***************************************************/
package byui.cit260.fireSwamp.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @authors Didier Jourdain and Nikkala Thomson
 */
public class Map implements Serializable{
    
    public static final int ROWS = 5;
    public static final int COLUMNS = 5;
    private Location[][] matrix = new Location[ROWS][COLUMNS];
    private Location mapEntrance;
    private Location mapExit;

    //constructor
    public Map() {
    }
    
    public void init() {
        
        Random rand = new Random();
        
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                int randLocation = rand.nextInt(LocationType.values().length);
                
                if (randLocation == 1) {
                    // create a flamespurt challenge
                }
                
                if (randLocation == 2) {
                    // create a ROUS challenge
                }
                
                if (randLocation == 3) {
                    // create a lightningsand challenge
                }
                
                Location location = new Location();
                location.setLocationColumn(col);
                location.setLocationRow(row);
                location.setLocationVisited(false);
                
                
                
                location.setLocationType(LocationType.values()[randLocation]);
                
                matrix[row][col] = location;
            }
        }
    }
    
    
    public void mapStatistics() {
        
        int difficultyLevel;
        int[] totalSafeRow = new int[ROWS];
        int[] totalDangersRow = new int[ROWS];
        int[] totalFlameSpurtRow = new int[ROWS];
        int[] totalLightningSandRow = new int[ROWS];
        int[] totalnumROUSRow = new int[ROWS];
        int[] totalSafeCol = new int[COLUMNS];
        int[] totalDangersCol = new int[COLUMNS];
        int[] totalFlameSpurtCol = new int[COLUMNS];
        int[] totalLightningSandCol = new int[COLUMNS];
        int[] totalnumROUSCol = new int[COLUMNS];
        LocationType dangerFound;
        
        for (int col = 0; col < COLUMNS; col++) {
            totalSafeCol[col] = 0;
            totalDangersCol[col] = 0;
            totalFlameSpurtCol[col] = 0;
            totalLightningSandCol[col] = 0;
            totalnumROUSCol[col] = 0;
        }
        for (int row = 0; row < ROWS; row++) {
            totalSafeRow[row] = 0;
            totalDangersRow[row] = 0;
            totalFlameSpurtRow[row] = 0;
            totalLightningSandRow[row] = 0;
            totalnumROUSRow[row] = 0;
        }
        
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                dangerFound = matrix[row][col].getLocationType();
                switch (dangerFound) {
                    case NONE:
                        totalSafeRow[row]++;
                        totalSafeCol[col]++;
                        break;
                    case FLAMESPURT:
                        totalFlameSpurtRow[row]++;
                        totalFlameSpurtCol[col]++;
                        break;
                    case LIGHTNINGSAND:
                        totalLightningSandRow[row]++;
                        totalLightningSandCol[col]++;                        
                        break;
                    case ROUS:
                        totalnumROUSRow[row]++;
                        totalnumROUSCol[col]++;
                        break;
                }
            }
        }
        
        
        int tally = 0;
        
        for (int col = 0; col < COLUMNS; col++){
            tally += totalSafeCol[col];
        }
        
        int GrandTotalDangers = COLUMNS * ROWS - tally;
        difficultyLevel = (GrandTotalDangers * 100) / (COLUMNS * ROWS);
        
        System.out.println("\nThe difficulty level for this game is evaluated at: "
                            + difficultyLevel + "%");
        if (difficultyLevel < 30)
            System.out.println("\nPiece of cake");
        else if (difficultyLevel < 50)
            System.out.println("\nYou have your chance");
        else if (difficultyLevel < 70)
            System.out.println("\nI hope you're good in math!");
        else
            System.out.println("\nYou better be good in math, or bring someone who is.");
    }

    //getters and setters

    public Location getLocationAt(int row, int col) {
        return matrix[row][col];
    }

    public Location getMapEntrance() {
        return mapEntrance;
    }

    public void setMapEntrance(Location mapEntrance) {
        this.mapEntrance = mapEntrance;
    }

    public Location getMapExit() {
        return mapExit;
    }

    public void setMapExit(Location mapExit) {
        this.mapExit = mapExit;
    }
    
    //hashCode()

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.mapEntrance);
        hash = 97 * hash + Objects.hashCode(this.mapExit);
        return hash;
    }
 
    //equals()

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Map other = (Map) obj;
        if (!Objects.equals(this.mapEntrance, other.mapEntrance)) {
            return false;
        }
        if (!Objects.equals(this.mapExit, other.mapExit)) {
            return false;
        }
        return true;
    }
    
    //toString()

    @Override
    public String toString() {
        return "Map{" + ", mapEntrance=" + mapEntrance + ", mapExit=" + mapExit + '}';
    }
       
}
