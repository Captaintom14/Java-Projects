/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.tp1;

import java.util.Scanner;

/**
 *
 * @author Mejia
 */
public class JavaApplication3TP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //DEBUT

        //Variable
//double
        double TPS = 0.05;
        double TVQ = 0.09975;
        double rabais = 0;
        double prix = 0;
        double prixAvantTaxes = 0;
        double prixApresTaxes = 0;
        double montant = 0;

//int
        int age;
        int cours = 1;
        int groupe;
        int nombreDePersonnes = 1;
        int refaire = 0;

//char
        char categorie;
        char forfait = 0;
        char abonnement;
        char famille;

//boolean
        boolean y = false;

//String
        String facture = "";
        String factureCatégorie = "";

        Scanner clavier = new Scanner(System.in);
        Scanner numb = new Scanner(System.in);
       
        
        //debut programmation
        
        do {
            cours = 1;
            nombreDePersonnes = 1;
            TPS = 0.05;
            TVQ = 0.09975;
            rabais = 0;

//Menu principal
            System.out.println("*******************************************");
            System.out.println("*   Bienvenue au complexe Sportif BDEB    *");
            System.out.println("*   Catégorie des abonnements             *");
            System.out.println("*-----------------------------------------*");
            System.out.println("* F   Forfait (nombre d'activités ilimité)*");
            System.out.println("* A   Activités (Nombre limité)           *");
            System.out.println("*                                         *");
            System.out.println("*******************************************");

            System.out.println("Écrivez le type d'abonnement");

            abonnement = clavier.nextLine().charAt(0);

            switch (abonnement) {

//Forfait
                case 'F':
                case 'f':
                    System.out.println("************************************");
                    System.out.println("*     Catégorie de forfait :       *");
                    System.out.println("*  --------------------------------*");
                    System.out.println("*     A Annuel:750$                *");
                    System.out.println("*     M Mensuel : 70$              *");
                    System.out.println("************************************");
                    forfait = clavier.nextLine().charAt(0);

                    switch (forfait) {
                        case 'A':
                        case 'a':
                            System.out.println("Vous avez choisi l'annuel ");
                            facture = "Forfait annuel";
                            prix = 750;
                            break;

                        case 'M':
                        case 'm':
                            System.out.println("Vous avez choisi le mensuel ");
                            facture = "Forfait mensuel";
                            prix = 70;
                            break;

                        default:
                            System.out.println("Erreur");
                            System.exit(0);
                            break;
                    }

                    break;

//Activité
                case 'A':
                case 'a':

                    System.out.println("Combien de cours souhaitez-vous à prendre?");
                    cours = numb.nextInt();

                    if (cours > 1) {

                        System.out.println("Vous choissisez " + cours);
                        facture = "Nombre d'activité";
                    } else {

                        System.out.println("Erreur");
                        System.exit(0);
                    }

                    break;

                default:
                    System.out.println("Erreur");
                    System.exit(0);
                    break;

            }

//1 Catégorie de personnes
            System.out.println("*********************************************");
            System.out.println("*         Catégorie des persones            *");
            System.out.println("* ------------------------------------------*");
            System.out.println("*                                           *");
            System.out.println("*  S ou s pour personne seule               *");
            System.out.println("*  G ou g pour groupe                       *");
            System.out.println("*  F ou f pour famille                      *");
            System.out.println("*                                           *");
            System.out.println("*********************************************");

            System.out.println("Écrivez la catégorie");
            categorie = clavier.nextLine().charAt(0);
            switch (categorie) {

//1.1 seule personne
                case 'S':
                case 's':
                    System.out.println("Vous êtes une personne seule.");
                    System.out.println("Écrivez votre âge ");
                    age = numb.nextInt();
                    if (age > 60 || age >= 13 && age < 18) {
                        System.out.println("Vous recevez un rabais de 5% ");
                        rabais = 0.05;
                      

                    }  else if (age > 0 && age < 13) {
                        System.out.println("Vous recevez un rabais de 10 %");
                        rabais=0.1;
                       
                    } else if (age < 60 && age > 18) {
                        System.out.println("Vous avez aucun rabais.");
                        
                    } else {
                        System.out.println("Erreur");
                        System.exit(0);
                    }
                    break;

//1.2 Groupe
                case 'g':
                case 'G':
                    System.out.println("*********************************");
                    System.out.println("*        type de groupe         *");
                    System.out.println("*   --------------------------- *");
                    System.out.println("*  A ou a pour ainé             *");
                    System.out.println("*  E ou e pour enfant           *");
                    System.out.println("*                               *");
                    System.out.println("*********************************");

                    System.out.println("Écrivez le type de groupe");
                    groupe = clavier.nextLine().charAt(0);
                    switch (groupe) {
// 1.2.1 Groupe ainé                 

                        case 'A':
                        case 'a':
                            System.out.println("Vous êtes combien.");
                            nombreDePersonnes = numb.nextInt();
                            if (nombreDePersonnes < 10) {
                                System.out.println("Erreur");
                                System.exit(0);
                            } else if (nombreDePersonnes > 10) {
                                System.out.println("Vous êtes " + nombreDePersonnes);
                                factureCatégorie = "Groupe Ainé";
                                rabais = 0.12;
                            } else {

                            }

                            break;
//1.2.2 Groupe enfant

                        case 'e':
                        case 'E':
                            System.out.println("Vous êtes combien.");
                            nombreDePersonnes = numb.nextInt();
                            if (nombreDePersonnes < 10) {
                                System.out.println("Erreur.");
                                System.exit(0);
                            } else if (nombreDePersonnes > 10) {
                                System.out.println("Vous êtes " + nombreDePersonnes);
                                factureCatégorie = "Groupe Scolaire";
                                rabais = 0.15;
                            } else {
                                break;

                            }
                            break;
//1.3Famille
                    }
                    break;
                case 'f':
                case 'F':
                    System.out.println("************************************************");
                    System.out.println("*           type de famille                    *");
                    System.out.println("*  ------------------------------------        *");
                    System.out.println("*  1. Deux adultes et deux enfants             *");
                    System.out.println("*  2. Deux adultes et trois enfants            *");
                    System.out.println("*  3. Deux adultes et quatres enfants ou plus  *");
                    System.out.println("*                                              *");
                    System.out.println("************************************************");

                    System.out.println("Écrivez le numéro du type de famille.");
                    famille = clavier.nextLine().charAt(0);

                    switch (famille) {

                        //1.3.1 Famille 1
                        case '1':
                            System.out.println("Vous avez un rabais de 10%.");
                            factureCatégorie = "Famille 1";
                            rabais = 0.10;
                            nombreDePersonnes = 4;
                            break;

                        //1.3.2 Famille 2
                        case '2':
                            System.out.println("Vous avez un rabais de 15%.");
                            factureCatégorie = "Famille 2";
                            rabais = 0.15;
                            nombreDePersonnes = 5;
                            break;

                        // 1.3.3 Famille 3
                        case '3':
                            System.out.println("Vous êtes combien de personnes?");

                            nombreDePersonnes = numb.nextInt();
                            if (nombreDePersonnes > 6) {
                                System.out.println("Vous avez un rabais de 20%");
                                rabais = 0.20;
                                factureCatégorie = "Famille 3";

                            } else if (nombreDePersonnes < 6) {
                                System.out.println("Erreur");
                                System.exit(0);
                            }
                            break;

                        default:
                            break;

                    }
                    break;

                default:
                    System.out.println("Erreur, veuillez écrire encore une fois");
                    System.exit(0);

                    break;

            }

//Calcul pour la facture
            prix = prix * cours * nombreDePersonnes;
            rabais = prix * rabais;
            prixAvantTaxes = prix - rabais;
            TPS = prixAvantTaxes * TPS;
            TVQ = prixAvantTaxes * TVQ;
            prixApresTaxes = prixAvantTaxes + TVQ + TPS;

            System.out.println("*********************************************************");

            //Facture 
            if (cours > 0) {
                //activité
                System.out.println("-----------------------------------");
                System.out.println("Catégorie :" + factureCatégorie);
                System.out.println("Nombre de cours : " + facture);
                System.out.println("Tarif : " + facture);
                System.out.println("-----------------------------------");
                System.out.println("Prix initial : " + facture);
                System.out.println("Rabais : " + rabais);
                System.out.println("Prix à payer : " + prix);
                System.out.println("TPS : " + TPS);
                System.out.println("TVQ : " + TVQ);
                System.out.println("Prix avec taxes : " + prixApresTaxes);
                System.out.println("                                   ");
                System.out.println("-----------------------------------");
            } else {

                //forfait
                System.out.println("----------------------------------");
                System.out.println("Catégorie : " + factureCatégorie);
                System.out.println("Tarif : " + facture);
                System.out.println("----------------------------------");
                System.out.println("Prix initi1ale : " + forfait);
                System.out.println("Rabais : " + rabais);
                System.out.println("Prix à payer :" + prix);
                System.out.println("TPS : " + TPS);
                System.out.println("TVQ : " + TVQ);
                System.out.println("Prix avec taxes : " + prixApresTaxes);
                System.out.println("                                  ");

            }
            System.out.println("Écrivez votre montant");
            montant = numb.nextDouble();
            if (montant >= prixApresTaxes) {
                System.out.println("Merci d'avoir payer!!!");

            } else if (montant < prixApresTaxes) {
                System.out.println("Erreur");
                System.exit(0);

            }

            //
            //***********************************************************
            System.out.println("Voulez-vous refaire ? 0 (quitter) ou 1 (recommencer)");

            refaire = numb.nextInt();

            switch (refaire) {
                case 1:
                    y = true;
                    break;
                case 0:
                    y = false;
                    break;
                default:

                    break;
            }
        } while (y);

    }// fin main
}// fin class    

