import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int answer = solution(reader);
            System.out.printf("%d", answer);
        } catch (IOException e) {

        }
    }

    private static int solution(BufferedReader reader) throws IOException {
        String firstWord = reader.readLine();
        String secondWord = reader.readLine();
        int[] firstWordCount = new int[26];
        int[] secondWordCount = new int[26];
        for (char c : firstWord.toCharArray()) {
            firstWordCount[c - 'a']++;
        }
        for (char c : secondWord.toCharArray()) {
            secondWordCount[c - 'a']++;
        }
        int count = 0;
        for(int i = 0; i < 26; i++) {
            count += Math.abs(firstWordCount[i] - secondWordCount[i]);
        }
        return count;
    }


}
