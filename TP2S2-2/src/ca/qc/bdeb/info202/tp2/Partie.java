package ca.qc.bdeb.info202.tp2;

import java.io.Serializable;

public class Partie implements Serializable {

 private Joueur [] tabJoueur;
 private Case [] plateauDeJeu;

 public Partie (Case[] plateauDeJeu, Joueur [] joueurs ){
     this.tabJoueur = joueurs;
     this.plateauDeJeu = plateauDeJeu;

 }
    protected Case []  informationCase(Case [] plateauDeJeu) {

        //information sur les cases du plateau de jeu
        for (int i = 0; i < plateauDeJeu.length; i++) {
            System.out.println((i+1) + " : " + plateauDeJeu[i].getNom() +", ");
        }
        System.out.println("-------------------------------------");



     return plateauDeJeu;
    }

    //information a propos des joueurs comme leur chiffre, leur possition et leur argent
    protected Joueur [] informationJoueur(Joueur [] tabJoueur, Case[] plateauDeJeu){
        for (int i = 0; i < tabJoueur.length ; i++) {

            System.out.println("Player " + (i+1) + " : " + tabJoueur[i].toString() +" est sur la case "+ plateauDeJeu[tabJoueur[i].getPosition()].getNom() +" et " +" possede " +tabJoueur[i].getArgent()+ " $");

        }

        System.out.println("-------------------------------------------");
        return tabJoueur;
}



    public Joueur[] getTabJoueur() {
        return tabJoueur;
    }

    public void setTabJoueur(Joueur [] tabJoueur) {
        this.tabJoueur = tabJoueur;
    }

    public Case [] getPlateauDeJeu() {
        return plateauDeJeu;
    }

    public void setPlateauDeJeu(Case [] plateauDeJeu) {
        this.plateauDeJeu = plateauDeJeu;
    }



}
