/***************************************************
 * Danger Class                                    *
 *                                                 *
 ***************************************************/
package byui.cit260.fireSwamp.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @authors Didier Jourdain and Nikkala Thomson
 */
public class Danger implements Serializable{
    
    private String dangerName;
    private String dangerDescription;
    private int dangerType;
    
    //constructor

    public Danger() {
    }
    
    //getters and setters

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

    public int getDangerType() {
        return dangerType;
    }

    public void setDangerType(int dangerType) {
        this.dangerType = dangerType;
    }

    //hashCode()
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.dangerName);
        hash = 23 * hash + Objects.hashCode(this.dangerDescription);
        hash = 23 * hash + this.dangerType;
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

    //toString()
    
    @Override
    public String toString() {
        return "Danger{" + "dangerName=" + dangerName + ", dangerDescription=" + dangerDescription + ", dangerType=" + dangerType + '}';
    }
    
}
