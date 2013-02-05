
package bol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Step implements ActionListener{
    
    int lastUpdate;
    int remainingTime;
    int stepNumber;
    int actualStepNumber;
    BOLObject calculate;
    
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
        this.calculate = calculate;
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

    // Setter
    public void setActualStepNumber(int actualStepNumber) {
        this.actualStepNumber = actualStepNumber;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }
    
    
    public void updateBOLObject(BOLObject BOLobj){
        this.calculate = BOLobj;
    }
    
    
    public void start(){
        resume();
    }
    
    public void stop(){
        pause();
    }
    
    void update(){
        int now = this.actualStepNumber++;
        int elapsed = now - lastUpdate;
        remainingTime -= elapsed;
        lastUpdate = now;
        
        if (remainingTime < 0) {
            remainingTime = 0;
        }
        
        if (remainingTime == 0) {
            timer.stop();
            return;
        }
        
        for (int j = 0; j < calculate.getUpdatedTab().getY(); j++) {
            for (int i = 0; i < calculate.getUpdatedTab().getX(); i++) {
                System.out.print(calculate.getUpdatedTab().getTab()[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");

        calculate.setTab(calculate.getUpdatedTab().getTab(), calculate.getUpdatedTab().getX(), calculate.getUpdatedTab().getY());
        calculate.CheckTab();
        this.updateBOLObject(calculate);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
    }
}
