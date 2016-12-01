/***************************************************
 * Item Class                                    *
 *                                                 *
 ***************************************************/
package byui.cit260.fireSwamp.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @authors Didier Jourdain and Nikkala Thomson
 */
public class Item implements Serializable{
    
    private int itemType;
    private String itemName;
    private String itemDescription;

    // Default constructor
    public Item() {
    }
    
    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.itemType;
        hash = 89 * hash + Objects.hashCode(this.itemName);
        hash = 89 * hash + Objects.hashCode(this.itemDescription);
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
        final Item other = (Item) obj;
        if (this.itemType != other.itemType) {
            return false;
        }
        if (!Objects.equals(this.itemName, other.itemName)) {
            return false;
        }
        if (!Objects.equals(this.itemDescription, other.itemDescription)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "itemType=" + itemType + ", itemName=" + itemName + ", itemDescription=" + itemDescription + '}';
    }
    
    
    
}
