
package gil.action;

import bol.BOLObject;
import dal.DALObject;
import gil.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExportCsv implements ActionListener {
    
    private BOLObject obj;
    private MainFrame frame;
    private DALObject DBAccess;

    public ExportCsv(BOLObject obj, MainFrame frame) {
        this.obj = obj;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DBAccess = new DALObject();
        
    }
}
