import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String result = solution(reader);
            System.out.printf("%s", result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String solution(BufferedReader reader) throws IOException {
        int testCaseCount = Integer.parseInt(reader.readLine());
        int[][] arr = new int[testCaseCount][20];
        for(int i = 0; i < testCaseCount; i++) {
            String[] input = reader.readLine().split(" ");
            arr[i] = Arrays.stream(input).skip(1).mapToInt(Integer::parseInt).toArray();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<testCaseCount; i++) {
            stringBuilder.append((i+1)).append(" ").append(sortArray(arr[i])).append("\n");
        }
        return stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
    }

    private static int sortArray(int[] arr) {
        int totalCount = 0;
        for (int i = 1; i < arr.length; i++) {
            int height = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > height) {
                arr[j + 1] = arr[j];
                j--;
                totalCount++;
            }
            arr[j + 1] = height;
        }
        return totalCount;
    }

}
