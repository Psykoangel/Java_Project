package gil;

import java.awt.*;
import javax.swing.JPanel;

public class PanGraphic extends JPanel{
    private Graphics[][] grid;
    
    public PanGraphic() {
        this.setPreferredSize(new Dimension(600, 500));
    }
    
    @Override
    public void paintComponent(Graphics g) {
        int width = 255;
        int length = 255;
        
        Graphics2D g2d = (Graphics2D) g;
        this.setLayout(new GridLayout(width,length));
        grid = new Graphics[width][length];
        for(int y=0; y<length; y++)
        {
            for(int x=0; x<width; x++)
            {
                //grid[x][y] = g
                g2d.setColor(new Color(x, 127, y));
                g2d.drawRect(x+5, y+5, 15, 15);
                //g2d.fillRect(x, y, width, length);
               /* 
                g2d.draw(new Rectangle2D.Double(x, y, 100, 100));*/
            }
        }
        g2d.setColor(Color.blue);
        //g2d.fillRect(1, 1, 20, 20);
    }
}
