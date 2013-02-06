package gil;

import bol.Case;

public class GILObject {
    private MainFrame mainFrame;
    private Case[][] tabToShow;
    
    public GILObject () {
        this.mainFrame = new MainFrame();
        this.mainFrame.setVisible(true);
    }
    
//    envoiyer tableau de case[][] changement d'état
//    set inversement
//    generation du tableau

    public Case[][] getTabToShow() {
        this.tabToShow = this.mainFrame.getTabToShow();
        return this.tabToShow;
    }

    public void setTabToShow(Case[][] tabToShow) {
        this.tabToShow = tabToShow;
        this.mainFrame.setTabToShow(this.tabToShow);
    }
}