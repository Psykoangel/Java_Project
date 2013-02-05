package gil;

import bol.Case;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class MainFrame extends JFrame {
    private JPanel panGraphic;
    private JPanel panMenu;
    private JPanel panPara;
    private JPanel panProgBar;
    private JPanel panText;
    private JSplitPane splitDroite;
    private JSplitPane splitBas;
    private Case[][] tabToShow;
    
    public MainFrame() {
        this.setLocationRelativeTo(null);
        this.setTitle("J-Sim Forest");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        
        this.panGraphic = new PanGraphic();
        this.panMenu = new PanMenu();
        this.panPara = new PanPara();
        this.panProgBar = new PanProgBar();
        this.panText = new PanText();
        
        this.splitDroite = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panMenu, panPara);
        this.splitDroite.setDividerLocation(225);

        this.splitBas = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panText, panProgBar);
        this.splitBas.setDividerLocation(300);
        
        this.getContentPane().add(splitDroite, BorderLayout.EAST);
        this.getContentPane().add(splitBas, BorderLayout.SOUTH);
        this.getContentPane().add(panGraphic, BorderLayout.CENTER);
    }

    public Case[][] getTabToShow() {
        return tabToShow;
    }

    public void setTabToShow(Case[][] tabToShow) {
        this.tabToShow = tabToShow;
        this.panGraphic (this.tabToShow);
    }
}
