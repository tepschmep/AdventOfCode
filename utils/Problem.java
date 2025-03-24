import java.util.Scanner;

public abstract class Problem {

    private static final Scanner SCANNER = new Scanner(System.in);

    public abstract void solve();

    /* Utility methods to get problem inputs */
    public String getInput() {
        System.out.print("Provide the problem's input: ");
        return SCANNER.nextLine();
    }

    public String getInputWithout(char... chars) {
        String regex = "[" + String.valueOf(chars) + "]";
        return getInput().replaceAll(regex, "");
    }

    public String getInputWithOnly(char... chars) {
        String regex = "[^" + String.valueOf(chars) + "]";
        return getInput().replaceAll(regex, "");
    }

}
