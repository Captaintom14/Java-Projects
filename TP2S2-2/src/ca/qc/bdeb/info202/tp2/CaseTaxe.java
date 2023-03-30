package ca.qc.bdeb.info202.tp2;

import java.io.Serializable;

public class CaseTaxe extends Case {
    //Constructeur du case Taxe puisque cela herite la classe Case
    public CaseTaxe(String type, String nom, String description,  int valeur, int loyer) {
        super(type, nom, description,valeur, loyer);

    }



    @Override
    public void effectuerAction(Joueur Joueur, int valeurDe) {
        //voir si le l'argent du montant est plus petit que la valeur du loyer ou si le joueur est plus petit que zerp
        if (Joueur.getArgent() < getLoyer() || Joueur.getArgent() < 0){
            System.out.println("OOPS, vous ne pouvez pas payer le montant. Alors, vous faites faillite");
            int faillite = 0;
            faillite = Joueur.getArgent();
            Joueur.setArgent(faillite);
        }
        //Vois si l'argent du montant est plus grand que loyer
        if (Joueur.getArgent() > getLoyer()) {

                System.out.println("OOPS, vous devez payer le montant du taxe  : " + getLoyer());
                System.out.println("Vous avez " + Joueur.getArgent() + "$");
                int nouveauArgent = Joueur.getArgent() - getLoyer();
                Joueur.setArgent(nouveauArgent);
                System.out.println("Vous avez maintenant " + Joueur.getArgent() + "$");
            }
        }

    @Override
    public void survolerCase(Joueur j) {
        System.out.println("OOPS, vous avez depasser la case Taxe : " +getNom());
        System.out.println("Par consequence, vous devez payer 10% du taxe");
        double pourcentageTaxe = (0.10) *getLoyer();
        int taxe2 = (int) pourcentageTaxe;
        if (j.getArgent() < taxe2 || j.getArgent() < 0){
            System.out.println("OOPS, vous ne pouvez pas payer le montant. Alors, vous faites faillite");
            int faillite = 0;
            faillite = j.getArgent();
            j.setArgent(faillite);
            j.getArgent();
        }
        if(j.getArgent() > pourcentageTaxe){
                 taxe2 = j.getArgent() - (int) pourcentageTaxe;
                 j.setArgent(taxe2);
                 System.out.println("Vous avez maintenant " +j.getArgent() + "$");
             }


        }


    }



