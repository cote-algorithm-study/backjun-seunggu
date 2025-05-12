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
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int q = Integer.parseInt(inputs[1]);

        int[] prefixXor = memoriesQuery(br, n);

        int result = 0;
        for (int i = 0; i < q; i++) {
            String[] query = br.readLine().split(" ");
            int s = Integer.parseInt(query[0]);
            int e = Integer.parseInt(query[1]);
            int rangeXor = prefixXor[e] ^ prefixXor[s - 1];
            result ^= rangeXor;
        }

        return result;
    }

    private static int[] memoriesQuery(BufferedReader br, int n) throws IOException {
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 누적 XOR 배열 생성 (0-based)
        int[] prefixXor = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ array[i - 1];
        }
        return prefixXor;
    }

}