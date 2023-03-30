/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2_slick;



import org.newdawn.slick.geom.*;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author thoma
 */

public class Vaisseau extends Entite {
    
    private int animation = 0;
    private ArrayList<Image> listeAnimation = new ArrayList<>();
    public Vaisseau(int x, int y,  SpriteSheet sprite) {
        super(x, y, sprite,0,0);
        listeAnimation.add(sprite.getSubImage(0, 0));
    }
    

    public void bouger() {
        
        if (animation == 0) {
            this.image = listeAnimation.get(0);
            animation = -1; 
        }
        animation = animation + 1;
    }

    
     public Shape getHitbox(){
        return new Rectangle(x,y,image.getWidth(),image.getHeight());
    }
      

    
    
    
    
}

   

