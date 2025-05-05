import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            br.readLine();
            String result = solution(br);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String solution(BufferedReader br) throws IOException {
        List<Integer> arr =
            Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        List<Integer> distinctArr = arr.stream().distinct().sorted().collect(Collectors.toList());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < distinctArr.size(); i++) {
            map.put(distinctArr.get(i), i);
        }
        StringBuilder builder = new StringBuilder();
        for (int num : arr) {
            builder.append(map.get(num)).append(" ");
        }
        return builder.toString();
    }

}
