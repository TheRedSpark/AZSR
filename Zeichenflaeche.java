import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;

public class Zeichenflaeche extends JPanel
{
    private ArrayList<Rechteck> hindernisse;

        public Zeichenflaeche()
    {
        super();  
        setVisible(true);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        for (Rechteck r: hindernisse){
            g.drawRect(r.getPosition().getX(),r.getPosition().getY(),r.getBreite(),r.getLange());
            g.fillRect(r.getPosition().getX(),r.getPosition().getY(),r.getBreite(),r.getLange());
        }
    }

    public void repaintFiguren(ArrayList<Rechteck> figuren){
        hindernisse = figuren;
        repaint();

    }
}
