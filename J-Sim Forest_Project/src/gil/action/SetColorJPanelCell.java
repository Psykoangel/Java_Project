
package gil.action;

import bol.BOLObject;
import gil.MainFrame;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class SetColorJPanelCell implements MouseListener {
    
    BOLObject obj;
    MainFrame frame;

    public SetColorJPanelCell(BOLObject obj, MainFrame frame) {
        this.obj = obj;
        this.frame = frame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JPanel selectedPanel = (JPanel) e.getSource();
        String selectedButton = frame.getPanPara().getCaseGroup().getSelection().getActionCommand();
        
        switch(selectedButton){
            case "Vide" :
                selectedPanel.setBackground(new Color(-1));
            break;
            case "Jeune pousse" :
                selectedPanel.setBackground(new Color(-7090095));
            break;
            case "Arbustre" :
                selectedPanel.setBackground(new Color(-13330125));
            break;
            case "Arbre" :
                selectedPanel.setBackground(new Color(-16692992));
            break;
            case "Feu" :
                selectedPanel.setBackground(new Color(-1630437));
            break;
            case "Cendre" :
                selectedPanel.setBackground(new Color(-8289663));
            break;
            case "Insectes" :
                selectedPanel.setBackground(new Color(-9618794));
            break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
