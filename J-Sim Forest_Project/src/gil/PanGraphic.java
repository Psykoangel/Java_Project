package gil;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanGraphic extends JPanel{
    private JButton[][] grid; //grille de bouton
    private int gridWidth;
    private int gridLength;
    
    public PanGraphic(int gridWidth, int gridLength) {
        this.setPreferredSize(new Dimension(600, 500));
        this.gridLength = gridLength;
        this.gridWidth = gridWidth;
        this.Grid();
    }
    
    private void Grid() {
        this.setLayout(new GridLayout(this.gridWidth, this.gridLength));
        grid = new JButton[this.gridWidth][this.gridLength];
        for(int y=0; y<this.gridLength; y++)
        {
            for(int x=0; x<this.gridWidth; x++)
            {
                //grid[x][y] = new JButton(x+","+y); //coordonnee - commenter la ligne suivante
                grid[x][y] = new JButton(); //creation des bouttons
                grid[x][y].setBackground(Color.white);
                this.add(grid[x][y]); //ajout des boutons
            }
        }
    }
}
