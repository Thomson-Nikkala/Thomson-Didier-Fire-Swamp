/***************************************************
 * Player Class                                    *
 *                                                 *
 ***************************************************/
package byui.cit260.fireSwamp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @authors Didier Jourdain and Nikkala Thomson
 */
public class Player implements Serializable{
    
    // class instance variables
    private String playerName;
    private char playerGender;
    private ArrayList<Item> playerInventory = new ArrayList();
    private Location playerPosition;
    private boolean playerIsAlive;

    // default constructor
    public Player() {
    }

    public ArrayList<Item> getPlayerInventory() {
        return playerInventory;
    }
    
    public void addPlayerInventory(Item item) {
        this.playerInventory.add(item);
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
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.playerName);
        hash = 47 * hash + this.playerGender;
        hash = 47 * hash + Objects.hashCode(this.playerInventory);
        hash = 47 * hash + Objects.hashCode(this.playerPosition);
        hash = 47 * hash + (this.playerIsAlive ? 1 : 0);
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
        if (this.playerIsAlive != other.playerIsAlive) {
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
        return true;
    }

    @Override
    public String toString() {
        return "Player{" + "playerName=" + playerName
                         + ", playerGender=" + playerGender
                         + ", playerInventory=" + playerInventory
                         + ", playerPosition=" + playerPosition
                         + ", playerIsAlive=" + playerIsAlive + '}';
    }
}
