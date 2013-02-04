
package bol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Step implements ActionListener{
    
    int lastUpdate;
    int remainingTime;
    int stepNumber;
    int actualStepNumber;
    
    Timer timer;

    // Constructors
    public Step(int msTime) {
        
        remainingTime = 100;
        this.actualStepNumber = 0;
        timer = new Timer(msTime, this);
        timer.setInitialDelay(0);
    }
    
    public Step() {
        
        remainingTime = 100;
        timer = new Timer(3000, this);
        timer.setInitialDelay(0);
    }

    // Getter
    public int getActualStepNumber() {
        return actualStepNumber;
    }

    // Setter
    public void setActualStepNumber(int actualStepNumber) {
        this.actualStepNumber = actualStepNumber;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
    }
}
