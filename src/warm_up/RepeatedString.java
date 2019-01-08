package warm_up;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Mir00r on 07-Jan-19
 */
public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long numberOfAs = 0, aCount = 0;
        long strLen = s.length();
        long subStrAddLen = n / strLen;
        long singleStrAddLen = n % strLen;

        for (int i = 0; i < strLen; i++) {
            if (s.charAt(i) == 'a') aCount++;
        }

        numberOfAs += (aCount * subStrAddLen);

        for (int i = 0; i < singleStrAddLen; i++) {
            if (s.charAt(i) == 'a') numberOfAs++;
        }


        /*if (strLen == 1 && s.charAt(0) == 'a') numberOfAs = n;
        else {
            for (int i = 0; i < subStrAddLen; i++) {
                repeatedStr += s;
            }
            for (int i = 0; i < singleStrAddLen; i++) {
                repeatedStr += s.charAt(i);
            }
            System.out.println("Final repeated string " + repeatedStr);
            for (int i = 0; i < repeatedStr.length(); i++) {
                if (repeatedStr.charAt(i) == 'a') numberOfAs++;
            }
        }*/
        return numberOfAs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);
        System.out.println(result);

       /* bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();*/

        scanner.close();
    }
}
