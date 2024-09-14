package personnages;

import java.util.Random;

public class Personnage {

    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Attributs">
    String nom;
    int pointsDeVie;
    int valeurMaxAttaque;
    int valeurDefense;
    int initiative;

    // </editor-fold>
    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Constructeurs et initialisation">
    public Personnage(String nom, int pvs, int attaqueMax, int defense, int ini) {
        this.nom = nom;
        this.pointsDeVie = pvs;
        this.valeurMaxAttaque = attaqueMax;
        this.valeurDefense = defense;
        this.initiative = ini;
    }

    public Personnage() {
        this.nom = "";
        this.pointsDeVie = 0;
        this.valeurMaxAttaque = 0;
        this.valeurDefense = 0;
        this.initiative = 0;
    }
    // </editor-fold>

    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Getters et setters">
    // TODO : Les getters
    public String getNom() {
        return nom;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public int getValeurMaxAttaque() {
        return valeurMaxAttaque;
    }

    public int getValeurDefense() {
        return valeurDefense;
    }

    public int getInitiative() {
        return initiative;
    }

    // TODO : Les setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    public void setValeurMaxAttaque(int valeurMaxAttaque) {
        this.valeurMaxAttaque = valeurMaxAttaque;
    }

    public void setValeurDefense(int valeurDefense) {
        this.valeurDefense = valeurDefense;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }
    // </editor-fold>

    // **************************************************************************
    // **************************************************************************
    // **************************************************************************
    // <editor-fold defaultstate="collapsed" desc="Mécanique de jeu">
    public void afficherInfosPersonnage() {
        System.out.println("\n" + this.getNom() + "\n    attaque : " + this.getValeurMaxAttaque() + "\n    Defense : " + this.getValeurDefense() + "\n    Points de vie : " + this.getPointsDeVie() + "\n    Initiative : " + this.getInitiative() + "\n    Statut : Vivant");

    }

     private int attaqueCalcul() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(this.getValeurMaxAttaque());
        return randomNumber;
    }

    public void frapperPersonnage(Personnage personnageCible) {
        // TODO : Récupérer la valeur d'attaque pour ce tour, calculer les dégats,
        int forceDeFrappe = attaqueCalcul();
        int valeurDefense = personnageCible.getValeurDefense();
        int dommage = forceDeFrappe - valeurDefense;
        //modifier les points de vie du personnage cible, afficher les détails
        if (dommage > 0 && personnageCible.getPointsDeVie() > 0)
        {
            if(personnageCible.getPointsDeVie() < dommage)
            {
                personnageCible.setPointsDeVie(0);
            }
            else
            {
                personnageCible.setPointsDeVie(personnageCible.getPointsDeVie() - dommage);
            }      
        }
        // sur l'attaque, tel que montré dans l'énoncé.
        System.out.println(this.getNom() + " attaque avec une puissance de : " + forceDeFrappe +"\n"+ personnageCible.getNom()+ " a une defense de : " + personnageCible.getValeurDefense());
        
        if (personnageCible.getValeurDefense() > forceDeFrappe)
        {
             System.out.println("Les dommages sont de : 0");
        }
        else
        {
            System.out.println("Les dommages sont de : " + dommage);
        }
        personnageCible.afficherInfosPersonnage();
        System.out.println("");
    }

    public void setNewInitiativeRandom() {
        // TODO : Modifier de façon aléatoire la valeur INI du personnage.
        Random rand = new Random();
        int randomNumber = rand.nextInt(101);
        this.setInitiative(randomNumber);
    }
    // </editor-fold>
}
