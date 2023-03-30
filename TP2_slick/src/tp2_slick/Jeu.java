/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2_slick;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static jdk.nashorn.internal.objects.NativeMath.random;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author thoma
 */
public class Jeu extends BasicGame {

    Random random = new Random();

    Vaisseau vaisseau;
    // Asteroid asteroid;
    Gun gun;

    private AppGameContainer app;
    private GameContainer container;
    public Image imageBack;
    public Image imageBack2;
    public Image imageLaser;
    public Image imageVaiseau;
    public Image imageLazer;
    public Image imageNouveauAsteroid;
    public boolean movingA = true;
    public int directionA = 2;

    public int x = 447;
    public int y = 675;

    public int image1y = -120;
    public int image2y = -1024;

    private long laserCooldown = 0;
    private long AsteroidCooldown = 0;
    private long AsteroidCTime = 1200;

    ArrayList<Asteroid> nombreAsteroid = new ArrayList<>();

    int healthVaisseau = 3;
    public boolean gameover = false;
    int nombreContainer = 0;
    int score = 0;

    static ArrayList<Gun> gy = new ArrayList<>();

    public int xA = positionRandom();
    public int yA = 0;

    public boolean moving = false;
    public boolean moving_lazer = false;
    public boolean laser = false;

    public int direction = 2;
    public int x_gun = x;
    public int y_gun = y;
    public Input input;

    public Jeu() {
        super("Game"); // Titre de l'ecran

    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        vaisseau = new Vaisseau(64, 500, new SpriteSheet("vaisseau.png", 128, 128));
        imageBack = new Image("plan_arriere.png");
        imageBack2 = new Image("plan_arriere.png");

        app.setDisplayMode(1024, 900, false);

        input = gc.getInput();

    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
       
        //mouvement vaisseau
        vaisseau.bouger();
        if (this.moving) {
            switch (this.direction) {

                case 0:
                    this.y -= .3f * delta;
                    if (y < 0) {
                        y = 0;
                    }
                    break;
                case 1:
                    this.x -= .3f * delta;
                    if (x < 0) {
                        x = 0;
                    }
                    break;
                case 2:
                    this.y += .3f * delta;
                    if (y > 900) {
                        y = 900;
                    }
                    break;
                case 3:
                    this.x += .3f * delta;
                    if (x > 895) {
                        x = 895;
                    }
                    break;

            }

        }

        //mouvement du plan arriere 
        image1y += 0.2f * delta;
        image2y += 0.2f * delta;

        if (image1y >= 900) {
            image1y = -1024;
        }

        if (image2y >= 900) {
            image2y = -1024;
        }

        //asteroid
        //  asteroid.bouger(delta);
        SpriteSheet sheet = new SpriteSheet(new Image("SpriteSheetRoches.png").getScaledCopy(1.3f), 332, 332);
        nombreAsteroid.forEach(asteroid -> {
            asteroid.bouger(delta);
        });

        if (AsteroidCooldown >= AsteroidCTime) {

            // imageLazer = new Image("lazer.png");
            nombreAsteroid.add(new Asteroid(new Random().nextInt(895 - 256), sheet));
            //  System.out.println(sheet.getVerticalCount());
            AsteroidCTime -= 10;
            AsteroidCooldown = 0;
        } else {
            AsteroidCooldown += delta;
        }

        for (Asteroid asteroid : nombreAsteroid) {

            asteroid.bouger(delta);

        }

        if (this.movingA) {

            this.yA += 0.2 * delta;

        }
        if (yA > 1200) {
            yA = 0;

        }

        //mouvement laser 
        if (this.laser == true && laserCooldown >= 800) {
            // imageLazer = new Image("lazer.png");

            gy.add(new Gun(x + 36, y));
            laserCooldown = 0;
        } else {
            laserCooldown += delta;
        }

        for (Gun laser : gy) {

            laser.bouger(delta);

        }

        //collision asteroide et vaisseau
        for (Asteroid asteroid : nombreAsteroid) {

            if (asteroid.getHitbox().intersects(vaisseau.getHitbox())) {
                healthVaisseau -= 1;
                
                if (healthVaisseau == 0) {

                    gameover = true;
                 
                } else {
                    
                }

                
            }

            for (Gun gun : gy) {

                if (asteroid.getHitbox().intersects(gun.getHitbox())) {
                    
                    int nouveauAHeight1 = (int) asteroid.getHeight()/2;
                    int nouveauAWidth1 = (int) asteroid.getWidth()/2;
                    
                    int nouveauAHeight2 = (int) asteroid.getHeight()/2;
                    int nouveauAWidth2 = (int) asteroid.getWidth()/2;
                    
                    SpriteSheet sheet1 = new SpriteSheet (new Image("SpriteSheetRoches.png").getScaledCopy(0.5f), nouveauAHeight1, nouveauAWidth1);
                    SpriteSheet sheet2 = new SpriteSheet(new Image("SpriteSheetRoches.png").getScaledCopy(0.5f), nouveauAHeight2, nouveauAWidth2);
                    
                    nombreAsteroid.add(new Asteroid(x, sheet1));
                    nombreAsteroid.add(new Asteroid(x+128, sheet2));
                  
                }
                else {
                  
                }

            }

        }

        vaisseau.setX(x);
        vaisseau.setY(y);

    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {

        g.drawImage(imageBack, 0, image1y);
        g.drawImage(imageBack2, 0, image2y);
        g.drawImage(vaisseau.getImage(), x, y);

        // g.drawImage(asteroid.getImage(), xA, yA);
        // g.drawString("Position X : " + x + "\n Position y : " + y, 0, 0);
        for (Asteroid asteroid : nombreAsteroid) {

            asteroid.draw();

        }

        for (Gun laser : gy) {

            laser.draw();

        }

        if (gameover == true){
        
        g.drawString("Game over " + "\t Voulez vous recommencer?", 300,300);
        }
        
        
        g.drawString("HP : " + healthVaisseau + "\t Container  : " + nombreContainer + "/ 16384\t Score : " + score, 0, 0);

    }

    public void keyReleased(int key, char c) {
        if (key == Input.KEY_W || key == Input.KEY_A || key == Input.KEY_S || key == Input.KEY_D) {
            this.moving = false;
        } else if (Input.KEY_ESCAPE == key) {
            this.container.exit();
        } else if (Input.KEY_SPACE == key) {
            this.laser = false;
        }

    }

    public void keyPressed(int key, char c) {

        switch (key) {
            case Input.KEY_W: //haut
                this.direction = 0;
                this.moving = true;

                break;
            case Input.KEY_A: // gauche
                this.direction = 1;
                this.moving = true;

                break;
            case Input.KEY_S: // bas
                this.direction = 2;
                this.moving = true;

                break;
            case Input.KEY_D: // droite
                this.direction = 3;
                this.moving = true;

                break;
            case Input.KEY_SPACE:
                this.moving_lazer = true;
                this.laser = true;

                break;

        }

    }

    public int positionRandom() {

        int position = random.nextInt(600);

        return position;

    }

    void start() throws SlickException {
        try {
            app = new AppGameContainer(this);
            app.setVSync(true);
            app.setShowFPS(false);
            app.setTargetFrameRate(60);
            app.start();

        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
