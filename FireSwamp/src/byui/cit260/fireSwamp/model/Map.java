package byui.cit260.fireSwamp.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Nikkala Thomson
 */
public class Map implements Serializable{
    
    private int numRows;
    private int numColumns;
    private Location mapEntrance;
    private Location mapExit;

    //constructor
    public Map() {
    }

    //getters and setters
    
    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public int getNumColumns() {
        return numColumns;
    }

    public void setNumColumns(int numColumns) {
        this.numColumns = numColumns;
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
        int hash = 5;
        hash = 67 * hash + this.numRows;
        hash = 67 * hash + this.numColumns;
        hash = 67 * hash + Objects.hashCode(this.mapEntrance);
        hash = 67 * hash + Objects.hashCode(this.mapExit);
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
        if (this.numRows != other.numRows) {
            return false;
        }
        if (this.numColumns != other.numColumns) {
            return false;
        }
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
        return "Map{" + "numRows=" + numRows + ", numColumns=" + numColumns + ", mapEntrance=" + mapEntrance + ", mapExit=" + mapExit + '}';
    }

    

    
    
    
    
}
