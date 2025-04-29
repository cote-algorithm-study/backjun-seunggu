import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            char[] arr = new char[n];
            Arrays.fill(arr, '?');
            System.out.println(getAnswer(arr, n, k, br));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getAnswer(char[] arr, int n, int k, BufferedReader br) throws IOException {
        boolean[] used = new boolean[26];
        int index = 0;

        for (int i = 0; i < k; i++) {
            String[] line = br.readLine().split(" ");
            int move = Integer.parseInt(line[0]);
            char letter = line[1].charAt(0);

            index = (index + move) % n;

            if (arr[index] == '?') {
                if (used[letter - 'A']) {
                    return "!";
                }
                arr[index] = letter;
                used[letter - 'A'] = true;
            } else {
                if (arr[index] != letter) {
                    return "!";
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[index]);
            index = (index - 1 + n) % n;
        }

        return sb.toString();
    }
}
