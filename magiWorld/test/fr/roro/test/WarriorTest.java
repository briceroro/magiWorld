package fr.roro.test;

import fr.roro.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    Warrior p1 = new Warrior();
    Warrior p2 = new Warrior();


    @Test
    void verifieSiSetclassPersoFonctionne(){
        p1.setClassPerso(12);
        assertEquals("joueur 12",p1.getName());
    }
    @Test
    void verifieSiAttackBasicFonctionne() {
        p1.setStrong(10);
        p2.setLife(50);
        p1.attackBasic(p2);
        assertEquals(40,p2.getLife());
    }

    @Test
    void verifieSiAttackSpecialFonctionne()  {
        p1.setStrong(10);
        p1.setLife(50);
        p2.setLife(50);
        p1.attackSpecial(p2);
        assertEquals(30,p2.getLife());
        assertEquals(45,p1.getLife());
    }
}