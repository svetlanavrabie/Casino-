/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Joueurs;
import Casinos.*;
import java.util.Calendar;
//import Jeux.*;
public class JoueurPauvre extends Joueur{
    
    
      //constructeurs
   public JoueurPauvre() {
        super("", 0, null);
    }

    public JoueurPauvre(String nom, int capital) {
        super(nom, capital, null);
    }

    public JoueurPauvre(String nom, int capital, Casino casino) {
        super(nom, capital, casino);
    }

    //constructeur par copie
    public JoueurPauvre(JoueurPauvre autre) {
        this(autre.getNom(), autre.getCapital(), autre.getCasino());
    }
    
    public boolean equals(JoueurPauvre autre) {
      return super.equals(autre);
    }
    
    public String toString() {
        String chaine = "";
        chaine += super.toString();
        chaine += "\nJe suis un Joueur Pauvre..!!";
        return chaine;
    }
    
    public void collecterCheque(){
       Calendar cal = Calendar.getInstance();
       int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
       if (dayOfMonth == 1) {
           this.setCapital(this.getCapital()+700);
           System.out.println("Cheque de $700 collecté :\n");
           System.out.println(this.toString());//apelle a toString pour verifier que le cheque a ete collecté!
       } else
            System.out.println("Attends le premier jour du prochain mois pour collecter le cheque!");
    }
}
