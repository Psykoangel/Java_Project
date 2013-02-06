package gil.action;

import gil.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButGeneration implements ActionListener {
    private String tailleX;
    private String tailleY;
    private MainFrame mainFrame;

    public ButGeneration(MainFrame mainFrame, String tailleX, String tailleY) {
        this.tailleX = tailleX;
        this.tailleY = tailleY;
        this.mainFrame = mainFrame;
    }

    public ButGeneration() {
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("Generation");
        this.mainFrame.setGridLength(Integer.valueOf(this.tailleX));
        this.mainFrame.setGridWidth(Integer.valueOf(this.tailleY));
    }

    public String getTailleX() {
        return tailleX;
    }

    public void setTailleX(String tailleX) {
        this.tailleX = tailleX;
    }

    public String getTailleY() {
        return tailleY;
    }

    public void setTailleY(String tailleY) {
        this.tailleY = tailleY;
    }
    
}