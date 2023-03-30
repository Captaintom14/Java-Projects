package ca.qc.bdeb.info202.tp2;

public class Joueur {

    private String nom = "";
    private int argent = 400;
    private String proprietaire = null;
    private int position = 0;

//Declaration du constructeur de la classe
public Joueur(String nom){
    this.nom = nom;
}
    public int getArgent() {
        return argent;
    }

    public void setArgent(int argent) {
        this.argent = argent;
    }


public String getProprietaire(){
    return proprietaire;
    }
public void setProprietaire(String proprietaire){
    this.proprietaire = proprietaire;
}

//Cela permet à retourner les noms du joueurs
@Override
  public String toString (){return nom;}

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
