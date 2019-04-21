package fr.roro.test;

import fr.roro.Mage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {
    Mage p1 = new Mage();
    Mage p2 = new Mage();


    @Test
    void verifieSiSetclasspersoFonctionne(){
        p1.setClassPerso(12);
        assertEquals("joueur 12",p1.getName());
    }

    @Test
    void verifieSiAttackBasicFonctionne() {
        p1.setIntel(10);
        p2.setLife(50);
        p1.attackBasic(p2);
        assertEquals(40,p2.getLife());
    }

    @Test
    void verifieSiAttackSpecialFionctionne() {
        p1.setLife(50);
        p1.setInitlife(50);
        p1.setLife(p1.getLife()-1);
        p1.setIntel(10);
        p1.attackSpecial(p2);
        assertEquals(50,p1.getLife());
    }
}