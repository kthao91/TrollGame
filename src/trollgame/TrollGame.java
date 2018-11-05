/*
 * This is Escape the Troll. The main object is to get to the X
 * https://www.reddit.com/r/dailyprogrammer/comments/4vrb8n/weekly_25_escape_the_trolls/
 */
package trollgame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.*;

/**
 *
 * @author Koua
 */
public class TrollGame {

    /**
     * @param args the command line arguments
     */
    
    //initialize feilds
    
    private final String maze
            = "#####################################\n"
            + "# #       #       #     #         # #\n"
            + "# # ##### # ### ##### ### ### ### # #\n"
            + "#       #   # #     #     # # #   # #\n"
            + "##### # ##### ##### ### # # # ##### #\n"
            + "#   # #       #     # # # # #     # #\n"
            + "# # ####### # # ##### ### # ##### # #\n"
            + "# #       # # #   #     #     #   # #\n"
            + "# ####### ### ### # ### ##### # ### #\n"
            + "#     #   # #   # #   #     # #     #\n"
            + "# ### ### # ### # ##### # # # #######\n"
            + "#   #   # # #   #   #   # # #   #   #\n"
            + "####### # # # ##### # ### # ### ### #\n"
            + "#     # #     #   # #   # #   #     #\n"
            + "# ### # ##### ### # ### ### ####### #\n"
            + "# #   #     #     #   # # #       # #\n"
            + "# # ##### # ### ##### # # ####### # #\n"
            + "# #     # # # # #     #       # #   #\n"
            + "# ##### # # # ### ##### ##### # #####\n"
            + "# #   # # #     #     # #   #       #\n"
            + "# # ### ### ### ##### ### # ##### # #\n"
            + "# #         #     #       #       # #\n"
            + "#X###################################";
    
    //Convert varible above to char
    private char charmap[];
    Canvas map;
    
    ArrayList<Brick> w = new ArrayList<>();
    Player player;
    Random rand = new Random();
    
    public TrollGame() {
        this.charmap = maze.toCharArray();
        map = new map();
        
        Objectsetup();
        map.setFocusable(true);
        map.addKeyListener(player);
        JFrame frame = new JFrame();
        frame.setSize(640, 420);
        
        
        frame.add(map);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    private void Objectsetup() {
        //setup map
        int count = 0;
        for (int y = 0; y < 23; y++) {
            for (int x = 0; x < 38; x++) {

                if (count >= 873) {

                } else {

                    w.add(new Brick(x, y, Character.toString(charmap[count])));
                    count++;
                }

            }

        }
        for(Brick b: w){
            b.setNeighbors(w);
        }
        
        //setup player
        while(true){
        int playerPlacement = rand.nextInt(w.size());
        Brick playerBrick = w.get(playerPlacement);
        if(playerBrick.getSprite().equals(" ")){
            player = new Player(playerBrick.getPosition()[0],playerBrick.getPosition()[1],"0",this);
            break;
        }
        }

    }
    
    public void update(){
        map.validate();
        map.repaint();
    }

    public static void main(String[] args) {
        // TODO code application logic here
        TrollGame t = new TrollGame();
        
        while(true) {
            try {
                t.update();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TrollGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    //method of painting
    private class map extends Canvas {

        @Override
        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setFont(new java.awt.Font("Courier New", 1, 15));
            g2d.setColor(Color.black);
            for (Brick wa : w) {
                g2d.drawString(wa.getSprite(), ((wa.getPosition()[0]) + 1) * 15,
                        ((wa.getPosition()[1]) + 1) * 15);
            }
            g2d.setColor(Color.red);
            g2d.setFont(new java.awt.Font("Courier New", 5, 15));
            g2d.drawString(player.getSprite(),((player.getPosition()[0]) + 1) * 15,
                    ((player.getPosition()[1]) + 1) * 15);
        }

    }

}
