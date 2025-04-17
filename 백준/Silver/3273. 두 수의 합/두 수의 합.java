import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int result = solution(reader);
            System.out.printf("%d", result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solution(BufferedReader reader) throws IOException {
        int count = Integer.parseInt(reader.readLine());
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(reader.readLine());
        int result = 0;
        for(int i=0; i < arr.length -1; i++) {
            for(int j= i+1; j < arr.length; j++) {
                if(arr[i] + arr[j] ==  target){
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
