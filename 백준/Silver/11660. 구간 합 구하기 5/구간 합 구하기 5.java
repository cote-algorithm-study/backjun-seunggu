import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]); // 배열 크기
            int m = Integer.parseInt(input[1]); // 쿼리 수

            int[][] arr = new int[n + 1][n + 1];
            int[][] dp = new int[n + 1][n + 1];

            // 배열 입력
            for (int i = 1; i <= n; i++) {
                int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = row[j - 1];
                }
            }

            // dp 배열 초기화 (2차원 누적합)
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = arr[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
                }
            }

            // 쿼리 처리
            StringBuilder sb = new StringBuilder();
            for (int q = 0; q < m; q++) {
                String[] range = br.readLine().split(" ");
                int x1 = Integer.parseInt(range[0]);
                int y1 = Integer.parseInt(range[1]);
                int x2 = Integer.parseInt(range[2]);
                int y2 = Integer.parseInt(range[3]);

                int result = dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1];
                sb.append(result).append("\n");
            }

            System.out.print(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}