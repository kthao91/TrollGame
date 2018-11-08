/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trollgame.GameObjects;

/**
 *
 * @author Koua
 */
public class Trolls extends GameObjects{
    int x,y;
    public Trolls(int x, int y, String sprite) {
        super(x, y, sprite);
        this.x = x;
        this.y = y;
    }
    
    public void moveTrolls(Brick walls, int targetX, int targetY){
        
    }
    
}
