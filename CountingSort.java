package CountingSort;

import java.util.Scanner;

/**
 * This program mimics the counting sort to keep the order of a given a list
 * that contains both integers and strings. Only the bottom half the list is
 * printed, while the strings on the upper half are replaces with dashes "-".
 */
/**
 * @author Paola Jiron 
 */
public class CountingSort
{

    /**
     * Inner class to create object containing a key and String.
     */
    private static class AB
    {

        // instance var's

        private int key;
        private String str;

        // constructor with key and string
        AB(int x, String s)
        {
            key = x;
            str = s;
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();        // (1 <= N <= 1000000)
        AB[] list = new AB[N];       // list of obj of length N
        int[] bucket = new int[100];    // keeps count of repeats
        AB[] aux = new AB[N + 1];           // auxiliary list of AB obj
        int count;
        int mid = N / 2;    // halve the array

        for (int i = 0; i < N; i++)
        {
            int x = in.nextInt();       // (0<= x <= 100)
            String s = in.next();       // (1 <= length <= 10)

            if (i < mid)    // set first half of list to "-"
            {           
                s = "-"; 
            }
            list[i] = new AB(x, s);     // add to list
        }
        for (int i = 0; i < list.length; i++)   // count occurences
        {
            count = list[i].key;
            bucket[count] += 1;
        }
        for (int j = 1; j < bucket.length; j++) // identify place of each key val
        {
            bucket[j] = bucket[j - 1] + bucket[j];
        }
        for (int index = list.length - 1; index >= 0; index--)
        {
                // position the strings in correct place

            aux[bucket[list[index].key]] = list[index];
            bucket[list[index].key]--;
        }
        for (int out = 1; out < aux.length; out++)  // output string
        {
            System.out.print(aux[out].str + " ");
        }
        System.out.println("");
    }
}