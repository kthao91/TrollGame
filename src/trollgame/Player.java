/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trollgame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Koua
 */
public class Player extends GameObjects implements KeyListener{
    int x,y;
    TrollGame g;
    public Player(int x, int y, String sprite, TrollGame g) {
        super(x, y, sprite);
        this.x = x;
        this.y = y;
        this.g=g;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if(e.getKeyCode() == 37){
            x-=1;
            super.setPosition(x, y);
            g.update();
        }
        if(e.getKeyCode() == 38){
            y-=1;
            super.setPosition(x, y);
            g.update();
        }
        if(e.getKeyCode() == 39){
            x+=1;
            super.setPosition(x, y);
            g.update();
        }if(e.getKeyCode() == 40){
            y+=1;
            super.setPosition(x, y);
            g.update();
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}



