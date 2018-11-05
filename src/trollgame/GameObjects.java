package trollgame;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Koua
 */
public class GameObjects {
    private int x,y;
    private String sprite;
    
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
    
    public void setSprite(){
        
    }
    
    public String getSprite(){
        return this.sprite;
    }
    
    
    
    
}
