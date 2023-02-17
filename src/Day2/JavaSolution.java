package Day2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class JavaSolution {
    static final int rock = 1;
    static final int paper = 2;
    static final int scissor = 3;

    static final int loss = 0;
    static final int draw = 3;
    static final int win = 6;

    public static void main(String[] args) throws IOException {
        Map<String, Integer> shapes = new HashMap<>();
        shapes.put("A", rock);
        shapes.put("B", paper);
        shapes.put("C", scissor);
        shapes.put("X", rock);
        shapes.put("Y", paper);
        shapes.put("Z", scissor);

        int score1 = 0;
        int score2 = 0;

        BufferedReader br = new BufferedReader(new FileReader("src/Day2/input"));
        String line;
        while ((line = br.readLine()) != null) {
        //for (String line : data.split("\n")) {
            String[] match = line.trim().split(" ");

            //Part 1
            if (shapes.get(match[0]) == shapes.get(match[1])) {
                score1 += draw;
            } else if (shapes.get(match[0]) == 1 && shapes.get(match[1]) == 2) {
                score1 += win;
            } else if (shapes.get(match[0]) == 2 && shapes.get(match[1]) == 3) {
                score1 += win;
            } else if (shapes.get(match[0]) == 3 && shapes.get(match[1]) == 1) {
                score1 += win;
            } else {
                score1 += loss;
            }
            score1 += shapes.get(match[1]);

            // Part 2
            if (match[1].equals("X")) {
                score2 += loss;

                if (shapes.get(match[0]) == rock) {
                    score2 += scissor;
                }
                if (shapes.get(match[0]) == paper) {
                    score2 += rock;
                }
                if (shapes.get(match[0]) == scissor) {
                    score2 += paper;
                }
            }
            if (match[1].equals("Y")) {
                score2 += draw;
                score2 += shapes.get(match[0]);
            }
            if (match[1].equals("Z")) {
                score2 += win;

                if (shapes.get(match[0]) == rock) {
                    score2 += paper;
                }
                if (shapes.get(match[0]) == paper) {
                    score2 += scissor;
                }
                if (shapes.get(match[0]) == scissor) {
                    score2 += rock;
                }
            }
        }
        System.out.println(score1);
        System.out.println(score2);
    }
}
