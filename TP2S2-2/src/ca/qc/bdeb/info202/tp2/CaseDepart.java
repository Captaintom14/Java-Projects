package ca.qc.bdeb.info202.tp2;

import java.io.Serializable;
import java.util.jar.JarOutputStream;

public class CaseDepart extends Case {
    //Constructeur du CaseDepart puisque cela herite de la Classe Case
    protected CaseDepart(String type, String nom, String description, int valeur, int loyer) {
        super(type, nom, description, valeur, loyer);

    }


    @Override
    public void effectuerAction(Joueur Joueur, int valeurDe) {
        int argentDepart = 50;

        int nouveauArgent = Joueur.getArgent() + argentDepart;
        Joueur.setArgent(nouveauArgent);
        System.out.println("Vous avez gagne " + argentDepart +"$");
        System.out.println("Vous avez  maintenant " +Joueur.getArgent() + "$");

    }

    @Override
    public void survolerCase(Joueur j) {
        System.out.println("Vous avez passez la Case Depart" + "Alors vous gagnez " +50 + "$");
        int newMontant = j.getArgent() + 50;
        j.setArgent(newMontant);
        System.out.println("Maintenant, vous avez " +newMontant+"$");
    }


}
