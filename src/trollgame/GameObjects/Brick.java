package trollgame.GameObjects;

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
public class Brick extends GameObjects{
    //intilize feilds
    private final ArrayList<GameObjects> neighbors = new ArrayList();
    private final int x;
    private final int y;
    private final String sprite;
    private final boolean movible;
    
    //setup Brick
    public Brick(int x, int y, String sprite) {
        super(x, y, sprite);
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.movible = false;
    }
    
    //set Neighbors
    public void setNeighbors(ArrayList<Brick> neighbors){
        GameObjects top,right,bottom,left;
        
        //check top
        if(index(this.x, this.y-1, 38,27)>= 0){
            
            top = neighbors.get(index(this.x -1, this.y, 38,38));
            this.neighbors.add(top);
        }
        //check right
        if(index(this.x+1, this.y, 38,27)>= 0){
            
            right = neighbors.get(index(this.x , this.y+1, 38,38));
            this.neighbors.add(right);
        }
        //check bottom
        if(index(this.x, this.y+1, 38,27)>= 0){
            bottom = neighbors.get(index(this.x +1, this.y, 38,38));
            this.neighbors.add(bottom);
        }
        //check left
        if(index(this.x-1 , this.y, 38,27)>= 0){
            left = neighbors.get(index(this.x , this.y-1, 38,38));
            this.neighbors.add(left);
        }
        
    }
    
    //return neighbors
    public ArrayList<GameObjects> getNeighbors(){
        return neighbors;
    }
    
    //use to check neighbors

   
    
    
}
