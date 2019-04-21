package fr.roro;


public class Mage extends Personnage {

    /**
     * sert a definir le nom,cri,la class et la  vie initial d'un mage
     * @param nbr
     */
    @Override
    public void setClassPerso(int nbr) {
        this.classPerso ="mage";
        this.cri = "Abracadabra!!!!";
        this.name = ("joueur "+ nbr);
        this.initlife = getLife();
    }

    /**
     * methode pour definir l'attaque basique boule de feu du mage
     * @param ennemi
     */
    @Override
    public void attackBasic(Personnage ennemi) {
        System.out.println(getName()+ " utilise boule de feu et inflige "+getIntel()+" de dégats");
        ennemi.setLife(ennemi.getLife()- getIntel());
        System.out.println(ennemi.getName()+" perd "+getIntel()+" points de vie");
        setCombat(false);
        ennemi.setCombat(true);
    }

    /**
     * methode pour lancer la methode soin du mage
     * @param ennemi
     */
    @Override
    public void attackSpecial(Personnage ennemi) {
        System.out.println(getName()+ " utilise soin et gagne "+ getIntel()/2+ " de vitalité");
        setLife(heal(getInitlife()));
        setCombat(false);
        ennemi.setCombat(true);
    }

    /**
     * methode pour vérifier si soin ne depasse pas le niveau de vie initial du mage
     * @param initLife
     * @return
     */
    private int heal (int initLife){
        int life = getLife()+(getIntel()*2);
        if ( life > initLife){
            return initLife;
        }
        return life;
    }


}
