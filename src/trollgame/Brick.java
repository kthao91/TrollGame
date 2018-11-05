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
public class Brick extends GameObjects{
    
    private ArrayList<GameObjects> neighbors = new ArrayList();
    int x,y;
    public Brick(int x, int y, String sprite) {
        super(x, y, sprite);
        this.x = x;
        this.y = y;
    }
    public void setNeighbors(ArrayList<Brick> neighbors){
        GameObjects top,right,bottom,left;
        
        //check top
        if(index(this.x -1, this.y, 38,27)>= -1){
            
        }
        
        
    }
    private int index(int x, int y, int row, int col) {

            if (x < 0 || x > col - 1 || y < 0 || y > row - 1) {
                return 0;
            }
            return x + y * row;
        }
}
