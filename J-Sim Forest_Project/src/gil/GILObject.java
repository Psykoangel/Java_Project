package gil;

import bol.Case;
import javax.swing.JFrame;

public class GILObject{
    private JFrame mainFrame;
    private Case[][] tabToShow;
    
    public GILObject() {
        this.mainFrame = new MainFrame();
        this.mainFrame.setVisible(true);
    }
    
    
//    envoiyer tableau de case[][] changement d'état
//    set inversement
//    generation du tableau

    public Case[][] getTabToShow() {
        return tabToShow;
    }

    public void setTabToShowA(Case[][] tabToShow) {
        this.tabToShow = tabToShow;
        
    }

    public void tabIsUpdate(Case[][] tabToShow) {
    }
}