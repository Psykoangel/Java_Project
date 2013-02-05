package gil;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanProgBar extends JPanel {

    public PanProgBar() {
        this.setPreferredSize(new Dimension(400, 40));
        JLabel libProgBar = new JLabel("ProgBar");
        this.add(libProgBar);
    }
}
