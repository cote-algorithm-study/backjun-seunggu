import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String sb = solution(br);
            System.out.println(sb);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String solution(BufferedReader br) throws IOException {
        int count = Integer.parseInt(br.readLine());
        Map<String, String> map = new HashMap<>();
        for(int i=0; i<count; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            String status = input[1];
            if("enter".equals(status)) {
                map.put(name, status);
            } else {
                map.remove(name);
            }
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String name : list) {
            sb.append(name).append("\n");
        }
        return sb.toString();
    }

}
