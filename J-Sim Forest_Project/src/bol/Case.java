
package bol;

public class Case {
    private Etat etat;
    
    public Case(){
        this.etat = Etat.vide;
    }

    public Case(Etat etat) {
        this.etat = etat;
    }

    //Getter
    public Etat getEtat() {
        return etat;
    }

    //Setter
    public void setEtat(Etat etat) {
        this.etat = etat;
    }
    
    
}
