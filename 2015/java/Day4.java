import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.*;

public class Day4 extends Problem {

    public static void main(String[] args) {
        Problem problem = new Day4();

        List<String> input = problem.getInput(2015, 4);

        problem.part1(input);
        problem.part2(input);
    }

    public void part1(List<String> input) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            for (String line : input) {
                findHashWithNZeroes(md5, 5, line);
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public void part2(List<String> input) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            for (String line : input) {
                findHashWithNZeroes(md5, 6, line);
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public void findHashWithNZeroes(MessageDigest algorithm, int count, String input) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder = builder.append(0);
        }
        String zeroes = builder.toString();

        String hash = "";
        int num = 1;

        while (!hash.startsWith(zeroes)) {
            String key = input + num;
            byte[] byteKey = key.getBytes(StandardCharsets.UTF_8);

            byte[] output = algorithm.digest(byteKey);

            hash = HexFormat.of().formatHex(output);

            if (hash.startsWith(zeroes)) { break; }

            num++;
            hash = "";
        }

        System.out.println("The lowest possible number that produces a hash with five zeroes given the key " + input + " is " + num + ".");
    }

}
