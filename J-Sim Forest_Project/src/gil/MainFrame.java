package gil;

import bol.Case;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class MainFrame extends JFrame {

    private PanGraphic panGraphic;
    private PanMenu panMenu;
    private PanPara panPara;
    private PanProgBar panProgBar;
    private PanText panText;
    private JSplitPane splitDroite;
    private JSplitPane splitBas;
    private Case[][] tabToShow;
    private int gridWidth;
    private int gridLength;

    public MainFrame() {
        //this.setLocationRelativeTo(null);
        this.setTitle("J-Sim Forest");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);

        this.panGraphic = new PanGraphic();
        this.panMenu = new PanMenu();
        this.panPara = new PanPara(this);
        this.panProgBar = new PanProgBar();
        this.panText = new PanText();

//        this.splitDroite = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panMenu, panPara);
//        this.splitDroite.setDividerLocation(225);

        this.splitBas = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panText, panProgBar);
        this.splitBas.setDividerLocation(300);

        this.getContentPane().add(panMenu, BorderLayout.NORTH);
        this.getContentPane().add(panPara, BorderLayout.EAST);
        this.getContentPane().add(splitBas, BorderLayout.SOUTH);
        this.getContentPane().add(panGraphic, BorderLayout.CENTER);
    }

    public Case[][] getTabToShow() {
        this.tabToShow = this.panGraphic.getTabToShow();
        return this.tabToShow;
    }

    public void setTabToShow(Case[][] tabToShow) {
        this.tabToShow = tabToShow;
        this.panGraphic.setTabToShow(this.tabToShow);
        this.panGraphic.repaint();
    }

    public int getGridLength() {

        this.gridLength = this.panGraphic.getGridLength();
        return gridLength;
    }

    public void setGridLength(int gridLength) {
        this.gridLength = gridLength;
        this.panGraphic.setGridLength(this.gridLength);
    }

    public int getGridWidth() {
        this.gridWidth = this.panGraphic.getGridWidth();
        return gridWidth;
    }

    public void setGridWidth(int gridWidth) {
        this.gridWidth = gridWidth;
        this.panGraphic.setGridWidth(this.gridWidth);
    }
}
