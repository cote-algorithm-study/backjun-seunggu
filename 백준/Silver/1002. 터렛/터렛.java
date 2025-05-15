import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main ( String[] args ) {
        try ( BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) ) ) {
            int count = Integer.parseInt( br.readLine() );
            for ( int i = 0; i < count; i++ ) {
                StringTokenizer stringTokenizer = new StringTokenizer( br.readLine() );
                int x1 = Integer.parseInt( stringTokenizer.nextToken() );
                int y1 = Integer.parseInt( stringTokenizer.nextToken() );
                int r1 = Integer.parseInt( stringTokenizer.nextToken() );
                int x2 = Integer.parseInt( stringTokenizer.nextToken() );
                int y2 = Integer.parseInt( stringTokenizer.nextToken() );
                int r2 = Integer.parseInt( stringTokenizer.nextToken() );
                int a = ( x1 - x2 ) * ( x1 - x2 ) + ( y1 - y2 ) * ( y1 - y2 );
                double distance = Math.sqrt( a );
                if ( distance == 0 && r1 == r2 ) {
                    System.out.println( -1 );
                } else if ( Math.abs( r1 - r2 ) == distance || r1 + r2 == distance ) {
                    System.out.println( 1 );
                } else if ( Math.abs( r1 - r2 ) < distance && distance < ( r1 + r2 ) ) {
                    System.out.println( 2 );
                } else {
                    System.out.println( 0 );
                }
            }
        } catch ( IOException e ) {
            e.printStackTrace();

        }
    }
}
