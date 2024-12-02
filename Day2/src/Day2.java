public class Day2 {
    static boolean isSafe(String[] levels) {
        Integer reportDiff = null;
        Integer prevVal = null;
        boolean safe = true;

        for (int i = 0; i < levels.length; i++) {
            if (levels[i] == null) {
                continue;
            }

            int val = Integer.parseInt(levels[i]);

            if (prevVal == null) {
                prevVal = val;
                continue;
            }

            int diff = val - prevVal;
            reportDiff = (reportDiff == null) ? diff : reportDiff;

            if ((reportDiff * diff < 0) || (Math.abs(diff) > 3) || (Math.abs(diff) < 1)) {
                safe = false;
                break;
            } else {
                prevVal = val;
            }
        }

        return safe;
    }

    public static void main(String[] args) {
        String[] reports = Input.readLines("input.txt");
        int safeCount = 0;
        int dampedSafeCount = 0;

        for (String report : reports) {
            String[] levels = report.split(" ");

            if (isSafe(levels)) {
                safeCount++;
            } else {
                String removed;
                for (int i = 0; i < levels.length; i++) {
                    removed = levels[i];
                    levels[i] = null;

                    if (isSafe(levels)) {
                        dampedSafeCount++;
                        break;
                    } else {
                        levels[i] = removed;
                    }
                }
            }
        }

        System.out.println("Part 1: " + String.valueOf(safeCount) + " safe levels.");
        System.out.println("Part 2: " + String.valueOf(safeCount + dampedSafeCount) + " safe levels.");
    }
}
