/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trollgame;

/**
 *
 * @author Koua
 */
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JTextArea;

public class Map extends JTextArea {

    private static final String PLAYMAP
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
    private int[][] list;
    
    public Map() {
        super(PLAYMAP);
        this.list = new int[37][23];
        int x =0;
        int y =0;
        
        super.setFont(new java.awt.Font("Courier New", 1, 36));
        
        for(String line: PLAYMAP.split("\\n")){
            for(char c : line.toCharArray()){
                
                if(c == '#'){
                    list[x][y]=0;
                }
                else{
                    list[x][y]=1;
                }
                x++;
            }
            x=0;
            y++;
        }
    }
    
}


