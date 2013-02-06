
package bol;

import gil.GILObject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * 
 * @author Psyko
 */
public class Step implements ActionListener{
    
    int lastUpdate;
    int remainingTime;
    int stepNumber;
    int actualStepNumber;
    
    BOLObject BOLObj;
    GILObject GILObj;
    
    Timer timer;

    // Constructors
    /**
     * 
     */
    public Step() {
        
        remainingTime = 100;
        timer = new Timer(3000, this);
        timer.setInitialDelay(0);
    }
    
    /**
     * 
     * @param msTime
     * @param calculate
     */
    public Step(int msTime, BOLObject calculate, GILObject window) {
        
        remainingTime = 100;
        this.actualStepNumber = 0;
        this.BOLObj = calculate;
        this.GILObj = window;
        timer = new Timer(msTime, this);
        timer.setInitialDelay(0);
    }

    // Getter
    /**
     * 
     * @return
     */
    public int getActualStepNumber() {
        return actualStepNumber;
    }

    /**
     * 
     * @return
     */
    public int getRemainingTime() {
        return remainingTime;
    }

    // Setter
    /**
     * 
     * @param actualStepNumber
     */
    public void setActualStepNumber(int actualStepNumber) {
        this.actualStepNumber = actualStepNumber;
    }

    /**
     * 
     * @param remainingTime
     */
    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }
    
    
    /**
     * 
     * @param BOLobj
     */
    public void updateBOLObject(BOLObject BOLobj){
        this.BOLObj = BOLobj;
    }
    
    
    /**
     * 
     */
    public void start(){
        resume();
    }
    
    /**
     * 
     */
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
/*        
//======================DEBUG=======================================================================
        
        for (int j = 0; j < BOLObj.getUpdatedTab().getY(); j++) {
            
            for (int i = 0; i < BOLObj.getUpdatedTab().getX(); i++) {
                
                System.out.print(BOLObj.getUpdatedTab().getTab()[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");

//===================================================================================================
*/
        this.GILObj.setGridLength(this.BOLObj.getUpdatedTab().getX());
        this.GILObj.setGridWidth(this.BOLObj.getUpdatedTab().getY());
        this.GILObj.setTabToShow(this.BOLObj.getUpdatedTab().getTab());
        BOLObj.setTab(GILObj.getTabToShow(), GILObj.getGridWidth(), GILObj.getGridLength());
        System.out.println(GILObj.getGridWidth()+"|"+GILObj.getGridLength());
        BOLObj.CheckTab();
        this.updateBOLObject(BOLObj);
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
