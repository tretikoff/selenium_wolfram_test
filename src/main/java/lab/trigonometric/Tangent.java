package lab.trigonometric;

import lab.AbstractFunction;
import lab.Functions;
import lab.util.BigDecimalSqrt;
import lab.util.FactorialSeries;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.lang.Double.*;
import static java.lang.Math.PI;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


public class Tangent extends AbstractFunction {

    {
        table.put(-PI, 0.0);
        table.put(-PI / 2, NEGATIVE_INFINITY);
        table.put(0.0, 0.0);
        table.put(PI / 2, POSITIVE_INFINITY);
        table.put(PI, 0.0);

//        table.put(3 * PI / 4, -1.0000051536258532);
//        table.put(-3 * PI / 4, 1.0000051536258532);
        table.put(3 * PI / 4, -1.0);
        table.put(-3 * PI / 4, 1.0);
        table.put(PI / 4, 1.0);
        table.put(-PI / 4, -1.0);
        function = Functions.TANGENT;

        table.put(-PI * 1.5, NEGATIVE_INFINITY);
        table.put(-PI * 1.5 + PI / 16, -5.027339481844);
        table.put(-PI * 1.5 + 2 * PI / 16, -2.414214618296);
    }

    private Cosinus cosinus;
    private Sinus sinus;

    public Tangent(double precision) {
        super(precision);
        cosinus = new Cosinus(precision);
        sinus = new Sinus(precision);
    }

    @Override
    public void setPrecision(double precision) {
        super.setPrecision(precision);
        cosinus.setPrecision(precision);
        sinus.setPrecision(precision);
    }

    @Override
    protected double calculate(double arg) {
        double cos = cosinus.calculate(arg);
        double sin = sinus.calculate(arg);
        if (Math.abs(cos) < DELTA) {
            return NaN;
        }
        return sin / cos;
    }

    @Override
    protected double calculateStub(double arg) {
        return Math.tan(arg);
    }
}