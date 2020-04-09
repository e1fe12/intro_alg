package org.stepik.alg.p02.huffman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    class Node implements Comparable<Node>{
        final int sum;
        String code;

        void buildCode(String code){
            this.code = code;
        }

        public Node(int sum) {
            this.sum = sum;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(sum, node.sum);
        }
    }

    class InternalNode extends Node {
        Node left;
        Node right;

        @Override
        void buildCode(String code){
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }


        public InternalNode(Node left, Node right) {
            super(left.sum + right.sum);
            this.left = left;
            this.right = right;
        }
    }

    class LeafNode extends Node {
        char symbol;

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            System.out.println(symbol + ": " + code);
        }

        public LeafNode(char symbol, int count) {
            super(count);
            this.symbol = symbol;
        }
    }
    private void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        String s = in.next();
        Map<Character, Integer> count = new HashMap<>();
        Map<Character, Node> charNode = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count.containsKey(c)){
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            LeafNode leafNode = new LeafNode(entry.getKey(), entry.getValue());
            charNode.put(entry.getKey(), leafNode);
            priorityQueue.add(leafNode);
        }

        int sum = 0;
        while (priorityQueue.size() > 1){
            Node left = priorityQueue.poll();
            Node right = priorityQueue.poll();
            InternalNode internalNode = new InternalNode(left, right);
            sum += internalNode.sum;
            priorityQueue.add(internalNode);
        }

        if (count.size() == 1) {
            sum = s.length();
        }
        System.out.println(count.size() + " " + sum);
        Node root = priorityQueue.poll();

        if (count.size() == 1){
            root.buildCode("0");
        } else {
            root.buildCode("");
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stringBuilder.append(charNode.get(c).code);
        }
        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) throws FileNotFoundException {

        long start = System.currentTimeMillis();
        new Main().run();
        long finish = System.currentTimeMillis();

        //System.out.println(finish - start + " ms");
    }
}
