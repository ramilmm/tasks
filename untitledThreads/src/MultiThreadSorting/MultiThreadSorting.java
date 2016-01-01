package MultiThreadSorting;


public class MultiThreadSorting extends Thread {
    private int[] unsorted, sorted;

    // Ограничиваем максимальное количество запускаемых потоков
    private static final int MAX_THREADS = 8;


    public MultiThreadSorting(int[] unsorted) {
        this.unsorted = unsorted;
    }

    public void run() {
        int middle;
        int[] left, right;

        if ( unsorted.length <= 1 ) {
            sorted = unsorted;
        } else {
            middle = unsorted.length / 2;

            left = new int[middle];
            right = new int[unsorted.length - middle];

            System.arraycopy( unsorted, 0, left, 0, middle );
            System.arraycopy( unsorted, middle, right, 0, unsorted.length - middle );

            if ( activeCount() < MAX_THREADS ) {
                MultiThreadSorting leftSort = new MultiThreadSorting( left );
                MultiThreadSorting rightSort = new MultiThreadSorting( right );

                leftSort.start();
                rightSort.start();

                try {
                    leftSort.join();
                    rightSort.join();

                    sorted = OneThreadSorting.merge( leftSort.getSorted(), rightSort.getSorted() );
                } catch ( Exception e ) {

                }

            } else {
                OneThreadSorting leftSort = new OneThreadSorting( left );
                OneThreadSorting rightSort = new OneThreadSorting( right );

                leftSort.sort();
                rightSort.sort();

                sorted = OneThreadSorting.merge( leftSort.getSorted(), rightSort.getSorted() );
            }

        }
    }

    public int[] getSorted() {
        return sorted;
    }
}
