package lab.trigonometric;

import lab.AbstractFunction;
import lab.Functions;
import lab.util.FactorialSeries;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.lang.Double.*;
import static java.lang.Math.PI;


public class Sinus extends AbstractFunction{

    {
        function = Functions.SINUS;
    }

    Sinus(double precision) {
        super(precision);
    }

    private Double CalibrateX(Double x) {
        double del = Math.PI * 2;
        if (x < 0)
            del *= -1;
        while (Math.abs(x) > 30.0) {
            x -= del;
        }
        return x;
    }

    @Override
    protected double calculate(double arg) {
        if (isNaN(arg) || isInfinite(arg)) {
            return NaN;
        }

        double x = CalibrateX(arg);
        double xn = x;
        double prevSum = 0.0;
        double sum = x;
        final double EPS = 1e-10, INF = 1.0e8;

        for (int n = 1; Math.abs(Math.abs(sum) - Math.abs(prevSum)) > EPS; n++) {
            prevSum = sum;
            xn *= (-x * x) / ((2 * n + 1) * 2 * n);
            sum += xn;
        }
        return Math.abs(sum) > INF ? INF : sum;
    }

    @Override
    protected double calculateStub(double arg) {
        return Math.cos(arg);
    }
}