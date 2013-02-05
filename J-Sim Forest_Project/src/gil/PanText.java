package gil;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanText extends JPanel {

    public PanText() {
        this.setPreferredSize(new Dimension(400, 40));
        JLabel libText = new JLabel("Text");
        this.add(libText);
    }
}
