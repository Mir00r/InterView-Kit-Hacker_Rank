package arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Mir00r on 13-Jan-19
 */
public class MinimumSwaps2 {
    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int len = arr.length;
        int swap = 0, tmp;
        int i = 0;
        while (i < len) {
            if (i != arr[i] - 1) {
                int j = arr[i] - 1;
                int k = arr[j] - 1;
                System.out.println(String.format("(%d, %d)", j, k));
                if ((j >= 0 && j < len) && (k >= 0 && k < len)) {
                    tmp = arr[j];
                    arr[j] = arr[k];
                    arr[k] = tmp;
                    swap++;
                }
            } else i++;
        }
        return swap;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);
        System.out.println(res);

        /*bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();
        bufferedWriter.close();*/

        scanner.close();
    }
}
