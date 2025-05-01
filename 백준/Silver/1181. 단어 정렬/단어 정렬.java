import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String result = solution(reader);
            System.out.printf("%s", result);
        } catch (IOException e) {
            System.err.println("An IOException occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String solution(BufferedReader reader) throws IOException {
        int count = Integer.parseInt(reader.readLine());
        Set<String> alphabets = new LinkedHashSet<>();
        for (int i = 0; i < count; i++) {
            alphabets.add(reader.readLine());
        }
        List<String> alphabetList = new ArrayList<>(alphabets);
        Collections.sort(alphabetList, ((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        }));
        StringBuilder stringBuilder = new StringBuilder();
        for (String alphabet : alphabetList) {
            stringBuilder.append(alphabet).append("\n");
        }
        return stringBuilder.toString();
    }

}
