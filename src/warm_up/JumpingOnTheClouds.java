package warm_up;

import java.util.Scanner;

/**
 * @author Mir00r on 31-Dec-18
 */
public class JumpingOnTheClouds {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int jumpCount = 0, i = 0;
        int cloudSize = c.length;
        while (i < cloudSize - 1) {
            if (i + 2 < cloudSize && c[i + 2] == 0) {
                i += 2;
                jumpCount++;
            } else {
                i++;
                jumpCount++;
            }
        }
        return jumpCount;
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);
        System.out.println("Final result is -> " + result);
        scanner.close();
    }
}
