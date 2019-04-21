package fr.roro;

public class Ranger extends Personnage {

    /**
     * sert a definir le nom,cri, la class du rodeur
     * @param nbr
     */
    @Override
    public void setClassPerso(int nbr) {
        this.classPerso ="rodeur";
        this.cri = "je suis l'ombre de vos cauchemards!!!!!";
        this.name = ("joueur "+ nbr);
    }

    /**
     * defini  l'attaque tir à larc du rodeur
     * @param ennemi
     */
    @Override
    public void attackBasic(Personnage ennemi) {
        System.out.println(getName()+ " utilise tir a l'arc et inflige "+getAgility()+" de dégats");
        ennemi.setLife(ennemi.getLife()- getAgility());
        System.out.println(ennemi.getName()+" perd "+getAgility()+" points de vie");
        setCombat(false);
        ennemi.setCombat(true);
    }

    /**
     * defini concentration du rodeur
     * @param ennemi
     */
    @Override
    public void attackSpecial(Personnage ennemi) {
        System.out.println(getName()+ " utilise concentration et gagne "+ getLvl()/2+ " d'agilité");
        setAgility(getAgility()+(getLvl()/2));
        setCombat(false);
        ennemi.setCombat(true);
    }
}
