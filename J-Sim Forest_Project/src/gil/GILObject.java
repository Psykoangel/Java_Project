package gil;

import bol.Case;

public class GILObject {
    private MainFrame mainFrame;
    private Case[][] tabToShow;
    private int gridWidth;
    private int gridLength;
    
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

    public void setTabToShow(Case[][] tabToShow, int gridLength, int gridWidth) {
        this.tabToShow = tabToShow;
        this.mainFrame.setTabToShow(this.tabToShow);
        this.gridLength = gridLength;
        this.mainFrame.setGridLength(this.gridLength);
        this.gridWidth = gridWidth;
        this.mainFrame.setGridWidth(this.gridWidth);
    }

    public int getGridLength() {
        this.gridLength = this.mainFrame.getGridLength();
        return gridLength;
    }

    public int getGridWidth() {
        this.gridWidth = this.mainFrame.getGridWidth();
        return gridWidth;
    }
    
}