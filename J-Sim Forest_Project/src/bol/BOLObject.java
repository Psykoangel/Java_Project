
package bol;

public class BOLObject {
    
    private Tableau tab;
    
    public BOLObject(){
        
    }
    
    public Tableau emptyTabGen(){
        this.tab = new Tableau();
        String eta = tab.getTab()[0][0].getEtat().toString();
        System.out.println(eta);
        return tab;
    }
    
    public Tableau emptyTabGen(int x, int y){
        this.tab = new Tableau(x, y);
        String eta = tab.getTab()[0][0].getEtat().toString();
        System.out.println(eta);
        return tab;
    }
}
