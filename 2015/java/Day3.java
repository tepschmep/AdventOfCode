import java.util.*;

public class Day3 extends Problem {

    private static final int X = 0;
    private static final int Y = 1;

    public static void main(String[] args) {
        Problem problem = new Day3();

        char[] chars = "^v<>".toCharArray();
        List<String> input = problem.getInputWithOnly(2015, 3, chars);

        problem.part1(input);
        problem.part2(input);
    }

    public void part1(List<String> input) {
        Set<House> grid = new HashSet<>();
        Santa santa = new Santa(grid);

        for (String line : input) {
            for (char instruction : line.toCharArray()) {
                santa.move(instruction);
            }
        }

        int result = grid.size();

        System.out.println(result + " houses receive at least one present.");
    }

    public void part2(List<String> input) {
        Set<House> grid = new HashSet<>();
        Santa santa1 = new Santa(grid);
        Santa santa2 = new Santa(grid);

        for (String line : input) {
            boolean isSanta1Turn = true;
            for (char instruction : line.toCharArray()) {
                if (isSanta1Turn) {
                    santa1.move(instruction);
                    isSanta1Turn = false;
                } else {
                    santa2.move(instruction);
                    isSanta1Turn = true;
                }
            }
        }

        int result = grid.size();

        System.out.println(result + " houses receive at least one present.");
    }

    abstract class Positionable {
        public final int[] position = new int[2];

        private Positionable(int x, int y) {
            this.position[X] = x;
            this.position[Y] = y;
        }

        public boolean atSameSpotAs(Positionable other) {
            return this.position[X] == other.position[X] && this.position[Y] == other.position[Y];
        }

    }

    class Santa extends Positionable {

        private final Set<House> space;

        public Santa(Set<House> space) {
            super(0, 0);
            this.space = space;
            deliver();
        }

        public void move(char instruction) {
            switch (instruction) {
                case '^':
                    position[Y]++; break;
                case 'v':
                    position[Y]--; break;
                case '>':
                    position[X]++; break;
                case '<':
                    position[X]--; break;
            }
            deliver();
        }

        public void deliver() {
            Optional<House> houseAtPos = space.stream().filter(house -> house.atSameSpotAs(this)).findFirst();
            if (houseAtPos.isPresent()) {
                houseAtPos.get().presentCount++;
            } else {
                House house = new House(position[X], position[Y]);
                house.presentCount++;
                space.add(house);
            }
        }

    }

    class House extends Positionable {

        private int presentCount;

        private House(int x, int y) {
            super(x, y);
        }

        public boolean equals(Object obj) {
            return obj instanceof House house && atSameSpotAs(house);
        }

        public int hashCode() {
            return position[X] + position[Y];
        }
    }

}
