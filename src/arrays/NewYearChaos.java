package arrays;

import java.util.Scanner;

/**
 * Since the question only asks the number of bribes, there's no need to really do a sorting,
 * not element swapping, not "bubbling up" an element.
 * All you need to do is to count the number of people who overtake a person.
 *
 * @author Mir00r on 12-Jan-19
 */
public class NewYearChaos {

    static void minimumBribes(int[] person) {
        int bribe = 0, maxN;
        int len = person.length;
        boolean chaotic = false;
        for (int i = 0; i < len; i++) {
            if (person[i] - (i + 1) > 2) {
                chaotic = true;
                break;
            } else {
                maxN = Math.max(0, person[i] - 2);
                for (int j = maxN; j < i; j++) {
                    if (person[j] > person[i]) bribe++;
                }
            }
        }
        if(chaotic) {
            System.out.println("Too chaotic");
        } else{
            System.out.println(bribe);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];
            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;

            }
            minimumBribes(q);
        }
        scanner.close();
    }
}
