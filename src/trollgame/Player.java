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
import java.util.ArrayList;

/**
 *
 * @author Koua
 */
public class Player extends GameObjects implements KeyListener {

    int x, y;
    TrollGame g;
    private ArrayList<GameObjects> neighbors = new ArrayList();

    public Player(int x, int y, String sprite, TrollGame g) {
        super(x, y, sprite);
        this.x = x;
        this.y = y;
        this.g = g;
        checkNeighbors();
    }

    public void checkNeighbors() {
        GameObjects top, right, bottom, left;
        neighbors = new ArrayList();
        //check top
        if (index(this.x, this.y - 1, 38, 27) >= -1) {

            top = g.w.get(index(this.x, this.y - 1, 38, 27));
            this.neighbors.add(top);
        }
        //check right
        if (index(this.x + 1, this.y, 38, 27) >= -1) {

            right = g.w.get(index(this.x + 1, this.y, 38, 27));
            this.neighbors.add(right);
        }
        //check bottom
        if (index(this.x, this.y + 1, 38, 27) >= -1) {
            bottom = g.w.get(index(this.x, this.y + 1, 38, 27));
            this.neighbors.add(bottom);
        }
        //check left
        if (index(this.x - 1, this.y, 38, 27) >= -1) {
            left = g.w.get(index(this.x - 1, this.y, 38, 27));
            this.neighbors.add(left);
        }

    }

    private int index(int x, int y, int row, int col) {

        if (x < 0 || x > col - 1 || y < 0 || y > row - 1) {
            return 0;
        }
        return x + y * row;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());

        //left
        if (e.getKeyCode() == 37) {
            if (neighbors.get(3).getSprite().equals("#")
                    && g.w.get(index(this.x - 2, this.y, 38, 27)).getSprite().equals(" ")) {
                g.w.get(index(this.x - 1, this.y, 38, 27)).setSprite(" ");
                g.w.get(index(this.x - 2, this.y, 38, 27)).setSprite("#");

            } else if (neighbors.get(3).getSprite().equals(" ")) {
                x -= 1;
                super.setPosition(x, y);
                g.update();
            }
        }
        //top
        if (e.getKeyCode() == 38) {
            if (neighbors.get(0).getSprite().equals("#")
                    && g.w.get(index(this.x , this.y- 2, 38, 27)).getSprite().equals(" ")) {
                g.w.get(index(this.x , this.y - 1, 38, 27)).setSprite(" ");
                g.w.get(index(this.x , this.y -  2, 38, 27)).setSprite("#");

            } else if (neighbors.get(0).getSprite().equals(" ")) {
                y -= 1;
                super.setPosition(x, y);
                g.update();
            }
        }
        //right
        if (e.getKeyCode() == 39) {
            if (neighbors.get(1).getSprite().equals("#")
                    && g.w.get(index(this.x + 2, this.y, 38, 27)).getSprite().equals(" ")) {
                g.w.get(index(this.x + 1, this.y, 38, 27)).setSprite(" ");
                g.w.get(index(this.x + 2, this.y, 38, 27)).setSprite("#");

            } else if (neighbors.get(1).getSprite().equals(" ")) {
                x += 1;
                super.setPosition(x, y);
                g.update();
            }
        }
        //bottom
        if (e.getKeyCode() == 40) {
            if (neighbors.get(2).getSprite().equals("#")
                    && g.w.get(index(this.x , this.y+ 2, 38, 27)).getSprite().equals(" ")) {
                g.w.get(index(this.x , this.y + 1, 38, 27)).setSprite(" ");
                g.w.get(index(this.x , this.y +  2, 38, 27)).setSprite("#");

            } else if (neighbors.get(2).getSprite().equals(" ")) {
                y += 1;
                super.setPosition(x, y);
                g.update();
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        checkNeighbors();
        g.setupNeighbor();
        System.out.println("top: " + neighbors.get(0).getSprite());
        System.out.println("right: " + neighbors.get(1).getSprite());
        System.out.println("bottom: " + neighbors.get(2).getSprite());
        System.out.println("left: " + neighbors.get(3).getSprite());
    }

}
