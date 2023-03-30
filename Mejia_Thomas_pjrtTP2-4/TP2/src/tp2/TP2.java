/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Mejia
 */
public class TP2 {

    /**
     * @param args the command line arguments
     */
    static int nombre = 0;
    static int nombreJoker = 0;
    static boolean recommencer = true;
    static int gril;
    static int[] grilChoisit;
    static int[] grilGagnante;
    static char[] JokerWin;
    static char[] JokerChoisit;
    static int ArgentUtilisateur = 100;
     //Le structure du programme
    public static void main(String[] args) {
        Random r = new Random();
      
        int tabCombinaison[];
        
       

        char[] joker = {'♠', '♥', '♦'};

        do {

            int grilleArgent = afficherGrille();
            int resteArgent = argentGrille();

            tabCombinaison = new int[grilleArgent];
            afficherlesRegles();

            initialiserCombinasionMachine(tabCombinaison);
            initialiserCombinaisonJoueur();

            afficherJoker();
            initialiserJoueurJoker();
            initialiserMachineJoker();

            int resteArgentJoker = argentJoker(resteArgent);
            MachineJokerGagnante();
            CombinaisonGagnante(tabCombinaison);

            verifierCombinaison();
            verifierJoker();
       

           
            afficherRejouer();
        } while (recommencer);

    } 
   
//L'affiche du premier Menu et les choix des nombres
    public static int afficherGrille() {
       
        System.out.println("---------------------");
        int grille;
       
        Scanner clavier = new Scanner(System.in);

        System.out.println("************************************");
        System.out.println("*          Type de Grille          *");
        System.out.println("*----------------------------------*");
        System.out.println("*  1- Jouer à 6 nombres, prix 10$  *");
        System.out.println("*  2- Jouer à 8 nombres, prix 20$  *");
        System.out.println("*  3- Jouer à 10 nombres, prix 30$ *");
        System.out.println("************************************");

        grille = clavier.nextInt();
        int[] tabCombinaison;
        switch (grille) {

            case 1: //6 nombres
                if (ArgentUtilisateur > 10){

                System.out.println("Vous avez choisi à jouer à 6 nombres");
                nombre = 6;
                }
                else if (ArgentUtilisateur < 10){
                    System.out.println("Vous n'avez pas assez d'argent");
                    System.exit(0);
                }
                break;

            case 2: // 8 nombres
                if (ArgentUtilisateur > 20){
                System.out.println("Vous avez choisi à jouer à 8 nombres");
                nombre = 8;
                }
                else if (ArgentUtilisateur < 20){
                    System.out.println("Vous n'avez pas assez d'argent");
                    System.exit(0);
                    
                }
                break;

            case 3: // 10 nombres
                if (ArgentUtilisateur > 30 ){
                System.out.println("Vous avez choisi à jouer à 10 nombres");
                nombre = 10;
                }
                else if (ArgentUtilisateur < 30){
                        System.out.println("Vous n'avez pas assez d'argent");
                        System.exit(0);
                        }
                break;
                

            default:
                System.out.println("Erreur,");
                System.exit(0);
                break;

        }
        return nombre;
    } 
       
//Les prix de chaque nombre
    public static int argentGrille() {

        
        int argentGrille = nombre;
        int prix = 0;
       
        

        Scanner clavier = new Scanner(System.in);

        switch (argentGrille) {
            case 6:
                System.out.println("Le prix est 10$");
                prix = 10;

                break;
            case 8:
                System.out.println("Le prix est 20$");
                prix = 20;
                break;
            case 10:
                System.out.println("Le prix est 30$");
                prix = 30;
                break;

            default:
                System.out.println("Erreur");
                System.exit(0);
                break;
        }

        ArgentUtilisateur = ArgentUtilisateur - prix;

        System.out.println("Présentement, vous avez  " + ArgentUtilisateur + "$");
        System.out.println("---------------------------------------------");

        return ArgentUtilisateur;

    }
 
