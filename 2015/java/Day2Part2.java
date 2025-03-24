import java.util.*;

public class Day2Part2 extends Problem {

    public static void main(String[] args) {
        Problem problem = new Day2Part2();
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
            result += box.calculateVolume() + box.calculateSmallestPerimeter();
        }

        System.out.println("The elves should order " + result + " feet of ribbon.");
    }

    record Box(int length, int width, int height) {

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