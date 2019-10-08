package lab.trigonometric;

import lab.TestUtil;
import lab.util.CSVWriter;
import org.junit.Before;
import org.junit.Test;

import static java.lang.Math.PI;
import static lab.AbstractFunction.DELTA;

public class TestTrigSystem {
    private double precision = DELTA;
    private TrigFunction function = new TrigFunction(precision);
    private TestUtil util = new TestUtil(function);
    private CSVWriter writer = new CSVWriter(function);

    @Before
    public void setUp() throws Exception {
        Cosinus cos = new Cosinus(precision);
        cos.setFuncIsStub(false);
        Secant sec = new Secant(precision);
        sec.setFuncIsStub(false);
        Tangent tan = new Tangent(precision);
        tan.setFuncIsStub(false);
        Cotangent cot = new Cotangent(precision);
        cot.setFuncIsStub(false);
        function.setPrecision(0.4);
    }

    @Test
    public void TestFunction() {
        util.checkRange(-2 * PI, 2 * PI, PI / 48);
        writer.write(-2 * PI, 2 * PI, PI / 48);
    }
}