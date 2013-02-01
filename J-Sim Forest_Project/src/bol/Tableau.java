
package bol;

public class Tableau {
    private Case tab[][];
    private int x;
    private int y;
    
    public Tableau(){
        this.x = 10;
        this.y = 10;
    }
    
    public Tableau(int x_default, int y_default){
        this.x = x_default;
        this.y = y_default;
    }
}
