import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String result = solution(reader);
            System.out.printf("%s", result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String solution(BufferedReader reader) throws IOException {
        String word = reader.readLine();
        word = word.toUpperCase();
        Map<String, Integer> map = new HashMap<>();
        String[] words = word.split("");
        for (String w : words) {
            int count = map.getOrDefault(w, 0);
            map.put(w, count + 1);
        }
        PriorityQueue<Alphabet> queue = new PriorityQueue<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.add(new Alphabet(entry.getKey(), entry.getValue()));
        }
        Alphabet max = queue.poll();
        if(!queue.isEmpty()) {
            Alphabet poll = queue.poll();
            if(max.count == poll.count) {
                return "?";
            }
        }
        return max.str;
    }

    static class Alphabet implements Comparable<Alphabet> {
        String str;
        int count;

        public Alphabet(String str, Integer count) {
            this.str = str;
            this.count = count;
        }

        @Override
        public int compareTo(Alphabet o) {
            return o.count- this.count;
        }

    }

}
