import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BartSimpsonUnitTest {
    @Test
    public void testingBartSimpsonNoParameterConstructor() {
        System.out.println("Creating Bart Simpson with 0 parameter constructor");
        BartSimpsonUnit bs = new BartSimpsonUnit();
        System.out.println();
        System.out.println("-- Testing Getters");
        System.out.println();
        System.out.println("-- Testing Symbol");
        assertEquals('B', bs.getSymbol());
        System.out.println("-- Testing Name");
        assertEquals("Bart Simpson", bs.getName());
        System.out.println("-- Testing Health");
        assertEquals(100.0, bs.getHealth(), 0.0001);
        System.out.println("-- Testing Health Modifier");
        assertEquals(0.0, bs.getHealthModifier(), 0.0001);
        System.out.println("-- Testing Damage");
        assertEquals(25.0, bs.getDamage(), 0.0001);
        System.out.println("-- Testing Damage Modifier");
        assertEquals(0.0, bs.getDamageModifier(), 0.0001);
        System.out.println("-- Testing Luck");
        assertEquals(0, bs.getLuck());
        System.out.println("-- Testing xCor");
        assertEquals(5, bs.getxCor());
        System.out.println("-- Testing yCor");
        assertEquals(5, bs.getyCor());
        System.out.println("-- Testing Movement");
        assertEquals(1, bs.getMovement());
        System.out.println("-- Testing Movement Modifier");
        assertEquals(0, bs.getMovementModifier());
        System.out.println("-- Testing Number of Times Spawned");
        assertEquals(0, bs.getNumTimesSpawned());
        System.out.println("-- Testing Distract");
        assertTrue(bs.canDistract());
        System.out.println("-- Testing Recruit");
        assertTrue(bs.canRecruit());
        System.out.println();
        System.out.println("-- Testing Setters");
        System.out.println();
        System.out.println("-- Testing Symbol");
        bs.setSymbol('S');
        assertEquals('S', bs.getSymbol());
        System.out.println("-- Testing Name");
        bs.setName("Not Bart Simpson");
        assertEquals("Not Bart Simpson", bs.getName());
        System.out.println("-- Testing Health");
        bs.setHealth(90.0);
        assertEquals(90.0, bs.getHealth(), 0.0001);
        System.out.println("-- Testing Health Modifier");
        bs.setHealthModifier(5.0);
        assertEquals(5.0, bs.getHealthModifier(), 0.0001);
        System.out.println("-- Testing Damage");
        bs.setDamage(23.0);
        assertEquals(23.0, bs.getDamage(), 0.0001);
        System.out.println("-- Testing Damage Modifier");
        bs.setDamageModifier(5.0);
        assertEquals(5.0, bs.getDamageModifier(), 0.0001);
        System.out.println("-- Testing Luck");
        bs.setLuck(5);
        assertEquals(5, bs.getLuck());
        System.out.println("-- Testing xCor");
        bs.setxCor(10);
        assertEquals(10, bs.getxCor());
        System.out.println("-- Testing yCor");
        bs.setyCor(10);
        assertEquals(10, bs.getyCor());
        System.out.println("-- Testing Movement");
        bs.setMovement(2);
        assertEquals(2, bs.getMovement());
        System.out.println("-- Testing Movement Modifier");
        bs.setMovementModifier(5);
        assertEquals(5, bs.getMovementModifier());
        System.out.println("-- Testing Number of Times Spawned");
        bs.setNumTimesSpawned(5);
        assertEquals(5, bs.getNumTimesSpawned());
        System.out.println("-- Testing Distract");
        bs.setDistract(false);
        assertFalse(bs.canDistract());
        System.out.println("-- Testing Recruit");
        bs.setRecruit(false);
        assertFalse(bs.canRecruit());
        System.out.println();
        bs.distracted();
        bs.setDistract(true);
        bs.distracted();
        System.out.println();

    }

    @Test
    public void testingBartSimpsonParameterConstructor() {
        System.out.println("Creating Bart Simpson with 14 parameter constructor");
        System.out.println();
        BartSimpsonUnit bs2 = new BartSimpsonUnit('S', "Not Bart Simpson", 90.0, 5.0, 23.0, 5.0, 5, 10, 10, 2, 5, 5,
                false, false, "Unknown");
        System.out.println();
        System.out.println("-- Testing Getters");
        System.out.println();
        System.out.println("-- Testing Symbol");
        assertEquals('S', bs2.getSymbol());
        System.out.println("-- Testing Name");
        assertEquals("Not Bart Simpson", bs2.getName());
        System.out.println("-- Testing Health");
        assertEquals(90.0, bs2.getHealth(), 0.0001);
        System.out.println("-- Testing Health Modifier");
        assertEquals(5.0, bs2.getHealthModifier(), 0.0001);
        System.out.println("-- Testing Damage");
        assertEquals(23.0, bs2.getDamage(), 0.0001);
        System.out.println("-- Testing Damage Modifier");
        assertEquals(5.0, bs2.getDamageModifier(), 0.0001);
        System.out.println("-- Testing Luck");
        assertEquals(5, bs2.getLuck());
        System.out.println("-- Testing xCor");
        assertEquals(10, bs2.getxCor());
        System.out.println("-- Testing yCor");
        assertEquals(10, bs2.getyCor());
        System.out.println("-- Testing Movement");
        assertEquals(2, bs2.getMovement());
        System.out.println("-- Testing Movement Modifier");
        assertEquals(5, bs2.getMovementModifier());
        System.out.println("-- Testing Number of Times Spawned");
        assertEquals(5, bs2.getNumTimesSpawned());
        System.out.println("-- Testing Distract");
        assertFalse(bs2.canDistract());
        System.out.println("-- Testing Recruit");
        assertFalse(bs2.canRecruit());
        System.out.println();
        System.out.println("-- Testing Setters");
        System.out.println();
        System.out.println("-- Testing Symbol");
        bs2.setSymbol('B');
        assertEquals('B', bs2.getSymbol());
        System.out.println("-- Testing Name");
        bs2.setName("Bart Simpson");
        assertEquals("Bart Simpson", bs2.getName());
        System.out.println("-- Testing Health");
        bs2.setHealth(100.0);
        assertEquals(100.0, bs2.getHealth(), 0.0001);
        System.out.println("-- Testing Health Modifier");
        bs2.setHealthModifier(0.0);
        assertEquals(0.0, bs2.getHealthModifier(), 0.0001);
        System.out.println("-- Testing Damage");
        bs2.setDamage(25.0);
        assertEquals(25.0, bs2.getDamage(), 0.0001);
        System.out.println("-- Testing Damage Modifier");
        bs2.setDamageModifier(0.0);
        assertEquals(0.0, bs2.getDamageModifier(), 0.0001);
        System.out.println("-- Testing Luck");
        bs2.setLuck(0);
        assertEquals(0, bs2.getLuck());
        System.out.println("-- Testing xCor");
        bs2.setxCor(5);
        assertEquals(5, bs2.getxCor());
        System.out.println("-- Testing yCor");
        bs2.setyCor(5);
        assertEquals(5, bs2.getyCor());
        System.out.println("-- Testing Movement");
        bs2.setMovement(1);
        assertEquals(1, bs2.getMovement());
        System.out.println("-- Testing Movement Modifier");
        bs2.setMovementModifier(0);
        assertEquals(0, bs2.getMovementModifier());
        System.out.println("-- Testing Number of Times Spawned");
        bs2.setNumTimesSpawned(0);
        assertEquals(0, bs2.getNumTimesSpawned());
        System.out.println("-- Testing Distract");
        bs2.setDistract(true);
        assertTrue(bs2.canDistract());
        System.out.println("-- Testing Recruit");
        bs2.setRecruit(true);
        assertTrue(bs2.canRecruit());
        System.out.println();
        bs2.distracted();
        bs2.setDistract(false);
        bs2.distracted();
        System.out.println();
    }

    @Test
    public void test_spawn() {
        System.out.println("Testing spawn");
        // create a BartSimpsonUnit and call its spawn method
        BartSimpsonUnit bart = new BartSimpsonUnit();
        // bart should be able to spawn
        assertTrue(bart.canSpawn());
        // bart spawns
        BartSimpsonUnit lilBart = bart.spawn();
        // Number of times piece has spawned should be increased
        assertEquals(1, bart.getNumTimesSpawned());
        // Now that max time number of spawns reached - it
        // shouldn't be able to spawn anymore
        assertFalse(bart.canSpawn());
        // lilBart should be able to spawn
        assertTrue(lilBart.canSpawn());
    }

}
