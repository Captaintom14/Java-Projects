package ca.qc.bdeb.info202.tp2;

public abstract class Case {

    private String type = "";
    private String nom = "";
    private String description = "";
    private int valeur = 0;
    private int loyer = 0;

    protected Case (String type, String nom, String description, int valeur, int loyer){
           this.nom = nom;
           this.description = description;
           this.type = type;
           this.valeur = valeur;
           this.loyer = loyer;
       }

public String getNom(){ return nom; }

public String getDescription(){return description;}

public String getType(){ return type; }

 @Override
 public String toString(){ return type +", " + nom + ", " + description +"," + valeur + ","+ loyer;}


public int getValeur(){ return valeur; }


public int getLoyer(){ return loyer; }


public abstract void effectuerAction(Joueur j, int valeurDe);

public abstract void survolerCase(Joueur j);

}
