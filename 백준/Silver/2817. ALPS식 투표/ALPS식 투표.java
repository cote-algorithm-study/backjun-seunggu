import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int participants = Integer.parseInt(br.readLine());
            int staffCount = Integer.parseInt(br.readLine());
            System.out.println(solution(staffCount, br, participants));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder solution(int staffCount, BufferedReader br, int participants) throws IOException {
        PriorityQueue<StaffScore> staffScores = new PriorityQueue<>();
        Map<String, Integer> staffMap = new HashMap<>();
        for(int i = 0; i< staffCount; i++) {
            String[] arr = br.readLine().split(" ");
            int vote = Integer.parseInt(arr[1]);
            if (vote < participants * 0.05){
                continue;
            }
            staffMap.put(arr[0], 0);
            makeScoreGroup(vote, arr, staffScores);
        }
        addChipToMap(staffMap, staffScores);
        List<Staff> staff = getStaffList(staffMap);
        StringBuilder stringBuilder = getResult(staff);
        return stringBuilder;
    }

    private static StringBuilder getResult(List<Staff> staff) {
        StringBuilder stringBuilder = new StringBuilder();
        Collections.sort(staff);
        for(Staff staffMember : staff) {
            stringBuilder.append(staffMember.getName()).append(" ").append(staffMember.getChip()).append("\n");
        }
        return stringBuilder;
    }

    private static List<Staff> getStaffList(Map<String, Integer> staffMap) {
        List<Staff> staff = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : staffMap.entrySet()) {
            Staff staffMember = Staff.of(entry.getKey(), entry.getValue());
            staff.add(staffMember);
        }
        return staff;
    }

    private static void makeScoreGroup(int score, String[] arr, PriorityQueue<StaffScore> staffScores) {
        for(int j=1; j<= 14; j++) {
            StaffScore staffScore = StaffScore.of(arr[0], score / (double) j);
            staffScores.add(staffScore);
        }
    }

    private static Map<String, Integer> addChipToMap(Map<String, Integer> staffMap, PriorityQueue<StaffScore> staffScores) {
        for(int i=0; i<14 && !staffScores.isEmpty(); i++) {
            StaffScore score = staffScores.poll();
            staffMap.put(score.name, staffMap.getOrDefault(score.name, 0) + 1);
        }
        return staffMap;
    }

    private static class Staff implements Comparable<Staff> {
        private String name;
        private int chip;

        public static Staff of(String name, int chip) {
            Staff staff = new Staff();
            staff.name = name;
            staff.chip = chip;
            return staff;
        }

        public String getName() {
            return name;
        }

        public int getChip() {
            return chip;
        }

        @Override
        public int compareTo(Staff o) {
            return this.name.compareTo(o.name);
        }

    }

    public static class StaffScore implements Comparable<StaffScore> {
        private String name;
        private double score;

        public StaffScore(String name, double score) {
            this.name = name;
            this.score = score;
        }

        public static StaffScore of(String name, double score) {
            return new StaffScore(name, score);
        }

        @Override
        public int compareTo(StaffScore o) {
            return Double.compare(o.score, this.score);
        }
    }

}
