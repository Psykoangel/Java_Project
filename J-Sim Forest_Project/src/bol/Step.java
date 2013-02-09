
package bol;

import bol.utils.Etat;
import gil.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.HashMap;
import javax.swing.Timer;

public class Step implements ActionListener{
    
    int lastUpdate;
    int remainingTime;
    int stepSpeed;
    int stepNumber;
    int actualStepNumber;
    
    BOLObject BOLObj;
    MainFrame frame;
    
    Timer timer;

    // Constructors
    public Step() {
        remainingTime = 100;
        timer = new Timer(3000, this);
        timer.setInitialDelay(0);
    }
    
    public Step(int msTime, BOLObject calculate) {
        remainingTime = 100;
        this.actualStepNumber = 0;
        this.BOLObj = calculate;
        timer = new Timer(msTime, this);
        timer.setInitialDelay(0);
    }

    // Getter
    public int getActualStepNumber() {
        return actualStepNumber;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    // Setter
    public void setActualStepNumber(int actualStepNumber) {
        this.actualStepNumber = actualStepNumber;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }
    
    public void updateBOLObject(BOLObject BOLobj){
        this.BOLObj = BOLobj;
    }
    
    public void setStepParameter(int stepNumber, int stepSpeed){
        this.remainingTime = this.stepNumber = stepNumber;
        this.stepSpeed = stepSpeed;
        this.actualStepNumber = 0;
        timer = new Timer(this.stepSpeed, this);
        timer.setInitialDelay(0);
    }
    
    
    public void start(BOLObject obj, MainFrame frame){
        this.BOLObj = obj;
        this.frame = frame;
        resume();
    }
    
    public void stop(){
        pause();
    }
    
    public void update(){
        if (remainingTime == 0) {
            this.frame.getPanPara().getButPause().setVisible(false);
            this.frame.getPanPara().getButGeneration().setVisible(true);
            timer.stop();
        } else {
            int now = this.actualStepNumber++;
            int elapsed = now - lastUpdate;
            remainingTime -= elapsed;
            lastUpdate = now;
            
            this.frame.setTabToShow(this.BOLObj.getUpdatedTab().getTab(), this.BOLObj.getUpdatedTab().getX(), this.BOLObj.getUpdatedTab().getY());
            BOLObj.setTab(frame.getTabToShow(), frame.getGridWidth(), frame.getGridLength());
            BOLObj.CheckTab();
            this.frame.getPanGraphic().repaint();
            this.updateBOLObject(BOLObj);
            
            this.frame.getPanProgBar().setProgressNumber((int)(((double)actualStepNumber * 100.0)/(stepNumber + 1)));
            HashMap countResult = BOLObj.getCaseCounter().CountStateGridCase(BOLObj, frame);
            
            int nbMaxTabCase = BOLObj.getTab().getX()* BOLObj.getTab().getY();
            DecimalFormat df = new DecimalFormat("#.###");
            
            this.frame.getPanText().setNbStep("Tour : " + (actualStepNumber-1) + "/" + stepNumber);
            //this.frame.getPanText().setNbJeunePousse("JP : " + countResult.get(Etat.jeunePousse) + "/" + nbMaxTabCase);
            this.frame.getPanText().setNbJeunePousse("JP : " + df.format((double)Integer.valueOf(countResult.get(Etat.jeunePousse).toString())/(double)nbMaxTabCase));
            //this.frame.getPanText().setNbArbuste("Arbu. : " + (double)Integer.valueOf(countResult.get(Etat.arbuste).toString())/(double)nbMaxTabCase);
            this.frame.getPanText().setNbArbuste("Arbu. : " + df.format((double)Integer.valueOf(countResult.get(Etat.arbuste).toString())/(double)nbMaxTabCase));
            //this.frame.getPanText().setNbArbre("Arbre : " + (double)Integer.valueOf(countResult.get(Etat.arbre).toString())/(double)nbMaxTabCase);
            this.frame.getPanText().setNbArbre("Arbre : " + df.format((double)Integer.valueOf(countResult.get(Etat.arbre).toString())/(double)nbMaxTabCase));
            if (this.frame.getPanText().getNbFeu().isEnabled()) {
                //this.frame.getPanText().setNbFeu("Feu : " + (double)Integer.valueOf(countResult.get(Etat.feu).toString())/(double)nbMaxTabCase);
                this.frame.getPanText().setNbFeu("Feu : " + df.format((double)Integer.valueOf(countResult.get(Etat.feu).toString())/(double)nbMaxTabCase));
            }
            if (this.frame.getPanText().getNbInfecte().isEnabled()) {
                //this.frame.getPanText().setNbInfecte("Inf. : " + (double)Integer.valueOf(countResult.get(Etat.infecte).toString())/(double)nbMaxTabCase);
                this.frame.getPanText().setNbInfecte("Inf. : " + df.format((double)Integer.valueOf(countResult.get(Etat.infecte).toString())/(double)nbMaxTabCase));
            }
            
            this.frame.getPanText().repaint();
        }
    }
    
    void resume(){
        lastUpdate = this.actualStepNumber;
        timer.start();
    }
    
    void pause(){
        int now = this.actualStepNumber;
        remainingTime -= (now - lastUpdate);
        timer.stop();
    }
    
    public void nextStep(BOLObject obj, MainFrame frame){
        this.BOLObj = obj;
        this.frame = frame;
        update();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
    }
}
