package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src.Sinus;

import java.util.HashMap;

public class SinusTest extends Assert {
    /*
     *   Hash Maps: key - input, value - result.
     */
    private HashMap<Double, Double> trueValues = new HashMap<>();
    private HashMap<Double, Double> falseValues = new HashMap<>();
    private static final double DELTA = 0.001;

    private void insertIntoTrueTree(double v){
        /*
         *   Inserts pair of positive and negative values.
         */
        trueValues.put(v, Math.sin(v));
        trueValues.put(-v, Math.sin(-v));
    }

    @Before
    public void setUp() {
        /*
         *   Values inside of [-PI,PI].
         */
        for (double i = Math.PI; i > Math.PI / 6; i -= Math.PI / 6){
            insertIntoTrueTree(i);
        }

        insertIntoTrueTree(3*Math.PI / 4);
        insertIntoTrueTree(Math.PI / 4);
        trueValues.put(0.0, Math.sin(0.0));

        /*
         *   Values outside of [-PI,PI].
         */
        insertIntoTrueTree(4*Math.PI);
        insertIntoTrueTree(2*Math.PI);

        /*
         *   Special values.
         */
        trueValues.put(Double.NaN, Double.NaN);
        trueValues.put(Double.POSITIVE_INFINITY, Double.NaN);
        trueValues.put(Double.NEGATIVE_INFINITY, Double.NaN);

        /*
         *   Values that should fail.
         */
        falseValues.put(0.0, 1.0);
        falseValues.put(Math.PI, 2.0);
    }

    @After
    public void tearDown() {
        trueValues.clear();
        falseValues.clear();
    }

    @Test
    public void doTest() {
        for (Double key : trueValues.keySet()) {
            assertEquals(assertMessage(trueValues.get(key), Sinus.sin(key), DELTA, true),
                    trueValues.get(key),
                    Sinus.sin(key),
                    DELTA);
        }

        for (Double key : falseValues.keySet()) {
            assertTrue(assertMessage(falseValues.get(key), Sinus.sin(key), DELTA, false),
                    Math.abs(Sinus.sin(key) - falseValues.get(key)) > DELTA);
        }
    }

    private String assertMessage(double expected, double actual, double delta, boolean equal){
        return "Expected: "+expected+" is assumed to be "+(equal ? "" : "not ")+"equal to Actual: "+actual+" with Delta: "+delta;
    }
}
