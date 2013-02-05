
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
            return " 0 ";
        }
        if (etat == Etat.jeunePousse) {
            return " 1 ";
        }
        if (etat == Etat.arbuste) {
            return " 2 ";
        }
        if (etat == Etat.arbre) {
            return " 3 ";
        }
        return " E ";
    }
    
    
}
