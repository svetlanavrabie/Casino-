/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Joueurs;

import Casinos.*;
//import Jeux.*;
public class JoueurRiche extends Joueur{
    
    // constructeurs
   public JoueurRiche() {
        super("", 0, null);
    }

    public JoueurRiche(String nom, int capital) {
        super(nom, capital, null);
    }

    public JoueurRiche(String nom, int capital, Casino casino) {
        super(nom, capital, casino);
    }

    //constructeur par copie
    public JoueurRiche(JoueurRiche autre) {
        this(autre.getNom(), autre.getCapital(), autre.getCasino());
    }
    
    public boolean equals(JoueurRiche autre) {
      return super.equals(autre);
    }
    
    public String toString() {
        String chaine = "";
        chaine += super.toString();
        chaine += "\nJe suis un Joueur Riche..!!";
        return chaine;
    }
    
    public void banqueRoute(){
        System.out.println("Toutes les comptes de " + this.getNom() + " sont fermés!!");
        this.setCapital(0);
        this.quitterCasino();
    }

}
