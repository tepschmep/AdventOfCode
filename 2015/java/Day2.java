import java.util.ArrayList;
import java.util.List;

public class Day2 extends Problem {

    public static void main(String[] args) {
        Problem problem = new Day2();

        char[] chars = "01234567890x".toCharArray();
        List<String> input = problem.getInputWithOnly(2015, 2, chars);

        problem.part1(input);
        problem.part2(input);
    }

    public void part1(List<String> input) {
        int result = 0;
        List<Box> boxes = getBoxes(input);

        for (Box box : boxes) {
            result += box.calculateSurfaceArea() + box.calculateSlackArea();
        }

        System.out.println("The elves should order " + result + " square feet of wrapping paper.");
    }

    public void part2(List<String> input) {
        int result = 0;
        List<Box> boxes = getBoxes(input);

        for (Box box : boxes) {
            result += box.calculateVolume() + box.calculateSmallestPerimeter();
        }

        System.out.println("The elves should order " + result + " feet of ribbon.");

    }

    private List<Box> getBoxes(List<String> input) {
        List<Box> boxes = new ArrayList<>();
        for (String line : input) {
            int start = 0;
            int firstX = line.indexOf('x');
            int lastX = line.lastIndexOf('x');
            int end = line.length();

            int length = Integer.parseInt(line.substring(start, firstX));
            int width = Integer.parseInt(line.substring(firstX + 1, lastX));
            int height = Integer.parseInt(line.substring(lastX + 1, end));

            boxes.add(new Box(length, width, height));
        }
        return boxes;
    }

    record Box(int length, int width, int height) {

        public int calculateSurfaceArea() {
            return 2 * length * width + 2 * width * height + 2 * length * height;
        }

        public int calculateSlackArea() {
            int a = length * width;
            int b = width * height;
            int c = length * height;

            if (a <= b && a <= c) { return a; }
            else if (b <= a && b <= c) { return b; }
            else { return c; }
        }

        public int calculateSmallestPerimeter() {
            int a = 2 * (length + width);
            int b = 2 * (width + height);
            int c = 2 * (length + height);

            if (a <= b && a <= c) { return a; }
            else if (b <= a && b <= c) { return b; }
            else { return c; }
        }

        public int calculateVolume() {
            return length * width * height;
        }

    }

}
