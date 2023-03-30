package ca.qc.bdeb.info202.tp2;

public  abstract class CaseProprietaire extends Case {
    //String proprietaire est null puisque il n'y a aucuns
    private String proprietaire = null;
    //le prix d'achat est égale à celui la valeur du terrain
    private int prixAchat = getValeur();

    public CaseProprietaire(String type, String nom, String description, int valeur, int loyer) {
        super(type, nom, description, valeur, loyer);
    }


    protected int getPrixAchat() {
        return prixAchat;
    }

    protected String getProprietaire(){
        return proprietaire;
    }

    protected void setProprietaire(String proprietaire){
        this.proprietaire = proprietaire;
    }



}
