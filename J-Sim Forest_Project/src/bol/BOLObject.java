
package bol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class BOLObject {
    
    
    //Attributes
    private Tableau tab;
    private Tableau updatedTab;
    
    
    // Constructors
    public BOLObject(){
        
    }
    
    
    //Setter
    public void setTab(Case[][] tab, int l, int w) {
        this.tab.setTab(tab);
        this.tab.setX(l);
        this.tab.setY(w);
    }

    public void setUpdatedTab(Case[][] tab, int l, int w) {
        this.updatedTab.setTab(tab);
        this.updatedTab.setX(l);
        this.updatedTab.setY(w);
    }
    
    
    //Getter
    public Tableau getTab() {
        return tab;
    }

    public Tableau getUpdatedTab() {
        return updatedTab;
    }
    
        
    public Tableau emptyTabGen(){
        this.tab = new Tableau();
        this.updatedTab = new Tableau();
        return tab;
    }
    
    public Tableau emptyTabGen(int x, int y){
        this.tab = new Tableau(x, y);
        this.updatedTab = new Tableau(x, y);
        return tab;
    }
    
    //Methods
    public void CheckTab(){
        
        updatedTab = new Tableau(this.tab.getX(), this.tab.getY());
        
        for (int width = 0; width < tab.getY(); width++) {
            for (int length = 0; length < tab.getX() ; length++) {
                
                ArrayList al = getVecinity(Neighborhood.VonNeumann, length, width, tab.getX(), tab.getY());
                
                HashMap countList = VecinityStateCount(al);
                
                UpdateCheckedCell(tab.getTab()[length][width], updatedTab.getTab()[length][width], countList);
                
            }
        }
    }
    
    private ArrayList getVecinity(Neighborhood nh, int length, int width, int xTabSize, int yTabSize){
        
        ArrayList<Case> VecinityList = new ArrayList<>();
        if (nh == Neighborhood.Moore) {
            
            if (length < xTabSize -1) {//   case droite
                VecinityList.add(tab.getTab()[length + 1][width]);
            }

            if (width < yTabSize -1) {//   case basse
                VecinityList.add(tab.getTab()[length][width + 1]);
            }

            if (length > 0) {//   case gauche
                VecinityList.add(tab.getTab()[length - 1][width]);
            }

            if (width > 0) {//   case haute
                VecinityList.add(tab.getTab()[length][width - 1]);
            }
            
        } else {
            
            if (length < xTabSize -1 && width > 0) {//   case droite haute
                VecinityList.add(tab.getTab()[length + 1][width - 1]);
            }

            if (length < xTabSize -1) {//   case droite
                VecinityList.add(tab.getTab()[length + 1][width]);
            }

            if (length < xTabSize -1 && width < yTabSize -1) {//   case droite basse
                VecinityList.add(tab.getTab()[length + 1][width + 1]);
            }

            if (width < yTabSize -1) {//   case basse
                VecinityList.add(tab.getTab()[length][width + 1]);
            }

            if (length > 0 && width < yTabSize -1) {//   case basse gauche
                VecinityList.add(tab.getTab()[length - 1][width + 1]);
            }

            if (length > 0) {//   case gauche
                VecinityList.add(tab.getTab()[length - 1][width]);
            }

            if (length > 0 && width > 0) {//   case gauche haute
                VecinityList.add(tab.getTab()[length - 1][width - 1]);
            }

            if (width > 0) {//   case haute
                VecinityList.add(tab.getTab()[length][width - 1]);
            }
        }
        
        return VecinityList;// retourne les cases du voisinage de la case donne en parametre.
    }
    
    private HashMap VecinityStateCount(ArrayList l){
        int temp;
        HashMap countList = new HashMap();
        countList.put(Etat.vide, 0);
        countList.put(Etat.jeunePousse, 0);
        countList.put(Etat.arbuste, 0);
        countList.put(Etat.arbre, 0);
        countList.put(Etat.feu, 0);
        countList.put(Etat.cendre, 0);
        countList.put(Etat.infecte, 0);
        
        
        for (Iterator it = l.iterator(); it.hasNext();) {//   pr chaque case du voisinage, on cherche son etat
            Case c = (Case) it.next();
            switch(c.getEtat()){
                case vide:
                    temp = Integer.valueOf(countList.get(Etat.vide).toString());
                    temp++;
                    countList.put(Etat.vide, temp);
                break;
                case jeunePousse:
                    temp = Integer.valueOf(countList.get(Etat.jeunePousse).toString());
                    temp++;
                    countList.put(Etat.jeunePousse, temp);
                break;
                case arbuste:
                    temp = Integer.valueOf(countList.get(Etat.arbuste).toString());
                    temp++;
                    countList.put(Etat.arbuste, temp);
                break;
                case arbre:
                    temp = Integer.valueOf(countList.get(Etat.arbre).toString());
                    temp++;
                    countList.put(Etat.arbre, temp);
                break;
                case feu:
                    temp = Integer.valueOf(countList.get(Etat.feu).toString());
                    temp++;
                    countList.put(Etat.feu, temp);
                break;
                case cendre:
                    temp = Integer.valueOf(countList.get(Etat.cendre).toString());
                    temp++;
                    countList.put(Etat.cendre, temp);
                break;
                case infecte:
                    temp = Integer.valueOf(countList.get(Etat.infecte).toString());
                    temp++;
                    countList.put(Etat.infecte, temp);
                break;
            }
        }
        return countList;
    }
    
    private void UpdateCheckedCell(Case c, Case cc, HashMap hm){
        cc.setEtat(c.getEtat());
        switch(c.getEtat()){
            case vide:
                if (Integer.valueOf(hm.get(Etat.arbre).toString()) >= 2
                    || Integer.valueOf(hm.get(Etat.arbuste).toString()) >= 3
                    || (Integer.valueOf(hm.get(Etat.arbre).toString()) == 1 && Integer.valueOf(hm.get(Etat.arbuste).toString()) == 2)) {
                    cc.setEtat(Etat.jeunePousse);
                }
            break;
            case jeunePousse:
                if (Integer.valueOf(hm.get(Etat.arbre).toString()) + Integer.valueOf(hm.get(Etat.arbuste).toString()) <= 3) {
                    cc.setEtat(Etat.arbuste);
                }
            break;
            case arbuste :
                if (c.getElapsedTime() == 1) {
                    cc.setEtat(Etat.arbre);
                    cc.setElapsedTime(0);
                } else{
                    cc.setElapsedTime(c.getElapsedTime() + 1);
                }
            break;
            case arbre:
                if (Integer.valueOf(hm.get(Etat.feu).toString()) <= 1) {
                    if (IgnitionOrInfected(Etat.arbre)) {
                        cc.setEtat(Etat.feu);
                    }
                }
            break;
            case feu:
                cc.setEtat(Etat.cendre);
            break;
            case cendre:
                cc.setEtat(Etat.vide);
            break;
            case infecte:
                cc.setEtat(Etat.vide);
            break;
        }
    }
    
    private int CreateRandomNumber(){
        int lowerPct = 0, hightPct = 100;
        int temp = (int)(Math.random() * (hightPct - lowerPct)) + lowerPct;
        int temp2 = (int)(Math.random() * (hightPct - lowerPct)) + lowerPct;
        int temp3 = (int)(Math.random() * (hightPct - lowerPct)) + lowerPct;
        return (int)((temp + temp2 + temp3)/3);
    }
    
    private boolean IgnitionOrInfected (Etat etat){
        int rdm = CreateRandomNumber();
        
        switch(etat){
            case jeunePousse:
                if (rdm > 0 && rdm < 25) {
                    return true;
                }
                if (rdm > 24 && rdm < 100) {
                    return false;
                }
            break;
            case arbuste:
                if (rdm > 0 && rdm < 50) {
                    return true;
                }
                if (rdm > 49 && rdm < 100) {
                    return false;
                }
            break;
            case arbre:
                if (rdm > 0 && rdm < 75) {
                    return true;
                }
                if (rdm > 74 && rdm < 100) {
                    return false;
                }
            break;
        }
        return false;
    }
}
