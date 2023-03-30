package ca.qc.bdeb.info202.tp2;

import java.io.*;
import java.util.*;



public class TP2S2 implements Serializable {

    public static void main(String[] args) {

        //lecture du fichier PlateauDeJeu.csv
        String contenu[] = lecturePlateauDeJeu();


        //afficher le menu du jeu dont il permet de charger ou commencer ou quitter le jeu
        afficherMenu(contenu);

    }


    //initialiser le tableau
    private static String[] lecturePlateauDeJeu() {
        int compteur = 0;
        String [] tableauPlateau = new String [10];

        try {

            //1- Créer un objet de FileReader pour les mots
            FileReader rT = new FileReader("PlateauDeJeu.csv");
            //2- Créer un objet de Buffered Reader pour les mots
            BufferedReader rL = new BufferedReader(rT);
            //3- récupérer une ligne pour le grille;
            String ligne = rL.readLine();
            while (rL.ready()) {
                tableauPlateau[compteur] = rL.readLine();
                compteur++;
            }


    rL.close();


    } catch (FileNotFoundException ex) {
        System.out.println("Le file n'existe pas. Veuillez vérifier si vous utilisez le bon fichier.");

    } catch(IOException ex) {
        System.out.println("Veuillez réesayer encore une fois. Veuillez vérifier si vous utilisez le bon fichier.");
    }
  return tableauPlateau;


}


    //validation le tableau du plateau du jeu
    private static Case [] validationPlateauDeJeu(String[] contenu) {
    System.out.println("Chargement du plateau de jeu... ok");
    int compteur = 0;
    Case plateau [] = new Case[10];
    for (int i = 0; i < contenu.length; i++) {
        String [] temp = contenu[i].split(",");
        if (temp[0].equals("D")) {
            compteur++;
            plateau[i] = new CaseDepart(temp[0],temp[1],temp[2],Integer.parseInt(temp[3]),Integer.parseInt(temp[4]));

        }
        if (compteur != 1){
            System.out.println("Le fichier nest pas valide");
            System.exit(0);
        }

        if (temp[0].equals("Tx")) {
            plateau[i] = new CaseTaxe(temp[0],temp[1],temp[2], Integer.parseInt(temp[3]),Integer.parseInt(temp[4]));
        }

        if (temp[0].equals("P")) {
            plateau[i] = new CaseStationnement(temp[0],temp[1],temp[2], Integer.parseInt(temp[3]), Integer.parseInt(temp[4]));
        }

        if (temp[0].equals("SP")) {
            plateau[i] = new CaseSerivcePublic(temp[0],temp[1], temp[2],Integer.parseInt(temp[3]), Integer.parseInt(temp[4]));
        }

        if (temp[0].equals("T")) {
            plateau[i] = new CaseTerrain(temp[0], temp[1], temp[2], Integer.parseInt(temp[3]),Integer.parseInt(temp[4]));
        }

    }
    System.out.println("Validation du plateau de jeu... ok!");

return plateau;
}

