package Joueurs;

import Casinos.Casino;

public abstract class Joueur implements Comparable {

    private String nom;
    private int capital;
    private Casino casino;

    public Joueur() {
        this("", 0, null);
    }

    public Joueur(String nom, int capital) {
        this(nom, capital, null);
    }

    public Joueur(String nom, int capital, Casino casino) {
        this.nom = nom;
        this.capital = capital;
        this.casino = casino;
        if (casino != null)
        this.joindreCasino(casino);
    }

    //constructeur par copie
    public Joueur(Joueur autre) {
        this(autre.nom, autre.capital, autre.casino);
    }

    //méthode equals 
    public boolean equals(Joueur autre) {
        if (this.nom.equals(autre.nom)
                && this.capital == (autre.capital)
                && this.casino == autre.casino) {
            return true;
        }
        return false;
    }

    public String toString() {
        String chaine;
        chaine = "Je suis " + nom + " et j'ai " + capital + "$";
        if (casino != null) {
            chaine += "\nJe suis au casino " + casino.getNom();
        } else {
            chaine += "\nJe ne suis pas dans un casino";
        }
        return chaine;
    }

    public void joindreCasino(Casino casino) {
        if (casino.ajouterJoueur(this)) {
            this.casino = casino;
        } else {
            System.out.println("Je n'ai pas réussi à entrer dans le casino!");
        }

    }

    public void jouer(int mise) {
        if (casino != null && mise <= capital) {
            casino.jouer(this, mise);

        } else if (mise > capital) {
            System.out.println("Je n'ai pas assez d'argent pour miser cette quantité!");
        } else {
            System.out.println("Je ne peux pas jouer, je ne suis pas dans un casino");
        }
    }

    public void quitterCasino() {
        if (casino != null) {
            casino.enleverJoueur(this);
            casino = null;
        } else {
            System.out.println("Je ne suis pas dans un casino!");
        }

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public Casino getCasino() {
        return casino;
    }

    public void setCasino(Casino casino) {
        this.casino = casino;
    }

    
 public int compareTo(Object autre) {
       Joueur joueur2 = (Joueur)autre;
       if (this.capital > joueur2.getCapital())
           return 1;
       else if (this.capital < joueur2.getCapital())
           return -1;
       else return 0;
    }

}
