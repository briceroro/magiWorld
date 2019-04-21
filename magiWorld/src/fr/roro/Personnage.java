package fr.roro;

public abstract class Personnage<string> {
    /**
     * constructor
     * @param lvl defini le lvl du joueur
     * @param life defini la vie du joueur
     * @param strong defini la force du joueur
     * @param agility defini l'agilié du joueur
     * @param intel defini l'intel d'un joueur
     * @param initLife defini la vie initial d'un mage
     * @param combat defini si c'est el tour d'un joueur de combattre
     * @param name defini le nom du joueur
     * @param classPerso defini  la class d'un joueur
     * @param cri defini le cri d'un joeur en focntion de sa class
     *
     */
    private int lvl;
    private int life;
    private int strong;
    private int intel;
    private int agility;
    protected int initlife;
    private boolean combat;
    protected string name;
    protected string classPerso;
    protected string cri;

    /**
     * getter et setter de la class
     */

    public int getLvl() {
        return lvl;
    }
    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getLife() {
        return life;
    }
    public void setLife(int life) {
        this.life = life;
    }

    public int getStrong() {
        return strong;
    }
    public void setStrong(int strong) {
        this.strong = strong;
    }

    public int getIntel() {
        return intel;
    }
    public void setIntel(int intel) {
        this.intel = intel;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getInitlife() {
        return initlife;
    }
    public void setInitlife(int initlife) {
        this.initlife = initlife;
    }

    public boolean isCombat() {
        return combat;
    }
    public void setCombat(boolean combat) {
        this.combat = combat;
    }

    public string getName() {
        return name;
    }

    public string getClassPerso() {
        return classPerso;
    }
    public abstract void setClassPerso(int nbr);

    public string getCri() {
        return cri;
    }

    /**
     * methode: attackBasic et attackSpecial
     * abstraites pour pouvoir les implémentées dans les class aprés
     */
    public abstract void attackBasic(Personnage ennemi);
    public abstract void attackSpecial(Personnage ennemi);

    /**
     * methode pour afficher un message a la création d'un joueur
     */
    public void description (){
        System.out.println(getCri()+" je suis le "+getClassPerso()+" "+ getName()+":"
                +" de niveau "+getLvl()+" je possede "+getLife()+" de vitalité, "+getStrong()+
                " de force, "+getAgility()+" d'agilité et "+ getIntel()+" d'intéligenace!!!");
    }



}