        //creation du fichier sauvegarde.bin
    private static void creationSer(Partie partie){
        // Serialization
        //Sauvegarder
        String nom = "sauvegarde.bin";
        try {
            FileOutputStream file = new FileOutputStream(nom);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(partie);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        }

        //afficher menu
        private static void afficherMenu(String [] contenu) {
        Scanner sc = new Scanner(System.in);

            try {
                System.out.println("*************Menu************");
                System.out.println("1. Charger une partie");
                System.out.println("2. Commencer une partie ");
                System.out.println("3. Quitter ");
                System.out.println("*****************************");

                int clavier = sc.nextInt();
                switch (clavier) {
                    case 1:
                        //creation du fichier sauvegarde.bin

                        break;
                    case 2:
                        //validation du tableau de plateau de jeu
                        Case tableau [] = validationPlateauDeJeu(contenu);
                        //Contenir les informations de joueurs
                        Joueur [] joueur  =  nomJoueur();
                        //Une methode de commencer la partie
                        deroulementDeJeu(joueur,tableau);
                        break;
                    case 3:
                        System.out.println("Merci et a la prochaine!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Veuillez choisir entre 1 a 3");
                        afficherMenu(contenu);
                        break;

                }

            } catch (InputMismatchException ex) {
                System.out.println("Veuillez ecrire un entier SVP");
                afficherMenu(contenu);

            }
        }
        //Declaration des noms
        private  static Joueur[] nomJoueur() {

        Scanner sc = new Scanner(System.in);
        Scanner x = new Scanner(System.in);
        Scanner d = new Scanner(System.in);
        System.out.println("*******************************************");
        System.out.println("*   Veuillez saisir deux noms de joueurs   *");

        Joueur [] tabJoueur = new Joueur [3];
        int compteur = 2;
        tabJoueur = new Joueur [compteur];
        String nom1 = sc.nextLine();
        tabJoueur[0] =  new Joueur(nom1);
        System.out.println("Player 1 : " +tabJoueur[0]);
        String nom2 = sc.nextLine();
        tabJoueur[1] = new Joueur(nom2);
        System.out.println("Player 2 : " +tabJoueur[1]);

        //Ajouter troisieme joueur ou pas
        try {
            System.out.println("******************************************");
            System.out.println("*Voulez vous ajouter un troisieme joueur?*");
            System.out.println("*                                        *");
            System.out.println("* 1- Oui                                 *");
            System.out.println("* 2- Non                                 *");
            System.out.println("*                                        *");
            System.out.println("******************************************");

            int decision = sc.nextInt();
            switch (decision) {
                case 1:
                    tabJoueur = Arrays.copyOf(tabJoueur,tabJoueur.length+1);

                    System.out.println("Veuillez ecrire le nom du troisieme joueur");
                    String nom3 = x.nextLine();
                    tabJoueur[2] = new Joueur(nom3);
                    System.out.println("Player 3 : " + tabJoueur[2]);
                    break;


                case 2:
                    System.out.println("Ok!");

                    break;


                default:
                    System.out.println("Veuillez recommencez");
                    nomJoueur();
                    break;

            }

        } catch (InputMismatchException ex) {
            System.out.println("Veuillez ecrire 1 ou 2 SVP");
            //   nomJoueur(nom,compteur);
        }
        return tabJoueur;
    }


    private static void deroulementDeJeu(Joueur [] tabJoueur, Case [] plateauDeJeu) {
        Scanner sc = new Scanner(System.in);
        Joueur joueur = null;
        int dice = 0;
        De de = new De();
        int position = 0;
        Partie jeu = new Partie(plateauDeJeu, tabJoueur);

        boolean tour = false;
        while (!tour) {
            jeu.informationCase(plateauDeJeu);
            jeu.informationJoueur(tabJoueur, plateauDeJeu);

            //Message du montant dargent  de chaque joueur
            for (int i = 0; i < tabJoueur.length && tour == false ; i++) {
                tour = MenuJoueur(tabJoueur[i], position, tour, dice, plateauDeJeu);
            }

        }


        finPartie(tabJoueur,plateauDeJeu);

    }
    //le Menu Joueur lorsque le joueur commence son tour
    public static boolean MenuJoueur(Joueur joueur, int position, boolean tour, int dice, Case[] plateauDeJeu) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Cest le tour a " + joueur.toString());
            System.out.println("*****************************************************");
            System.out.println("*   1) Lancer le de                                 *");
            System.out.println("*   2) Sauvegarder et quitter                       *");
            System.out.println("*   3) Mettre la fin du partie et quitter           *");
            System.out.println("*****************************************************");
            int selection = sc.nextInt();
            switch (selection) {
                //lancer son dé
                case 1: //lorsque le joueur choisi à lancer le dé
                    dice = De.lancer();
                    System.out.println("Vous lancez votre de");
                    System.out.println("Le chiffre du de est " + dice);
                    int position1 = joueur.getPosition();
                    for (int j = 0; j < dice; j++) {
                        position++;

                        if (j == dice - 1) {
                            System.out.println("Vous etes atterie sur la case : " + plateauDeJeu[position].getNom());
                            plateauDeJeu[position].effectuerAction(joueur, dice);

                        } else {
                            plateauDeJeu[position].survolerCase(joueur);
                        }
                        if (position == plateauDeJeu.length - 1) {
                            position = 0;

                        }
                    }
                    joueur.setPosition(position);
                    tour = false;

                    if (joueur.getArgent() < 0) {

                        tour = true;
                    }
                    break;

                case 2: //Sauvegarder le match et quitter

                    tour = true;
                    break;

                case 3: //le match est fini
                    tour = true;
                    System.out.println("La partie est fini");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Veuillez svp choisir 1,2 ou 3,");

                    break;

            }


            System.out.println("----------------------------------------");

        } catch (InputMismatchException ex) {
            System.out.println("Veuillez svp choisir 1,2 ou 3,");
        }

       return tour;
    }

    //Lorsque le match est finie apres des sessions de lancer de des
    public static void finPartie(Joueur[] tabJoueur, Case[] plateauDeJeu){
        //si la fin contient 2 joueur
        if (tabJoueur.length == 2){
            if (tabJoueur[0].getArgent() > tabJoueur[1].getArgent());{
                System.out.println("Le gagnant.e.s est " + tabJoueur[0] );
                System.out.println("Le gagnant.e.s est " + tabJoueur[1] );
            }

            //si la fin contient 3 joueurs
       if (tabJoueur.length == 3){
           if (tabJoueur[0].getArgent() > tabJoueur[1].getArgent() && tabJoueur[0].getArgent() > tabJoueur[2].getArgent());{
               System.out.println("Le gagnant.e.s est " + tabJoueur[0] );
               System.out.println("Le gagnant.e.s est " + tabJoueur[1] + " " + tabJoueur[2]);
           }
       }




       }




    }
}






