
package bol;

public class BOLObject {
    
    private Tableau tab;
    
    public BOLObject(){
        
    }
    
    public Tableau emptyTabGen(){
        this.tab = new Tableau();
        return tab;
    }
    
    public Tableau emptyTabGen(int x, int y){
        this.tab = new Tableau(x, y);
        return tab;
    }
    
    public void CheckTab(Tableau t){
        for (int width = 0; width < t.getY(); width++) {
            for (int length = 0; length < t.getX(); length++) {
                Case c = t.getTab()[length][width];
                // TODO complete the fonction checkTab.
                //Foreach cells look at the up, right, down, left and diagonals to list the various types of cells.
            }
        }
    }
    
    private void VecinityCellsCheck(){//   Fait la vérification du voisinage d'une cellule
        
    }
}
