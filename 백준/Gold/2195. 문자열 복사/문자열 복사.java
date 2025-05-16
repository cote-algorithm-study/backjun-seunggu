import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문자열 복사 ( 골드 5 )
 */
public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String word = reader.readLine();
            String[] completeWord = reader.readLine().split("");
            StringBuilder temp = new StringBuilder();
            int answer = 0;
            for (String s : completeWord) {
                temp.append(s);
                if (!word.contains(temp)) {
                    answer++;
                    temp = new StringBuilder();
                    temp.append(s);
                }
            }
            System.out.println(answer + 1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
}
