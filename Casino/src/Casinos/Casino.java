package Casinos;

import Joueurs.Joueur;
import Jeux.Jeu;
import Joueurs.JoueurPauvre;
import Joueurs.JoueurRiche;

public abstract class Casino implements Comparable {

    private String nom;
    private Joueur joueurs[];
    private int joueursPresents;
    private Jeu jeu;

    public Casino() {
        this("", 0, null);
    }

    public Casino(String nom, int nbJoueursMax, Jeu jeu) {
        this.nom = nom;
        this.jeu = jeu;
        joueursPresents = 0;
        joueurs = new Joueur[nbJoueursMax];

    }

    public Casino(Casino autre) {
        this(autre.nom, autre.joueurs.length, autre.jeu);
        joueursPresents = autre.joueursPresents;

        for (int i = 0; i < joueursPresents; i++) {
            this.joueurs[i] = autre.joueurs[i];
        }
    }

    public boolean equals(Casino autre) {
        if (this.nom.equals(autre.nom)
                && this.jeu.equals(autre.jeu)) {
            return true;
        }
        return false;
    }

    public boolean ajouterJoueur(Joueur joueur) {
        if (((joueur instanceof JoueurPauvre) && (joueur.getCapital() >= 10)) || ((joueur instanceof JoueurRiche) && (joueur.getCapital() >= 1000))) {
            if (this.joueursPresents >= this.joueurs.length) {
                System.out.println("Désolé " + joueur.getNom() + ", le casino est plein!");
                return false;
            } else {
                this.joueurs[this.joueursPresents] = joueur;
                this.joueursPresents++;
                return true;
            }
        } else if (joueur instanceof JoueurPauvre) {
            System.out.println(joueur.getNom() + ", pour entrer dans le casino le Joueur Pauvre doit avoir au moin 10 dollars.");
        } else {
            System.out.println(joueur.getNom() + ",  pour entrer dans le casino le Joueur Riche doit avoir au moin 1000 dollars.");
        }
        return false;
    }

    public void enleverJoueur(Joueur joueur) {

        for (int i = 0; i < (this.joueursPresents); i++) {
            if (this.joueurs[i].equals(joueur)) {
                for (int j = i; j < (this.joueursPresents); j++) {
                    if (j != this.joueursPresents - 1) {
                        this.joueurs[j] = this.joueurs[j + 1];
                    } else {
                        this.joueurs[j] = null;
                    }
                }
                this.joueursPresents--;
                joueur.setCasino(null);
                //joueur.quitterCasino();
                System.out.println(joueur.getNom() + " a quitté le casino.");
                return;
            }
        }
        System.out.println("Désolé! " + joueur.getNom() + " ne peut pas quitter car il n'est pas dans le casino!");
    }

    public String toString() {
        String listeJoueur = "";
        for (int i = 0; i < joueursPresents; i++) {
            if (i == joueursPresents - 1) {
                listeJoueur += joueurs[i].getNom() + " : $" + joueurs[i].getCapital();
            } else {
                listeJoueur += joueurs[i].getNom() + " : $" + joueurs[i].getCapital() + ", ";
            }
        }

        String chaine;
        if (joueursPresents <= 1) {
            chaine = "Bienvenue au Casino " + this.nom + "!\nIl y a " + joueursPresents + " joueur présent.";
        } else {
            chaine = "Bienvenue au Casino " + this.nom + "!\nIl y a " + joueursPresents + " joueurs présents.";
        }
        if (joueursPresents > 0) {

            chaine += "\nVoici la liste: " + listeJoueur + ".";
        }
        return chaine;
    }

    public void jouer(Joueur joueur, int mise) {

        joueur.setCapital(joueur.getCapital() - mise);
        int gains = jeu.calculerGains(mise);
        joueur.setCapital(joueur.getCapital() + gains);
    }

    public int getJoueursPresents() {
        return joueursPresents;
    }

    public void setJoueursPresents(int joueursPresents) {
        this.joueursPresents = joueursPresents;
    }

    public Jeu getJeu() {
        return jeu;
    }

    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }

    public Joueur[] getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(Joueur[] joueurs) {
        this.joueurs = joueurs;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int compareTo(Object autre) { // compare les sommes du capitales de deux casino.
        Casino casinoB = (Casino) autre;
        double sommecap1 = 0;
        double sommecap2 = 0;
        for (int i = 0; i < (this.joueursPresents); i++) { // calcul la somme total du capital de joueurs presents en casino 1
            sommecap1 = sommecap1 + this.joueurs[i].getCapital();
        }
        for (int i = 0; i < (casinoB.joueursPresents); i++) {
            sommecap2 = sommecap2 + casinoB.joueurs[i].getCapital(); //calcul la somme total du capital de joueurs presents en casino 2
        }
        if (sommecap1 > sommecap2) {
            return 1;
        } else if (sommecap1 < sommecap2) {
            return -1;
        } else {
            return 0;
        }
    }

}
