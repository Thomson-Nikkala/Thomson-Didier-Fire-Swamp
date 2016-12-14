/** *************************************************
 * Player Class                                    *
 *                                                 *
 ************************************************** */
package byui.cit260.fireSwamp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @authors Didier Jourdain and Nikkala Thomson
 */
public class Player implements Serializable {

    // class instance variables
    private String playerName;
    private ArrayList<Item> playerInventory = new ArrayList<>();
    private Location playerPosition;

    // default constructor
    public Player() {
    }
    
    public void setPlayerInventory(ArrayList<Item> playerInventory) {
        this.playerInventory = playerInventory;
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

    /*public char getPlayerGender() {
        return playerGender;
    }

    public void setPlayerGender(char playerGender) {
        this.playerGender = playerGender;
    }*/

    public Location getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(Location playerPosition) {
        this.playerPosition = playerPosition;
    }

    /*public boolean isPlayerAlive() {
        return playerAlive;
    }

    public void setPlayerAlive(boolean playerAlive) {
        this.playerAlive = playerAlive;
    }*/

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.playerName);
        hash = 97 * hash + Objects.hashCode(this.playerInventory);
        hash = 97 * hash + Objects.hashCode(this.playerPosition);
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
        return "Player{" + "playerName=" + playerName + ", playerInventory=" + playerInventory + ", playerPosition=" + playerPosition + '}';
    }    
}
