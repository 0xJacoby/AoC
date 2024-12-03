public class Day3 {
    public static void main(String[] args) {
        String[] inputLines = Input.readLines("input.txt");

        int part1Total = 0;
        int part2Total = 0;
        boolean active = true;

        for (String line : inputLines) {
            String[] mults = line.split("mul\\(");

            for (int i = 0; i < mults.length; i++) {
                boolean new_active = active;

                if (mults[i].contains("do()")) {
                    String[] doSections = mults[i].split("do\\(\\)");
                    if (!doSections[doSections.length - 1].contains("don't()"))
                        new_active = true;

                } else if (mults[i].contains("don't()")) {
                    String[] doSections = mults[i].split("don\\'t\\(\\)");
                    if (!doSections[doSections.length - 1].contains("do()"))
                        new_active = false;
                }

                try {
                    String[] nums = mults[i].split("\\)")[0].split(",");

                    if (nums.length == 2) {
                        part1Total += Integer.parseInt(nums[0]) * Integer.parseInt(nums[1]);

                        if (active) {
                            part2Total += Integer.parseInt(nums[0]) * Integer.parseInt(nums[1]);
                        }
                    }
                } catch (Exception e) {
                    continue;
                }

                active = new_active;
            }
        }

        System.out.println("Part 1: " + String.valueOf(part1Total));
        System.out.println("Part 2: " + String.valueOf(part2Total));
    }
}
