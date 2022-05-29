import java.awt.Color;
public class Rechteck
{
    private Punkt position = new Punkt();
    private int breite;
    private int lange;
    private String bezeichnung;
    private Color farbe;
    private Punkt vektor = new Punkt();
    
    public Rechteck(){
        this.farbe = Color.red;
    }
    public Rechteck(Punkt position,int breite,int lange,String bezeichnung,Color farbe){
            this.position = position;
            this.breite = breite;
            this.lange = lange;
            this.bezeichnung = bezeichnung;
            this.farbe = farbe;
            
    }

    public Punkt getPosition(){
        return position;
    }
    
    public void setPosition(Punkt position){
        this.position = position;
        }
        
    public int getBreite(){
        return breite;
    }
    
    public void setBreite(int breite){
        this.breite = breite;
        }
        
    public int getLange(){
        return lange;
    }
    
    public void setLange(int lange){
        this.lange = lange;
        }
        
    public String getBezeichnung(){
        return bezeichnung;
    }
    
    public void  setBezeichnung(String bezeichnung){
        this.bezeichnung = bezeichnung;
        }
        
    public Color getFarbe(){
        return farbe;
    }
    
    public void  setColor(){
        this.farbe = farbe;
    }
    
    public void bewegeUm(Punkt vektor){
        int dx = vektor.getX();
        int dy = vektor.getY();
        position.bewegeUm(dx,dy);
    }
    
    public void ausgabeAttribute(){
       System.out.println(position+","+breite+","+lange+","+bezeichnung+","+farbe);
    }
    
    public boolean ueberlappt(Rechteck r){
        int xrange = getPosition().getX() + getBreite();
        int yrange = getPosition().getY() + getLange();
        int PunktX = getPosition().getX();
        int PunktY = getPosition().getY();
        
        int x = r.position.getX();
        int y = r.position.getY();
        int xlange = r.position.getX() + r.lange;
        int ybreite = r.position.getY() + r.breite;
        
        if(PunktX<= x & x <= xrange){
            return true;
        }else if (PunktX<= xlange & xlange <= xrange){
            return true;
        }else if (PunktY<= y & y <= yrange){
            return true;
        }else if (PunktY<= ybreite & ybreite <= yrange){
            return true;
        }else{return false;}
        
    }
}
