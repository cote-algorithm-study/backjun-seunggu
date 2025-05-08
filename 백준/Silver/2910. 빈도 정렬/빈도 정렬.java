import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            br.readLine();
            Map<Integer, Frequency> frequencyMap = new HashMap<>();
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int order = 0;
            for (int num : nums) {
                if (frequencyMap.containsKey(num)) {
                    frequencyMap.get(num).count++;
                } else {
                    frequencyMap.put(num, Frequency.of(num, 1, order++));
                }
            }
            Frequency[] frequencies = frequencyMap.values().toArray(new Frequency[0]);
            Arrays.sort(frequencies);
            StringBuilder sb = new StringBuilder();
            for (Frequency frequency : frequencies) {
                for (int i = 0; i < frequency.count; i++) {
                    sb.append(frequency.num).append(" ");
                }
            }
            System.out.printf("%s\n", sb.toString().trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Frequency implements Comparable<Frequency> {

        private int num;
        private int count;
        private int order;

        private Frequency(int num, int count, int order) {
            this.num = num;
            this.count = count;
            this.order = order;
        }

        public static Frequency of(int num, int count, int order) {
            return new Frequency(num, count, order);
        }

        @Override
        public int compareTo(Frequency o) {
            if (this.count == o.count) {
                return this.order - o.order;
            }
            return o.count - this.count;
        }

    }

}
