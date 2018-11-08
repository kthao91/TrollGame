/*
 * This is Escape the Troll. The main object is to get to the X
 * https://www.reddit.com/r/dailyprogrammer/comments/4vrb8n/weekly_25_escape_the_trolls/
 */
package trollgame;

import trollgame.GameObjects.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private final char charmap[];
    JPanel map;
    int[] winningPosition = new int[2];
    public ArrayList<Brick> w = new ArrayList<>();
    Player player;
     public ArrayList<Trolls> t = new ArrayList<>();
    Random rand = new Random();

    //setup the JCompents that will be need for a windows and initilze any feild
    public TrollGame() {
        this.charmap = maze.toCharArray();
        map = new map();
        Objectsetup();
        map.setDoubleBuffered(true);
        map.setFocusable(true);
        map.addKeyListener(player);
        JFrame frame = new JFrame();
        frame.setSize(640, 420);
        frame.add(map);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    //setup Object that will go into game
    private void Objectsetup() {
        //setup map
        int count = 0;
        for (int y = 0; y < 23; y++) {
            for (int x = 0; x < 38; x++) {
                //make sure no indexing error accures
                if (count >= (23 * 38) - 1) {

                } else {
                    //create a new BRICK base on map appove and add it to array
                    if(Character.toString(charmap[count]).equals("X")){
                        winningPosition[0] = x;
                        winningPosition[1] = y;
                    }
                    w.add(new Brick(x, y, Character.toString(charmap[count])));
                    count++;
                }

            }

        }

        //setup player
        while (true) {
            //This will randomly place the player on a random unit and make sure
            //that the unit isnt taken
            int playerPlacement = rand.nextInt(w.size());
            Brick playerBrick = w.get(playerPlacement);
            if (playerBrick.getSprite().equals(" ")) {
                player = new Player(playerBrick.getPosition()[0], playerBrick.getPosition()[1],
                        "0", this);
                
                break;
            }
        }
        
        //setup trolls
        
        for(int i=0;i<10;i++){
            while(true){
            int trollPlacement = rand.nextInt(w.size());
            Brick trollBrick = w.get(trollPlacement);
            if (trollBrick.getSprite().equals(" ")) {
                Trolls t = new Trolls(trollBrick.getPosition()[0], trollBrick.getPosition()[1],
                        "T");
                
                this.t.add(t);
                break;
            }
            }
        }

    }
    
    //this class is to setup neighbors and this wil run again
    public void setupNeighbor() {
        w.forEach((b) -> {
            b.setNeighbors(w);
        });
    }
    
    public void checkWin(){
        int[] playerPosition = {player.getPosition()[0],player.getPosition()[1]};
        
        if(Arrays.equals(playerPosition, winningPosition)){
            System.out.println("Winner");
        }
    }
    
    //update to repaint
    public void update() {
        map.removeAll();
        map.revalidate();
        map.repaint();
        checkWin();
    }

    public static void main(String[] args) {
        // TODO code application logic here
        TrollGame t = new TrollGame();

        while (true) {
            try {
                t.update();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TrollGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    //method of painting
    private class map extends JPanel {
        
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;

            g2d.setFont(new java.awt.Font("Courier New", 1, 15));
            g2d.setColor(Color.black);
            w.forEach((wa) -> {
                g2d.drawString(wa.getSprite(), ((wa.getPosition()[0]) + 1) * 15,
                        ((wa.getPosition()[1]) + 1) * 15);
            });
            t.forEach((troll) ->{
                g2d.drawString(troll.getSprite(), ((troll.getPosition()[0]) + 1) * 15,
                        ((troll.getPosition()[1]) + 1) * 15);
            
            });
            g2d.setColor(Color.red);
            g2d.setFont(new java.awt.Font("Courier New", 5, 15));
            g2d.drawString(player.getSprite(), ((player.getPosition()[0]) + 1) * 15,
                    ((player.getPosition()[1]) + 1) * 15);
        }

    }

}

