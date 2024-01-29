import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lab1E {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Input
        int n = Integer.parseInt(reader.readLine());
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        // Output
        int result = minCoinsNeeded(n, a, b, c);
        System.out.println(result);
    }

    public static int minCoinsNeeded(int n, int a, int b, int c) {

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = n;
        }

        for (int i = 1; i <= n; i++) {
            // Update using copper coins
            if (i >= 1) {
                arr[i] = Math.min(arr[i], arr[i - 1] + 1);
            }

            // Update using silver coins
            if (i >= a) {
                arr[i] = Math.min(arr[i], arr[i - a] + 1);
            }

            // Update using gold coins
            if (i >= b) {
                arr[i] = Math.min(arr[i], arr[i - b] + 1);
            }

            // Update using platinum coins
            if (i >= c) {
                arr[i] = Math.min(arr[i], arr[i - c] + 1);
            }
        }

        return arr[n];
    }
}
