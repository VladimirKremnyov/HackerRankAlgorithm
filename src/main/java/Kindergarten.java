import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Kindergarten {

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        Scanner scn = new Scanner(System.in);
        int n;
        n = scn.nextInt();
        int[] dp = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            int x = scn.nextInt();
            if (x < n) {
                int start = (i + 1) % n;//possible start
                int end = (start - x + n) % n;//possible end
                dp[start] = dp[start] + 1;
                dp[end] = dp[end] - 1;
                if (end <= start) {
                    count++;
                }
            }
        }
        int index = 0;
        int val = 0;
        for (int i = 0; i < n; i++) {
            count += dp[i];
            if (count > val) {
                val = count;
                index = i;
            }
        }
        int id = index + 1;

        bufferedWriter.write(String.valueOf(id));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }

}
