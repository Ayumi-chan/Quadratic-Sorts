
import java.util.Arrays;
import java.util.Random;


public class Sorts {


    private int[] integer_array;
    private int steps;
    public Sorts() {
        integer_array = new int[10];
        integer_array[0] = -10001;
        integer_array[1] = 3;
        integer_array[2] = 7;
        integer_array[3] = 19;
        integer_array[4] = 15;
        integer_array[5] = 19;
        integer_array[6] = 7;
        integer_array[7] = 3;
        integer_array[8] = 19;
        integer_array[9] = -100;


    }


    public Sorts(int[] temp) {
        integer_array = temp;
    }


    // Constructs an array with size random Sorts from [0,range)
    public Sorts(int size, int range) {
        integer_array = new int[size];

        Random r = new Random();
        for (int n = 0; n < size; ++n)
        {
            integer_array[n] = r.nextInt(range);
        }

    }


    // Constructs an array of random Sorts [0-range) array of size count with a
    // seed
    // The seed allows you to use the same set of random numbers


    public Sorts(int count, int range, long seed) {

        integer_array = new int[count];

        Random r = new Random(seed);
        for (int n = 0; n < count; ++n)
        {
            integer_array[n] = r.nextInt(range);
        }
    }


    // This constructor will create an ordered array of consecutive integers
    // true will yield ascending order
    // false will yield descending order
    public Sorts(int count, boolean ordered) {

        integer_array = new int[count];
        for (int n = count - 1; n >= 0; --n)
        {
            integer_array[n] = n + 1;
        }

        if (ordered)
        {
            Arrays.sort(integer_array);
        }
    }


    public int getSteps() {
        return steps;
    }


    public void display() {
        for (int x : integer_array)
            System.out.print(x + " ");
        System.out.println();
    }

    public String toString()
    {
        display();
        return "";
    }


    public int[] getIntegerArray() {
        return integer_array;


    }

    public void bubble_sort() {

        steps = 0;
        for (int n = 0; n < integer_array.length; ++n)
        {
            steps ++;
            for (int m = 0; m < integer_array.length - 1; ++m)
            {
                steps++;
                if (integer_array[m] > integer_array[m + 1])
                {
                    steps++;
                    //swap
                    int temp = integer_array[m + 1];
                    integer_array[m + 1] = integer_array[m];
                    integer_array[m] = temp;
                }
            }
        }
    }

    public void insertion_sort()
    {
        steps = 0;
        for (int n = 0; n < integer_array.length; ++n)
        {
            steps++;
            int temp = integer_array[n];
            int j = n;
            for (; j > 0 && (integer_array[j - 1] > temp); --j)
            {
                steps++;
                integer_array[j] = integer_array[j - 1];
            }
            integer_array[j] = temp;
        }
    }


    public void selection_sort()
    {
        steps = 0;
        for (int n = 0; n < integer_array.length - 1; ++n)
        {
            steps++;
            int i = n;
            for (int j = n + 1; j < integer_array.length; ++j)
            {
                steps++;
                if (integer_array[j] < integer_array[i])
                {
                    steps++;
                    i = j;
                }
            }

            //swap
            int temp = integer_array[i];
            integer_array[i] = integer_array[n];
            integer_array[n] = temp;
        }
    }

    public static void test_bubblesort()
    {
        Sorts[] n = {
                new Sorts(3000, 0x1337, 0xDEADBEEF),
                new Sorts(3000, true),
                new Sorts(3000, false)
        };

        System.out.println("BubbleSort");
        for (int i = 0; i < n.length; ++i)
        {

            Stopwatch stopwatch = new Stopwatch();
            stopwatch.start();
            n[i].bubble_sort();
            stopwatch.stop();
            //n[i].display();
            System.out.println((i + 1) + " Steps: " + n[i].getSteps());
            System.out.println((i + 1) + " Default Array time: " + stopwatch.getElapsedTime()+ " milliseconds.");
            System.out.println();

        }
    }

    public static void test_insertionsort()
    {
        Sorts[] n = {
                new Sorts(3000, 0x1337, 0xDEADBEEF),
                new Sorts(3000, true),
                new Sorts(3000, false)
        };

        System.out.println("InsertionSort");
        for (int i = 0; i < n.length; ++i)
        {

            Stopwatch stopwatch = new Stopwatch();
            stopwatch.start();
            n[i].insertion_sort();
            stopwatch.stop();
            //n[i].display();
            System.out.println((i + 1) + " Steps: " + n[i].getSteps());
            System.out.println((i + 1) + " Default Array time: " + stopwatch.getElapsedTime()+ " milliseconds.");
            System.out.println();

        }
    }

