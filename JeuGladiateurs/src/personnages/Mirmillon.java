/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personnages;

import java.util.Random;

/**
 *
 * @author 202230076
 */
public class Mirmillon extends Personnage {

    private String classe;

    public void setClasse() {
        classe = "Mirmillon";
    }

    public String getClasse() {
        return classe;
    }

    public Mirmillon(String nom, int pvs, int attaqueMax, int defense, int ini) {
        this.nom = nom;
        this.pointsDeVie = pvs;
        this.valeurMaxAttaque = attaqueMax;
        this.valeurDefense = defense;
        this.initiative = ini;
    }

    @Override
    public void afficherInfosPersonnage() {
        super.afficherInfosPersonnage();
        System.out.println("    classe : " + this.getClasse());
    }

    @Override
    public void setNewInitiativeRandom() {
        // TODO : Modifier de façon aléatoire la valeur INI du personnage.
        Random rand = new Random();
        int randomNumber = rand.nextInt(30);
        this.setInitiative(randomNumber);
    }

    @Override
    public void frapperPersonnage(Personnage personnageCible) {
        // TODO : Récupérer la valeur d'attaque pour ce tour, calculer les dégats,
        int nombreDeFrappe = 1;

        do {
            if (personnageCible.getPointsDeVie() == 0) 
            {
                System.out.println("Bob le malchanceux decapite son adversaire\n");
            }
            else
            {
                super.frapperPersonnage(personnageCible);
            }

            nombreDeFrappe++;
        } while (nombreDeFrappe <= 2);
    }
}
