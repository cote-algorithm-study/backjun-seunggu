import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String answer = solution(reader);
            System.out.printf("%s", answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String solution(BufferedReader reader) throws IOException {
        int[] widthHeightArray = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] nowPosition = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = Integer.parseInt(reader.readLine());
        int x = nowPosition[0];
        int y = nowPosition[1];
        int w = widthHeightArray[0];
        int h = widthHeightArray[1];
        int nx = w - Math.abs(w - (x + count) % (2 * w));
        int ny = h - Math.abs(h - (y + count) % (2 * h));
        return nx + " " + ny;
    }

}