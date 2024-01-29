import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class Lab1A {
    public static int a, b, c;
    public static double coinChange(int n){
        if(n < 0)
            return Double.POSITIVE_INFINITY;
        else if(n == 0)
            return 0;
        else{
            double tempA = Math.min(n, 1 + coinChange(n - a));
            double tempB = Math.min(1 + coinChange(n - b), 1 + coinChange(n - c));
            return Math.min(tempA, tempB);
        }

    }
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        a = Integer.parseInt(reader.readLine());
        b = Integer.parseInt(reader.readLine());
        c = Integer.parseInt(reader.readLine());

        double result = coinChange(n);
        System.out.println(Math.round(result));

    }
}