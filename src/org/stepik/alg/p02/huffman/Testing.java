package org.stepik.alg.p02.huffman;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Testing {
    public static  void run() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("input.txt");
        Random random = new Random();
        int n = random.nextInt(10000);
        for (int i = 0; i < n; i++) {
            printWriter.print((char)('a' + random.nextInt(26)));
        }
        printWriter.close();

    }
    public static void main(String[] args) throws FileNotFoundException {
        new Testing().run();
    }
}
