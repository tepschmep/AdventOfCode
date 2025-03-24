import java.util.List;

public class Day1 extends Problem {

    public static void main(String[] args) {
        Problem problem = new Day1();

        char[] chars = "()".toCharArray();
        List<String> input = problem.getInputWithOnly(2015, 1, chars);

        problem.part1(input);
        problem.part2(input);
    }

    public void part1(List<String> input) {
        int floor = 0;

        for (String line : input) {
            for (char c : line.toCharArray()) {
                floor += (c == '(') ? 1 : -1;
            }
        }

        System.out.println("The instructions sent take Santa to floor " + floor + ".");
    }

    public void part2(List<String> input) {
        int floor = 0;
        int position = 0;

        for (String line : input) {
            for (char c : line.toCharArray()) {
                floor += (c == '(') ? 1 : -1;
                position++;
                if (floor < 0) {
                    break;
                }
            }
        }

        System.out.println("Santa first enters the basement by character position " + position + ".");
    }
}
