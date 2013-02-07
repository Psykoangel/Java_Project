package jsim_forest;

import bol.BOLObject;
import bol.Case;
import bol.Etat;
import bol.Step;
import gil.GILObject;
import java.sql.SQLException;


public class JSimForest_Project {

    public static void main(String[] args) throws SQLException {
        System.out.println("=== J-sim Forest ===");

        
        
        int stepNumber = 15;
        int wantedXTab = 7;
        int wantedYTab = 7;
        int TimeForOneStep = 1000;
        
        BOLObject calculate = new BOLObject();
        
        GILObject window = new GILObject(calculate);
        
        Step timeStep = new Step(TimeForOneStep, calculate, window);
        
        
        //================PARAMETRAGE============================================
        
        calculate.emptyTabGen(wantedXTab, wantedYTab);
        
        //Case[][] newTab = new Case[window.getGridLength()][window.getGridWidth()];
        Case[][] newTab = new Case[wantedXTab][wantedYTab];
        for (int i = 0; i < wantedYTab; i++) {
            for (int j = 0; j < wantedXTab; j++) {
                newTab[j][i] = new Case(Etat.vide);
            }
        }
        newTab[3][2].setEtat(Etat.jeunePousse);
        newTab[3][3].setEtat(Etat.jeunePousse);
        newTab[4][3].setEtat(Etat.jeunePousse);
        newTab[5][3].setEtat(Etat.jeunePousse);
        
        //================SIMULATION============================================
        
        System.out.println("=============SIMULATION==============");
        System.out.print("\n");
        System.out.print("\n");
        
        calculate.setUpdatedTab(newTab, wantedXTab, wantedYTab);
        calculate.setFireMode(false);
        calculate.setInvasionMode(false);

        timeStep.updateBOLObject(calculate);
        
        timeStep.setRemainingTime(stepNumber);
        //timeStep.start();
    }
}
