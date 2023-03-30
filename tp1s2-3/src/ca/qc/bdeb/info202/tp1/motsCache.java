/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.info202.tp1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.Arrays;

/**
 *
 * @author thoma
 */
public class motsCache {

    private char[][] grilleCache;
    private char[][] mots;

    //le methode diagonale
    public String[] motsCaches(char[][] grilleCache, String[] mots) {
        // variable des diagonales de gauche et droite.
        String[] diagonalG = new String[(grilleCache.length * 2) - 1];
        String[] diagonalD = new String[(grilleCache.length * 2) - 1];

        // Diagonale gauche 1er moitié
        for (int i = 0; i < grilleCache.length; i++) {
            diagonalG[i] = "";
            for (int j = 0; j <= i; j++) {
                diagonalG[i] += grilleCache[i - j][j];
            }
        }
        //Diagonale gauche 2er moitié
        for (int i = 0; i < grilleCache.length - 1; i++) {
            diagonalG[grilleCache.length + i] = "";
            for (int j = 0; j <= i; j++) {
                diagonalG[grilleCache.length + i] = diagonalG[grilleCache.length + i] + grilleCache[grilleCache.length - j - 1][grilleCache.length - i + j - 1];
            }
        }

        // Diagonale droite 1er moitié
        for (int i = 0; i < grilleCache.length; i++) {
            diagonalD[i] = "";
            for (int j = 0; j <= i; j++) {
                diagonalD[i] = diagonalD[i] + grilleCache[j][grilleCache.length - 1 - i + j];
            }
        }

        // Diagonale droite 2e moitié
        for (int i = 0; i < grilleCache.length - 1; i++) {
            diagonalD[grilleCache.length + i] = "";
            for (int j = 0; j <= i; j++) {
                diagonalD[grilleCache.length + i] = diagonalD[grilleCache.length + i] + grilleCache[grilleCache.length - 1 - i + j][j];
            }
        }

        //Une methode pour inverser les diagonales
        String[] diagonalGReverse = reverseDiagonal(diagonalG);
        String[] diagonalDReverse = reverseDiagonal(diagonalD);

        //trouver les intrus
        for (int i = 0; i < mots.length; i++) {
            boolean estUnIntrus = true;

            // trouver les intrus du diagonale gauche
            for (int j = 0; j < diagonalG.length; j++) {
                if (diagonalG[j].contains(mots[i])) {
                    estUnIntrus = false;

                }

            }
            //trouver les intrus du diagonale droite
            for (int j = 0; j < diagonalD.length; j++) {
                if (diagonalD[j].contains(mots[i])) {
                    estUnIntrus = false;

                }
            }

            //trouver les intrus du diagonale gauche inverse
            for (int j = 0; j < diagonalGReverse.length; j++) {
                if (diagonalGReverse[j].contains(mots[i])) {
                    estUnIntrus = false;

                }
            }
            // trouver les intrus du diagonale droite inverse
            for (int j = 0; j < diagonalDReverse.length; j++) {
                if (diagonalDReverse[j].contains(mots[i])) {
                    estUnIntrus = false;

                }
            }
            //
            if (!estUnIntrus) {
                mots[i] = "";
            }

        }

        return mots;
    }

    //reverser les diagonales gauche et ceux droites
    private String[] reverseDiagonal(String[] diagonal) {
        String[] diagonalReverse = new String[diagonal.length];
        for (int i = 0; i < diagonal.length; i++) {
            diagonalReverse[i] = new StringBuilder(diagonal[i]).reverse().toString();

        }

        return diagonalReverse;
    }

    public static void exit() {
        try (PrintWriter intrus = new PrintWriter(new FileOutputStream("intrus.txt"))) {
            intrus.print("");
            System.out.println("Il y a aucun intru");
            System.exit(0);
        } catch (FileNotFoundException ex) {
        }
    }

    //les refractor
    /**
     * @return the grilleCache
     */
    public char[][] getGrilleCache() {
        return grilleCache;
    }

    /**
     * @param grilleCache the grilleCache to set
     */
    public void setGrilleCache(char[][] grilleCache) {
        this.grilleCache = grilleCache;
    }

    /**
     * @return the motsCache
     */
    public char[][] getMots() {
        return mots;
    }

    /**
     * @param motsCache the motsCache to set
     */
    public void setMots(char[][] motsCache) {
        this.mots = mots;
    }

}
