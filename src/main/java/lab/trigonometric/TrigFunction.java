package lab.trigonometric;

import lab.AbstractFunction;
import lab.Functions;

import static java.lang.Double.NaN;
import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class TrigFunction extends AbstractFunction {
    private Cosinus cosinus;
    private Secant secant;
    private Tangent tangent;
    private Cotangent cotangent;
    private Cosecant cosecant;

    {
        table.put(0.01, 1010000.0);
        table.put(-0.01, -9.90001e5);
        table.put(0.0, NaN);
        table.put(PI, NaN);
        table.put(2*PI, NaN);
        table.put(-PI, NaN);
        table.put(-2 * PI, NaN);
//
//        table.put(1.01, 0.9898052287352547);
//        table.put(1.0, 1.0514533523222378);
//        table.put(0.99, 1.1170816671751458);
//
//        table.put(1.570900018 + 0.01, 2.001475909139914e-4);
//        table.put(1.570900018, 0.0);
//        table.put(1.570900018 - 0.01, 1.9888998093426087e-4);
//
//        table.put(-17.278800 + 0.01, 2.001475909139914e-4);
//        table.put(-17.278800, 0.0);
//        table.put(-17.278800 - 0.01, 1.9888998093426087e-4);
//
//        table.put(-2.19038087 + 0.01, 0.11978582280904848);
//        table.put(-2.19038087, 0.12017868464179626);
//        table.put(-2.19038087 - 0.01, 0.11982030530484743);
//
//        table.put(-2.31976664 + 0.01, 0.022961039961962967);
//        table.put(-2.31976664, -2.6625611618416215E-4);
//        table.put(-2.31976664 - 0.01, -0.02735194917552614);
//
//        table.put(-4.713001 + 0.01, 1.7714445555187369E-4);
//        table.put(-4.713001, 0.0);
//        table.put(-4.713001 - 0.01, 2.2436897140541053E-4);
//
//        table.put(-PI - 0.01, 1.0035656447616072E10);
//        table.put(-PI, NaN);
//        table.put(-PI + 0.01, -9.836662592201763E9);

        function = Functions.TRIG_FN;
    }

    public TrigFunction(double precision) {
        super(precision);
        cosinus = new Cosinus(precision);
        secant = new Secant(precision);
        tangent = new Tangent(precision);
        cotangent = new Cotangent(precision);
        cosecant = new Cosecant(precision);
    }

    @Override
    public void setPrecision(double precision) {
        super.setPrecision(precision);
    }

    @Override
    public double calculate(double arg) {
        double cos = cosinus.calculate(arg);
        double sec = secant.calculate(arg);
        double tan = tangent.calculate(arg);
        double cot = cotangent.calculate(arg);
        double csc = cosecant.calculate(arg);

        return (((((cos + csc) * sec) / csc) * (cos * csc)) / (tan / cot) * cos);
//        double divisor = (tan / (sec + tan));
//        if (Math.abs(divisor) < DELTA) {
//            return NaN;
//        }
    }

    @Override
    protected double calculateStub(double x) {
        double cos = cosinus.calculateStub(x);
        double sec = secant.calculateStub(x);
        double tan = tangent.calculateStub(x);
        double cot = cotangent.calculateStub(x);
        double csc = cosecant.calculateStub(x);
        return (((((cos + csc) * sec) / csc) * (cos * csc)) / (tan / cot) * cos);
    }
}