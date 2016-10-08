package byui.cit260.fireSwamp.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Nikkala Thomson
 */
public class Game implements Serializable{
    
    private Map map;
    private Player player;
    private Item[] itemList;

    //constructor
    
    public Game() {
    }
    
    //getters and setters
   
    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Item[] getItemList() {
        return itemList;
    }

    public void setItemList(Item[] itemList) {
        this.itemList = itemList;
    }

    //hashCode()
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.map);
        hash = 89 * hash + Objects.hashCode(this.player);
        hash = 89 * hash + Arrays.deepHashCode(this.itemList);
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
        if (!Objects.equals(this.map, other.map)) {
            return false;
        }
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (!Arrays.deepEquals(this.itemList, other.itemList)) {
            return false;
        }
        return true;
    }

    //toString()
    
    @Override
    public String toString() {
        return "Game{" + "map=" + map + ", player=" + player + ", itemList=" + itemList + '}';
    }
    
    
}
