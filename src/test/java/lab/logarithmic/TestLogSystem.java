package lab.logarithmic;

import lab.TestUtil;
import lab.util.CSVWriter;
import org.junit.Before;
import org.junit.Test;

import static lab.AbstractFunction.DELTA;

public class TestLogSystem {
    private double precision = DELTA;
    private LogFunction function = new LogFunction(precision);
    private TestUtil util = new TestUtil(function);
    private CSVWriter writer = new CSVWriter(function);

    @Before
    public void setUp() {
        Ln ln = new Ln(DELTA);
        ln.setFuncIsStub(false);
        Log3 log3 = new Log3(DELTA);
        log3.setFuncIsStub(false);
        Log10 log10 = new Log10(DELTA);
        log10.setFuncIsStub(false);
        function.setPrecision(0.01);
    }

    @Test
    public void TestFunction() {
        util.checkRange(0.5, 15, 0.5);
        writer.write(0.5, 15, 0.5);
    }
}