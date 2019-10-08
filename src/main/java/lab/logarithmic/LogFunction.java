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
        table.put(0.01, 13415.174712659141193380552762282820809173835833788105);
        table.put(0.99, 0.000000000000161045);
        table.put(1.01, 1.51666137239966e-13);
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
        ln.setPrecision(precision);
        log3.setPrecision(precision);
        log10.setPrecision(precision);
    }

    @Override
    public double calculate(double arg) {
        return pow(((pow(log10.calc(arg), 3) - log10.calc(arg)) * ln.calc(arg)) * log3.calc(arg), 2);
    }

    @Override
    protected double calculateStub(double x) {
        return Math.pow((((Math.pow(Math.log10(x), 3) - Math.log10(x)) * Math.log(x)) * StubLog3(x)), 2);
    }

    private Double StubLog3(double a) {
        return Math.log(a) / Math.log(3);
    }
}