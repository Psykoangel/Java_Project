package gil;

import gil.action.ButGeneration;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanPara extends JPanel{
    private JButton butGeneration;
    private JTextField tailleX;
    private JTextField tailleY;
    private MainFrame mainframe;
    
    public PanPara(MainFrame mainFrame) {
        this.mainframe = mainFrame;
        this.setPreferredSize(new Dimension(200, 50));
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        //---------------------------------------------        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.gridwidth = 4;
        this.butGeneration = new JButton("Génération");
        //this.butGeneration.addActionListener(new ButGeneration(this.mainframe, this.tailleX.getText(), this.tailleY.getText()));
        this.add(butGeneration, gbc);
        //---------------------------------------------
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.tailleX = new JTextField("100");
        this.tailleX.setPreferredSize(new Dimension(50, 20));
        this.add(tailleX ,gbc);
        //tailleX.getText()
        //---------------------------------------------
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.tailleY = new JTextField("100");
        this.tailleY.setPreferredSize(new Dimension(50, 20));
        this.add(tailleY ,gbc);
        //---------------------------------------------
    }
}
