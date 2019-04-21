package fr.roro;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Game {

    Scanner sc = new Scanner(System.in);
    private Personnage[] persos = new Personnage[2];
    private Personnage p1;
    private Personnage p2;

    /**
     * création du jeu
     * création des 2 personnages
     * initialisation du combat
     */
    public Game(){

        p1 = setPersonnage(p1,1);
        p2 = setPersonnage(p2,2);
        p1.setCombat(true);
        p2.setCombat(false);
        combat(p1,p2);
    }

    /**
     * methode pour gerer les exeption des xeption des scanner de la class Game
     * @return int
     */
    public int intTryCatch(){

        int tryCatch = 0;
        try {
            tryCatch = sc.nextInt();
        } catch (InputMismatchException e) {
            sc.next();
            System.out.println("Merci de saisir un chiffre correct, recommence");
            tryCatch = intTryCatch();
        }
        return  tryCatch;
    }

    /**
     * methode servant a lancer la création d'un personnage
     * @param persoX
     * @param nbrPerso
     * @return Personnage
     */
    public Personnage setPersonnage (Personnage persoX, int nbrPerso){

        System.out.println("Création du joueur :"+" "+nbrPerso);
        System.out.println("Veuilliez choisir la classe de votre personnage ( guerrier: 1, mage: 2, rodeur: 3");
        int choixClasse = intTryCatch();
        persoX = setClass(persoX,choixClasse);
        persoX = setCaract(persoX,nbrPerso);
        persoX.description();
        return persoX;
    }

    /**
     * methode servant a définir la class du personnage
     * @param persoX
     * @param choix
     * @return Personnage
     */
    public Personnage setClass(Personnage persoX ,int choix){

        if ( choix == 1){
            persoX = new Warrior();

        }else if( choix == 2){
            persoX = new Mage();

        }else if ( choix == 3){
            persoX =new Ranger();

        }else if ( choix <= 1 || choix >= 3 ) {
            System.out.println("choisi une classe valide");
            choix = intTryCatch();

            return setClass(persoX,choix);
        }
        return persoX;
    }

    /**
     * methode servant a définir les caractéristiques du personnage
     * @param persoX
     * @param nbrPerso
     * @return
     */
    public Personnage setCaract( Personnage persoX,int nbrPerso){

        System.out.println("Niveau du Personnage ?");
        persoX.setLvl(intTryCatch());
        persoX.setLife(persoX.getLvl()*5);
        System.out.println("Force du personnage ?");
        persoX.setStrong(intTryCatch());
        System.out.println("Agilité du personnage ?");
        persoX.setAgility(intTryCatch());
        System.out.println("Intélligence du personnage ?");
        persoX.setIntel(intTryCatch());
        checkCaract(persoX,nbrPerso);
        persoX.setClassPerso(nbrPerso);

        return persoX;
    }

    /**
     * methode pour vérifier si les caractéristique correponde à l'énoncé ( lvl = strong+intel+agility)
     * @param persoX
     * @param nbrPerso
     */
    public void checkCaract (Personnage persoX, int nbrPerso){

        if(persoX.getLvl() != (persoX.getStrong()+persoX.getIntel()+persoX.getAgility())){
            System.out.println("le total de force+agilité+inteligence doit etre égal au niveau du joueur, recommence");
            setCaract(persoX,nbrPerso);
        }
    }

    /**
     * methode pour lancer le combat
     * @param p1
     * @param p2
     */
    public void combat(Personnage p1, Personnage p2){

        if (p1.isCombat() && (p2.getLife()> 0 || p1.getLife() >0)) {
          choiceTypeAttack(p1,p2);
        } else if (p2.isCombat()&& (p2.getLife()> 0 || p1.getLife() >0)) {
            choiceTypeAttack(p2,p1);
        }
        checkStopCombat(p1,p2);
       }

    /**
     * methode pour choisir les type d'attaque pendant le combat
     * @param attack
     * @param def
     */
    public void choiceTypeAttack(Personnage attack, Personnage def){
        System.out.println(attack.getName()+" ("+attack.getLife()+" de vitalité, veuilliez choisir votre action (1: attaque basique, 2: attaque spéciale)");
        int attackChoice = intTryCatch();
        if (attackChoice == 1 ) {
            attack.attackBasic(def);
        }else if (attackChoice == 2) {
            attack.attackSpecial(def);
        } else{
            System.out.println("choisi une attaque valide, recommence");
        }
    }

    /**
     * methode pour vérifier si un joueur est mort et appeller la methode stopCombat()
     * @param p1
     * @param p2
     */
    public void checkStopCombat(Personnage p1, Personnage p2){
        if (p1.getLife() <= 0 || p2.getLife() <= 0) {
            stopCombat(p1,p2);
        }else{
            combat(p1,p2);
        }
    }

    /**
     * methode pour stop le jeu
     * @param p1
     * @param p2
     */
    public void stopCombat(Personnage p1, Personnage p2){
        if (p1.getLife() <= 0){
            System.out.println(p1.getName()+" a perdu, il est mort");
        }else{
            System.out.println(p2.getName()+" a perdu, il est mort");
        }
    }
}
