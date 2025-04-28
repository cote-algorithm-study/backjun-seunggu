import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            String[][][] arr = new String[n][n][4];
            char[] directions = br.readLine().toCharArray();

            int x = 0;
            int y = 0;

            for (char dirChar : directions) {
                Direction dir = Direction.getDirection(String.valueOf(dirChar));
                if (dir == null) continue; // 잘못된 입력 방어

                int nx = x + dir.getDxy()[0];
                int ny = y + dir.getDxy()[1];

                // 범위 밖으로 나가면 이동하지 않음
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                recordDirection(dirChar, arr, x, y, dir, nx, ny);

                x = nx;
                y = ny;
            }
            printResult(n, arr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void recordDirection(char dirChar, String[][][] arr, int x, int y, Direction dir, int nx, int ny) {
        arr[x][y][dir.getNum()] = String.valueOf(dirChar);

        Direction opposite = dir.getOpposite();
        arr[nx][ny][opposite.getNum()] = opposite.name();
    }

    private static void printResult(int n, String[][][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean vertical = (arr[i][j][0] != null || arr[i][j][2] != null); // U or D
                boolean horizontal = (arr[i][j][1] != null || arr[i][j][3] != null); // R or L
                System.out.print(getString(vertical, horizontal));
            }
            System.out.println();
        }
    }

    private static String getString(boolean vertical, boolean horizontal) {
        if (vertical && horizontal) {
            return "+";
        }
        if (vertical) {
            return "|";
        }
        if (horizontal) {
            return "-";
        }
        return ".";
    }

    private enum Direction {
        U(0, new int[]{-1, 0}),
        R(1, new int[]{0, 1}),
        D(2, new int[]{1, 0}),
        L(3, new int[]{0, -1});

        private final int num;
        private final int[] dxy;

        Direction(int num, int[] dxy) {
            this.num = num;
            this.dxy = dxy;
        }

        public int getNum() {
            return this.num;
        }

        public int[] getDxy() {
            return this.dxy;
        }

        public static Direction getDirection(String name) {
            if (name == null || name.isEmpty()) return null;
            for (Direction dir : values()) {
                if (dir.name().equals(name)) {
                    return dir;
                }
            }
            return null;
        }

        public Direction getOpposite() {
            switch (this) {
                case U: return D;
                case D: return U;
                case L: return R;
                case R: return L;
            }
            return null;
        }
    }
}