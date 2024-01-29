import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lab1B {
    public static int a, b, c;

    public static double coinChange(int n){
        if(n < 0)
            return Double.POSITIVE_INFINITY;
        else if(n == 0)
            return 0;
        else {
            double tempA = Math.min(n, 1 + coinChange(n - a));
            double tempB = Math.min(1 + coinChange(n - b), 1 + coinChange(n - c));
            return Math.min(tempA, tempB);
        }
    }

    public static void main(String[] args) {
        a = 5;
        b = 6;
        c = 7;

        for (int n = 1; true; n++) { // Incrementing n
            long startTime = System.currentTimeMillis();
            double result = coinChange(n);
            long endTime = System.currentTimeMillis();

            long duration = endTime - startTime;
            System.out.println("n = " + n + ", Time taken: " + duration + " ms");

            if (duration > 1000) { // Break the loop if time exceeds 1 second
                break;
            }
        }
    }
}