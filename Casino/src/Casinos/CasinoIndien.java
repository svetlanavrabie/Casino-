/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casinos;
import Joueurs.*; // connection avec les classes Joueur et Jeu
import Jeux.*;

public class CasinoIndien extends Casino {
    
    // les constructeurs
    
  public CasinoIndien() {
        super("", 0, null);
    }
    
    public CasinoIndien(String nom, int nbJoueursMax, Jeu jeu) {
       super(nom, nbJoueursMax, jeu); 
    }
    
    public CasinoIndien(CasinoIndien autre) {
       super(autre); 
    }
    
    public boolean equals(CasinoIndien autre) {
      return super.equals(autre);
    }
    
    public String toString() {
        String chaine = "";
        chaine += super.toString();
        chaine += "\nCe casino est un Casino Indien..!!";
        return chaine;
    }
    
    public void descenteDePolice(){
        Joueur[] joueursL = this.getJoueurs();
        System.out.println("Descente De Police, on doit quitter le casino vite!!");
         while (this.getJoueursPresents() > 0) {
           this.enleverJoueur(joueursL[0]);      
        }
    }





}
