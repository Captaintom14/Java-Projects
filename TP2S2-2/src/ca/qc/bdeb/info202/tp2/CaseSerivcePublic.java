package ca.qc.bdeb.info202.tp2;

import java.io.Serializable;
import java.util.Scanner;

public class CaseSerivcePublic extends CaseProprietaire {
    //Constructeur du case Service public puisque cela herite la classe Proprietaire
    public CaseSerivcePublic(String type, String nom, String description, int valeur, int loyer) {
        super(type, nom, description, valeur, loyer);

    }

    //Lorsque le joueur atterit dans la case
    @Override
    public void effectuerAction(Joueur  Joueur, int valeurDe) {
    Scanner sc = new Scanner(System.in);

    if (getProprietaire() == null){
    int montantDe = valeurDe * 10;
    int nouveauMontant = Joueur.getArgent() - montantDe;
    Joueur.setArgent(nouveauMontant);
    System.out.println("Vous avez maintenant " +Joueur.getArgent()+"$");
        System.out.println("Ce service public coute " +getPrixAchat());
        System.out.println("Voulez vous acheter le service?");
        System.out.println(" 1) Oui ");
        System.out.println(" 2) Non ");
        int acheter = sc.nextInt();
        switch (acheter){
            case 1 :   //Si le joueur veut acheter le service
                setProprietaire(Joueur.toString());
                System.out.println("Vous etes finalement le proprietaire de ce service " +getProprietaire());
                int montant = getPrixAchat();
                int newMontant  = Joueur.getArgent() - montant;
                Joueur.setArgent(newMontant);
                System.out.println("Maintenant, vous avez "+Joueur.getArgent() + "$");
                break;
            case 2:    //si le joueur refuse de acheter le service
                System.out.println("Ok!");
                break;
            default :
                System.out.println("Veuillez SVP choisir 1 ou 2");
                    break;
        }   //lorsque le joueur atterit dans son case acheté
        if (getProprietaire() == Joueur.toString()){
            System.out.println("Vous etes dans votre propre Service");
        }

}
        if (getProprietaire() != null && getProprietaire() != Joueur.toString()){
            System.out.println("Opps! Vous devez payer le loyer du Service Public ");

        }



    }

    @Override
    public void survolerCase(Joueur j) {

    }

}
