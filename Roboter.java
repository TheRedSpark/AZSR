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
        boolean ende = false;
        Scanner fragenscanner = new Scanner(System.in);
        while(ende = false){
            System.out.println("Welche Frage hast du?");
            String frage = fragenscanner.next().toUpperCase().trim();
            
            switch(frage){
                case "ENDE":
                    ende = true;
                    System.out.println("Ende");
                
                case "NAME":
                    System.out.println("Du bist im Case Name");
                
                case "ALTER":
                    System.out.println("Du bist im Case Alter");
                    
                case "HERSTELLER":
                    System.out.println("Du bist im Case Hersteller");
                    
                case "GESCHLECHT":
                    System.out.println("Du bist im Case Geschlecht");
                    
                default:
                    System.out.println("Ich habs nicht richtig verstanden versuchs erneut");
            }
            
        }
            
    }
    }
