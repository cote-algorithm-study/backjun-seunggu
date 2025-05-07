
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int answer = 0;
            int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int number : array) {
                answer += (number * number);
            }
            answer %= 10;
            System.out.println(answer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
