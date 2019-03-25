package Main;

import Joueurs.Joueur;
import Casinos.Casino;
import Casinos.CasinoIndien;
import Casinos.CasinoLegal;
import Jeux.DoublesEnDes;
import Jeux.Jeu;
import Jeux.PileOuFace;
import Joueurs.JoueurPauvre;
import Joueurs.JoueurRiche;

public class TestCasino {

    public static void main(String[] args) {

    //creation des jeux
     System.out.println();
     Jeu jeu1 = new PileOuFace();
     Jeu jeu2 = new DoublesEnDes();
     
     //creatio des casinos
     System.out.println();
     Casino casino1 = new CasinoLegal("Red Rock", 3, jeu2);
     Casino casino2 = new CasinoIndien("Casino Algonquino", 3, jeu1);
     
     //creation des joueurs  
        Joueur joueur1 = new JoueurRiche("JR1", 2000);
        Joueur joueur2 = new JoueurRiche("JR2", 3000);
        Joueur joueur3 = new JoueurRiche("JR3", 6000);
        Joueur joueur4 = new JoueurRiche("JR4", 100);// pas assez d'argent!
        
        Joueur joueur5 = new JoueurPauvre("JP1", 60);
        Joueur joueur6 = new JoueurPauvre("JP2", 100);
        Joueur joueur7 = new JoueurPauvre("JP3", 300);
        Joueur joueur8 = new JoueurPauvre("JP4", 2);// pas assez d'argent!
        Joueur joueur9 = new JoueurPauvre("JP5", 100);//le casino est plein!
        
        
     //ajout de joueurs
        System.out.println();
        joueur1.joindreCasino(casino1);
        joueur2.joindreCasino(casino1);
        joueur3.joindreCasino(casino1);
        joueur4.joindreCasino(casino1);
        joueur5.joindreCasino(casino2);
        joueur6.joindreCasino(casino2);
        joueur7.joindreCasino(casino2);
        joueur8.joindreCasino(casino2);
        joueur9.joindreCasino(casino2);
        
        //quitter un casino
        System.out.println();
        joueur5.quitterCasino();
        
        //methodes toString des casinos
        System.out.println();
        System.out.println(casino1.toString());//liste de casino 1
        System.out.println();
        System.out.println(casino2.toString());// liste de casino 2
        
        //methode compareTo entre deux casinos - somme de casino
        System.out.println();
        if (casino1.compareTo(casino2) == 1)
            System.out.println("Le capital total dans le casino "+casino1.getNom()+" est plus grand que dans le casino " +casino2.getNom());
        else if(casino1.compareTo(casino2) == -1)
            System.out.println("Le capital total dans le casino "+casino1.getNom()+" est plus petit que dans le casino " +casino2.getNom());
        else
            System.out.println("Le capital total dans le casino "+casino1.getNom()+" est egal que dans le casino " +casino2.getNom());
        
        //compareTo entre deux joueurs
        System.out.println();
        if (joueur1.compareTo(joueur2) == 1)
            System.out.println("Le capital de " + joueur1.getNom() + " est plus grans que celui de" + joueur2.getNom());
        else if(joueur1.compareTo(joueur2) == -1)
            System.out.println("Le capital de " + joueur1.getNom() + " est plus petit que celui de " + joueur2.getNom());
        else
            System.out.println("Le capital de " + joueur1.getNom() + " est egal que celui de " + joueur2.getNom());
        
        //collecterCheque du JoueurPauvre
        System.out.println();
        ((JoueurPauvre)joueur6).collecterCheque(); // premier jour de mois  son capital + 700 -jpo
        
        //methode collecterImpots du CasinoLegal -enleve 15 % du capital de chaque joueur de CL
        System.out.println();
        ((CasinoLegal)casino1).collecterImpots();
        System.out.println(casino1.toString()); // pour verifier le verifier!
        
        //methode banqueRoute du JoueurRiche - le capital est met a 0, le joueur quitte le casinp
        System.out.println();
        ((JoueurRiche)joueur2).banqueRoute();
        System.out.println(joueur2.toString()); // pour verifier capital est devenu 0  et qu'il a quitté le casino!
        
        //methodes toString des classes PileOuFace et DoublesEnDes pour savoir les regles de ces jeux..
        System.out.println();
        jeu1.toString();
        System.out.println();
        jeu2.toString();
        
        //on fait jouer quelques jouers (methode jouer de la clase Joueur)
        System.out.println();
        joueur1.jouer(50);
        joueur7.jouer(100);
        joueur5.jouer(150);//pas assez d'argent pour miser..
        
        // methode descenteDePolice, tout les joueurs vont quitter le casino!!
        System.out.println();
        ((CasinoIndien)casino2).descenteDePolice();
        System.out.println(casino2.toString()); // pour verifier que le methode fait son travail
        
        
        
     
     
    }
}
