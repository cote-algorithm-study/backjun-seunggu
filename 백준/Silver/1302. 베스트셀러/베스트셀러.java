import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String result = solution(br);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String solution(BufferedReader br) throws IOException {
        int count = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i < count; i++) {
            String bookName = br.readLine();
            map.put(bookName, map.getOrDefault(bookName, 0) + 1);
        }
        List<Book> books = map.entrySet().stream()
                .map(entry -> Book.of(entry.getKey(), entry.getValue()))
                .sorted().collect(Collectors.toList());
        return books.get(0).name;
    }

    private static class Book implements Comparable<Book> {

        String name;

        int sellCount;
        private Book(String name, int sellCount) {
            this.name = name;
            this.sellCount = sellCount;
        }
        public static Book of(String name, int sellCount) {
            return new Book(name, sellCount);
        }

        @Override
        public int compareTo(Book o) {
            if(this.sellCount == o.sellCount) {
                return this.name.compareTo(o.name);
            }
            return Integer.compare(o.sellCount, this.sellCount);
        }
    }

}
