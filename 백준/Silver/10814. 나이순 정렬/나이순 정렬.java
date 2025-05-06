import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main ( String[] args ) {
        try( BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) )){
            int count = Integer.parseInt( br.readLine() );
            String[][] arrays = new String[count][2];
            for(int i=0; i< count; i++){
                arrays[i] = br.readLine().split( " " );
            }
            Arrays.sort( arrays, (( o1, o2 ) -> {
                if( Integer.parseInt( o1[0] ) == Integer.parseInt( o2[0] )) {
                    return 0;
                }
                return Integer.parseInt( o1[0] ) - Integer.parseInt( o2[0] );

            }) );
            for ( String[] array : arrays ) {
                System.out.println(array[0] + " " + array[1]);
            }
        } catch ( IOException e ) {
            throw new RuntimeException( e );
        }
    }
}
