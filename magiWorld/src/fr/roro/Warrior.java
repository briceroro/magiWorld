package fr.roro;

public class Warrior extends Personnage {

    /**
     * sert a definir le nom,cri,la class d'un geurrier
     * @param nbr
     */
    @Override
    public void setClassPerso(int nbr) {
        this.classPerso ="guerrier";
        this.cri = "waaaarggg!!!!";
        this.name = ("joueur "+ nbr);
    }

    /**
     * défini l'attaque coup d'épee du guerrier
     * @param ennemi
     */
    @Override
    public void attackBasic(Personnage ennemi) {
        System.out.println(getName()+ " utilise coup d'épée et inflige "+getStrong()+" de dégats");
        ennemi.setLife(ennemi.getLife()- getStrong());
        System.out.println(ennemi.getName()+" perd "+getStrong()+" points de vie");
        setCombat(false);
        ennemi.setCombat(true);

    }

    /**
     * defini l'attaque coup de rage du guerrier
     * @param ennemi
     */
    @Override
    public void attackSpecial(Personnage ennemi) {
        System.out.println(getName()+ " utilise coup de rage et inflige "+getStrong()*2+" de dégats");
        ennemi.setLife(ennemi.getLife()-(getStrong()*2));
        System.out.println(ennemi.getName()+" perd "+getStrong()*2+" points de vie");
        setLife(getLife()-(getStrong()/2));
        System.out.println(getName()+" perd "+ getStrong()/2 +" points de vie suite a coup de rage");
        setCombat(false);
        ennemi.setCombat(true);

    }
}
