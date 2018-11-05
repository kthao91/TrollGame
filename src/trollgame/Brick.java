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
    private int x,y;
    private String sprite;
    private boolean movible;
    public Brick(int x, int y, String sprite) {
        super(x, y, sprite);
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.movible = false;
    }
    public void setNeighbors(ArrayList<Brick> neighbors){
        GameObjects top,right,bottom,left;
        
        //check top
        if(index(this.x, this.y-1, 38,27)>= -1){
            
            top = neighbors.get(index(this.x -1, this.y, 38,27));
            this.neighbors.add(top);
        }
        //check right
        if(index(this.x+1, this.y, 38,27)>= -1){
            
            right = neighbors.get(index(this.x , this.y+1, 38,27));
            this.neighbors.add(right);
        }
        //check bottom
        if(index(this.x, this.y+1, 38,27)>= -1){
            bottom = neighbors.get(index(this.x +1, this.y, 38,27));
            this.neighbors.add(bottom);
        }
        //check left
        if(index(this.x-1 , this.y, 38,27)>= -1){
            left = neighbors.get(index(this.x , this.y-1, 38,27));
            this.neighbors.add(left);
        }
        
    }
    
    public ArrayList<GameObjects> getNeighbors(){
        return neighbors;
    }
    private int index(int x, int y, int row, int col) {
            int index = x + y * row;
            if (x < 0 || x > col - 1 || y < 0 || y > row - 1 || index >= 873) {
                return 0;
            }
            return index;
        }
    
    public void isMovable(){
        for(GameObjects b:this.neighbors){
            System.out.print(b.getPosition()[0]+ ":" + b.getPosition()[1] + " ");
        }
    }
}
