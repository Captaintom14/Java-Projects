/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2_slick;

import java.awt.Rectangle;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author thoma
 */
public abstract class Entite {

  protected int x, y, width, height; 
    protected Image image; 
    protected boolean detruire = false; 



    public Entite(int x, int y, int width, int height, String imagepath) {
        this.x = x;
        this.y = y;

        try {
            image = new Image(imagepath);
        } catch (SlickException e) {
            System.out.println("Image non trouvée pour " + getClass());
        }

        this.width = image.getWidth();
        this.height = image.getHeight();
    }



    public Entite(int x, int y, SpriteSheet spriteSheet, int ligne, int colonne) {
        this.x = x;
        this.y = y;
        this.image = spriteSheet.getSubImage(ligne, colonne);
        this.width = image.getWidth();
        this.height = image.getHeight();


    }
    
    public void draw (){
        
        image.draw(x,y);
        
    }
    
        



    public float getX() { 
        return x;
    }


    public float getY() { 
        return y;
    }


     void  setX(int x) { 
        this.x = x;
    }


    void  setY(int y) { 
         this.y=y;
    }
    public float getWidth() { 
        return width;
    }


    public float getHeight() { 
        return height;
    }


    public Image getImage() { 
        return image;
    }


    public Rectangle getRectangleC() { 
        return new Rectangle(x, y, width,height);
    }




    public void setLocation(int x, int y) { 
        this.x = x;
        this.y = y;
    }


    public boolean getDetruire() { 
        return detruire;
    }





}
