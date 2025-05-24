import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, T, K, a, b;
    static char[][] board;

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            board = new char[N][M];
            for (int i = 0; i < N; i++) {
                board[i] = br.readLine().toCharArray();
            }

            while (T-- > 0) {
                board = nextState(board);
            }

            // 출력
            StringBuilder sb = new StringBuilder();
            for (char[] row : board) {
                sb.append(row).append("\n");
            }
            System.out.print(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static char[][] nextState(char[][] current) {
        char[][] next = new char[N][M];
        int[][] prefixSum = computePrefixSum(current);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int cnt = countNeighbors(prefixSum, i, j);

                if (current[i][j] == '*') {
                    next[i][j] = (cnt >= a && cnt <= b) ? '*' : '.';
                } else {
                    next[i][j] = (cnt > a && cnt <= b) ? '*' : '.';
                }
            }
        }
        return next;
    }

    static int countNeighbors(int[][] prefixSum, int x, int y) {
        int x1 = Math.max(0, x - K);
        int y1 = Math.max(0, y - K);
        int x2 = Math.min(N - 1, x + K);
        int y2 = Math.min(M - 1, y + K);

        int total = prefixSum[x2 + 1][y2 + 1];
        if (x1 > 0) total -= prefixSum[x1][y2 + 1];
        if (y1 > 0) total -= prefixSum[x2 + 1][y1];
        if (x1 > 0 && y1 > 0) total += prefixSum[x1][y1];

        // Exclude the current cell if it is within bounds
        if (board[x][y] == '*') total--;

        return total;
    }

    static int[][] computePrefixSum(char[][] board) {
        int[][] prefixSum = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                prefixSum[i][j] = (board[i - 1][j - 1] == '*' ? 1 : 0)
                    + prefixSum[i - 1][j]
                    + prefixSum[i][j - 1]
                    - prefixSum[i - 1][j - 1];
            }
        }
        return prefixSum;
    }
}
