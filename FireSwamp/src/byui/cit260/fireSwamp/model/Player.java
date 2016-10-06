package byui.cit260.fireSwamp.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Didier and Nikkala
 */
public class Player implements Serializable{
    
    // class instance variables
    private String playerName;
    private char playerGender;
    private Item[] playerInventory;
    private Location playerPosition;
    private Boolean playerIsAlive;

    // default constructor
    public Player() {
    }
    
    

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public char getPlayerGender() {
        return playerGender;
    }

    public void setPlayerGender(char playerGender) {
        this.playerGender = playerGender;
    }

    public Item[] getPlayerInventory() {
        return playerInventory;
    }

    public void setPlayerInventory(Item[] playerInventory) {
        this.playerInventory = playerInventory;
    }

    public Location getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(Location playerPosition) {
        this.playerPosition = playerPosition;
    }

    public Boolean getPlayerIsAlive() {
        return playerIsAlive;
    }

    public void setPlayerIsAlive(Boolean playerIsAlive) {
        this.playerIsAlive = playerIsAlive;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.playerName);
        hash = 13 * hash + this.playerGender;
        hash = 13 * hash + Arrays.deepHashCode(this.playerInventory);
        hash = 13 * hash + Objects.hashCode(this.playerPosition);
        hash = 13 * hash + Objects.hashCode(this.playerIsAlive);
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
        if (this.playerGender != other.playerGender) {
            return false;
        }
        if (!Objects.equals(this.playerName, other.playerName)) {
            return false;
        }
        if (!Arrays.deepEquals(this.playerInventory, other.playerInventory)) {
            return false;
        }
        if (!Objects.equals(this.playerPosition, other.playerPosition)) {
            return false;
        }
        if (!Objects.equals(this.playerIsAlive, other.playerIsAlive)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Player{" + "playerName=" + playerName + ", playerGender=" + playerGender + ", playerInventory=" + playerInventory + ", playerPosition=" + playerPosition + ", playerIsAlive=" + playerIsAlive + '}';
    }

    public void setPlayerInventory(Item startingInventory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    

}
