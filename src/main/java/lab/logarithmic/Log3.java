package lab.logarithmic;

import lab.Functions;


public class Log3 extends LogN {
    public static final int BASE = 3;

    {
        table.put(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
//        table.put(2.0 - 0.01, 0.992768);
//        table.put(2.0, 1.0);
//        table.put(2.0 + 0.01, 1.00720);
//
//        table.put(0.0 - 0.01, Double.NaN);
//        table.put(0.0, Double.NEGATIVE_INFINITY);
//        table.put(0.0 + 0.01, -6.632979274557514);
//
//        table.put(1.0 - 0.01, -0.0144996);
//        table.put(1.0, 0.0);
//        table.put(1.0 + 0.01, 0.0143553);
        function = Functions.LOG_3;
    }

    public Log3(double precision) {
        super(precision);
    }

    @Override
    protected double calculate(double arg) {
        return log(arg, BASE);
    }

    @Override
    protected double calculateStub(double arg) {
        return Math.log(arg) / Math.log(3);
    }
}