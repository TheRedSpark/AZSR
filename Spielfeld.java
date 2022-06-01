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
    private static Random zufallszahl = new Random();

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

    public ArrayList<Rechteck> hindernisseErzeugen (){
        System.out.println("Anzahl der Rechtecke bitte");
        Scanner input = new Scanner(System.in);
        int rechtecke = input.nextInt();
        ArrayList<Rechteck> rechteliste = new ArrayList<Rechteck>();
        int errorcounter = 0;
        boolean rechteck_passt = false;
        boolean rechteck_uberlappt = false;
        //Rechteck(Punkt position,int breite,int lange,String bezeichnung,Color farbe){
        for (int i=0; i<rechtecke; i++){
            Rechteck randomRechteck = new Rechteck(new Punkt(zufallszahl(0,1000),zufallszahl(0,1000)),zufallszahl(0,1000),zufallszahl(0,1000),"Rechteck" + i,zufallsfarbe());
            //                                                     xpunkt              ypunkt              breite              lange         bezeichnung          zufallsfarbe
            if (randomRechteck.getPosition().getX() + randomRechteck.getLange() <= a & randomRechteck.getPosition().getY() + randomRechteck.getBreite() <= b){//überprüfen spielfeld
                //rechteck_passt = true;
                //pass;
            }
            else{
                rechteck_passt = false;
                errorcounter++;
                continue;
            }

            for (int o=0; o<rechteliste.size(); o++){ //überprüfen  überlapptr
                if (!randomRechteck.ueberlappt(rechteliste.get(o))){
                    rechteck_uberlappt = true;
                }

                else{
                    rechteck_uberlappt = false;
                    errorcounter++;

                }
                if (rechteck_passt = true && rechteck_uberlappt = false){
                    rechteliste.add(randomRechteck);

                }
                else{
                    i--;
                    errorcounter ++;
                }
            }
            return rechteliste;
        }
    }
    
        private int zufallszahl(int von, int bis){
        return von +zufallszahl.nextInt(bis+1);

    }

    private Color zufallsfarbe(){
        Color zufallsfarbe = new Color(zufallszahl.nextInt(255),zufallszahl.nextInt(255),zufallszahl.nextInt(255));
        return zufallsfarbe;
    }
}