    public static void test_selectionsort()
    {
        Sorts[] n = {
                new Sorts(3000, 0x1337, 0xDEADBEEF),
                new Sorts(3000, true),
                new Sorts(3000, false)
        };

        System.out.println("SelectionSort");
        for (int i = 0; i < n.length; ++i)
        {
            Stopwatch stopwatch = new Stopwatch();
            stopwatch.start();
            n[i].selection_sort();
            stopwatch.stop();
            //n[i].display();
            System.out.println((i + 1) + " Steps: " + n[i].getSteps());
            System.out.println((i + 1) + " Default Array time: " + stopwatch.getElapsedTime()+ " milliseconds.");
            System.out.println();
        }
    }

    public static void test_randomarray()
    {
        System.out.println("Randomarray");
        for (int n = 0; n < 3; ++n) {
            //range comes out to 61453
            Sorts one = new Sorts(3000, Integer.MAX_VALUE >> 0xDEADBEEF & 0xBAADF00D, 0xBAADF00D);
            Stopwatch timer = new Stopwatch();
            timer.start();
            switch (n) {
                case 0:
                    one.bubble_sort();
                    break;
                case 1:
                    one.insertion_sort();
                    break;
                case 2:
                    one.selection_sort();
                    break;
            }
            timer.stop();
          //  one.display();
            System.out.println("Steps: " + one.getSteps());
            System.out.println("Default Array time: " + timer.getElapsedTime() + " milliseconds.");
            System.out.println();
        }
    }

    public static void test_orderedarray()
    {
        System.out.println("Ordered");
        for (int n = 0; n < 3; ++n) {
            //range comes out to 61453
            Sorts one = new Sorts(3000, true);
            Stopwatch timer = new Stopwatch();
            timer.start();
            switch (n) {
                case 0:
                    one.bubble_sort();
                    break;
                case 1:
                    one.insertion_sort();
                    break;
                case 2:
                    one.selection_sort();
                    break;
            }
            timer.stop();
          //  one.display();
            System.out.println("Steps: " + one.getSteps());
            System.out.println("Default Array time: " + timer.getElapsedTime() + " milliseconds.");
            System.out.println();
        }
    }

    public static void test_descendingarray()
    {
        System.out.println("Desc");
        for (int n = 0; n < 3; ++n) {
            //range comes out to 61453
            Sorts one = new Sorts(3000, false);
            Stopwatch timer = new Stopwatch();
            timer.start();
            switch (n) {
                case 0:
                    one.bubble_sort();
                    break;
                case 1:
                    one.insertion_sort();
                    break;
                case 2:
                    one.selection_sort();
                    break;
            }
            timer.stop();
          //  one.display();
            System.out.println("Steps: " + one.getSteps());
            System.out.println("Default Array time: " + timer.getElapsedTime() + " milliseconds.");
            System.out.println();
        }
    }


    public static void main(String[] args) {

    	Sorts one = new Sorts(0x2999, Integer.MAX_VALUE >> 0xDEADBEEF & 0xBAADF00D, 0xBAADF00D);
    	Stopwatch timer = new Stopwatch();
        timer.start();
        int[] i = Quicksort.qsort(one.getIntegerArray());
        timer.stop();
        Quicksort.printArray(i);
        System.out.println("Default Array time: " + timer.getElapsedTime()+ " milliseconds.");

        i = one.getIntegerArray();
        timer = new Stopwatch();
        timer.start();
        Quicksort.quicksort(i);
        timer.stop();
        Quicksort.printArray(i);
        System.out.println("Default Array time: " + timer.getElapsedTime()+ " milliseconds.");

       // Sorts.test_randomarray();
       // Sorts.test_orderedarray();
        //Sorts.test_descendingarray();
//
        //Sorts.test_bubblesort();
        //Sorts.test_insertionsort();
        //Sorts.test_selectionsort();
/*
        for (int n = 0; n < 3; ++n)
        {
            //range comes out to 61453
            Sorts one = new Sorts(0x10, Integer.MAX_VALUE >> 0xDEADBEEF & 0xBAADF00D, 0xBAADF00D);
            Stopwatch timer = new Stopwatch();
            timer.start();
            switch (n)
            {
                case 0:
                    one.bubble_sort();
                    break;
                case 1:
                    one.insertion_sort();
                    break;
                case 2:
                    one.selection_sort();
                    break;
            }
            timer.stop();
            one.display();
            System.out.println("Default Array time: " + timer.getElapsedTime()+ " milliseconds.");

            System.out.println();
        }
        */



        //This is a sample code for testing bubble sort  for data in  reverse order
        //Sorts two = new Sorts (100000,false);
        // timer.reset();
        // timer.start();
        // two.bubbleSort();
        // timer.stop();
        // two.display();
        // System.out.println("Reverse order Steps: " + two.getSteps());
        // System.out.println("Reverse order time: " + timer.getElapsedTime()+ "
        // milliseconds");
        // System.out.println();


    }
}
