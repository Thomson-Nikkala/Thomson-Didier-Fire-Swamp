/***************************************************
 * Danger Class                                    *
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
public class Danger implements Serializable{
    
    private String dangerName;
    private String dangerDescription;
    private DangerType dangerType;
    
    /***********************************************/

    // Constructor
    public Danger() {
    }
    
    /***********************************************/
    
    // Getters and Setters functions    
    public String getDangerName() {
        return dangerName;
    }

    public void setDangerName(String dangerName) {
        this.dangerName = dangerName;
    }

    public String getDangerDescription() {
        return dangerDescription;
    }

    public void setDangerDescription(String dangerDescription) {
        this.dangerDescription = dangerDescription;
    }

    public DangerType getDangerType() {
        return dangerType;
    }

    public void setDangerType(DangerType dangerType) {
        this.dangerType = dangerType;
    }

    /***********************************************/
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.dangerName);
        hash = 37 * hash + Objects.hashCode(this.dangerDescription);
        hash = 37 * hash + Objects.hashCode(this.dangerType);
        return hash;
    }

    /***********************************************/
    
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
        final Danger other = (Danger) obj;
        if (!Objects.equals(this.dangerName, other.dangerName)) {
            return false;
        }
        if (!Objects.equals(this.dangerDescription, other.dangerDescription)) {
            return false;
        }
        if (this.dangerType != other.dangerType) {
            return false;
        }
        return true;
    }

    /***********************************************/
    
    @Override
    public String toString() {
        return "Danger{" + "dangerName=" + dangerName
                         + ", dangerDescription=" + dangerDescription
                         + ", dangerType=" + dangerType + '}';
    }    
}
