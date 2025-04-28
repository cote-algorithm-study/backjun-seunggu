import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(br.readLine());
            for(int i=0; i< count; i++) {
                int isPalindrome = solution(br);
                System.out.println(isPalindrome);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solution(BufferedReader br) throws IOException {
        int num = Integer.parseInt(br.readLine());
        for(int j=2; j<=64; j++) {
            StringBuilder sb = new StringBuilder();
            int n = num;
            makePhrase(n, j, sb);
            String str = sb.toString();
            if(str.equals(sb.reverse().toString())) {
                return 1;
            }
        }
        return 0;
    }

    private static void makePhrase(int n, int j, StringBuilder sb) {
        while(n > 0) {
            int remainder = n % j;
            if(remainder < 10) {
                sb.append(remainder);
            } else {
                sb.append((char) ('A' + (remainder - 10)));
            }
            n /= j;
        }
    }

}