package arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Mir00r on 08-Jan-19
 */
public class LeftRotation {
    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int len = a.length, i;
        int[] result = new int[len];

        if (d > len) d %= len;
        for (i = 0; i < len; i++) {
            // for shifting left side element
            if (i < len - d) result[i] = a[i + d];
            // shifting right side element
            else result[i] = a[i - (len - d)];
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nd[0]);
        int d = Integer.parseInt(nd[1]);
        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
            //System.out.println();
            /*bufferedWriter.write(String.valueOf(result[i]));
            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }*/
        }

/*        bufferedWriter.newLine();
        bufferedWriter.close();*/

        scanner.close();
    }
}
