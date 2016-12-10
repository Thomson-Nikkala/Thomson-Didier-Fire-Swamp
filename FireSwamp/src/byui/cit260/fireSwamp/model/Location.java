/***************************************************
 * Location Class                                  *
 *                                                 *
 ***************************************************/
package byui.cit260.fireSwamp.model;

import byui.cit260.fireSwamp.enums.DangerType;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @authors Didier Jourdain and Nikkala Thomson
 */
public class Location implements Serializable {
    
    // class instance variables
    private int locationRow;
    private int locationColumn;
    private boolean locationVisited;
    private String locationDescription;
    private DangerType dangerType;   //see the enum 
    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    // Default constructor
    public Location() {
    }
    
    public int getLocationRow() {
        return locationRow;
    }
    
    public int getLocationRowForPeople() {
        return locationRow + 1;
    }

    public boolean isLocationVisited() {
        return locationVisited;
    }

    public void setLocationVisited(boolean locationVisited) {
        this.locationVisited = locationVisited;
    }

    public DangerType getLocationType() {
        return dangerType;
    }

    public void setLocationType(DangerType dangerType) {
        this.dangerType = dangerType;
    }

    public void setLocationRow(int locationRow) {
        this.locationRow = locationRow;
    }

    public int getLocationColumn() {
        return locationColumn;
    }
    
    public int getLocationColumnForPeople() {
        return locationColumn + 1;
    }

    public void setLocationColumn(int locationColumn) {
        this.locationColumn = locationColumn;
    }

    public boolean getLocationVisited() {
        return locationVisited;
    }

    public void setLocationVisited(Boolean locationVisited) {
        this.locationVisited = locationVisited;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.locationRow;
        hash = 43 * hash + this.locationColumn;
        hash = 43 * hash + Objects.hashCode(this.locationVisited);
        hash = 43 * hash + Objects.hashCode(this.locationDescription);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Location other = (Location) obj;
        if (this.locationRow != other.locationRow) {
            return false;
        }
        if (this.locationColumn != other.locationColumn) {
            return false;
        }
        if (!Objects.equals(this.locationDescription, other.locationDescription)) {
            return false;
        }
        if (!Objects.equals(this.locationVisited, other.locationVisited)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Location{" + "locationRow=" + locationRow
                           + ", locationColumn=" + locationColumn
                           + ", locationVisited=" + locationVisited
                           + ", locationDescription=" + locationDescription + '}';
    }
    
}
