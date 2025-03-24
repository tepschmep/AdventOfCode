import java.nio.file.Path;
import java.io.*;
import java.util.*;

public abstract class Problem {

    public abstract void part1(List<String> input);
    public abstract void part2(List<String> input);

    /* Utility methods to get problem inputs */
    public List<String> getInput(int year, int day) {
        return getFilteredInput(year, day, "");
    }

    public List<String> getInputWithout(int year, int day, char... chars) {
        String regex = "[" + String.valueOf(chars) + "]";
        return getFilteredInput(year, day, regex);
    }

    public List<String> getInputWithOnly(int year, int day, char... chars) {
        String regex = "[^" + String.valueOf(chars) + "]";
        return getFilteredInput(year, day, regex);
    }

    private List<String> getFilteredInput(int year, int day, String regex) {
        File file = Path.of(String.valueOf(year), "input", "Day" + day + ".txt").toAbsolutePath().toFile();
        List<String> input = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String data = scanner.nextLine().replaceAll(regex, "");
                input.add(data);
            }
            return input;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        }
    }

}
