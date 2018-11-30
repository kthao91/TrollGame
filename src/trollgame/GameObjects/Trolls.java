/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trollgame.GameObjects;

import java.util.ArrayList;

/**
 *
 * @author Koua
 */
public class Trolls extends GameObjects{
    int x,y;
    private ArrayList<GameObjects> neighbors = new ArrayList();
    private ArrayList<Brick> map = new ArrayList();
    public Trolls(int x, int y, String sprite,ArrayList<Brick> map) {
        super(x, y, sprite);
        this.x = x;
        this.y = y;
        this.map = map;
        checkNeighbors();
    }
    
    public void checkNeighbors(){
        GameObjects top, right, bottom, left;
        neighbors = new ArrayList();
        //check top
        if (index(this.x, this.y - 1, 38, 27) >= -1) {

            top = map.get(index(this.x, this.y - 1, 38, 38));
            this.neighbors.add(top);
        }
        //check right
        if (index(this.x + 1, this.y, 38, 27) >= -1) {
            
            right = map.get(index(this.x + 1, this.y, 38, 38));
            this.neighbors.add(right);
        }
        //check bottom
        if (index(this.x, this.y + 1, 38, 27) >= -1) {
            bottom = map.get(index(this.x, this.y + 1, 38, 38));
            this.neighbors.add(bottom);
        }
        //check left
        if (index(this.x - 1, this.y, 38, 27) >= -1) {
            left = map.get(index(this.x - 1, this.y, 38, 38));
            this.neighbors.add(left);
        }
    }
    
    public void moveTrolls(Brick walls, int targetX, int targetY){
        
    }
    
}
