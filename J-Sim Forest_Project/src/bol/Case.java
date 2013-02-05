
package bol;

public class Case {
    private Etat etat;
    private int elapsedTime;
    
    public Case(){
        this.etat = Etat.vide;
        this.elapsedTime = 0;
    }

    public Case(Etat etat) {
        this.etat = etat;
        this.elapsedTime = 0;
    }

    //Getter
    public Etat getEtat() {
        return etat;
    }

    public int getElapsedTime() {
        return elapsedTime;
    }

    //Setter
    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public void setElapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    @Override
    public String toString() {
        if (etat == Etat.vide) {
            return " V ";
        }
        if (etat == Etat.jeunePousse) {
            return " J ";
        }
        if (etat == Etat.arbuste) {
            return " U ";
        }
        if (etat == Etat.arbre) {
            return " A ";
        }
        return " E ";
    }
}
