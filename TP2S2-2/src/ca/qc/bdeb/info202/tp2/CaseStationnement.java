package ca.qc.bdeb.info202.tp2;

public class CaseStationnement extends Case {

    public CaseStationnement(String type, String nom, String description,  int valeur, int loyer) {
        super(type, nom, description, valeur, loyer);
      // System.out.println(type +"," + nom + "," + description +"," + valeur+ "," + loyer);
    }

    @Override
    public void effectuerAction(Joueur Joueur, int valeurDe) {
        System.out.println("Vous etes dans un stationnement gratuit!");
    }

    @Override
    public void survolerCase(Joueur j) {

    }



}
