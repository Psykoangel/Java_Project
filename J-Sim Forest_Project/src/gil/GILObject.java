package gil;

import bol.BOLObject;
import bol.Case;

public class GILObject {
    
    private MainFrame mainFrame;
    BOLObject BOLObj;
    private Case[][] tabToShow;
    private int gridWidth;
    private int gridLength;
    
    
    public GILObject () {
        this.mainFrame = new MainFrame();
        this.mainFrame.setVisible(true);
    }

    public GILObject(BOLObject calculate) {
        this.BOLObj = calculate;
        this.mainFrame = new MainFrame(this.BOLObj);
        this.mainFrame.setVisible(true);
    }
    
//    envoiyer tableau de case[][] changement d'état
//    set inversement
//    generation du tableau

    public int getGridLength() {
        this.gridLength = this.mainFrame.getGridLength();
        return gridLength;
    }

    public int getGridWidth() {
        this.gridWidth = this.mainFrame.getGridWidth();
        return gridWidth;
    }

    public Case[][] getTabToShow() {
        this.tabToShow = this.mainFrame.getTabToShow();
        return this.tabToShow;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }
    
    public void setGridLength(int length){
        this.gridLength = length;
    }
    
    public void setGridWidth(int width){
        this.gridWidth = width;
    }

    public void setTabToShow(Case[][] tabToShow, int gridLength, int gridWidth) {
        this.tabToShow = tabToShow;
        this.gridLength = gridLength;
        this.gridWidth = gridWidth;
        this.mainFrame.setTabToShow(this.tabToShow, this.gridLength, this.gridWidth);
    }
}