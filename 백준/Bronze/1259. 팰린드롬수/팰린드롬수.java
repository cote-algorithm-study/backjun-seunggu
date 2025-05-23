
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if(line.equals("0"))break;
                String reverse = new StringBuilder(line).reverse().toString();
                if(reverse.equals(line)) {
                    System.out.println("yes");
                }else {
                    System.out.println("no");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}