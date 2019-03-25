/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casinos;

import Joueurs.*;
import Jeux.*;

public class CasinoLegal extends Casino {

// les constructeurs
   public CasinoLegal() {
        super("", 0, null);
    }
    
    public CasinoLegal(String nom, int nbJoueursMax, Jeu jeu) {
       super(nom, nbJoueursMax, jeu); 
    }
    
    public CasinoLegal(CasinoLegal autre) {
       super(autre); 
    }
    
    public boolean equals(CasinoLegal autre) {
      return super.equals(autre);
    }
    
    public String toString() {
        String chaine = "";
        chaine += super.toString();
        chaine += "\nCe casino est un Casino Legal..!!";
        return chaine;
    }
    
    public void collecterImpots(){
         Joueur[] joueursL = this.getJoueurs();
         for (int i = 0; i < (this.getJoueursPresents()); i++) {
           joueursL[i].setCapital((int)(joueursL[i].getCapital()*0.85));
        }
        if (this.getJoueursPresents()>0)
            System.out.println("Les impots ont été collecté sur la liste des joueurs!");
        else 
            System.out.println("Pas de joueurs pour collecter des impots!");
    }

}
