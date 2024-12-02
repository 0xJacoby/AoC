import java.util.ArrayList;
import java.util.Collections;

public class Day1 {
    public static void main(String[] args) {
        String[] inputLines = Input.readLines("input.txt");

        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();

        for (String line : inputLines) {
            String[] nums = line.split("   ");

            left.add(Integer.parseInt(nums[0]));
            right.add(Integer.parseInt(nums[1]));
        }

        Collections.sort(left);
        Collections.sort(right);

        int distance = 0;
        int similarity = 0;

        for (int i = 0; i < left.size(); i++) {
            distance += Math.abs(left.get(i) - right.get(i));
            similarity += left.get(i) * Collections.frequency(right, left.get(i));
        }

        System.out.println("Total distance: " + String.valueOf(distance));
        System.out.println("Total similarity: " + String.valueOf(similarity));
    }
}
