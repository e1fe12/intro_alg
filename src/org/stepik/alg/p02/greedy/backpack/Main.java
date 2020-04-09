package org.stepik.alg.p02.greedy.backpack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    class Item implements Comparable<Item>{
        int cost;
        int weight;

        public Item(int cost, int weight) {
            this.cost = cost;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "cost=" + cost +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Item o) {
            long r1 = (long) cost * o.weight;
            long r2 = (long) o.cost * weight;
            return -Long.compare(r1, r2);        }
    }
    private void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int n = in.nextInt();
        int w = in.nextInt();
        Item[] items = new Item[n];
        for (int i = 0; i < n; ++i) {
            items[i] = new Item(in.nextInt(), in.nextInt());
        }

//        Arrays.sort(items, new Comparator<Item>() {
//            @Override
//            public int compare(Item o1, Item o2) {
//                double r1 = (double) o1.cost / o1.weight;
//                double r2 = (double) o2.cost / o2.weight;
//                return -Double.compare(r1, r2);
//            }
//        });

        Arrays.sort(items);
        double result = 0;
        for (int i = 0; i < n; ++i) {
            if (items[i].weight <= w) {
                result += items[i].cost;
                w -= items[i].weight;
            } else {
                result += (double) items[i].cost * w / items[i].weight;
                break;
            }
        }

        System.out.printf("%.3f\n", result);
    }

    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        new Main().run();
        long finish = System.currentTimeMillis();
        System.out.println(finish - start + " ms");
    }
}