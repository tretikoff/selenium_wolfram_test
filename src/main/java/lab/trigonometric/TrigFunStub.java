package lab.trigonometric;

public class TrigFunStub {
    public static Double sin(Double x) {
        return Math.sin(x);
    }

    public static Double cos(Double x) {
        return Math.cos(x);
    }

    public static Double tan(Double x) {
        return Math.tan(x);
    }

    public static Double cot(Double x) {
        return Math.cos(x) / Math.sin(x);
    }

    public static Double sec(Double x) {
        return 1 / Math.cos(x);
    }

    public static Double csc(Double x) {
        return 1 / Math.sin(x);
    }
}