package gil;

import bol.BOLObject;
import bol.Case;
import gil.action.ValidParam;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class MainFrame extends JFrame {

    private PanGraphic panGraphic;
    private PanMenu panMenu;
    private PanPara panPara;
    private PanProgBar panProgBar;
    private PanText panText;
    
    private JSplitPane splitBas;
    
    BOLObject BOLObj;
    private Case[][] tabToShow;
    private int gridWidth;
    private int gridLength;

    
    public MainFrame() {
        //this.setLocationRelativeTo(null);
        this.setTitle("J-Sim Forest");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);

        this.panMenu = new PanMenu();
        this.panGraphic = new PanGraphic();
        this.panPara = new PanPara();
        this.panText = new PanText();
        this.panProgBar = new PanProgBar();

        this.splitBas = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panText, panProgBar);
        this.splitBas.setDividerLocation(300);

        this.setJMenuBar(panMenu);
        this.getContentPane().add(panGraphic, BorderLayout.CENTER);
        this.getContentPane().add(panPara, BorderLayout.EAST);
        this.getContentPane().add(splitBas, BorderLayout.SOUTH);
    }

    MainFrame(BOLObject BOLObj) {
        //this.setLocationRelativeTo(null);
        this.setTitle("J-Sim Forest");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);

        this.panGraphic = new PanGraphic();
        this.panMenu = new PanMenu();
        this.panPara = new PanPara();
        this.panProgBar = new PanProgBar();
        this.panText = new PanText();
        
        this.panPara.getButValid().addActionListener(new ValidParam(BOLObj, this));

        this.splitBas = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panText, panProgBar);
        this.splitBas.setDividerLocation(300);

        this.setJMenuBar(panMenu);
        this.getContentPane().add(panGraphic, BorderLayout.CENTER);
        this.getContentPane().add(panPara, BorderLayout.EAST);        
        this.getContentPane().add(splitBas, BorderLayout.SOUTH);
    }

    
    public Case[][] getTabToShow() {
        this.tabToShow = this.panGraphic.getTabToShow();
        return this.tabToShow;
    }

    public int getGridLength() {

        this.gridLength = this.panGraphic.getGridLength();
        return gridLength;
    }

    public int getGridWidth() {
        this.gridWidth = this.panGraphic.getGridWidth();
        return gridWidth;
    }

    public PanGraphic getPanGraphic() {
        return panGraphic;
    }

    public PanMenu getPanMenu() {
        return panMenu;
    }

    public PanPara getPanPara() {
        return panPara;
    }

    public PanProgBar getPanProgBar() {
        return panProgBar;
    }

    public PanText getPanText() {
        return panText;
    }

    
    public void setTabToShow(Case[][] tabToShow, int gridLength, int gridWidth) {
        this.tabToShow = tabToShow;
        this.gridLength = gridLength;
        this.gridWidth = gridWidth;
        this.panGraphic.setTabToShow(this.tabToShow);
        this.panGraphic.setGridLength(this.gridLength);
        this.panGraphic.setGridWidth(this.gridWidth);
        this.panGraphic.repaint();
    }
}
