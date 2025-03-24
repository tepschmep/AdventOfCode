public class Day1Part2 extends Problem {

    public static void main(String[] args) {
        Problem problem = new Day1Part2();
        problem.solve();
    }

    public void solve() {
        String input = getInputWithOnly('(', ')');
        int floor = 0;
        int position = 0;

        for (char c : input.toCharArray()) {
            floor += (c == '(') ? 1 : -1;
            position++;
            if (floor < 0) {
                break;
            }
        }

        System.out.println("Santa first enters the basement by character position " + position + ".");
    }
}
