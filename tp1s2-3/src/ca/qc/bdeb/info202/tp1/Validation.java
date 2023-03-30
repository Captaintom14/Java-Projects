/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.info202.tp1;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 *
 * @author thoma
 */
//une classe pour valider le mot et le grille
public class Validation {

    private boolean valide;
    private char[][] verGrille;
    private char[][] verMots;
    
    //methode et les variables de verification de grille et la liste de mots.
    public void validation(char[][] verGrille, String[] verMots) {

        // grille 
        //verifier si le grille est carre
        for (int i = 0; i < verGrille.length; i++) {
            
            if (verGrille[i].length != verGrille.length) {
                System.out.println("Votre liste de lettre n'est pas carré. Veuillez réesayer encore une fois");
                exit();
            }

        }
        //verifier si la liste de la grille contient juste des lettres

        for (int i = 0; i < verGrille.length; i++) {
            for (int j = 0; j < verGrille[i].length; j++) {
                boolean x = Character.isLetter(verGrille[i][j]);
                if (x != true) {
                System.out.println("Votre liste de lettre contient un ou des espaces ou un ou des numéros");
                    exit();
                }
        }
        }

        System.out.println("Validation Grille...ok");
        
        //verifier si la liste de mots contient juste des lettres
        System.out.println("Chargement de la liste des mots");
        for (int i = 0; i < verMots.length; i++) {
            for (int j = 0; j < verMots[i].length(); j++) {
                boolean x = Character.isLetter(verMots[i].charAt(j));
                if (x != true) {
                    System.out.println("Votre liste de mots contient une ou des espace ou un ou des numeros,");
                    exit();
                } 
            }
        }
        System.out.println("Validation de la liste des mots...ok");

    }
    //fermer le programme et effacer l
     public static void exit(){
        try(PrintWriter intrus = new PrintWriter(new FileOutputStream("intrus.txt"))){
            intrus.print("");
            System.out.println("Il y a aucun intru");
        System.exit(0);
        }catch(FileNotFoundException ex){
        }
     }

     //les refractors

    public boolean isValide() {
        return valide;
    }

    /**
     * @param valide the valide to set
     */
    public void setValide(boolean valide) {
        this.valide = valide;
    }

    /**
     * @return the verGrille
     */
    public char[][] getVerGrille() {
        return verGrille;
    }

    /**
     * @param verGrille the verGrille to set
     */
    public void setVerGrille(char[][] verGrille) {
        this.verGrille = verGrille;
    }

    /**
     * @return the verMots
     */
    public char[][] getVerMots() {
        return verMots;
    }

    /**
     * @param verMots the verMots to set
     */
    public void setVerMots(char[][] verMots) {
        this.verMots = verMots;
    }
    
       
}


