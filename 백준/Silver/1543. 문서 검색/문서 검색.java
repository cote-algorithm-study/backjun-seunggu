import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int answer = solution(reader);
            System.out.printf("%d", answer);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solution(BufferedReader reader) throws IOException {
            int count = 0;
            String document = reader.readLine();
            String word = reader.readLine();
            int docLen = document.length();
            int windowSize = word.length();

            int lt = 0;
            int rt = windowSize;
            while(rt <= docLen) {
                String sub = document.substring(lt, rt);
                if (sub.equals(word)) {
                    count++;
                    lt += windowSize;
                    rt += windowSize;
                } else {
                    lt++;
                    rt++;
                }
            }

        return count;
    }

}
