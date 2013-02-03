
package bol;

public class Tableau {
    private Case tab[][];
    private int x;
    private int y;
    
    public Tableau(){
        this.x = 100;
        this.y = 100;
        this.tab = new Case[x][y];
        for (int width = 0; width < this.y -1; width++) {
            for (int length = 0; length < this.x -1; length++) {
                this.tab[length][width] = new Case(Etat.vide);
            }
        }
    }
    
    public Tableau(int x_default, int y_default){
        this.x = x_default;
        this.y = y_default;
        this.tab = new Case[x][y];
        for (int width = 0; width < this.y -1; width++) {
            for (int length = 0; length < this.x -1; length++) {
                this.tab[length][width] = new Case();
            }
        }
    }

    //Getter
    public Case[][] getTab() {
        return tab;
    }

    //Setter
    public void setTab(Case[][] tab) {
        this.tab = tab;
    }
    
    
}
