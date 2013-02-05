
package bol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class BOLObject {
    
    private Tableau tab;
    private Tableau updatedTab;
    
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
    
    
    
    
    
    
    
    public void CheckTab(){
        
        updatedTab = new Tableau(this.tab.getX(), this.tab.getY());
        
        for (int width = 0; width < tab.getY(); width++) {
            for (int length = 0; length < tab.getX() ; length++) {
                
                //System.out.println("DEBUG : " + length + " - " + width);
                
                ArrayList al = getVecinity(length, width, tab.getX(), tab.getY());
                
                HashMap countList = VecinityStateCount(al);
                
                UpdateCheckedCell(tab.getTab()[length][width], updatedTab.getTab()[length][width], countList);
            }
        }
    }
    
    private ArrayList getVecinity(int length, int width, int xTabSize, int yTabSize){
        
        ArrayList<Case> VecinityList = new ArrayList<>();
        
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
        
        return VecinityList;// retourne les cases du voisinage de la case donne en parametre.
    }
    
    private HashMap VecinityStateCount(ArrayList l){
        int temp;
        HashMap countList = new HashMap();
        countList.put(Etat.vide, 0);
        countList.put(Etat.jeunePousse, 0);
        countList.put(Etat.arbuste, 0);
        countList.put(Etat.arbre, 0);
        
        
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
            default:
            break;
                
        }
    }
}
