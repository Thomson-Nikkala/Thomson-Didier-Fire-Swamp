package byui.cit260.fireSwamp.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Nikkala Thomson
 */
public class Map implements Serializable{
    
    private int mapRows;
    private int mapColumns;
    private Location mapEntrance;
    private Location mapExit;

    //constructor
    public Map() {
    }

    //getters and setters

    public int getMapRows() {
        return mapRows;
    }

    public void setMapRows(int mapRows) {
        this.mapRows = mapRows;
    }

    public int getMapColumns() {
        return mapColumns;
    }

    public void setMapColumns(int mapColumns) {
        this.mapColumns = mapColumns;
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
        hash = 97 * hash + this.mapRows;
        hash = 97 * hash + this.mapColumns;
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
        if (this.mapRows != other.mapRows) {
            return false;
        }
        if (this.mapColumns != other.mapColumns) {
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
        return "Map{" + "mapRows=" + mapRows + ", mapColumns=" + mapColumns + ", mapEntrance=" + mapEntrance + ", mapExit=" + mapExit + '}';
    }
       
}
