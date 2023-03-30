/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2_slick;

import org.newdawn.slick.geom.*;


/**
 *
 * @author thoma
 */
public class Gun extends Entite {
  
   private int animation = 0;
   // private ArrayList<Image> listeAnimation = new ArrayList<>();
    public boolean showLaser = false;
    public int yDepart;
     
    
    
    
    public Gun(int x, int y){
        super(x,y,49,72, "lazer.png");
         // listeAnimation.add(sprite.getSubImage(0, 0));
        yDepart = y;
        
    }
    
    public void bouger (int delta){
        
         y -= 0.3 * delta;
     //   if (yDepart >= y + image)
             
        
        
    }
    
    
    
    public Shape getHitbox(){
        return new Rectangle(x,y,image.getWidth(),image.getHeight());
    }
      

    
    

    
}
