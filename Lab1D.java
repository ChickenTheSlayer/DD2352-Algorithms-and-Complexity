import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lab1D {
    public static int a, b, c;
    public static double[] memory;

    public static double coinChange(int x){
        if(x < 0)
            return Double.POSITIVE_INFINITY;
        else if(memory[x] != -1)
            return memory[x];
        else if(x == 0)
            return 0;
        else {
            double tempA = Math.min(x, 1 + coinChange(x - a));
            double tempB = Math.min(1 + coinChange(x - b), 1 + coinChange(x - c));
            double minChoice = Math.min(tempA, tempB);
            memory[x] = minChoice;
            return minChoice;
        }
    }

    public static void main(String[] args) {
        a = 5;
        b = 6;
        c = 7;

        for (int n = 1; true; n++) { // Incrementing n
            memory = new double[n+1];
            for (int i = 0; i <= n; i++) {
                memory[i] = -1;
            }

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