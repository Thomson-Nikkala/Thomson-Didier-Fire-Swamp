package byui.cit260.fireSwamp.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Didier and Nikkala
 */
public class Player implements Serializable{
    
    // class instance variables
    private String name;
    private char gender;
    /* Before using these attributes We need to implement the Item and Location
       classes
    
    private Items[] inventory;
    private Location playerPosition;
    */
    private boolean isAlive;

    // default constructor function
    public Player() {
    }    
    
    // class functions
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    /*public arrayOfItems[] getInventory() {
        return inventory;
    }

    public void setInventory(arrayOfItems[] inventory) {
        this.inventory = inventory;
    }

    public Location getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(Location playerPosition) {
        this.playerPosition = playerPosition;
    }
    */
    
    public boolean isIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + this.gender;
        //hash = 59 * hash + Arrays.deepHashCode(this.inventory);
        //hash = 59 * hash + Objects.hashCode(this.playerPosition);
        hash = 59 * hash + (this.isAlive ? 1 : 0);
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
        final Player other = (Player) obj;
        if (this.gender != other.gender) {
            return false;
        }
        if (this.isAlive != other.isAlive) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        /*if (!Arrays.deepEquals(this.inventory, other.inventory)) {
            return false;
        }
        if (!Objects.equals(this.playerPosition, other.playerPosition)) {
            return false;
        }
        */
        return true;
    }

    @Override
    public String toString() {
        //return "Player{" + "name=" + name + ", gender=" + gender + ", inventory=" + inventory + ", playerPosition=" + playerPosition + ", isAlive=" + isAlive + '}';
        return "Player{" + "name=" + name + ", gender=" + gender + ",  isAlive=" + isAlive + '}';
    }
    
    
    
}
