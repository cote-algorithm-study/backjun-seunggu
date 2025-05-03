import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String sb = solution(br);
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String solution(BufferedReader br) throws IOException {
        int count = Integer.parseInt(br.readLine());
        Person[] arr = new Person[count];
        for(int i=0; i < count; i++) {
            String[] input = br.readLine().split(" ");
            arr[i] = Person.of(input[1], Integer.parseInt(input[0]));
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (Person person : arr) {
            sb.append(person.age).append(" ").append(person.name).append("\n");
        }
        return sb.toString();
    }

    private static class Person implements Comparable<Person> {

        private String name;

        private int age;
        private Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public static Person of(String name, int age) {
            return new Person(name, age);
        }

        @Override
        public int compareTo(Person o) {
            return Integer.compare(this.age, o.age);
        }
    }
}
