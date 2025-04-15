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
        int width = widthHeight[0];
        int height = widthHeight[1];
        String[][] map = getCastle(reader, width, height);
        int row = 0;
        row = getRowCount(width, map, row);
        int col = getColCount(width, height, map);
        int result = Math.max(row, col);
        return result;
    }

    private static String[][] getCastle(BufferedReader reader, int width, int height) throws IOException {
        String[][] map = new String[width][height];
        for(int i = 0; i < width; i++) {
            String line = reader.readLine();
            map[i] = line.split("");
        }
        return map;
    }

    private static int getRowCount(int width, String[][] map, int row) {
        for(int i = 0; i< width; i++) {
            if(isContainsX(map[i])) {
                continue;
            }
            row++;
        }
        return row;
    }

    private static int getColCount(int width, int height, String[][] map) {
        int col = 0;
        e: for(int i = 0; i< height; i++) {
            for(int j = 0; j< width; j++) {
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
