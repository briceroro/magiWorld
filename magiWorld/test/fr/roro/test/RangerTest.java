package fr.roro.test;

import fr.roro.Ranger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangerTest {
    Ranger p1 = new Ranger();
    Ranger p2 = new Ranger();

    @Test
    void verifieSiSetclassPersoFonctionne(){
        p1.setClassPerso(12);
        assertEquals("joueur 12",p1.getName());
    }

    @Test
    void verifieSiAttackBasicFonctionne() {
        p1.setAgility(10);
        p2.setLife(50);
        p1.attackBasic(p2);
        assertEquals(40,p2.getLife());
    }

    @Test
    void verifieSiAttackSpecialFonctionne() {
        p1.setLvl(10);
        p1.setAgility(10);
        p1.attackSpecial(p2);
        assertEquals(15,p1.getAgility());
    }
}