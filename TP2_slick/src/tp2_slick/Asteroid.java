/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2_slick;

import org.newdawn.slick.geom.*;
import java.util.*;
import static jdk.nashorn.internal.objects.NativeMath.random;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author thoma
 */

public class Asteroid extends Entite {

    private int animation = 0;
    private ArrayList<Image> listeAnimation = new ArrayList<>();
    
    
    Random random;

    public Asteroid(int x,SpriteSheet sprite) {
        super(x,-256, sprite, 0, 0);
        
        listeAnimation.add(sprite.getSubImage(0, 0));
        listeAnimation.add(sprite.getSubImage(0, 1));
        listeAnimation.add(sprite.getSubImage(0, 2));
        listeAnimation.add(sprite.getSubImage(0, 3));
        listeAnimation.add(sprite.getSubImage(0, 4));
        listeAnimation.add(sprite.getSubImage(0, 5));
        listeAnimation.add(sprite.getSubImage(0, 6));
                 
        
    }

    public void bouger(int delta) {

        if (animation == 0) {

            this.image = listeAnimation.get(0);

        } else if (animation == 100 / 2) {
            this.image = listeAnimation.get(1);

        } else if (animation == 200 / 2) {
            this.image = listeAnimation.get(2);

        } else if (animation == 300 / 2) {
            this.image = listeAnimation.get(3);

        } else if (animation == 400 / 2) {
            this.image = listeAnimation.get(4);

        } else if (animation == 500 / 2) {
            this.image = listeAnimation.get(5);

        } else if (animation == 600 / 2) {
            this.image = listeAnimation.get(6);
animation=-6;
        }
        
        animation = animation + 2;
        
          y += 0.3 * delta;
        
        
        
    }
    
    
    public Shape getHitbox(){ 
       return new Circle(128f,128f,128f); 
    }


    
   
    
    

}
