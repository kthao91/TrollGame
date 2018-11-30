package trollgame.GameObjects;

import java.util.ArrayList;

/*
 *This will be the base class for all the objects in the game.
 */

/**
 *
 * @author Koua
 */
public class GameObjects {
    private int x,y;
    private String sprite;

    //
    public GameObjects(int x, int y, String sprite){
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        
    }
    
    public int[] getPosition(){
        int returnList[] = {x,y};
        return returnList; 
    }
    
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void setSprite(String sprite){
        this.sprite = sprite;
    }
    
    public String getSprite(){
        return this.sprite;
    }
    
    //index of neighbors
     public int index(int x, int y, int row, int col) {
            int index = x + y * row;
            if (x < 0 || x > col - 1 || y < 0 || y > row - 1 || index >= 873) {
                return 0;
            }
            return index;
        }
}
