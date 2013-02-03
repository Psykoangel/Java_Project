
package gil;

import java.awt.HeadlessException;
import javax.swing.JFrame;

public class MainWindow extends JFrame {

    public MainWindow() throws HeadlessException {
        this.setTitle("Main");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
}
