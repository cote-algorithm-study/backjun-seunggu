import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int answer = solution(br);
            System.out.printf("%d\n", answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solution(BufferedReader br) throws IOException {
        int count = Integer.parseInt(br.readLine());
        int[][] arr = new int[count][2];
        for (int i = 0; i < count; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        sortMeeting(arr);

        int answer = 0;
        int end = 0;
        for (int[] meeting : arr) {
            if (end <= meeting[0]) {
                end = meeting[1];
                answer++;
            }
        }
        return answer;
    }

    private static void sortMeeting(int[][] arr) {
        Arrays.sort(arr, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
    }

}
