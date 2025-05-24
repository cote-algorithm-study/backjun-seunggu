import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int first = array[0];
            int second = array[1];
            Map<String, Boolean> map = new HashMap<>();
            for (int i = 0; i < first; i++) {
                String str = br.readLine();
                map.put(str, true);
            }
            int count = 0;
            for (int i = 0; i < second; i++) {
                if (map.containsKey(br.readLine())) {
                    count++;
                }
            }
            System.out.printf("%d", count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
