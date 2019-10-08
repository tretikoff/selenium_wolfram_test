package lab.trigonometric;

import lab.AbstractFunction;
import lab.Functions;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.lang.Double.isInfinite;
import static java.lang.Double.isNaN;
import static java.lang.Float.NaN;
import static java.lang.Math.PI;


public class Cotangent extends AbstractFunction {
    {
        table.put(-PI, Double.POSITIVE_INFINITY);
        table.put(-PI / 2, 0.0);
        table.put(0.0, Double.POSITIVE_INFINITY);
        table.put(PI / 2, 0.0);
        table.put(PI, Double.POSITIVE_INFINITY);

        table.put(3 * PI / 4, -1.0);
        table.put(-3 * PI / 4, 1.0);
        table.put(PI / 4, 1.0);
        table.put(-PI / 4, -1.0);
        function = Functions.COTANGENT;
    }

    private Tangent tangent;

    public Cotangent(double precision) {
        super(precision);
        tangent = new Tangent(precision);
    }

    @Override
    public void setPrecision(double precision) {
        super.setPrecision(precision);
        tangent.setPrecision(precision);
    }

    @Override
    protected double calculate(double arg) {
        double tan = tangent.calculate(arg);
        if (Math.abs(tan) < DELTA) {
            return tan > 0 ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
        }
        return 1 / tan;
    }

    @Override
    protected double calculateStub(double arg) {
        double tan = Math.tan(arg);
        if (Math.abs(tan) < DELTA) {
            return tan > 0 ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
        }
        return 1 / tan;
    }
}