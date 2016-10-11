package byui.cit260.fireSwamp.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @authors Didier Jourdain and Nikkala Thomson
 */
public class Player implements Serializable{
    
    // class instance variables
    private String playerName;
    private char playerGender;
    private Item playerInventory;
    private Location playerPosition;
    private boolean playerIsAlive;

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

    public Item getPlayerInventory() {
        return playerInventory;
    }

    public void setPlayerInventory(Item playerInventory) {
        this.playerInventory = playerInventory;
    }

    public Location getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(Location playerPosition) {
        this.playerPosition = playerPosition;
    }

    public boolean getPlayerIsAlive() {
        return playerIsAlive;
    }

    public void setPlayerIsAlive(boolean playerIsAlive) {
        this.playerIsAlive = playerIsAlive;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.playerName);
        hash = 23 * hash + this.playerGender;
        hash = 23 * hash + Objects.hashCode(this.playerInventory);
        hash = 23 * hash + Objects.hashCode(this.playerPosition);
        hash = 23 * hash + Objects.hashCode(this.playerIsAlive);
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
        if (!Objects.equals(this.playerInventory, other.playerInventory)) {
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

    

    
    
    
    

}
