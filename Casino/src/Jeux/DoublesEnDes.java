/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jeux;

/**
 *
 * @author laura
 */
public class DoublesEnDes extends Jeu {
 
    public DoublesEnDes() {
        super("");
    }

    public DoublesEnDes(String nom) {
        super(nom);
    }

    public DoublesEnDes(Jeu autre) {
        super(autre.getNom());
    }
    
    public int calculerGains(int mise) {
         int de1 = (int)(6 * Math.random()+1);
         int de2 = (int)(6 * Math.random()+1);
         System.out.println("Nombre obtenu du dé #1 :" + de1 + "\n");
         System.out.println("Nombre obtenu du dé #2 :" + de2 + "\n");
         if (de1 == 6 && de2 == 6) 
         {
             System.out.println("Vous avez gagné $" + (mise*6));
             return mise * 6;
         }
         else if (de1 == 5 && de2 == 5)
         {
             System.out.println("Vous avez gagné $" + (mise*5));
             return mise * 5;
         }
         else if (de1 == 4 && de2 == 4) 
         {
             System.out.println("Vous avez gagné $" + (mise*4));
             return mise * 4;
         }
         else if (de1 == 3 && de2 == 3) 
         {
             System.out.println("Vous avez gagné $" + (mise*3));
             return mise * 3;
         }
         else if (de1 == 2 && de2 == 2) 
         {
             System.out.println("Vous avez gagné $" + (mise*2));
             return mise * 2;
         }
         else if (de1 == 1 && de2 == 1) 
         {
             System.out.println("Vous avez gagné $" + (mise));
             return mise;
         }
         else 
         {
             System.out.println("Desole, vous avez perdu la mise..");
             return 0;
         }
    }
    
    public String toString() {
        String chaine;
        chaine = "Le nom du jeu est: " + this.getNom() + " et les règles de ce jeu sont : \n ";
        chaine += "les deux dés sont lancés et un nombre de 1 à 6 est obtenu au hasard pour chaque dé.\n ";
        chaine += "Si on obtient un double 6, la mise est multiplié par 6 et ce sera le gain obtenu.\n ";
        chaine += "Si on obtient un double 5, la mise est multiplié par 5 et ce sera le gain obtenu.\n ";
        chaine += "Si on obtient un double 4, la mise est multiplié par 4 et ce sera le gain obtenu.\n ";
        chaine += "Si on obtient un double 3, la mise est multiplié par 3 et ce sera le gain obtenu.\n ";
        chaine += "Si on obtient un double 2, la mise est multiplié par 2 et ce sera le gain obtenu.\n ";
        chaine += "Si on obtient un double 1, la mise sera le gain obtenu (on ne perd pas rien dans cette tirage!).\n ";
        chaine += "BONNE CHANCE!!!";
        return chaine;
    }
}
