package gil;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class PanProgBar extends JPanel {
    
    private JProgressBar progressBar;
    private int progressNumber = 0;

    public PanProgBar() {
        this.setPreferredSize(new Dimension(400, 40));
        progressBar = new JProgressBar(0, 100);
        progressBar.setPreferredSize(new Dimension(400, 40));
        progressBar.setValue(progressNumber);
        progressBar.setStringPainted(true);
        this.add(progressBar);
    }

    public int getProgressNumber() {
        return progressNumber;
    }

    public void setProgressNumber(int progressNumber) {
        this.progressNumber = progressNumber;
    }
    
    
}
