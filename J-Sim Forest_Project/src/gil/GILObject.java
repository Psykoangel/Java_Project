
package gil;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

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
        
        panGraphic = new PanGraphic(10, 10);
        panMenu = new PanMenu();
        panPara = new PanPara();
        panProgBar = new PanProgBar();
        panText = new PanText();
        
        splitDroite = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panMenu, panPara);
        splitDroite.setDividerLocation(225);

        splitBas = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panText, panProgBar);
        splitBas.setDividerLocation(300);
        
        this.getContentPane().add(splitDroite, BorderLayout.EAST);
        this.getContentPane().add(splitBas, BorderLayout.SOUTH);
        this.getContentPane().add(panGraphic, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
