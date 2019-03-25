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
public class PileOuFace extends Jeu {
  
    public PileOuFace() {
        super("");
    }

    public PileOuFace(String nom) {
        super(nom);
    }

    public PileOuFace(Jeu autre) {
        super(autre.getNom());
    }
    
    public String toString() {
        String chaine;
        chaine = "\nLes règles du jeu Pile ou Face sont simples:\nPar défaut, le joueur prend face, donc si le casino affiche face, vous doublez votre mise.";
        chaine += "\nBONNE CHANCE!!!";
        return chaine;
    }
    
    public int calculerGains(int mise) {
        //Assumons que pile vaut 0 et que le joueur prend toujours face.
        int pileOuFace = (int) (2 * Math.random());
        if (pileOuFace == 0) {
            System.out.println("Vous avez gagné $" + (mise*2));
            return mise * 2;
        } else {
            System.out.println("Desole, vous avez perdu la mise..");
            return 0;
        }
    }
}
