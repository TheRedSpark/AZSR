import java.util.*;
import java.awt.*;
/**
 * Write a description of class Spielfeld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Spielfeld
{
    // instance variables - replace the example below with your own
    private int a = 1000;
    private int b = 1000;
    private static Random zufallsgenerator = newRandom()

    /**
     * Constructor for objects of class Spielfeld
     */
    public Spielfeld()
    {
    }

    public Punkt[] punkteEingeben()
    {
        System.out.println("Wie viele Punkte willst du haben?");
        Scanner input = new Scanner(System.in);
        int eingabewert = input.nextInt();
        Punkt[] punkteliste = new Punkt[eingabewert];

        for (int i=0; i<eingabewert; i++){
            System.out.println("X-Koordinate:");
            int x = input.nextInt();

            System.out.println("Y-Koordinate:");
            int y = input.nextInt();

            if (x>=0 & x<=a & y>=0 & y<=b){

                punkteliste[i] = new Punkt(x,y);     
            }
            else {
                System.out.println("Gib einen gültigen Wert ein!");
                i--;
            }
        }

        return punkteliste;
    }

    public ArrayList<Punkt> poiSortieren (Punkt[] poi){

        ArrayList<Punkt> poiSort = new ArrayList<Punkt>();
        poiSort.add(poi[0]);
        int x0 = 0;
        int y0 = 0;
        Punkt bigger = new Punkt();
        Punkt smaller = new Punkt();
        boolean run = true;
        for(int i = 0; i < poi.length && run == true; i++){
            run = false;
            Punkt p0 = new Punkt(x0,y0);
            for (int j = 0; j < poi.length-1; j++){
                double abstandEins = p0.gibAbstand(poi[j]);
                double abstandZwei = p0.gibAbstand(poi[j+1]);
                if(abstandEins > abstandZwei){
                    bigger = poi[j];
                    smaller = poi[j+1];
                    poi[j] = smaller;
                    poi[j+1] = bigger;
                    run = true;
                }
            }
        }

        return poiSort;
    }

    public void poiAbfahren(){
        ArrayList<Punkt>  sortedPoi = poiSortieren(punkteEingeben());
    }
    
    private int zufallszahl(int von, int bis){
        Random zufallsgenerator;       //BlueJ Buch Seite 230
        zufallsgenerator = new Random();
        int index = zufallsgenerator.nextInt(int n);
        System.out.println(index);
    }
    
    private int zufallsfarbe(){
        int index = zufallsgernerator.nextInt() //Test
        int test
        new Color(zufallsgenerator.nextInt(255),zufallsgenerator.nextInt(255),zufallsgenerator.nextInt(255));
    }
}
