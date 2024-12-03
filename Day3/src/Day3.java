public class Day3 {
    public static void main(String[] args) {
        String inputString = Input.joinLines("input.txt");

        int part1Total = 0;
        int part2Total = 0;
        boolean active = true;

        String[] mults = inputString.split("mul\\(");

        for (String mult : mults) {
            boolean new_active = active;
            String lastDoSection = mult.substring(mult.lastIndexOf("do") + 2);

            if (lastDoSection.startsWith("()")) {
                new_active = true;
            } else if (lastDoSection.startsWith("n't()")) {
                new_active = false;
            }

            new_active = lastDoSection.startsWith("()")    ? true
                       : lastDoSection.startsWith("n't()") ? false
                                                           : new_active;

            try {
                String[] nums = mult.split("\\)")[0].split(",");

                if (nums.length == 2) {
                    int product = Integer.parseInt(nums[0]) * Integer.parseInt(nums[1]);

                    part1Total += product;
                    part2Total += (active) ? product : 0;
                }
            } catch (NumberFormatException e) {
                continue;
            }

            active = new_active;
        }

        System.out.println("Part 1: " + String.valueOf(part1Total));
        System.out.println("Part 2: " + String.valueOf(part2Total));
    }
}
