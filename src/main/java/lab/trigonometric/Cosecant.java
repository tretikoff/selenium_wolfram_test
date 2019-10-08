package lab.trigonometric;

import lab.AbstractFunction;

import static java.lang.Double.NaN;
import static java.lang.Math.PI;


public class Cosecant extends AbstractFunction {
    {
        table.put(-PI, NaN);
        table.put(-2*PI, NaN);
        table.put(-3*PI, NaN);

        table.put(PI, NaN);
        table.put(2*PI, NaN);
        table.put(3*PI, NaN);
    }

    private Sinus sinus;

    Cosecant(double precision) {
        super(precision);
        sinus = new Sinus(precision);
    }

    @Override
    public void setPrecision(double precision) {
        super.setPrecision(precision);
        sinus.setPrecision(precision);
    }

    @Override
    protected double calculate(double arg) {
        double sin = sinus.calculate(arg);
        if (Math.abs(sin) < DELTA) {
            return NaN;
        }
        return 1 / sin;
    }

    @Override
    protected double calculateStub(double arg) {
        double sin = Math.sin(arg);
        if (Math.abs(sin) < DELTA) {
            return NaN;
        }
        return 1 / sin;
    }
}