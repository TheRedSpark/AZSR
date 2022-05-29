public class Punkt 
{
    int x;
    int y;
    public Punkt(){
        
    }
    
    public Punkt(int x,int y){
            this.x = x;
            this.y = y;
    }
    
    public int  getX(){
        return x;
    }
    
    public int  getY(){
        return y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
 
    public void ausgabeAttribute(){
       System.out.println(x+","+y);
    }
    
    public void bewegeUm(int dx, int dy){
        this.x = this.x + dx;
        this.y = this.y + dy;
    }
    
    public double gibAbstand(Punkt neuerPunkt){
        
        return Math.sqrt((neuerPunkt.getX()-x)*(neuerPunkt.getX()-x)+(neuerPunkt.getY()-y)*(neuerPunkt.getY()-y));
        
    }
}
