import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 대소문자 바꾸기
 * @see <a href="https://www.acmicpc.net/problem/2744">백준 대소문자 바꾸기</a>
 */
public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String result = solution(reader);
            System.out.println(result);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String solution(BufferedReader reader) throws IOException {
        String word = reader.readLine();
        char[] chars = word.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            char changedChar;
            if (Character.isLowerCase(aChar)) {
                changedChar = Character.toUpperCase(aChar);
            } else {
                changedChar = Character.toLowerCase(aChar);
            }
            stringBuilder.append(changedChar);
        }
        return stringBuilder.toString();
    }
}
