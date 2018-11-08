package trollgame.GameObjects;

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
    
    
    
    
}