    //L'affiche du type de jeu
    public static int afficherlesRegles() {
        int lesRegles;

        Scanner clavier = new Scanner(System.in);

        System.out.println("****************CHOIX DU JEU***********************");
        System.out.println("*                                                 *");
        System.out.println("*          Choissisez le type de jeu              *");
        System.out.println("*-------------------------------------------------*");
        System.out.println("* 1- La machine choisit la combinaison des nombres*");
        System.out.println("*                                                 *");
        System.out.println("* 2- Le joueur choisit la combianaison des nombres*");
        System.out.println("*                                                 *");
        System.out.println("***************************************************");

        System.out.println("Veuillez, écrire le type de jeu");

        lesRegles = clavier.nextInt();

        switch (lesRegles) {

            case 1: //Machine Combinaison

                gril = 1;
                System.out.println("La machine choisit la combinaison des nombres");

                break;

            case 2: //Joueur Combinaison 

                gril = 2;
                System.out.println("Vous choisissez la combinaison des nombres");
                break;

            default:
                System.out.println("Erreur, veuillez reéssayer encore une fois");
                System.exit(0);
                break;

        }
        System.out.println("-----------------------");
        return gril;
    }

//Saisir les nombres qui sont choisis par l'Utilisateur
    public static int initialiserCombinaisonJoueur() {
        boolean combJoueur;
        int[] joueurValeur = new int[nombre];

        int chiffre;
        if (gril == 2) {
            System.out.println("Veuillez écrire des chiffres entre 1 à 30");
            for (int i = 0; i < nombre; i++) {
                Scanner clavier = new Scanner(System.in);
                do {
                    combJoueur = true;
                    chiffre = clavier.nextInt();
                    if (!(chiffre <= 30 && chiffre > 0)) {
                        combJoueur = false;
                        System.out.println("Erreur, veuillez réesayez encore une fois");
                    }
                    if (chiffre != 0) {

                        for (int x = 0; x < nombre; x++) {
                            if (chiffre == joueurValeur[x]) {
                                combJoueur = false;
                                System.out.println("Veuillez choisir une autre chiffre");
                            }
                        }
                    }
                    joueurValeur[i] = chiffre;
                    grilChoisit = joueurValeur;

                } while (combJoueur == false);

            }

        }
        return gril;
    }
    
//Une combinaison qui est effectuer par le machine
    public static int initialiserCombinasionMachine(int[] tabCombinaison2) {

        Random ran = new Random();
        int tabCombinaison[];

        int positionNombre1 = 0;
        int positionNombre2 = 0;
        int temporaire = 0;
        tabCombinaison = new int[30];

        if (gril == 1) {

            for (int i = 0; i < tabCombinaison.length; i++) {
                tabCombinaison[i] = i + 1;
            }
            for (int i = 0; i < 100; i++) {
                positionNombre1 = ran.nextInt(30);
                positionNombre2 = ran.nextInt(30);

                temporaire = tabCombinaison[positionNombre1];
                tabCombinaison[positionNombre1] = tabCombinaison[positionNombre2];
                tabCombinaison[positionNombre2] = temporaire;

            }

            for (int i = 0; i < 6; i++) {
                tabCombinaison2[i] = tabCombinaison[i];
                grilChoisit = tabCombinaison2;

            }

        }
        return gril;

    }
    
