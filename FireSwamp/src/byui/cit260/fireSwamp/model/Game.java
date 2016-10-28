/***************************************************
 * Game Class                                      *
 *                                                 *
 ***************************************************/
package byui.cit260.fireSwamp.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @authors Didier Jourdain and Nikkala Thomson
 */
public class Game implements Serializable{
    
    private Map gameMap;
    private Player gamePlayer;
    private Item[] gameItemList;

    //constructor
    
    public Game() {
    }
    
    //getters and setters

    public Map getGameMap() {
        return gameMap;
    }

    public void setGameMap(Map gameMap) {
        this.gameMap = gameMap;
    }

    public Player getGamePlayer() {
        return gamePlayer;
    }

    public void setGamePlayer(Player gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public Item[] getGameItemList() {
        return gameItemList;
    }

    public void setGameItemList(Item[] gameItemList) {
        this.gameItemList = gameItemList;
    }
   
    //hashCode()

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.gameMap);
        hash = 53 * hash + Objects.hashCode(this.gamePlayer);
        hash = 53 * hash + Arrays.deepHashCode(this.gameItemList);
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
        final Game other = (Game) obj;
        if (!Objects.equals(this.gameMap, other.gameMap)) {
            return false;
        }
        if (!Objects.equals(this.gamePlayer, other.gamePlayer)) {
            return false;
        }
        if (!Arrays.deepEquals(this.gameItemList, other.gameItemList)) {
            return false;
        }
        return true;
    }
    
    //toString()

    @Override
    public String toString() {
        return "Game{" + "gameMap=" + gameMap + ", gamePlayer=" + gamePlayer + /*", gameItemList=" + gameItemList + */ '}'; 
        //gameItemList is an array so it doesn't work with the toString function
    }
    
        
}
