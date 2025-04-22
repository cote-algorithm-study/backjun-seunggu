import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(br.readLine());
            int[] arr = new int[45];
            for(int i=1; i < 46;i++) {
                arr[i-1] = i * (i + 1) / 2;
            }
            for(int i=0; i<count; i++) {
                int num = Integer.parseInt(br.readLine());
                boolean found = false;
                for(int j=0; j< arr.length; j++) {
                    for(int k=j; k< arr.length; k++) {
                        for(int l=k; l< arr.length; l++) {
                            if(arr[j] + arr[k] + arr[l] == num) {
                                found = true;
                                break;
                            }
                        }
                        if(found) break;
                    }
                    if(found) break;
                }
                System.out.println(found ? 1 : 0);
            }
        }

    }

}