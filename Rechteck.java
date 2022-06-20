/**
 * It's a class that represents a rectangle
 */
// It imports the Color class from the java.awt package.

import java.awt.Color;

public class Rechteck {
    // It's creating a new object of the class Punkt.
    private Punkt position = new Punkt();
    private int breite;
    private int lange;
    private String bezeichnung;
    private Color farbe;
    private Punkt vektor = new Punkt();

    public Rechteck() {
        this.farbe = Color.red;
    }

    // It's a constructor.
    public Rechteck(Punkt position, int breite, int lange, String bezeichnung, Color farbe) {
        this.position = position;
        // It's checking if the value of breite and lange is less than 100. If it's not, it's printing out a message
        // and exiting the program.
        if (breite <= 100 & lange <= 100) {
            this.breite = breite;
            this.lange = lange;
        } else {
            System.out.println("Gib einen gültigen Wert ein!");
            System.exit(0);
        }
        this.bezeichnung = bezeichnung;
        this.farbe = farbe;

    }

    // It's a getter and setter.
    public Punkt getPosition() {
        return position;
    }

    public void setPosition(Punkt position) {
        this.position = position;
    }

    public int getBreite() {
        return breite;
    }

    public void setBreite(int breite) {
        this.breite = breite;
    }

    public int getLange() {
        return lange;
    }

    public void setLange(int lange) {
        this.lange = lange;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public Color getFarbe() {
        return farbe;
    }

    public void setColor() {
        this.farbe = farbe;
    }

    /**
     * The function bewegeUm() takes a Punkt object as a parameter and moves the Punkt object that is stored in the
     * variable position by the amount of the x and y values of the Punkt object that is passed as a parameter
     *
     * @param vektor The vector to move the point by.
     */
    public void bewegeUm(Punkt vektor) {
        int dx = vektor.getX();
        int dy = vektor.getY();
        position.bewegeUm(dx, dy);
    }

    /**
     * The function `ausgabeAttribute()` prints the attributes of the object `Rechteck` to the console
     */
    public void ausgabeAttribute() {
        System.out.println(position + "," + breite + "," + lange + "," + bezeichnung + "," + farbe);
    }

    /**
     * If the x or y coordinates of the rectangle are within the range of the x or y coordinates of the other rectangle,
     * then the rectangles overlap
     *
     * @param r The rectangle that is being checked for overlap
     */
    public boolean ueberlappt(Rechteck r) {
        int xrange = getPosition().getX() + getBreite();
        int yrange = getPosition().getY() + getLange();
        int PunktX = getPosition().getX();
        int PunktY = getPosition().getY();

        int x = r.position.getX();
        int y = r.position.getY();
        int xlange = r.position.getX() + r.lange;
        int ybreite = r.position.getY() + r.breite;

        if (PunktX <= x & x <= xrange) {
            return true;
        } else if (PunktX <= xlange & xlange <= xrange) {
            return true;
        } else if (PunktY <= y & y <= yrange) {
            return true;
        } else if (PunktY <= ybreite & ybreite <= yrange) {
            return true;
        } else {
            return false;
        }

    }
}
