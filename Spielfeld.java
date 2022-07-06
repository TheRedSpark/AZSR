import java.util.*;
import java.awt.*;

/**
 * Write a description of class Spielfeld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Spielfeld {
    // instance variables - replace the example below with your own
    private int a = 1000;
    private int b = 1000;
    private static Random zufallszahl = new Random();

    public Spielfeld() {
        Roboter Robo = new Roboter();
    }

    public static void Anrede(){
        System.out.println("\n"+"--------------------------------");
        System.out.println("Wähle 1 für Points of Intrest");
        System.out.println("Wähle 2 für Hindernisse umfahren");
        System.out.println("Wähle 3 für Stichwörter erkennen");
        System.out.println("Wähle 4 für das Ende");
        System.out.println("--------------------------------"+"\n");
    }
    
    public static void main(String[] args) {
        Spielfeld spieli = new Spielfeld();
        Roboter robi = new Roboter();
        Anrede();
        int antwort;
        loop:while (true){
            Scanner input = new Scanner(System.in);
            try{
                String frage = input.next().toUpperCase().trim();
                if (frage == "ENDE"){
                    antwort = 4;
                }
                else{
                    antwort = input.nextInt();
                }
            }
            catch(Exception e){
                System.out.println("Bitte eine Zahl eingeben");
                continue;
            }

            switch(antwort){
                case 1:
                    System.out.println("Du hast die Points of Intrest gewählt");
                    robi.spracherkennung();
                    Anrede();
                    break;
                case 2:
                    System.out.println("Du hast Hindernisse umfahren gewählt");
                    spieli.hindernisseUmfahren();
                    Anrede();
                    break;
                case 3:
                    System.out.println("Du hast die Spracherkennung gewählt");
                    robi.spracherkennung();
                    Anrede();
                    break;
                case 4:
                    System.out.println("Du hast das Ende gewählt");
                    break loop;
                default:
                    System.out.println("Bitte eine Zahl von 1-4 wählen");
                    break;
            }

        }
        System.out.println("Du hast das Program beendet");
    }

    /**
     * Constructor for objects of class Spielfeld
     */

    /**
     * It asks the user how many points he wants to enter, then it asks for the x and y coordinates of each point and
     * stores them in an array
     *
     * @return An array of points
     */
    public Punkt[] punkteEingeben() {
        System.out.println("Wie viele Punkte willst du haben?");
        Scanner input = new Scanner(System.in);
        int eingabewert = input.nextInt();
        Punkt[] punkteliste = new Punkt[eingabewert];

        for (int i = 0; i < eingabewert; i++) {
            System.out.println("X-Koordinate:");
            int x = input.nextInt();

            System.out.println("Y-Koordinate:");
            int y = input.nextInt();

            // It checks if the input is valid.
            if (x >= 0 & x <= a & y >= 0 & y <= b) {

                punkteliste[i] = new Punkt(x, y);
            } else {
                System.out.println("Gib einen gültigen Wert ein!");
                i--;
            }
        }

        return punkteliste;
    }

    /**
     * It sorts an array of points by their distance to the origin
     *
     * @param poi an array of points
     * @return An ArrayList of Points
     */
    public ArrayList<Punkt> poiSortieren(Punkt[] poi) {

        ArrayList<Punkt> poiSort = new ArrayList<Punkt>();
        poiSort.add(poi[0]);
        int x0 = 0;
        int y0 = 0;
        Punkt bigger = new Punkt();
        Punkt smaller = new Punkt();
        boolean run = true;
        for (int i = 0; i < poi.length && run == true; i++) {
            run = false;
            Punkt p0 = new Punkt(x0, y0);
            // Sorting the array of points by their distance to the origin.Bubble-Sort
            for (int j = 0; j < poi.length - 1; j++) {
                double abstandEins = p0.gibAbstand(poi[j]);
                double abstandZwei = p0.gibAbstand(poi[j + 1]);
                // Sorting the array of points by their distance to the origin.
                if (abstandEins > abstandZwei) {
                    bigger = poi[j];
                    smaller = poi[j + 1];
                    poi[j] = smaller;
                    poi[j + 1] = bigger;
                    run = true;
                }
            }
        }

        // for (Punkt s : poiSort){
        // System.out.println(s.ausgabeAttribute());
        // }
        return poiSort;
    }

    /**
     * > This function sorts the POIs by distance from the current location
     */
    public void poiAbfahren() {
        ArrayList<Punkt> sortedPoi = poiSortieren(punkteEingeben());

        // for (Punkt s : sortedPoi){
        // System.out.println(s.ausgabeAttribute());
        // }
        System.out.println(sortedPoi);
    }

    /**
     * It creates a random number of rectangles, checks if they fit into the game field and if they overlap with each other
     *
     * @return An ArrayList of Rectangles
     */
    public ArrayList<Rechteck> hindernisseErzeugen() {
        System.out.println("Anzahl der Rechtecke bitte");
        Scanner input = new Scanner(System.in);
        int rechtecke = input.nextInt();
        ArrayList<Rechteck> rechteliste = new ArrayList<Rechteck>();
        int errorcounter = 0;
        boolean rechteck_passt = false;
        boolean rechteck_uberlapptnicht = false;
        //Rechteck(Punkt position,int breite,int lange,String bezeichnung,Color farbe){
        for (int i = 0; i < rechtecke; i++) {
            Rechteck randomRechteck = new Rechteck(new Punkt(zufallszahl(0, 1000), zufallszahl(0, 1000)), zufallszahl(0, 1000), zufallszahl(0, 1000), "Rechteck" + i, zufallsfarbe());
            //                                                     xpunkt              ypunkt              breite              lange         bezeichnung          zufallsfarbe
            if (randomRechteck.getPosition().getX() + randomRechteck.getLange() >= a & randomRechteck.getPosition().getY() + randomRechteck.getBreite() >= b) {//überprüfen spielfeld
                rechteck_passt = false;
                errorcounter++;
                continue;
            }

            for (int o = 0; o < rechteliste.size(); o++) { //überprüfen  überlapptr
                if (!randomRechteck.ueberlappt(rechteliste.get(o))) {
                    rechteck_uberlapptnicht = true;
                } else {
                    rechteck_uberlapptnicht = false;
                }
                if (rechteck_uberlapptnicht = false) {
                    rechteliste.add(randomRechteck);
                } else {
                    i--;
                    errorcounter++;
                }
            }
        }
        return rechteliste;
    }

    public void zeichnen(ArrayList<Rechteck> hindernisse){

    }

    public void hindernisseUmfahren(){

    }

    /**
     * The function zufallszahl() returns a random number between the two numbers passed to it
     *
     * @param von the minimum number
     * @param bis The maximum number of the random number.
     * @return A random number between the two numbers given.
     */
    private int zufallszahl(int von, int bis) {
        return von + zufallszahl.nextInt(bis + 1);

    }

    /**
     * It creates a new color object with random values for red, green and blue
     *
     * @return A random color.
     */
    private Color zufallsfarbe() {
        Color zufallsfarbe = new Color(zufallszahl.nextInt(255), zufallszahl.nextInt(255), zufallszahl.nextInt(255));
        return zufallsfarbe;
    }
}
