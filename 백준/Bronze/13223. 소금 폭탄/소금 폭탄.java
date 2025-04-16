import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String answer = solution(reader);
            System.out.printf("%s", answer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static String solution(BufferedReader reader) throws IOException {
        String[] nowTimeArray = reader.readLine().split(":");
        String[] targetTimeArray = reader.readLine().split(":");
        LocalDateTime now = getDateTime(nowTimeArray);
        LocalDateTime target = getDateTime(targetTimeArray);
        if(!target.isAfter(now)) {
            target = target.plusDays(1);
        }
        Duration duration = Duration.between(now, target);
        return String.format("%02d:%02d:%02d", duration.toHours(), duration.toMinutes() % 60, duration.getSeconds() % 60);
    }

    private static LocalDateTime getDateTime(String[] timeArray) {
        LocalDate basicTime = LocalDate.of(2000, 1, 1);
        return basicTime.atTime(Integer.parseInt(timeArray[0]),Integer.parseInt(timeArray[1]),Integer.parseInt(timeArray[2]));
    }

}
