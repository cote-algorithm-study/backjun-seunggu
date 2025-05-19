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

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int cnt = countNeighbors(current, i, j);

                if (current[i][j] == '*') {
                    next[i][j] = (cnt >= a && cnt <= b) ? '*' : '.';
                } else {
                    next[i][j] = (cnt > a && cnt <= b) ? '*' : '.';
                }
            }
        }
        return next;
    }

    static int countNeighbors(char[][] board, int x, int y) {
        int count = 0;
        for (int dx = -K; dx <= K; dx++) {
            for (int dy = -K; dy <= K; dy++) {
                if (dx == 0 && dy == 0)
                    continue; // 자기 자신 제외
                int nx = x + dx;
                int ny = y + dy;

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (board[nx][ny] == '*')
                        count++;
                }
            }
        }
        return count;
    }

}
