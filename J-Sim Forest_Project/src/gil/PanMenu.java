package gil;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanMenu extends JPanel{
    
    public PanMenu() {
        this.setPreferredSize(new Dimension(200, 200));
        JLabel libMenu = new JLabel("Menu");
        this.add(libMenu);
    }
}
