
package gil;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GILObject extends JFrame {
    private JPanel pan;
    private JPanel pan1;
    
    public GILObject() {
        this.setTitle("J-Sim");
        this.setSize(500,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.pan = new JPanel(new BorderLayout());
        this.pan.setBackground(Color.RED);
        
        this.pan1 = new JPanel();
        this.pan1.setBackground(Color.BLUE);
/*        pan.add(pan1, BorderLayout.EAST);*/
        
      /*  this.getContentPane().add(pan);
        this.pan.add(new Button("OK"));
        this.getContentPane().add(pan1);*/
        
        this.setVisible(true);
    }
}
