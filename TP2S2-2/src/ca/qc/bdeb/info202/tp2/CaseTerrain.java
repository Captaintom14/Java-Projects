package ca.qc.bdeb.info202.tp2;

import com.sun.deploy.security.SelectableSecurityManager;

import java.io.Serializable;
import java.sql.SQLOutput;
import java.util.Scanner;

public class CaseTerrain extends CaseProprietaire {

    public CaseTerrain(String type, String nom, String description, int valeur, int loyer) {
        super(type, nom, description, valeur,loyer );

    }

    @Override
    protected String getProprietaire() {
        return super.getProprietaire();
    }



    @Override
    public void effectuerAction(Joueur Joueur, int valeurDe) {
           Scanner sc = new Scanner(System.in);

               if (getProprietaire() == null) {
                   if (Joueur.getArgent() > getPrixAchat()) {

                   System.out.println("Ce terrain coute " + getPrixAchat());
                   System.out.println("Voulez vous acheter ce terrain? ");
                   System.out.println(" 1) Oui ");
                   System.out.println(" 2) Non ");
                   int acheter = sc.nextInt();
                   switch (acheter) {
                       case 1: // si le joueur veut acheter
                           setProprietaire(Joueur.toString());
                           System.out.println("Vous etes finalement le proprietaire de ce propriete " + getProprietaire());
                           int montant = getPrixAchat();
                           int resteArgent = Joueur.getArgent() - montant;
                           Joueur.setArgent(resteArgent);
                           System.out.println("Vous avez maintenant " + Joueur.getArgent() + "$");
                           break;
                       case 2: // si le joueur ne veut pas acheter
                           System.out.println("Ok!");

                           break;
                       default:
                           System.out.println("Veuillez SVP choisir 1 ou 2. Merci");
                           break;
                   }
               }
                   else{
                       System.out.println("Desoler, mais vous ne pouvez pas acheter ce terrain");
                   }
           }


        if (Joueur.getProprietaire() != null ){
        System.out.println("OOPS. Vous attirisez au territoire  a " +getProprietaire() + "SVP, veuillez payer le loyer du proprietaire");
        int montant = getLoyer();
        int resteArgent = Joueur.getArgent() - montant;
        Joueur.setArgent(resteArgent);
            System.out.println("Vous avez maintenant "+Joueur.getArgent() + "$");


    }

        if (getProprietaire() == Joueur.toString()){
            System.out.println("Vous etes dans votre territoire et vous payez rien");
        }

}

    @Override
    public void survolerCase(Joueur j) {

    }
}
