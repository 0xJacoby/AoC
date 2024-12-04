import java.util.Arrays;

public class Day4 {
    public static int countPart1(String[] rows) {
        StringBuilder[] directionBuffers = {
            new StringBuilder("...."), // horizontal
            new StringBuilder("...."), // vertical
            new StringBuilder("...."), // downwards diagonal
            new StringBuilder("...."), // upwards diagonal
        };

        String[] allowedStrings = {"XMAS", "SAMX"};
        int count = 0;

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[i].length(); j++) {
                for (int k = 0; k < 4; k++) {
                    directionBuffers[0].setCharAt(
                        k, (j < rows[i].length() - 3) ? rows[i].charAt(j + k) : '.'); // horizontal

                    directionBuffers[1].setCharAt(
                        k, (i < rows.length - 3) ? rows[i + k].charAt(j) : '.'); // vertical

                    directionBuffers[2].setCharAt(
                        k, ((i < rows.length - 3) && (j < rows[i].length() - 3))
                               ? rows[i + k].charAt(j + k)
                               : '.'); // downwards diagonal

                    directionBuffers[3].setCharAt(
                        k, ((i >= 3) && (j < rows[i].length() - 3)) ? rows[i - k].charAt(j + k)
                                                                    : '.'); // upwards diagonal
                }

                for (StringBuilder dirBuffer : directionBuffers) {
                    if (Arrays.asList(allowedStrings).contains(dirBuffer.toString())) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static int countPart2(String[] rows) {
        String[] allowedStrings = {"MAS", "SAM"};
        int count = 0;

        for (int i = 0; i < rows.length - 2; i++) {
            for (int j = 0; j < rows[i].length() - 2; j++) {
                String top = rows[i].substring(j, j + 3);
                String mid = rows[i + 1].substring(j, j + 3);
                String bottom = rows[i + 2].substring(j, j + 3);

                String diagUp = "" + bottom.charAt(0) + mid.charAt(1) + top.charAt(2);
                String diagDown = "" + top.charAt(0) + mid.charAt(1) + bottom.charAt(2);

                if (Arrays.asList(allowedStrings).contains(diagUp)
                    && Arrays.asList(allowedStrings).contains(diagDown)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String[] inputLines = Input.readLines("input.txt");
        System.out.println("Part1 count: " + countPart1(inputLines));
        System.out.println("Part2 count: " + countPart2(inputLines));
    }
}
