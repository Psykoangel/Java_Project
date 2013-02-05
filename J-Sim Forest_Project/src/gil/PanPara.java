package gil;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanPara extends JPanel{
    
    public PanPara() {
        this.setPreferredSize(new Dimension(200, 200));
        JLabel libPara = new JLabel("Para");
        this.add(libPara);
    }
}
