package test;

import javafx.stage.Screen;
import org.junit.Test;
import src.Person;
import src.Spaceship;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*
 * Форд похлопал Зафода по плечу и показал на задний экран.
 * На нем было отчетливо видно, как вслед кораблю движутся сквозь атмосферу две серебристые стрелы.
 * Увеличение показало две массивные ракеты.
 * Это потрясло их своей неожиданностью.
 */

public class DomenModelTest {
    private Person FirstPerson = new Person();
    private Person SecondPerson = new Person();
    private Person ThirdPerson = new Person();
    private Person FourthPerson = new Person();


    private Spaceship Spacesheep;

    @Test
    public void doTest() {

        Person[] crew = new Person[]{FirstPerson, SecondPerson, ThirdPerson, FourthPerson};
        Spacesheep = new Spaceship(crew, Spaceship.Engine.PHOTONIC);
//        Ford.clapShoulderOf(Zafod);
//        assertEquals(States.CLAPPING, Ford.getState());
//        assertEquals(States.CLAPPED, Zafod.getState());
//
//        screen = Ford.pointToBackScreen();
//        seenObjects = screen.getSeenObjects();
//
//        assertEquals(2, seenObjects.length);
//
//        for (SeenObject seenObject : seenObjects ){
//            assertTrue(seenObject.isSeenClearly());
//            assertTrue(seenObject.isGoingAfterShipThroughAtmosphere());
//            assertEquals(Colours.SILVER, seenObject.getColour());
//            assertEquals(Types.ARROW, seenObject.getType());
//        }
//
//        for (int i = 0; i < seenObjects.length; i++)
//            assertEquals(screen.zoomIn(i).getType(), Types.MASSIVE_ROCKET);
//
//        Ford.becomeShocked();
//        Zafod.becomeShocked();
//
//        assertEquals(States.SHOCKED, Ford.getState());
//        assertEquals(States.SHOCKED, Zafod.getState());
    }
}
