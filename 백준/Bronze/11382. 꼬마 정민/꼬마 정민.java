import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            long[] array = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            System.out.println((array[0] + array[1] + array[2]));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
