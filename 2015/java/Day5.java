import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5 extends Problem {

    public static void main(String[] args) {
        Problem problem = new Day5();

        List<String> input = problem.getInput(2015, 5);

        problem.part1(input);
        problem.part2(input);
    }

    @Override
    public void part1(List<String> input) {
        List<String> niceStrings = new ArrayList<>();

        for (String line : input) {
            if (hasThreeVowels(line) && hasRepeatingLetter(line) && !isBlacklisted(line)) {
                niceStrings.add(line);
            }
        }

        int result = niceStrings.size();

        System.out.println("There are " + result + " nice strings in the list.");
    }

    @Override
    public void part2(List<String> input) {
        List<String> niceStrings = new ArrayList<>();

        for (String line : input) {
            if (hasIndependentPairs(line) && hasLetterBetweenPair(line)) {
                niceStrings.add(line);
            }
        }

        int result = niceStrings.size();

        System.out.println("There are " + result + " nice strings in the list.");
    }

    private boolean hasThreeVowels(String string) {
        List<Character> list = new ArrayList<>();
        for (Character c : string.toCharArray()) { list.add(c); }

        return list.stream()
                .filter(c -> "aeiou".contains(c.toString()))
                .count() >= 3;
    }

    private boolean hasRepeatingLetter(String string) {

        boolean charsAreEqual = false;
        for (int i = 0; i < string.length() - 1; i++) {
            char c1 = string.charAt(i);
            char c2 = string.charAt(i + 1);
            charsAreEqual = c1 == c2;
            if (charsAreEqual) break;
        }
        return charsAreEqual;
    }

    private boolean isBlacklisted(String string) {
        boolean charsAreIllegal = false;
        for (int i = 0; i < string.length() - 1; i++) {
            String pair = string.substring(i, i + 2);
            charsAreIllegal = pair.matches("(ab)|(cd)|(pq)|(xy)");
            if (charsAreIllegal) break;
        }
        return charsAreIllegal;
    }

    private boolean hasLetterBetweenPair(String string) {
        boolean hasLetterBetweenPair = false;
        for (int i = 0; i < string.length() - 2; i++) {
            char c1 = string.charAt(i);
            char c3 = string.charAt(i + 2);
            hasLetterBetweenPair = c1 == c3;
            if (hasLetterBetweenPair) break;
        }
        return hasLetterBetweenPair;
    }

    private boolean hasIndependentPairs(String string) {
        boolean hasIndependentPairs = false;

        for (int i = 0; i < string.length() - 1; i++) {
            String pair = string.substring(i, i + 2);
            String substring = string.substring(i + 2);

            hasIndependentPairs = substring.contains(pair);
            if (hasIndependentPairs) { break; }
        }
        return hasIndependentPairs;
    }

}
