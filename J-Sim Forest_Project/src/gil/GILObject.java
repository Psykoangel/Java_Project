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

    public void setTabToShow(Case[][] tabToShow) {
        this.tabToShow = tabToShow;
        this.mainFrame.setTabToShow(this.tabToShow);
    }

    public int getGridLength() {
        this.gridLength = this.mainFrame.getGridLength();
        return gridLength;
    }

    public void setGridLength(int gridLength) {
        this.gridLength = gridLength;
        this.mainFrame.setGridLength(this.gridLength);
    }

    public int getGridWidth() {
        this.gridWidth = this.mainFrame.getGridWidth();
        return gridWidth;
    }

    public void setGridWidth(int gridWidth) {
        this.gridWidth = gridWidth;
        this.mainFrame.setGridWidth(this.gridWidth);
    }
    
}