package lab.logarithmic;

import lab.AbstractFunction;
import lab.Functions;

import static java.lang.Math.pow;


public class LogFunction extends AbstractFunction {
    private double precision;
    Ln ln;
    Log3 log3;
    Log10 log10;

    {
        table.put(0.01, 13162.313221);
        table.put(0.99, 0.000000000000161045);
        table.put(1.01, 1.51666137239966e-13);
        table.put(5.0, 0.7104214239689);
        table.put(10.0, 0.0);
        table.put(15.0, 9.0500252167076474149);

        function = Functions.LOG_FN;
    }

    public LogFunction(double precision) {
        super(precision);
        this.precision = precision;
        ln = new Ln(precision);
        log3 = new Log3(precision);
        log10 = new Log10(precision);
    }

    @Override
    public void setPrecision(double precision) {
        super.setPrecision(precision);
    }

    @Override
    public double calculate(double arg) {
        return pow(((pow(log10.calc(arg), 3) - log10.calc(arg)) * ln.calc(arg)) * log3.calc(arg), 2);
    }

    @Override
    protected double calculateStub(double x) {
        return Math.pow((((Math.pow(Math.log10(x), 3) - Math.log10(x)) * Math.log(x)) * log3.calculateStub(x)), 2);
    }
}