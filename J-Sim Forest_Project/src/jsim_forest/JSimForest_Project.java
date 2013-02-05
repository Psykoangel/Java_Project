package jsim_forest;

import bol.BOLObject;
import bol.Case;
import bol.Etat;
import gil.GILObject;


public class JSimForest_Project {

    public static void main(String[] args) throws Exception {
        System.out.println("=== J-sim Forest ===");
        
        GILObject window = new GILObject();
        BOLObject calculate = new BOLObject();
        calculate.emptyTabGen(7, 7);
        
        Case[][] newTab = new Case[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                newTab[j][i] = new Case(Etat.vide);
            }
        }
        newTab[3][2].setEtat(Etat.jeunePousse);
        newTab[3][3].setEtat(Etat.jeunePousse);
        newTab[4][3].setEtat(Etat.jeunePousse);
        newTab[5][3].setEtat(Etat.jeunePousse);
        
        
        System.out.println("=============SIMULATION==============");
        System.out.print("\n");
        System.out.print("\n");
        
        calculate.setUpdatedTab(newTab, 7, 7);
        
//        for (int pas = 0; pas < 7; pas++) {
//            for (int j = 0; j < calculate.getUpdatedTab().getY(); j++) {
//                for (int i = 0; i < calculate.getUpdatedTab().getX(); i++) {
//                    System.out.print(calculate.getUpdatedTab().getTab()[i][j] + " ");
//                }
//                System.out.print("\n");
//            }
//            System.out.print("\n\n");
//            calculate.setTab(calculate.getUpdatedTab().getTab(), calculate.getUpdatedTab().getX(), calculate.getUpdatedTab().getY());
//            calculate.CheckTab();
//        }
        
        window.setTabToShow(calculate.getUpdatedTab().getTab());
    }
}
