package AoC2022.Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class JavaSolution {

    public static void main(String[] args) throws FileNotFoundException {
        List<Elf> elves = new ArrayList<>();
        List<Integer> food = new ArrayList<>();

        File file = new File("src/AoC2022/Day1/input");
        Scanner reader = new Scanner(file);
        String line;

        while (reader.hasNextLine()) {
            line = reader.nextLine();
            if (line.equals("")) {
                elves.add(new Elf(food));
                food.clear();
                continue;
            }
            food.add(Integer.parseInt(line));
        }

        elves.sort(Comparator.comparing(Elf::getTotalCalories));

        System.out.println("-----Part One-----");
        System.out.println(elves.get(elves.size()-1).getTotalCalories() + " calories\n");

        int threeHighest = 0;
        for (int i = elves.size()-1; i > elves.size()-4; i--) {
            threeHighest += elves.get(i).getTotalCalories();
        }
        System.out.println("-----Part Two-----");
        System.out.println(threeHighest + " calories");
    }
}