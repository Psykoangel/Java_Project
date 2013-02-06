package gil;


import gil.action.ButGeneration;
import gil.action.ButQuit;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

public class PanMenu extends JMenuBar{
    private JButton butOpen;
    private JButton butGeneration;
    private JButton butPlay;
    
    public PanMenu() {
        this.setPreferredSize(new Dimension(30, 30));
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        JMenu file = new JMenu("Files");
        this.add(file);
        
        
            JMenuItem importItem = new JMenuItem("Import");
            file.add(importItem);

            JMenuItem exportItem = new JMenuItem("Export");
            file.add(exportItem);

            JMenuItem csvItem = new JMenuItem("Export CSV");
            file.add(csvItem);

            JMenuItem quitItem = new JMenuItem("Quit");
            file.add(quitItem);
            quitItem.addActionListener(new ButQuit());
        
        
        JMenu generate = new JMenu("Generation");
        this.add(generate);
        
            JMenuItem geneItem = new JMenuItem("Generation");
            generate.add(geneItem);
            geneItem.addActionListener(new ButGeneration());

            JMenuItem playItem = new JMenuItem("Play");
            generate.add(playItem);

            JMenuItem pauseItem = new JMenuItem("Pause");
            generate.add(pauseItem);
        
        
        JMenu mode = new JMenu("Mode");
        this.add(mode);
        
            JMenuItem fireItem = new JCheckBoxMenuItem("Fire");
            mode.add(fireItem);

            JMenuItem infectItem = new JCheckBoxMenuItem("Infected");
            mode.add(infectItem);
        
        
        this.setVisible(true);
    }
        
   /*    
        //Case de départ du composant
        gbc.gridx = 0;
        gbc.gridy = 0;
        //Hauteur et largeur du composant
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
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridheight = 1;
        gbc.gridwidth = 4;
        this.butPlay = new JButton("Play");
        butPlay.addActionListener(new ButGenerationListener());
        this.add(butPlay, gbc);
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

    public JButton getButGeneration() {
        return butGeneration;
    }

    public void setButGeneration(JButton butGeneration) {
        this.butGeneration = butGeneration;
    }
    //bouton Play
    class ButPlayListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println("Play");
        }
    }*/
}
