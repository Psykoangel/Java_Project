
package gil;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class GILObject extends JFrame {
    private JPanel panGraphic;
    private JPanel panMenu;
    private JPanel panPara;
    private JPanel panProgBar;
    private JPanel panText;
    private JSplitPane splitDroite;
    private JSplitPane splitBas;
    
    
    public GILObject() {

        this.setLocationRelativeTo(null);
        this.setTitle("J-Sim Forest");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);

        panGraphic = new JPanel();
        panGraphic.setBackground(Color.black);
        panGraphic.setPreferredSize(new Dimension(600, 500));
//        JLabel libGraphic = new JLabel("Graphic");
//        panGraphic.add(libGraphic);

        panMenu = new JPanel();
        panMenu.setBackground(Color.red);
        panMenu.setPreferredSize(new Dimension(200, 200));
        JLabel libMenu = new JLabel("Menu");
        panMenu.add(libMenu);
        
        panPara = new JPanel();
        panPara.setBackground(Color.orange);
        panPara.setPreferredSize(new Dimension(200, 200));
        JLabel libPara = new JLabel("Para");
        panPara.add(libPara);
        
        panProgBar = new JPanel();
        panProgBar.setBackground(Color.green);
        panProgBar.setPreferredSize(new Dimension(400, 40));
        JLabel libProgBar = new JLabel("ProgBar");
        panProgBar.add(libProgBar);
        
        panText = new JPanel();
        panText.setBackground(Color.black);
        panText.setPreferredSize(new Dimension(400, 40));
        JLabel libText = new JLabel("Text");
        panText.add(libText);
        
        splitDroite = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panMenu, panPara);
        splitDroite.setDividerLocation(225);

        splitBas = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panText, panProgBar);
        splitBas.setDividerLocation(300);
        
        this.getContentPane().add(splitDroite, BorderLayout.EAST);
        this.getContentPane().add(panGraphic, BorderLayout.CENTER);
        this.getContentPane().add(splitBas, BorderLayout.SOUTH);

        int width = 50; 
        int length = 50;
        
        JButton[][] grid; //nom de la grille de bouton
        panGraphic.setLayout(new GridLayout(width,length)); //Layout
        grid = new JButton[width][length]; //allocattion de la taille de la grille
        for(int y=0; y<length; y++)
        {
            for(int x=0; x<width; x++)
            {
              //grid[x][y] = new JButton(x+","+y); //coordonnee - commenter la ligne suivante
                grid[x][y] = new JButton(); //creation des bouttons
                grid[x][y].setBackground(Color.white);
                panGraphic.add(grid[x][y]); //ajout des boutons
            }
        }
        this.setVisible(true);
    }
}
