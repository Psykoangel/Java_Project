package gil;

import bol.Case;
import bol.Etat;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PanGraphic extends JPanel{
    private JPanel[][] grid;
    private Case[][] tabToShow;
    private int gridWidth;
    private int gridLength;
    private Border blackline;

    public PanGraphic(){
        this.setPreferredSize(new Dimension(600, 500));
        this.blackline = BorderFactory.createLineBorder(Color.black, 1);
        //this.CreateGrid();
    }
    
    private void CreateGrid() {
        //this.removeAll();
    }
    
    private void updateGrid() {
        this.CreateGrid();
        System.out.println("Update grid");
        System.out.println(this.tabToShow[3][2].getEtat());
        for(int y=0; y<this.gridLength; y++)
        {
            for(int x=0; x<this.gridWidth; x++)
            {
                //this.grid[x][y] = new JPanel();
                this.grid[x][y].setBorder(blackline);
                //this.add(this.grid[x][y]);
                this.ConvertToGrid(x, y);
                this.ConvertToCell(x, y);
            }
        }
    }
    
    private void ConvertToGrid(int x, int y) 
    {
        switch (this.tabToShow[x][y].getEtat()) 
        {
            case vide:        //vide -- blanc -- 255,255,255 -- 0
                this.grid[x][y].setBackground(new Color(255,255,255));
                break;
            case jeunePousse:  //jeune pousse -- vert clair -- 147,208,81 -- 1
                this.grid[x][y].setBackground(new Color(147,208,81));
                break;
            case arbuste:       //arbuste -- vert -- 52,153,51 -- 2
                this.grid[x][y].setBackground(new Color(52,153,51));
                break;
            case arbre:         //arbre -- vert foncée  -- 1,73,0 -- 3
                this.grid[x][y].setBackground(new Color(1,73,0));
                break;
            case feu:           //feu -- rouge -- 231,31,27 -- 4
                this.grid[x][y].setBackground(new Color(231,31,27));
                break;
            case cendre:        //cendre -- gris -- 129,130,129 -- 5
                this.grid[x][y].setBackground(new Color(129,130,129));
                break;
            case infecte:       //infecte -- violet -- 109,58,150 -- 6
                this.grid[x][y].setBackground(new Color(109,58,150));
                break;
            default:
                this.grid[x][y].setBackground(new Color(255, 255, 255));
                break;
        }
    }
    private void ConvertToCell(int x, int y) 
    {
        switch (this.grid[x][y].getBackground().getRGB()) {
            case -1:        //vide -- blanc -- 255,255,255 -- 0
                this.tabToShow[x][y].setEtat(Etat.vide);
                break;
            case -7090095:  //jeune pousse -- vert clair -- 147,208,81 -- 1
                this.tabToShow[x][y].setEtat(Etat.jeunePousse);
                break;
            case -13330125: //arbuste -- vert -- 52,153,51 -- 2
                this.tabToShow[x][y].setEtat(Etat.arbuste);
                break;
            case -16692992: //arbre -- vert foncée  -- 1,73,0 -- 3
                this.tabToShow[x][y].setEtat(Etat.arbre);
                break;
            case -1630437:  //feu -- rouge -- 231,31,27 -- 4
                this.tabToShow[x][y].setEtat(Etat.feu);
                break;
            case -8289663:  //cendre -- gris -- 129,130,129 -- 5
                this.tabToShow[x][y].setEtat(Etat.cendre);
                break;
            case -9618794:  //infecte -- violet -- 109,58,150 -- 6
                this.tabToShow[x][y].setEtat(Etat.infecte);
                break;
            default:
                this.tabToShow[x][y].setEtat(Etat.vide);
                break;
        }
    }
    
    public Case[][] getTabToShow() {
        return this.tabToShow;
    }

    public void setTabToShow(Case[][] tabToShow) {
        this.tabToShow = tabToShow;
        this.updateGrid();
    }

    public int getGridLength() {
        return gridLength;
    }

    public void setGridLength(int gridLength) {
        this.gridLength = gridLength;
    }

    public int getGridWidth() {
        return gridWidth;
    }

    public void setGridWidth(int gridWidth) {
        if(this.gridWidth != gridWidth)
        {
            this.gridWidth = gridWidth;
            this.removeAll();
            this.grid = new JPanel[this.gridWidth][this.gridLength];
            this.setLayout(new GridLayout(this.gridWidth, this.gridLength));

            for(int y=0; y<this.gridLength; y++)
            {
                for(int x=0; x<this.gridWidth; x++)
                {   
                    this.grid[x][y] = new JPanel();
                    this.add(this.grid[x][y]);
                }
            }
        }
    }
//    
//    class ButGenerationListener implements ActionListener{
//        @Override
//        public void actionPerformed(ActionEvent event) {
//            System.out.println("Generation");
//
//        }
//    }
}
