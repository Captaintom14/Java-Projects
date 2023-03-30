/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.info202.tp1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 *
 * @author thoma
 */
public class TP1S2 {

//Main class
    public static void main(String[] args) {
        //Main class

        //matrice de lecture et methode de lecture du grille
        char[][] matriceGrille = lectureGrille();
        //matrice de mots et methode de lecture de la liste de mots
        String[] matriceMots = lectureMots();

        //creation de classe de validation
        Validation valider = new Validation();
        //methode de validation
        valider.validation(matriceGrille, matriceMots);

        //creation de classe de diagonale
        motsCache diagonale = new motsCache();
        //methode de diagonale
        String[] tableauIntrus = diagonale.motsCaches(matriceGrille, matriceMots);
        //creation du fichier intru.txt
        creationIntrus(tableauIntrus);

    }

    //lecture du grille.txt
    public static char[][] lectureGrille() {
        char[][] matrice = null;
        int compteur = 0;
        String contenuStr = "";
        String[] matriceStr;

        try {
            System.out.println("Chargement grille...ok");
            //1- Creer un objet de FileReader pour le grille
            FileReader monFr = new FileReader("grille.txt");
            //2- Crrer un objet de BufferedReader pour le grille
            BufferedReader fL = new BufferedReader(monFr);
            //3-recuperer une ligne pour le grille
            String ligne;
            while (fL.ready()) {

                compteur++;
                ligne = fL.readLine();
                ligne = ligne.toLowerCase().trim();
                contenuStr += ligne + "\n";

            }
            matriceStr = contenuStr.split("\n");
            //4-Recuperer toutes les lignes avec une boucle pour le grille
            matrice = new char[compteur][];
            for (int i = 0; i < matrice.length; i++) {
                matrice[i] = matriceStr[i].toCharArray();
                //  System.out.println(matrice[i]);
            }

            fL.close();

            //verifier si la matrice est carre 
        } catch (FileNotFoundException e) {
            System.out.println("Le file n'existe pas, Veuillez réesayer encore une fois");
            exit();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Veuillez réesyaer encore une fois");
            exit();
        }

        return matrice;
    }

    //lecture des mots.txt
    public static String[] lectureMots() {

        int compteur = 0;
        String contenuStr = "";
        String[] matriceStr = {};

        try {
            //1- Créer un objet de FileReader pour les mots
            FileReader rT = new FileReader("mots.txt");
            //2- Créer un objet de Buffered Reader pour les mots
            BufferedReader rL = new BufferedReader(rT);
            //3- récupérer une ligne pour le grille; 
            String ligne2 = rL.readLine();
            while (ligne2 != null) {
                compteur++;

                ligne2 = ligne2.toLowerCase().trim();
                contenuStr += ligne2 + "\n";

                ligne2 = rL.readLine();
            }

            matriceStr = contenuStr.split("\n");
            
            rL.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Le file n'existe pas. Veuillez vérifier si vous utilisez le bon fichier.");
            exit();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Veuillez réesayer encore une fois. Veuillez vérifier si vous utilisez le bon fichier.");
            exit();
        }
        return matriceStr;

    }

    //creation et lecture de intrus.txt
    public static void creationIntrus(String[] tableau) {
        try (PrintWriter intru = new PrintWriter(new FileOutputStream("intrus.txt"), true)) {
            for (int i = 0; i < tableau.length; i++) {
                intru.println(tableau[i]);
            }
            System.out.println("Les intrus sont trouvés. Veuillez s'il vous plaît verifier au fichier intrus.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Veuillez réesayer encore une fois");
        }
    }

    //la fermeture du programme
    public static void exit() {
        try (PrintWriter intrus = new PrintWriter(new FileOutputStream("intrus.txt"), false)) {
            intrus.print("");
            System.out.println("Il y a aucun intrus");
            System.exit(0);
        } catch (FileNotFoundException ex) {
        }

    }

}
