import java.util.*;
/**
 * Write a description of class Roboter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Roboter
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Roboter
     */
    public Roboter()
    {

    }

    public enum Stichwort{
        NAME,ALTER,HERSTELLER,GESCHLECHT;
    }
    public void spracherkennung(){
        boolean weitermachen = true;
        Scanner sc = new Scanner(System.in);
        while(weitermachen){
            System.out.println("Welche Frage hast du?");
            boolean gueltig = false;
            while(sc.hasNext()){
                String frage = sc.next().toUpperCase().trim();
                switch(frage){
                    case "ENDE":
                        weitermachen = false;
                        gueltig = true;
                        System.out.println("Ende");
                        break;
                    
                    case "NAME":
                        System.out.println("Mein Name ist Callio");
                        gueltig = true;
                        break;
                    
                    case "ALTER":
                        System.out.println("Ich bin schon groß und 4");
                        gueltig = true;
                        break;
                        
                    case "HERSTELLER":
                        System.out.println("Diakonie");
                        gueltig = true;
                        break;
                        
                    case "GESCHLECHT":
                        System.out.println("Krebskrank seit 30 Jahren");
                        gueltig = true;
                        break;
                    default:
                        break;
                }
            }
            
            if(!gueltig)
                System.out.println("Sprich deutsch");
        }
            
    }
    }
