package gil;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanMenu extends JPanel{
    private JButton butSave;
    private JButton butExport;
    private JButton butOpen;
    private JButton butGeneration;
    
    public PanMenu() {
        this.setPreferredSize(new Dimension(200, 200));
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        //Case de départ du composant
        gbc.gridx = 0;
        gbc.gridy = 0;
        //hauteur et largeur du composant
        gbc.gridheight = 1;
        gbc.gridwidth = 3;
        JLabel libMenu = new JLabel("Menu");
        this.add(libMenu, gbc);
        //---------------------------------------------
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.butSave = new JButton("Save");
        butSave.addActionListener(new ButSaveListener());
        this.add(butSave, gbc);
        //---------------------------------------------
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.butExport = new JButton("Export");
        butExport.addActionListener(new ButExportListener());
        this.add(butExport ,gbc);
        //---------------------------------------------
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.butOpen = new JButton("Open");
        butOpen.addActionListener(new ButOpenListener());
        this.add(butOpen, gbc);
        //---------------------------------------------
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.gridwidth = 4;
        this.butGeneration = new JButton("Génération");
        butGeneration.addActionListener(new ButGenerationListener());
        this.add(butGeneration, gbc);
        //---------------------------------------------
    }
      
    //bouton Save
    class ButSaveListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println("Save");
        }
    }
      
    //bouton Export
    class ButExportListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println("Export");
        }
    }
      
    //bouton Open
    class ButOpenListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println("Open");
        }
    }
    
    //bouton Génération
    class ButGenerationListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println("Generation");
        }
    }
}
