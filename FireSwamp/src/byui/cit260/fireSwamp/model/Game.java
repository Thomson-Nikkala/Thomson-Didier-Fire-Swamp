/***************************************************
 * Game Class                                      *
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
public class Game implements Serializable{
    
    private Map gameMap;
    private Player gamePlayer;
    private ArrayList<Item> gameItemList;

    //constructor
    
    public Game() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.gameMap);
        hash = 29 * hash + Objects.hashCode(this.gamePlayer);
        hash = 29 * hash + Objects.hashCode(this.gameItemList);
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
        final Game other = (Game) obj;
        if (!Objects.equals(this.gameMap, other.gameMap)) {
            return false;
        }
        if (!Objects.equals(this.gamePlayer, other.gamePlayer)) {
            return false;
        }
        if (!Objects.equals(this.gameItemList, other.gameItemList)) {
            return false;
        }
        return true;
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

    public ArrayList<Item> getGameItemList() {
        return gameItemList;
    }

    public void setGameItemList(ArrayList<Item> gameItemList) {
        this.gameItemList = gameItemList;
    }

    @Override
    public String toString() {
        return "Game{" + "gameMap=" + gameMap
                       + ", gamePlayer=" + gamePlayer
                       + ", gameItemList=" + gameItemList + '}';
    }
    
}
