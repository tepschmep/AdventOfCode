import java.util.*;

public class Day2Part1 extends Problem {

    public static void main(String[] args) {
        Problem problem = new Day2Part1();
        problem.solve();
    }

    public void solve() {
        List<String> input = getInput(2015, 2);
        List<Box> boxes = new ArrayList<>();

        int result = 0;

        for (String line : input ) {
            int start = 0;
            int firstX = line.indexOf('x');
            int lastX = line.lastIndexOf('x');
            int end = line.length();

            int l = Integer.parseInt(line.substring(start, firstX));
            int w = Integer.parseInt(line.substring(firstX + 1, lastX));
            int h = Integer.parseInt(line.substring(lastX + 1, end));

            boxes.add(new Box(l, w, h));
        }

        for (Box box : boxes) {
            result += box.calculateSurfaceArea() + box.calculateSlackArea();
        }

        System.out.println("The elves should order " + result + " square feet of wrapping paper.");
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

    }

}