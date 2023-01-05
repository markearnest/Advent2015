package org.mystikos.aoc2015.day02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Advent02 {
    public static void main(String[] args) {
        String fileName = "02/input.txt";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            int totalPaper = 0;
            int totalRibbon = 0;
            while (line != null) {
                int l = Integer.parseInt(line.split("x")[0]);
                int w = Integer.parseInt(line.split("x")[1]);
                int h = Integer.parseInt(line.split("x")[2]);
                totalPaper += (2*l*w) + (2*w*h) + (2*h*l) + getSmallest(l*w,w*h,h*l);
                int small1 = getSmallest(l,w,h);
                int small2 = (small1 == l) ? Math.min(w, h) : (small1 == w) ? Math.min(l, h) : Math.min(l, w);
                totalRibbon += small1*2 + small2*2 + l*w*h;
                line = reader.readLine();
            }
            System.out.println("Paper = " +totalPaper);
            System.out.println("Ribbon = " +totalRibbon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static int getSmallest(int ... sizes) {
        int smallest = Integer.MAX_VALUE;
        for(int i : sizes) {
            if (smallest > i) smallest = i;
        }
        return smallest;
    }
}