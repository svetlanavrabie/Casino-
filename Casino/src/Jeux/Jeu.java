package Jeux;

import Casinos.Casino;
import Joueurs.Joueur;

public abstract  class Jeu {

   private String nom;

    public Jeu() {
        this("");
    }

    public Jeu(String nom) {
        this.nom = nom;
    }

    public Jeu(Jeu autre) {
        this.nom = autre.nom;
    }

    public boolean equals(Jeu autre) {
        if (this.nom.equals(autre.nom)) {
            return true;
        }
        return false;
    }


    public abstract int calculerGains(int mise);

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


}
