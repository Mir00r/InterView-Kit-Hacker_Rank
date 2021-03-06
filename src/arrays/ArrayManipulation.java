package arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Mir00r on 15-Jan-19
 */
public class ArrayManipulation {

    static long setOperationValue(int[] arr, int n) {
        long maxN = 0, sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += arr[i];
            if (maxN < sum) maxN = sum;
        }
        return maxN;
    }

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        int len = queries.length;
        int[] arr = new int[n + 1];

        for (int i = 0; i < len; i++) {
            arr[queries[i][0]] += queries[i][2];
            if (queries[i][1] + 1 <= n) {
                arr[queries[i][1] + 1] -= queries[i][2];
            }
        }
        return setOperationValue(arr, n);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);
        System.out.println(result);

        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();*/

        scanner.close();
    }
}
