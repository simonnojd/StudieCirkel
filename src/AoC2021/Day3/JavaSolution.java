package AoC2021.Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class JavaSolution {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/AoC2021/Day3/input");
        Scanner reader = new Scanner(file);
        ArrayList<String> input = new ArrayList<>();
        while (reader.hasNextLine()) {
            input.add(reader.nextLine());
        }
        puzzleA(input);
        puzzleB(input);
    }

    private static void puzzleA(ArrayList<String> input) {
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();
        for (int cols = 0; cols < input.get(0).length(); cols++) {
            int zero = 0;
            int one = 0;
            for (String s : input) {
                if (s.charAt(cols) == ('0')) {
                    zero++;
                } else {
                    one++;
                }
            }
            if (zero > one) {
                gamma.append("0");
                epsilon.append("1");
            }
            else {
                gamma.append("1");
                epsilon.append("0");
            }
        }
        System.out.println(Integer.parseInt(gamma.toString(), 2) * Integer.parseInt(epsilon.toString(), 2));
    }

    private static void puzzleB(ArrayList<String> input) {
        ArrayList<String> oxygen = new ArrayList<>(input);
        ArrayList<String> co2 = new ArrayList<>(input);
        int col = 0;

        while (oxygen.size() > 1) {
            int ones = 0;
            int zeros = 0;
            for (String s : oxygen) {
                if (s.charAt(col) == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            char max = (ones >= zeros ? '1':'0');
            for (int row = oxygen.size() - 1; row >= 0 ; row--) {
                if (oxygen.get(row).charAt(col) != max) {
                    oxygen.remove(row);
                }
            }
            col++;
        }

        col = 0;
        while (co2.size() > 1) {
            int ones = 0;
            int zeros = 0;
            for (String s : co2) {
                if (s.charAt(col) == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            char max = (zeros <= ones ? '0':'1');
            for (int row = co2.size() - 1; row >= 0 ; row--) {
                if (co2.get(row).charAt(col) != max) {
                    co2.remove(row);
                }
            }
            col++;
        }
        System.out.println(Integer.parseInt(oxygen.get(0), 2) * Integer.parseInt(co2.get(0), 2));
    }
}