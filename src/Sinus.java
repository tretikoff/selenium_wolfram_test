package src;

public class Sinus {
    public static double sin(double v) {
    double result = 0;
    for (int n = 0; n < 19; n++) {
        result += Math.pow(-1, n) * Math.pow(v, 2*n+1) / factorial(2*n+1);
    }
    return result;
}

    private static double factorial(int i) {
        double result = 1;
        for (int j = 2; j <= i; j++) {
            result *= j;
        }
        return result;
    }

}
