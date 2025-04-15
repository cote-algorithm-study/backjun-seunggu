import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int result = solution(reader);
            System.out.printf("%d", result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solution(BufferedReader reader) throws IOException {
        int[] widthHeight = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rowCount = widthHeight[0];
        int colCount = widthHeight[1];
        String[][] map = getCastle(reader, rowCount, colCount);
        int row = 0;
        row = getRowCount(rowCount, map, row);
        int col = getColCount(rowCount, colCount, map);
        int result = Math.max(row, col);
        return result;
    }

    private static String[][] getCastle(BufferedReader reader, int rowCount, int colCount) throws IOException {
        String[][] map = new String[rowCount][colCount];
        for(int i = 0; i < rowCount; i++) {
            String line = reader.readLine();
            map[i] = line.split("");
        }
        return map;
    }

    private static int getRowCount(int rowCount, String[][] map, int row) {
        for(int i = 0; i< rowCount; i++) {
            if(isContainsX(map[i])) {
                continue;
            }
            row++;
        }
        return row;
    }

    private static int getColCount(int rowCount, int colCount, String[][] map) {
        int col = 0;
        e: for(int i = 0; i< colCount; i++) {
            for(int j = 0; j< rowCount; j++) {
                if("X".equals(map[j][i])) {
                    continue e;
                }
            }
            col++;
        }
        return col;
    }

    private static boolean isContainsX(String[] map) {
        return Arrays.stream(map).anyMatch(s -> "X".equals(s));
    }

}
