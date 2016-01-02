package MultiThreadSorting;

import java.util.Random;

public class Main {
    public static void main( String[] args ) {

        int arrSize = 15000000;
        int[] unsorted = new int[arrSize];
        Random random = new Random();

        for (int i = 0;i < arrSize;i++) {
            unsorted[i] = random.nextInt(10000);
        }

        long startTime = System.nanoTime();

        OneThreadSorting sorter = new OneThreadSorting(unsorted);
        sorter.sort();

        long endTime = System.nanoTime();

        System.out.println("Single Thread Sort: " + (endTime - startTime));

        startTime = System.nanoTime();

        MultiThreadSorting multiMerger = new MultiThreadSorting(unsorted);
        multiMerger.start();
        try {
            multiMerger.join();
        } catch ( Exception e ) {

        }
        endTime = System.nanoTime();

        System.out.println("Multi Thread Sort: " + (endTime - startTime));
    }
}
