import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(br.readLine());
            for (int i = 0; i < count; i++) {
                int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).filter(n -> n % 2 ==0).sorted().toArray();
                int min = array[0];
                int sum = IntStream.of(array).sum();
                System.out.println(sum + " " + min);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}