
package gil;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class GILObject extends JFrame {
    private JPanel panGraphic;
    private JPanel panMenu;
    private JPanel panPara;
    private JPanel panProgBar;
    private JPanel panText;
    private JSplitPane split;
    private JSplitPane split2;
    
    public GILObject() {

        this.setLocationRelativeTo(null);
        this.setTitle("J-Sim Forest");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);

        panGraphic = new JPanel();
        panGraphic.setBackground(Color.blue);
        panGraphic.setPreferredSize(new Dimension(600, 500));
        JLabel libGraphic = new JLabel("Graphic");
        panGraphic.add(libGraphic);

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
        panProgBar.setPreferredSize(new Dimension(400, 50));
        JLabel libProgBar = new JLabel("ProgBar");
        panProgBar.add(libProgBar);
        
        panText = new JPanel();
        panText.setBackground(Color.black);
        panText.setPreferredSize(new Dimension(400, 50));
        JLabel libText = new JLabel("Text");
        panText.add(libText);

       
        
        split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panMenu, panPara);
        split.setDividerLocation(200);

        split2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panText, panProgBar);
        split2.setDividerLocation(300);
        
        this.getContentPane().add(split, BorderLayout.EAST);
        this.getContentPane().add(panGraphic, BorderLayout.CENTER);
        this.getContentPane().add(split2, BorderLayout.SOUTH);
        
        
        this.setVisible(true);
    }
}