 //Deuxième partie
    public static int[] CombinaisonMachine2(int[] tabCombinaison) {

        grilChoisit = new int[6];
        int temporaire = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (grilChoisit[i] < grilChoisit[j]) {

                    temporaire = grilChoisit[i];
                    grilChoisit[i] = grilChoisit[j];
                    grilChoisit[j] = temporaire;

                }
            }

        }

        return grilChoisit;

    }
   
 //Une combinaison gagnante qui est effectuer par le machine
    public static int CombinaisonGagnante(int[] tabCombinaison3) {
        Random ran = new Random();
        int tabCombinaison[];

        int positionNombre1 = 0;
        int positionNombre2 = 0;
        int temporaire = 0;
        tabCombinaison = new int[30];

        for (int i = 0; i < tabCombinaison.length; i++) {
            tabCombinaison[i] = i + 1;
        }
        for (int i = 0; i < 100; i++) {
            positionNombre1 = ran.nextInt(30);
            positionNombre2 = ran.nextInt(30);

            temporaire = tabCombinaison[positionNombre1];
            tabCombinaison[positionNombre1] = tabCombinaison[positionNombre2];
            tabCombinaison[positionNombre2] = temporaire;

        }
        grilGagnante = new int[6];

        for (int i = 0; i < 6; i++) {
            grilGagnante[i] = tabCombinaison[i];
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < i; j++) {
                if (grilGagnante[i] < grilGagnante[j]) {
                    temporaire = grilGagnante[i];
                    grilGagnante[i] = grilGagnante[j];
                    grilGagnante[j] = temporaire;

                }

            }

        }
        return gril;

    }
   
   //Affiche du menu de Joker
    public static void afficherJoker() {
        Scanner clavier = new Scanner(System.in);
        int afficheJoker;

        System.out.println("*******************************");
        System.out.println("*   Doubler vos gain, Joker!  *");
        System.out.println("* Ne manquez pas votre chance *");
        System.out.println("*-----------------------------*");
        System.out.println("* 1- Oui (10$ supplémentaire) *");
        System.out.println("* 2- Non                      *");
        System.out.println("*******************************");

        afficheJoker = clavier.nextInt();

        switch (afficheJoker) {

            case 1:
                System.out.println("Vous doublez vos gain!");

                nombreJoker = 1;

                break;

            case 2:
                System.out.println("Vous ne doublez pas vos gain");
                nombreJoker = 2;

                break;

            default:
                System.out.println("Erreur, Veuillez réessayer encore une fois");
                System.exit(0);

                break;
        }

    }
 
 //Argent supplémentaire de Joker
    public static int argentJoker(int resteArgent) {
        int supplémentaire = nombreJoker;
        int argentSupplémentaire = 0;
       
        Scanner clavier = new Scanner(System.in);
        switch (supplémentaire) {
           
            case 1:
               
                argentSupplémentaire = 10;
                break;

            case 2:
                break;

            default:
                System.out.println("Erreur");
                System.exit(0);
        }

        ArgentUtilisateur = ArgentUtilisateur - argentSupplémentaire;
        System.out.println("Présentement, vous avez " + ArgentUtilisateur);
        System.out.println("--------------------------------------------");
        
       
        
        return ArgentUtilisateur;
        

    }
   
 // Machine Joker
    public static int initialiserMachineJoker() {
        Random ran = new Random();
       
        char[] jokerWin = null;
        int tabJoker[];
        tabJoker = new int[6];
        int machineJoker = 0;
        machineJoker = ran.nextInt(5) + 1;
        Scanner clavier = new Scanner(System.in);
        if (gril == 1 && nombreJoker == 1) {
            switch (machineJoker) {
                case 1:
                    char[] joker = {'♠', '♥', '♦'};
                    JokerChoisit = joker;

                    break;

                case 2:
                    char[] joker2 = {'♥', '♠', '♦'};
                    JokerChoisit = joker2;
                    break;

                case 3:
                    char[] joker3 = {'♥', '♦', '♠'};
                    JokerChoisit = joker3;
                    break;

                case 4:
                    char[] joker4 = {'♠', '♦', '♥'};
                    JokerChoisit = joker4;
                    break;

                case 5:
                    char[] joker5 = {'♠', '♥', '♠'};
                    JokerChoisit = joker5;
                    break;

                case 6:
                    char[] joker6 = {'♦', '♥', '♠'};
                    JokerChoisit= joker6;
                    break;

                default:
                    System.out.println("");
                    System.exit(0);
                    break;
            }
           

         

        }
        return nombreJoker;
    }
  
     //Joueur Joker
    public static int initialiserJoueurJoker() {

        Scanner clavier = new Scanner(System.in);
        int joueurJoker = 0;
        
        if (gril == 2 && nombreJoker == 1) {
            System.out.println("**************************************");
            System.out.println("*          Vous avez 6 choix         *");
            System.out.println("*------------------------------------*");
            System.out.println("*   1- ♠, ♥, ♦                       *");
            System.out.println("*   2- ♠, ♥, ♦                       *");
            System.out.println("*   3- ♥, ♦, ♠                       *");
            System.out.println("*   4- ♠, ♦, ♥                       *");
            System.out.println("*   5- ♠, ♥, ♠                       *");
            System.out.println("*   6- ♦, ♥, ♠                       *");
            System.out.println("**************************************");

            joueurJoker = clavier.nextInt();
            
            switch (joueurJoker) {
                case 1:
                    char[] joker = {'♠', '♥', '♦'};
                    System.out.println("Vous avez choisi" +Arrays.toString(joker));
                    JokerChoisit = joker;
                    

                    break;

                case 2:
                    char[] joker2 = {'♥', '♠', '♦'}; 
                    System.out.println("Vous avez choisi" +Arrays.toString(joker2));
                    JokerChoisit = joker2;
                    
                    break;

                case 3:
                    char[] joker3 = {'♥', '♦', '♠'};
                    System.out.println("Vous avez choisi" +Arrays.toString(joker3));
                    JokerChoisit = joker3;
                     
                    break;

                case 4:
                    char[] joker4 = {'♠', '♦', '♥'};
                    System.out.println("Vous avez choisi " +Arrays.toString(joker4));
                    JokerChoisit = joker4;
                    
                    break;

                case 5:
                    char[] joker5 = {'♠', '♥', '♠'};
                    System.out.println("Vous avez choisi " + Arrays.toString(joker5));
                    JokerChoisit = joker5;
                    break;

                case 6:
                    char[] joker6 = {'♦', '♥', '♠'};
                    System.out.println("Vous avez chosir" +Arrays.toString(joker6));
                    JokerChoisit = joker6;
                    break;

                default:
                    System.out.println("Erreur, veuillez écrire encore une fois");
                    System.exit(0);
                    break;
            }
            
        }
        return nombreJoker;
    }
  
    //Machine Machine 
    public static int MachineJokerGagnante() {
        Random ran = new Random();
        char[] jokerWin = null;
        int tabJoker[];
        tabJoker = new int[6];
        int machineJoker = 0;
        machineJoker = ran.nextInt(5) + 1;
        Scanner clavier = new Scanner(System.in);
        if (nombreJoker == 1) {
            switch (machineJoker) {
                case 1:
                    char[] joker = {'♠', '♥', '♦'};
                    JokerWin = joker;
                   

                    break;

                case 2:
                    char[] joker2 = {'♥', '♠', '♦'};
                    JokerWin = joker2;
                    
                    break;

                case 3:
                    char[] joker3 = {'♥', '♦', '♠'};
                    JokerWin = joker3;
                    
                    break;

                case 4:
                    char[] joker4 = {'♠', '♦', '♥'};
                    JokerWin = joker4;
                    
                    break;

                case 5:
                    char[] joker5 = {'♠', '♥', '♠'};
                    JokerWin = joker5;
                    
                    break;

                case 6:
                    char[] joker6 = {'♦', '♥', '♠'};
                    JokerWin = joker6; 
                    
                    break;

                default:
                    System.out.println("");
                    System.exit(0);
                    break;
            }

         
        } 
       
        return nombreJoker;
    }

 //Verification si l'utilisateur a gagné les combinaison.
    public static int verifierCombinaison() {

        int verifierCombinaison = 0;
        int nombreCommun = 0;
        System.out.println("Votre combinaison est " + Arrays.toString(grilChoisit));
        System.out.println("La combinaison gagnante est " + Arrays.toString(grilGagnante));
        for (int i = 0; i < grilChoisit.length; i++) {
            for (int j = 0; j < 6; j++) {
                if (grilChoisit[i] == grilGagnante[j]) {
                    nombreCommun = nombreCommun +1 ;
                } 
                else  {
                    
                }
             }
            }
            System.out.println("Les chiffres en communs sont " + nombreCommun);

            if (nombreCommun < 4) {
                System.out.println("Vous avez rien gagné");

            } else if (nombreCommun == 4) {
                System.out.println("Vous avez gagné 20$");
            } else if (nombreCommun == 5) {
                System.out.println("Vous avez gagné 40$");

            } else if (nombreCommun == 6) {
                System.out.println("Vous avez gagné 60$");

            }
            else {
                
            }
      
        return nombreCommun;
    }
   
        //Verification si l'utilisateur a gagné le Joker
    public static int verifierJoker (){
          
        if (nombreJoker == 1){
            System.out.println("Votre Joker est : " +Arrays.toString (JokerChoisit));
            System.out.println("La Joker gagnante est : " + Arrays.toString(JokerWin));
          int jokerCommun = 0;
          
            if (jokerCommun == 4 || jokerCommun == 5 || jokerCommun == 6) {
               
                
            }
            
        }
        return nombreJoker;
    }

   //Demander si l'utilisateur aimerait recommencer de jouer
    public static boolean afficherRejouer() {
        Scanner clavier = new Scanner(System.in);
        boolean recommencer = true;
        int rejouer;

        System.out.println("*******************************");
        System.out.println("*   Voulez vous recommencer?  *");
        System.out.println("*-----------------------------*");
        System.out.println("* 1 - Oui                     *");
        System.out.println("*                             *");
        System.out.println("* 2-  Non                     *");
        System.out.println("*                             *");
        System.out.println("*******************************");

        rejouer = clavier.nextLine().charAt(0);

        switch (rejouer) {
            case '1':
                recommencer = true;

                break;

            case '2':
                System.out.println("Merci d'avoir jouer!");
                System.exit(0);
                recommencer = false;

                break;

            default:
                System.out.println("Erreur");
                System.exit(0);
                break;

        }
        return recommencer;
    } 


}
