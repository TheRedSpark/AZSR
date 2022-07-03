/**
 * The class Punkt represents a point in a two-dimensional coordinate system
 */
public class Punkt {
    int x;
    int y;

    public Punkt() {

    }

    // A constructor.
    public Punkt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // A getter and setter.
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * The function ausgabeAttribute() prints the values of the attributes x and y
     */
    public String ausgabeAttribute() {
        return (x+","+y);  
    }

    /**
     * This function moves the point by the given amount.
     *
     * @param dx The change in the x-coordinate.
     * @param dy The change in the y-coordinate.
     */
    public void bewegeUm(int dx, int dy) {
        this.x = this.x + dx;
        this.y = this.y + dy;
    }

    /**
     * The function gibAbstand() returns the distance between the point that is passed as an argument and the point that is
     * the object of the function
     *
     * @param neuerPunkt The new point to be compared to the current point.
     * @return The distance between the two points.
     */
    public double gibAbstand(Punkt neuerPunkt) {

        return Math.sqrt((neuerPunkt.getX() - x) * (neuerPunkt.getX() - x) + (neuerPunkt.getY() - y) * (neuerPunkt.getY() - y));

    }
}
