import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lab1C {
    public static int a;
    public static int b;
    public static int c;
    public static double [] memory;
    public static double coinChange(int x){
        if(x < 0)
            return Double.POSITIVE_INFINITY;
        else if (memory[x] != -1)
            return memory[x];
        else if(x == 0)
            return 0;
        else{
            double tempA = Math.min(x, 1 + coinChange(x - a));
            double tempB = Math.min(1 + coinChange(x - b), 1 + coinChange(x - c));
            double minChoice = Math.min(tempA, tempB);
            memory[x] = minChoice;
            return minChoice;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        a = Integer.parseInt(reader.readLine());
        b = Integer.parseInt(reader.readLine());
        c = Integer.parseInt(reader.readLine());

        memory = new double[n+1];
        for(int i = 0; i <= n; i++){
            memory[i] = -1;
        };
        // Output
        double result = coinChange(n);
        System.out.println(Math.round(result));

    }
}