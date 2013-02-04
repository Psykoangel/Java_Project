
package bol;

import java.util.*;

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
    
    public void CheckTab(){
        Case cRight = null;
        Case cRightDown = null;
        Case cDown = null;
        Case cDownLeft = null;
        Case cLeft = null;
        Case cLeftUp = null;
        Case cUp = null;
        Case cRightUp = null;
        List<Case> VecinityList = new ArrayList<>();
        
        for (int width = 0; width < tab.getY() -1; width++) {
            for (int length = 0; length < tab.getX() -1; length++) {
                Case c = tab.getTab()[length][width];
                
                if (length < tab.getX() -1) {
                    cRight = tab.getTab()[length + 1][width];
                    VecinityList.add(cRight);
                }
                if (length < tab.getX() -1 && width < tab.getY() -1) {
                    cRightDown = tab.getTab()[length + 1][width + 1];
                    VecinityList.add(cRightDown);
                }
                if (width < tab.getY() -1) {
                    cDown = tab.getTab()[length][width + 1];
                    VecinityList.add(cDown);
                }
                if (length > 0 && width < tab.getY() -1) {
                    cDownLeft = tab.getTab()[length - 1][width + 1];
                    VecinityList.add(cDownLeft);
                }
                if (length > 0) {
                    cLeft = tab.getTab()[length - 1][width];
                    VecinityList.add(cLeft);
                }
                if (length > 0 && width > 0) {
                    cLeftUp = tab.getTab()[length - 1][width - 1];
                    VecinityList.add(cLeftUp);
                }
                if (width > 0) {
                    cUp = tab.getTab()[length][width - 1];
                    VecinityList.add(cUp);
                }
                if (length < tab.getX() -1 && width > 0) {
                    cRightUp = tab.getTab()[length + 1][width - 1];
                    VecinityList.add(cRightUp);
                }
                
            }
        }
    }
    
    private HashMap VecinityCountCheck(ArrayList l){
        HashMap countList = new HashMap();
        countList.put(Etat.vide, 0);
        countList.put(Etat.jeunePousse, 0);
        countList.put(Etat.arbuste, 0);
        countList.put(Etat.arbre, 0);
        
        for (Iterator it = l.iterator(); it.hasNext();) {
            Case c = (Case) it.next();
            switch(c.getEtat()){
                case vide:
                    if (countList.containsKey(Etat.vide)) {
                        int temp = Integer.valueOf(countList.get(Etat.vide).toString());
                        temp++;
                        countList.put(Etat.vide, temp);
                    } else {
                        countList.put(Etat.vide, 1);
                    }
                break;
                case jeunePousse:
                    if (countList.containsKey(Etat.jeunePousse)) {
                        int temp = Integer.valueOf(countList.get(Etat.jeunePousse).toString());
                        temp++;
                        countList.put(Etat.jeunePousse, temp);
                    } else {
                        countList.put(Etat.jeunePousse, 1);
                    }
                break;
                case arbuste:
                    if (countList.containsKey(Etat.arbuste)) {
                        int temp = Integer.valueOf(countList.get(Etat.arbuste).toString());
                        temp++;
                        countList.put(Etat.arbuste, temp);
                    } else {
                        countList.put(Etat.arbuste, 1);
                    }
                break;
                case arbre:
                    if (countList.containsKey(Etat.arbre)) {
                        int temp = Integer.valueOf(countList.get(Etat.arbre).toString());
                        temp++;
                        countList.put(Etat.arbre, temp);
                    } else {
                        countList.put(Etat.arbre, 1);
                    }
                break;
            }
        }
        return countList;
    }
}
