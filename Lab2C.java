import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lab2C {
    public static double p;
    public static int k;
    public static double [] memory;
    public static double probability(int x){
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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Input
        int n = Integer.parseInt(reader.readLine());
        k = Integer.parseInt(reader.readLine());
        p = Double.parseDouble(reader.readLine());

        memory = new double[n+1];
        for(int i = 0; i <= n; i++){
                memory[i] = -1;
        }
        double result = probability(n);
        System.out.println(result);

    }
}