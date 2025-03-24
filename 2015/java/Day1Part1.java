public class Day1Part1 extends Problem {

    public static void main(String[] args) {
        Problem problem = new Day1Part1();
        problem.solve();
    }

    public void solve() {
        String input = getInputWithOnly(2015, 1, '(', ')').getFirst();
        int floor = 0;

        for (char c : input.toCharArray()) {
            floor += (c == '(') ? 1 : -1;
        }

        System.out.println("The instructions sent take Santa to floor " + floor + ".");
    }

}