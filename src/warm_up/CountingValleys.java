package warm_up;

import java.util.Scanner;

/**
 * @author Mir00r on 31-Dec-18
 */
public class CountingValleys {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int valleyCount = 0;
        int upAndDown = 0;

        /*for (char c: s.toCharArray()) {
            if (c == 'D')  upAndDown++;
            if (c == 'U')  upAndDown--;

            if (upAndDown == 0 && c == 'U') valleyCount++;
        }*/
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'D')  upAndDown++;
            if (s.charAt(i) == 'U')  upAndDown--;

            if (upAndDown == 0 && s.charAt(i) == 'U') valleyCount++;
        }
        return valleyCount;
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String s = scanner.nextLine();

        int result = countingValleys(n, s);
        System.out.println("Final result is -> " + result);
        scanner.close();
    }
}
