package gil;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanMenu extends JPanel{
    private JButton butSave;
    
    public PanMenu() {
        this.setPreferredSize(new Dimension(200, 200));
        JLabel libMenu = new JLabel("Menu");
        this.add(libMenu);
        
        this.butSave = new JButton("Save");
        //Classes internes qui écoutent nos boutons
        butSave.addActionListener(new ButSaveListener());
        this.add(butSave);
    }
      
    //Classe écoutant le bouton Save
    class ButSaveListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            System.out.println("Save");
        }
    }
}
