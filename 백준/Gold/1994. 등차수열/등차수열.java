import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 등차수열 (플래티넘5)
 */
public class Main {

    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(solution(reader));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solution(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int[] array = getArray(reader, n);
        int[][] dp = new int[2001][2001];
        int maxLength = findLongestApLength(n,array, dp);
        return maxLength;
    }

    private static int[] getArray(BufferedReader reader, int n) throws IOException {
        int[] array = new int[2001];
        for (int i = 0; i < n; i++) array[i + 1] = Integer.parseInt(reader.readLine());
        Arrays.sort(array, 1, n + 1);
        return array;
    }

    private static int findLongestApLength(int n, int[] array, int[][]dp) {
        int max = 1;
        for (int i = 1; i <= n; i++)
            for (int j = i + 1; j <= n; j++)
                max = Math.max(max, dp(dp, array, i, j, n));
        return max;
    }

    private static int dp(int[][] dp, int[] array, int i, int j, int n) {
        if (i > j) return 0;
        else if (i == j) return 1;

        int result = dp[i][j];
        if (result != 0) return result;

        int target = 2 * array[j] - array[i];
        int index = findIndex(array, target, j + 1, n);

        if (index == -1) return dp[i][j] = 2;
        else return dp[i][j] = dp(dp, array, j, index, n) + 1;
    }

    private static int findIndex(int[] array, int target, int start, int n) {
        int left = start, right = n, mid = (left + right) / 2;
        while (left < right) {
            mid = (left + right) / 2;
            if (array[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        if (left <= n && array[left] == target) return left;
        if (array[mid] == target) return mid;
        return -1;
    }

}
