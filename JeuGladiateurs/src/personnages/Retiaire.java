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
public class Retiaire extends Personnage {

    private String classe;
    
    boolean filetEnMain;

    
    
    public boolean isFiletEnMain() {
        return filetEnMain;
    }
    
    public String getClasse() {
        return classe;
    }

    
    public void setFiletEnMain(boolean filetEnMain) {
        this.filetEnMain = filetEnMain;
    }

    public void setClasse() {
        this.classe = "Retiaire";
    }

    public Retiaire(String nom, int pvs, int attaqueMax, int defense, int ini) {
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
    public void frapperPersonnage(Personnage personnageCible) {
        // TODO : Récupérer la valeur d'attaque pour ce tour, calculer les dégats,
        
        int success = 0;

        Random rand = new Random();
        int chanceDeTuer = rand.nextInt(10);

        if (this.isFiletEnMain() == true) {
            System.out.println("Igor l'empaleur lance son filet");
            this.setFiletEnMain(false);
            if(chanceDeTuer == success)
            {
                System.out.println("Son filet attrape Bob le malchanceux et il l'empale sauvagement avec sa lance\n");
                personnageCible.setPointsDeVie(0);
            }
            else{
                System.out.println("Le filet n'atteint pas sa cible\n");
            }
        } else {
            System.out.println("Igor l'empaleur ramasse son filet et en profite pour attaquer");
            super.frapperPersonnage(personnageCible);
            this.setFiletEnMain(true);
        }

    }
}
