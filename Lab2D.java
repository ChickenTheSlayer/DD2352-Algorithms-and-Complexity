import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lab2D {
    public static double p;
    public static int k;
    public static double[] memory;

    public static double probability(int x) {
        if (memory[x] != -1)
            return memory[x];
        else if (x == k) {
            return Math.pow(p, k);
        } else if (x < k) {
            return 0;
        } else {
            double temp = probability(x - 1) + Math.pow(p, k) * (1 - p) * (1 - probability(x - k - 1));
            memory[x] = temp;
            return temp;
        }
    }

    public static void main(String[] args) throws IOException {
        p = 0.99;
        int maxN = 1000; // 改这个
        long startTime, endTime;

        for (int n = 1; n <= maxN; n+= 10) {
            k = n / 2;
            memory = new double[n + 1];
            for (int i = 0; i <= n; i++) {
                memory[i] = -1;
            }
            startTime = System.nanoTime();
            double result = probability(n);
            endTime = System.nanoTime();

            System.out.println("n = \t" + n + "\t Time = \t " + (endTime - startTime) );

            // Adjust the following condition based on your machine's performance
            if ((endTime - startTime) / 1000000.0 > 1000) {
                break;
            }
        }
    }
}
