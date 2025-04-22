import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String s = br.readLine();
            String[] arr = s.split(" ");
            int str = Integer.parseInt(arr[0]);
            int n = Integer.parseInt(arr[1]);
            String result = Integer.toString(str, n);
            if(n > 10) {
                result = result.toUpperCase();
            }
            System.out.printf("%s", result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
