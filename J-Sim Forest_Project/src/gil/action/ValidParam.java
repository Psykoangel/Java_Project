
package gil.action;

import bol.BOLObject;
import gil.MainFrame;
import gil.PanPara;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ValidParam implements ActionListener {
    
    BOLObject obj;
    MainFrame frame;
    
    public ValidParam(BOLObject obj, MainFrame frame) {
        this.obj = obj;
        this.frame = frame;
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        PanPara panelParam = (PanPara) ((Component)e.getSource()).getParent();
        int abscisse = Integer.valueOf(panelParam.getTailleX().getText());
        int ordonnee = Integer.valueOf(panelParam.getTailleY().getText());
        this.frame.setTabToShow(obj.emptyTabGen(abscisse, ordonnee).getTab(), abscisse, ordonnee);
        panelParam.getTfStep().setVisible(true);
        panelParam.getTfStepNumber().setVisible(true);
        this.frame.getPanGraphic().repaint();
    }
    
}
