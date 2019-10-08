package lab.logarithmic;

public class LogFunStub {
    public static Double log_10(Double x) {
        return x <= 0 ? Double.NaN : Math.log(x)/Math.log(2);
    }

    public static Double ln(Double x) {
        return x <= 0 ? Double.NaN : Math.log(x);
    }

    public static Double log_3(Double x) {
        return x <= 0 ? Double.NaN : Math.log(x)/Math.log(3);
    }
}