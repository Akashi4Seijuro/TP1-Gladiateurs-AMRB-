package jeugladiateurs;

import personnages.Personnage;
import personnages.Mirmillon;
import personnages.Retiaire;
import combat.CompteurDeTour;
import combat.AffichageEcran;

public class JeuGladiateurs {

    public static void main(String[] args) {

        // **************************************************************************
        // **************************************************************************
        // **************************************************************************
        // <editor-fold defaultstate="expanded" desc="Instanciation des objets">
        CompteurDeTour tour = new CompteurDeTour();
        AffichageEcran affichage = new AffichageEcran();
        Mirmillon Bob = new Mirmillon("Bob le malchanceux", 70, 15, 15, 15);
        Retiaire Igor = new Retiaire("Igor l'empaleur", 100, 25, 5, 30);
        Bob.setClasse();
        Igor.setClasse();
        // </editor-fold>
        // **************************************************************************
        // **************************************************************************
        // **************************************************************************
        // <editor-fold defaultstate="collapsed" desc="Affichage pré-combat">
        // TODO : Afficher les infos de chaque personnage
        Bob.afficherInfosPersonnage();
        Igor.afficherInfosPersonnage();
        // TODO : Afficher le message du début du combat
        affichage.afficherDebutCombat();
        // </editor-fold>

        // **************************************************************************
        // **************************************************************************
        // **************************************************************************
        // <editor-fold defaultstate="collapsed" desc="Mécanique de combat">
        // TODO : La boucle contenant les étapes du combat
        tour.setCptrTour(1);
        while (Bob.getPointsDeVie() != 0 && Igor.getPointsDeVie() != 0) 
        {
            tour.afficheTour();

            for (int i = 0; i <= 100; i++) {
                if (i == Bob.getInitiative()) {
                    Bob.frapperPersonnage(Igor);
                    if(Igor.getPointsDeVie() == 0)
                    {
                        System.out.println("Bob le malchanceux decapite son adversaire\n");
                    }
                    else
                    {
                        Bob.frapperPersonnage(Igor);
                    }
                    
                }
                if (i == Igor.getInitiative()) {
                    Igor.frapperPersonnage(Bob);
                }
            }

            affichage.afficherSeparateurInfosPerso();
            Bob.afficherInfosPersonnage();
            Igor.afficherInfosPersonnage();
            affichage.afficherSeparateurDeTour();

            tour.augmenteTour();
            Bob.setNewInitiativeRandom();
            Igor.setNewInitiativeRandom();
        }
        // TODO : Après la boucle, afficher le résultat du combat
        affichage.afficheVictoire(Bob, Igor);
        // </editor-fold>
    }

}
