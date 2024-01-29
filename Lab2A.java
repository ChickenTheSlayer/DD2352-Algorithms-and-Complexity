import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lab2A {
    public static int NofGames;
    public static double p;
    public static double[][] memory;

    public static double probability(int x, int y) {
        if (memory[x][y] != -1) {
            return memory[x][y];
        } else if (x == 0 && y > 0) {
            return 0.0;
        } else if (y == 0) {
            return 1.0;
        } else {
            double temp = p * probability(x - 1, y - 1) + (1 - p) * probability(x - 1, NofGames);
            memory[x][y] = temp;
            return temp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Input
        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());
        p = Double.parseDouble(reader.readLine());
        NofGames = k;
        memory = new double[n + 1][k + 1];

        // Initialize memory array
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                memory[i][j] = -1;
            }
        }
        double result = probability(n, k);
        System.out.println(result);
    }
}