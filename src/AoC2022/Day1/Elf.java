package AoC2022.Day1;

import java.util.List;

public class Elf {

    private int totalCalories;

    public Elf(List<Integer> foods) {
        for(int food: foods) {
            totalCalories += food;
        }
    }

    public int getTotalCalories() {
        return totalCalories;
    }
}
