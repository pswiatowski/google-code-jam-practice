package com.googlecodejam.practice.year2017.round1C.task1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AmpleSyrup {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int K = in.nextInt();

            PriorityQueue<PanCake> result = new PriorityQueue<>(N, (aDouble, anotherDouble) -> aDouble.surface.compareTo(anotherDouble.surface) * (-1));


            for (int j = 0; j < N; j++) {
                double R = in.nextInt();
                double H = in.nextInt();


                double surface = Math.PI * 2 * R * H;
                double area = Math.PI * R * R + surface;

                PanCake panCake = new PanCake(R, H, area, surface);
                result.add(panCake);
            }

            double areaMax = 0;
            double biggestR = 0;


            while (K - 1 > 0) {

                PanCake poll = result.poll();

                if (poll.R > biggestR) {
                    biggestR = poll.R;
                }

                areaMax += Math.PI * 2 * poll.R * poll.H;

                K--;
            }

            double total = areaMax + Math.PI * biggestR * biggestR;

            while (!result.isEmpty()) {

                PanCake poll = result.poll();
                double areaTemp = areaMax + Math.PI * 2 * poll.R * poll.H;

                double totalTemp;
                if (poll.R > biggestR) {
                    totalTemp = areaTemp + Math.PI * poll.R * poll.R;
                } else {
                    totalTemp = areaTemp + Math.PI * biggestR * biggestR;

                }

                if (totalTemp > total) {
                    total = totalTemp;
                }

            }

            System.out.println("Case #" + i + ": " + String.format("%.6f", total).replace(",", "."));
        }
    }

    private static class PanCake {
        Double R;
        Double H;
        Double area;
        Double surface;

        public PanCake(Double r, Double h, Double area, Double surface) {
            this.R = r;
            this.H = h;
            this.area = area;
            this.surface = surface;
        }
    }
}
