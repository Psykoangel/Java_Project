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
        
        
        int stepNumber = 100;
        int wantedXTab = 50;
        int wantedYTab = 50;
        int TimeForOneStep = 500;
        
        GILObject window = new GILObject();
        
        BOLObject calculate = new BOLObject();
        calculate.emptyTabGen(7, 7);
        
        Step timeStep = new Step(TimeForOneStep, calculate, window);
        
        calculate.emptyTabGen(wantedXTab, wantedYTab);
        
        Case[][] newTab = new Case[window.getGridLength()][window.getGridWidth()];
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
        timeStep.start();
    }
}
