import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(br.readLine());
            StringBuilder builder = new StringBuilder();
            for(int i=0; i<count; i++) {
                builder.append(solution(br)).append("\n");
            }
            System.out.println(builder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solution(BufferedReader br) throws IOException {
        int[] guests = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int floor = guests[0];
        int guest = guests[2];
        if (guest % floor == 0) {
            return (floor * 100) + (guest / floor);
        }
        return (guest % floor * 100) + (guest / floor + 1);
    }
}
