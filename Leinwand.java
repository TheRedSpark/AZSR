import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;

public class Leinwand
{
    private JFrame fenster;
    private Zeichenflaeche zeichenflaeche;
    public int breite;
    public int laenge;

    /**
     * Konstruktor für Objekte der Klasse Leinwand
     */
    public Leinwand(int breite, int lange)
    {
        zeichenflaeche = new Zeichenflaeche();
        fenster = new JFrame();                         
        fenster.setContentPane(zeichenflaeche);         
        fenster.setTitle("Titel");  
        fenster.setPreferredSize(new Dimension(laenge, breite));
        fenster.setVisible(true);
    }
    
    /**
     * wartet auf bestimmte Anzahl von Millisekunden bevor Schritt beendet wird.
     * wird für animationen genutzt, um eine kurze verzögerung zuerzeugen, damit man was erkennt
     * @param  milliseconds  the number 
     */
    public void warten(int millisekunden)
    {
        try
        {
            Thread.sleep(millisekunden);
        } 
        catch (Exception e)
        {
        }
    }
    
    public void zeichnen(ArrayList<Rechteck> hindernisse)
    {
        zeichenflaeche.repaintFiguren(hindernisse);
    }
}
