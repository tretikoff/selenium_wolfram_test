package lab.trigonometric;

import lab.AbstractFunction;
import lab.Functions;

import static java.lang.Math.PI;


public class Secant extends AbstractFunction {
    {
//        table.put(-PI, -1.0000001352604628);
        table.put(-PI, -1.0);
        table.put(-PI / 2, Double.POSITIVE_INFINITY);
        table.put(0.0, 1.0);
        table.put(PI / 2, Double.POSITIVE_INFINITY);
//        table.put(PI, -1.0000001352604628);
        table.put(PI, -1.0);

        table.put(3 * PI / 4, -1.41421356375);
        table.put(-3 * PI / 4, -1.41421356375);
        table.put(PI / 4, 1.41421356375);
        table.put(-PI / 4, 1.41421356375);
        function = Functions.SECANT;
    }

    Cosinus cosinus;

    public Secant(double precision) {
        super(precision);
        cosinus = new Cosinus(precision);
    }

    @Override
    public void setPrecision(double precision) {
        super.setPrecision(precision);
        cosinus.setPrecision(precision);
    }

    @Override
    protected double calculate(double arg) {
        double cos = cosinus.calculate(arg);
        if (Math.abs(cos) < DELTA) {
            return cos > 0 ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
        }
        return 1 / cos;
    }

    @Override
    protected double calculateStub(double arg) {
        double cos = Math.cos(arg);
        if (Math.abs(cos) < DELTA) {
            return cos > 0 ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
        }
        return 1 / cos;
    }
}